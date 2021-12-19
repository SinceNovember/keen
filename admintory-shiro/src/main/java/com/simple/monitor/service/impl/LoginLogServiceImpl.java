package com.simple.monitor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.simple.common.utils.AddressUtil;
import com.simple.common.utils.HttpContextUtils;
import com.simple.common.utils.IpUtil;
import com.simple.common.utils.StringUtils;
import com.simple.monitor.dao.LoginLogMapper;
import com.simple.monitor.model.dto.LoginLogDTO;
import com.simple.monitor.model.entity.LoginLog;
import com.simple.monitor.model.vo.LoginLogCondition;
import com.simple.monitor.service.LoginLogService;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> implements LoginLogService {

    @Resource
    private LoginLogMapper loginLogMapper;
    @Override
    public IPage<LoginLogDTO> pageLoginLog(LoginLogCondition condition, int pageIndex, int pageSize) {
        LambdaQueryWrapper<LoginLog> lambdaQueryWrapper = Wrappers.lambdaQuery();
        lambdaQueryWrapper.like(StringUtils.isNotEmpty(condition.getNickname()), LoginLog::getNickname, condition.getNickname())
                .ge(StringUtils.isNotEmpty(condition.getCreateTimeFrom()), LoginLog::getLoginTime, condition.getCreateTimeFrom())
                .le(StringUtils.isNotEmpty(condition.getCreateTimeTo()), LoginLog::getLoginTime, condition.getCreateTimeTo())
                .orderByDesc(LoginLog::getLoginTime);

        Page<LoginLog> logPage = new Page<>(pageIndex, pageSize);
        IPage<LoginLogDTO> loginLogIPage = page(logPage, lambdaQueryWrapper).convert(this::convertTo);
        return loginLogIPage;
    }

    @Override
    public List<Map<String, Object>> countLoginLogByDateScope(Date startDate, Date endDate) {
        List<Map<String, Object>> dataList = new ArrayList<>();
        for (Date date = startDate; date.before(endDate); date = DateUtils.addDays(date, 1)) {
            Map<String, Object> map = new HashMap<>();
            map.put("date", DateFormatUtils.format(date, DateFormatUtils.ISO_DATE_FORMAT.getPattern()));
            map.put("count", loginLogMapper.countLoginLogByLoginDate(date));
            dataList.add(map);
        }
        return dataList;
    }

    @Override
    public void saveLoginLog(LoginLog loginLog) {
        loginLog.setLoginTime(new Date());
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        String ip = IpUtil.getIpAddr(request);
        loginLog.setIp(ip);
        loginLog.setLocation(AddressUtil.getCityInfo(ip));
        save(loginLog);
    }



    @Override
    public void saveLoginLog(String nickname) {
        LoginLog loginLog = new LoginLog();
        loginLog.setNickname(nickname);
        loginLog.setSystemBrowserInfo();
        saveLoginLog(loginLog);
    }

    @Override
    public void removeLogByIds(String ids) {
        List<String> idList = Arrays.asList(ids.split(","));
        idList.forEach(id -> {
            this.removeById(Long.valueOf(id));
        });
    }

    @Override
    public LoginLogDTO convertTo(LoginLog loginLog) {
        Assert.notNull(loginLog, "loginLog must not be null");
        return new LoginLogDTO().covertFrom(loginLog);
    }

    @Override
    public List<LoginLogDTO> convertTo(List<LoginLog> loginLogs) {
        if (CollectionUtils.isEmpty(loginLogs)) {
            return Collections.emptyList();
        }
        return loginLogs.stream()
                .map(this::convertTo)
                .collect(Collectors.toList());
    }
}
