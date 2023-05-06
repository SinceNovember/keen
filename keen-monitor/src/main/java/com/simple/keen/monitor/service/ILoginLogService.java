package com.simple.keen.monitor.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageSerializable;
import com.simple.keen.common.base.vo.ChartVO;
import com.simple.keen.monitor.model.entity.LoginLog;
import com.simple.keen.monitor.model.query.LoginLogQuery;
import com.simple.keen.monitor.model.vo.LoginLogVO;
import com.simple.keen.monitor.model.vo.RecentLoginLogVO;
import java.util.List;

public interface ILoginLogService extends IService<LoginLog> {

    /**
     * 分页获取登录日志
     *
     * @param loginLogQuery 登录日志查询
     * @return 分页系登录日志VO
     */
    PageSerializable<LoginLogVO> pageLoginLog(LoginLogQuery loginLogQuery);

    /**
     * 通过id获取登录日志
     *
     * @param id id
     * @return 登录日志VO
     */
    LoginLogVO getLoginLogById(Integer id);

    /**
     * 获取最近登录日志（前5）
     *
     * @return 登录日志VO
     */
    List<RecentLoginLogVO> getRecentLoginLog();

    /**
     * 计算所有登录日志数
     */
    long getLoginLogAllCount();

    /**
     * 计算今天登录日志数
     */
    long getLoginLogTodayCount();

    /**
     * 获取最近一周的登录日志图标
     *
     * @return
     */
    ChartVO getLoginLogWeekChart();

    /**
     * 添加或更新登录日志
     *
     * @param loginLogQuery 登录日志查询
     */
    void addLoginLog(LoginLogQuery loginLogQuery);

    /**
     * 添加登录日志
     *
     * @param nickname 昵称
     */
    void addLoginLog(String nickname);

    /**
     * 删除登录日志
     *
     * @param ids id
     */
    void deleteLoginLog(List<Integer> ids);

}
