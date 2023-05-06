package com.simple.keen.monitor.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageSerializable;
import com.simple.keen.monitor.model.entity.OperateLog;
import com.simple.keen.monitor.model.query.OperateLogQuery;
import com.simple.keen.monitor.model.vo.OperateLogVO;
import java.lang.reflect.Method;
import java.util.List;
import org.aspectj.lang.ProceedingJoinPoint;

public interface IOperateLogService extends IService<OperateLog> {

    /**
     * 分页获取操作日志
     *
     * @param operateLogQuery 操作日志查询
     * @return 分页系操作日志VO
     */
    PageSerializable<OperateLogVO> pageOperateLog(OperateLogQuery operateLogQuery);

    /**
     * 添加或更新操作日志
     *
     * @param operateLogQuery 操作日志查询
     */
    void addOperateLog(OperateLogQuery operateLogQuery);

    /**
     * 通过id获取操作日志
     *
     * @param id id
     * @return 操作日志VO
     */
    OperateLogVO getOperateLogById(Integer id);

    /**
     * 删除操作日志
     *
     * @param ids id
     */
    void deleteOperateLog(List<Integer> ids);

    /**
     * 添加操作日志
     *
     * @param nickname  昵称
     * @param point     切入点
     * @param method    操作方法
     * @param ip        ip地址
     * @param operation 操作
     * @param start     开始时间
     */
    void addOperateLog(String nickname, ProceedingJoinPoint point, Method method, String ip,
        String operation, long start);
}
