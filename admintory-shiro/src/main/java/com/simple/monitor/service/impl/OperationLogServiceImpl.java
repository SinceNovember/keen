package com.simple.monitor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.simple.common.model.constant.Strings;
import com.simple.common.utils.AddressUtil;
import com.simple.common.utils.StringUtils;
import com.simple.monitor.dao.OperationLogMapper;
import com.simple.monitor.model.dto.OperationLogDTO;
import com.simple.monitor.model.entity.OperationLog;
import com.simple.monitor.model.vo.OperationLogCondition;
import com.simple.monitor.service.OperationLogService;
import com.simple.system.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OperationLogServiceImpl extends ServiceImpl<OperationLogMapper, OperationLog> implements OperationLogService {

    private final ObjectMapper objectMapper;


    @Override
    public IPage<OperationLogDTO> pageOperationLog(OperationLogCondition logCondition, int pageIndex, int pageSize) {
        LambdaQueryWrapper<OperationLog> logLambdaQueryWrapper = Wrappers.lambdaQuery();
        logLambdaQueryWrapper.like(StringUtils.isNotEmpty(logCondition.getNickname()), OperationLog::getNickname, logCondition.getNickname())
                .like(StringUtils.isNotEmpty(logCondition.getOperation()), OperationLog::getOperation, logCondition.getOperation())
                .ge(StringUtils.isNotEmpty(logCondition.getCreateTimeFrom()), OperationLog::getCreateTime, logCondition.getCreateTimeFrom())
                .le(StringUtils.isNotEmpty(logCondition.getCreateTimeTo()), OperationLog::getCreateTime, logCondition.getCreateTimeTo())
                .orderByDesc(OperationLog::getCreateTime);

        Page<OperationLog> logPage = new Page<>(pageIndex, pageSize);
        IPage<OperationLogDTO> systemLogIPage = page(logPage, logLambdaQueryWrapper).convert(this::convertTo);
        return systemLogIPage;
    }

    @Override
    public void saveOperationLog(User user, ProceedingJoinPoint point, Method method, String ip, String operation, long start) {
        OperationLog systemLog = new OperationLog();
        // 设置 IP地址
        systemLog.setIp(ip);
        if (user != null) {
            systemLog.setNickname(user.getNickname());
        }
        // 设置耗时
        systemLog.setTime(System.currentTimeMillis() - start);
        // 设置操作描述
        systemLog.setOperation(operation);
        // 请求的类名
        String className = point.getTarget().getClass().getName();
        // 请求的方法名
        String methodName = method.getName();
        systemLog.setMethod(className + Strings.DOT + methodName + "()");
        // 请求的方法参数值
        Object[] args = point.getArgs();
        // 请求的方法参数名称
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = u.getParameterNames(method);
        if (args != null && paramNames != null) {
            StringBuilder params = new StringBuilder();
            params = handleParams(params, args, Arrays.asList(paramNames));
            systemLog.setParams(params.toString());
        }
        systemLog.setCreateTime(new Date());
        systemLog.setLocation(AddressUtil.getCityInfo(ip));
        // 保存系统日志
        save(systemLog);
    }

    @Override
    public void removeLogByIds(String ids) {
        List<String> idList = Arrays.asList(ids.split(","));
        idList.forEach(id -> {
            this.removeById(Long.valueOf(id));
        });
    }

    @Override
    public OperationLogDTO convertTo(OperationLog systemLog) {
        Assert.notNull(systemLog, "systemLog must not be null");
        return new OperationLogDTO().covertFrom(systemLog);
    }

    @Override
    public List<OperationLogDTO> convertTo(List<OperationLog> systemLogs) {
        if (CollectionUtils.isEmpty(systemLogs)) {
            return Collections.emptyList();
        }
        return systemLogs.stream()
                .map(this::convertTo)
                .collect(Collectors.toList());
    }



    @SuppressWarnings("all")
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
                            params.append(Strings.SPACE).append(paramNames.get(i)).append(": ").append(objectMapper.writeValueAsString(args[i]));
                        } catch (NoSuchMethodException e) {
                            params.append(Strings.SPACE).append(paramNames.get(i)).append(": ").append(objectMapper.writeValueAsString(args[i].toString()));
                        }
                    } else if (args[i] instanceof MultipartFile) {
                        MultipartFile file = (MultipartFile) args[i];
                        params.append(Strings.SPACE).append(paramNames.get(i)).append(": ").append(file.getName());
                    } else {
                        params.append(Strings.SPACE).append(paramNames.get(i)).append(": ").append(args[i]);
                    }
                }
            }
        } catch (Exception ignore) {
            params.append("参数解析失败");
        }
        return params;
    }

}


