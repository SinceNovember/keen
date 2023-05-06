package com.simple.keen.monitor.service.impl;

import static com.simple.keen.common.utils.HttpUtils.requestBrowser;
import static com.simple.keen.common.utils.HttpUtils.requestIp;
import static com.simple.keen.common.utils.HttpUtils.requestLocation;
import static com.simple.keen.common.utils.HttpUtils.requestSystem;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageSerializable;
import com.simple.keen.common.base.dto.ChartDTO;
import com.simple.keen.common.base.vo.ChartVO;
import com.simple.keen.common.utils.LocalDateTimeUtils;
import com.simple.keen.common.utils.PageHelperUtils;
import com.simple.keen.kafka.message.LoginLogMessage;
import com.simple.keen.kafka.producer.Producer;
import com.simple.keen.monitor.mapper.LoginLogMapper;
import com.simple.keen.monitor.mapping.LoginLogMapping;
import com.simple.keen.monitor.model.dto.LoginLogDTO;
import com.simple.keen.monitor.model.dto.RecentLoginLogDTO;
import com.simple.keen.monitor.model.entity.LoginLog;
import com.simple.keen.monitor.model.query.LoginLogQuery;
import com.simple.keen.monitor.model.vo.LoginLogVO;
import com.simple.keen.monitor.model.vo.RecentLoginLogVO;
import com.simple.keen.monitor.service.ILoginLogService;
import com.simple.keen.system.service.IUserRoleRelateService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/2/6
 */
@Service
@RequiredArgsConstructor
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> implements
    ILoginLogService {

    private final List<Producer> producerList;

    private final IUserRoleRelateService userRoleRelateService;

    @Override
    public PageSerializable<LoginLogVO> pageLoginLog(LoginLogQuery loginLogQuery) {
        PageHelper.startPage(loginLogQuery.getPageNum(), loginLogQuery.getPageSize());
        List<LoginLogDTO> loginLogDTOS = baseMapper.selectLoginLogList(
            loginLogQuery);

        return PageHelperUtils.convertPageDto2Vo(loginLogDTOS,
            LoginLogMapping.INSTANCE::toLoginLogVOList);
    }

    @Override
    public LoginLogVO getLoginLogById(Integer id) {
        return LoginLogMapping.INSTANCE.toLoginLogVO(getById(id));
    }

    @Override
    public List<RecentLoginLogVO> getRecentLoginLog() {
        List<RecentLoginLogDTO> recentLoginLogDTOS = baseMapper.selectLoginLogTop5List();
        recentLoginLogDTOS.forEach(
            item -> {
                item.setFormatTime(LocalDateTimeUtils.formatSimpleTime(item.getLoginTime()));
                item.setRoleNames(userRoleRelateService.listRoleNameByUserId(item.getUserId()));
            });

        return LoginLogMapping.INSTANCE.toRecentLoginLogVOList(recentLoginLogDTOS);
    }

    @Override
    public long getLoginLogAllCount() {
        return count();
    }

    @Override
    public long getLoginLogTodayCount() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startOfDay = LocalDateTime.of(now.toLocalDate(), LocalTime.MIN);
        LocalDateTime endOfDay = LocalDateTime.of(now.toLocalDate(), LocalTime.MAX);
        return count(Wrappers.<LoginLog>lambdaQuery()
            .between(LoginLog::getLoginTime, startOfDay, endOfDay));
    }

    @Override
    public ChartVO getLoginLogWeekChart() {
        List<String> names = new ArrayList<>();
        List<Object> counts = new ArrayList<>();
        List<ChartDTO> chartDTOS = baseMapper.selectLoginLogWeekChart();
        Map<String, Integer> collect = chartDTOS.stream()
            .collect(Collectors.toMap(ChartDTO::getName, ChartDTO::getCount));

        for (LocalDate now = LocalDate.now().minusDays(6); LocalDate.now().plusDays(1).isAfter(now);
            now = now.plusDays(1)) {
            String formatDate = LocalDateTimeUtils.format(now, "yyyy-MM-dd");
            names.add(formatDate);
            counts.add(collect.computeIfAbsent(formatDate, k -> 0));
        }
        return ChartVO.builder()
            .nameList(names)
            .valueList(counts)
            .build();
    }

    @Override
    public void addLoginLog(LoginLogQuery loginLogQuery) {
        LoginLogDTO loginLogDTO = LoginLogMapping.INSTANCE.toLoginLogDTO(
            loginLogQuery);
        this.save(LoginLogMapping.INSTANCE.toLoginLog(loginLogDTO));
    }

    @Override
    public void addLoginLog(String nickname) {
        LoginLog loginLog = new LoginLog();
        loginLog.setNickname(nickname);
        loginLog.setBrowser(requestBrowser());
        loginLog.setSystem(requestSystem());
        loginLog.setIp(requestIp());
        loginLog.setLocation(requestLocation(requestIp()));
        loginLog.setLoginTime(LocalDateTime.now());
        loginLog.setUserId(StpUtil.getLoginIdAsInt());

        LoginLogMessage loginLogMessage = new LoginLogMessage();
        loginLogMessage.setNickname(nickname);
        loginLogMessage.setBrowser(requestBrowser());
        loginLogMessage.setSystem(requestSystem());
        loginLogMessage.setIp(requestIp());
        loginLogMessage.setLocation(requestLocation(requestIp()));
        loginLogMessage.setLoginTime(LocalDateTime.now());

//        KafkaProducers.LOGIN_LOG.sendAsync(loginLogMessage);
        save(loginLog);
    }


    @Override
    public void deleteLoginLog(List<Integer> ids) {
        remove(Wrappers.<LoginLog>lambdaUpdate()
            .in(LoginLog::getId, ids));
    }

}
