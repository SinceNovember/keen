package com.simple.keen.monitor.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageSerializable;
import com.simple.keen.common.consts.StringConsts;
import com.simple.keen.common.utils.HttpUtils;
import com.simple.keen.common.utils.PageHelperUtils;
import com.simple.keen.monitor.mapper.OperateLogMapper;
import com.simple.keen.monitor.mapping.OperateLogMapping;
import com.simple.keen.monitor.model.dto.OperateLogDTO;
import com.simple.keen.monitor.model.entity.OperateLog;
import com.simple.keen.monitor.model.query.OperateLogQuery;
import com.simple.keen.monitor.model.vo.OperateLogVO;
import com.simple.keen.monitor.service.IOperateLogService;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/2/6
 */
@Service
@RequiredArgsConstructor
public class OperateLogServiceImpl extends ServiceImpl<OperateLogMapper, OperateLog> implements
    IOperateLogService {

    @Override
    public PageSerializable<OperateLogVO> pageOperateLog(OperateLogQuery operateLogQuery) {
        PageHelper.startPage(operateLogQuery.getPageNum(), operateLogQuery.getPageSize());
        List<OperateLogDTO> operateLogDTOS = baseMapper.selectOperateLogList(
            operateLogQuery);

        return PageHelperUtils.convertPageDto2Vo(operateLogDTOS,
            OperateLogMapping.INSTANCE::toOperateLogVOList);
    }

    @Override
    public void addOperateLog(OperateLogQuery operateLogQuery) {
        OperateLogDTO operateLogDTO = OperateLogMapping.INSTANCE.toOperateLogDTO(
            operateLogQuery);
        this.saveOrUpdate(OperateLogMapping.INSTANCE.toOperateLog(operateLogDTO));
    }

    @Override
    public OperateLogVO getOperateLogById(Integer id) {
        return OperateLogMapping.INSTANCE.toOperateLogVO(getById(id));
    }

    @Override
    public void deleteOperateLog(List<Integer> ids) {
        remove(Wrappers.<OperateLog>lambdaUpdate()
            .in(OperateLog::getId, ids));
    }

    @Override
    public void addOperateLog(String nickname, ProceedingJoinPoint point, Method method,
        String ip, String operation, long start) {
        OperateLog operateLog = new OperateLog();
        // 设置 IP地址
        operateLog.setIp(ip);
        operateLog.setNickname(nickname);
        // 设置耗时
        operateLog.setTime(System.currentTimeMillis() - start);
        // 设置操作描述
        operateLog.setOperation(operation);
        // 请求的类名
        String className = point.getTarget().getClass().getName();
        // 请求的方法名
        String methodName = method.getName();
        operateLog.setMethod(className + StringConsts.DOT + methodName + "()");
        // 请求的方法参数值
        Object[] args = point.getArgs();
        // 请求的方法参数名称
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = u.getParameterNames(method);
        if (args != null && paramNames != null) {
            StringBuilder params = new StringBuilder();
            params = handleParams(params, args, Arrays.asList(paramNames));
            operateLog.setParams(params.toString());
        }
        operateLog.setOperateTime(LocalDateTime.now());
        operateLog.setLocation(HttpUtils.requestLocation(ip));
        operateLog.setUserId(StpUtil.getLoginIdAsInt());
        // 保存系统日志
        save(operateLog);

    }

    private StringBuilder handleParams(StringBuilder params, Object[] args, List paramNames) {
        try {
            for (int i = 0; i < args.length; i++) {
                if (args[i] instanceof Map) {
                    Set set = ((Map) args[i]).keySet();
                    List<Object> list = new ArrayList<>();
                    List<Object> paramList = new ArrayList<>();
                    for (Object key : set) {
                        list.add(((Map) args[i]).get(key));
                        paramList.add(key);
                    }
                    return handleParams(params, list.toArray(), paramList);
                } else {
                    if (args[i] instanceof Serializable) {
                        Class<?> aClass = args[i].getClass();
                        try {
                            aClass.getDeclaredMethod("toString", new Class[]{null});
                            // 如果不抛出 NoSuchMethodException 异常则存在 toString 方法 ，安全的 writeValueAsString ，否则 走 Object的 toString方法
                            params.append(StringConsts.SPACE).append(paramNames.get(i)).append(": ")
                                .append(args[i].toString());
                        } catch (NoSuchMethodException e) {
                            params.append(StringConsts.SPACE).append(paramNames.get(i)).append(": ")
                                .append(args[i].toString());
                        }
                    } else if (args[i] instanceof MultipartFile) {
                        MultipartFile file = (MultipartFile) args[i];
                        params.append(StringConsts.SPACE).append(paramNames.get(i)).append(": ")
                            .append(file.getName());
                    } else {
                        params.append(StringConsts.SPACE).append(paramNames.get(i)).append(": ")
                            .append(args[i]);
                    }
                }
            }
        } catch (Exception ignore) {
            params.append("参数解析失败");
        }
        return params;
    }

}
