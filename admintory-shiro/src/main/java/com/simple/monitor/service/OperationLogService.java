package com.simple.monitor.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.simple.common.model.constant.PropertyConstant;
import com.simple.monitor.model.dto.OperationLogDTO;
import com.simple.monitor.model.entity.OperationLog;
import com.simple.monitor.model.vo.OperationLogCondition;
import com.simple.system.model.entity.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.scheduling.annotation.Async;


import java.lang.reflect.Method;
import java.util.List;

public interface OperationLogService extends IService<OperationLog> {

    IPage<OperationLogDTO> pageOperationLog(OperationLogCondition logCondition, int pageIndex, int pageSize);

    /**
     * 异步保存操作日志
     *
     * @param user      用户信息
     * @param point     切点
     * @param method    Method
     * @param ip        ip
     * @param operation 操作内容
     * @param start     开始时间
     */
    @Async(PropertyConstant.SHIRO_THREAD_POOL)
    void saveOperationLog(User user, ProceedingJoinPoint point, Method method, String ip, String operation, long start);

    void removeLogByIds(String ids);

    OperationLogDTO convertTo(OperationLog systemLog) ;

    List<OperationLogDTO> convertTo(List<OperationLog> systemLogs) ;


}
