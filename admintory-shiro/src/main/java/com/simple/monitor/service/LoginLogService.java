package com.simple.monitor.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.simple.monitor.model.dto.LoginLogDTO;
import com.simple.monitor.model.entity.LoginLog;
import com.simple.monitor.model.vo.LoginLogCondition;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface LoginLogService extends IService<LoginLog> {

    IPage<LoginLogDTO> pageLoginLog(LoginLogCondition condition, int pageIndex, int pageSize);

    List<Map<String, Object>> countLoginLogByDateScope(Date startDate, Date endDate);

    void saveLoginLog(LoginLog loginLog);

    void saveLoginLog(String nickname);

    void removeLogByIds(String ids);

    LoginLogDTO convertTo(LoginLog loginLog) ;

    List<LoginLogDTO> convertTo(List<LoginLog> loginLogs) ;


}
