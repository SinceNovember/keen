package com.simple.keen.monitor.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simple.keen.common.base.dto.ChartDTO;
import com.simple.keen.monitor.model.dto.LoginLogDTO;
import com.simple.keen.monitor.model.dto.RecentLoginLogDTO;
import com.simple.keen.monitor.model.entity.LoginLog;
import com.simple.keen.monitor.model.query.LoginLogQuery;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/2/6
 */
@Mapper
public interface LoginLogMapper extends BaseMapper<LoginLog> {

    @Select("<script>"
        + "select * from t_login_log "
        + "<where>"
        + "<if test=\"nickname != null and nickname != ''\">"
        + "and nickname like concat('%', #{nickname}, '%') "
        + "</if>"
        + "<if test=\"userId != null and userId != ''\">"
        + "and user_id = #{userId}"
        + "</if>"
        + "</where> "
        + "order by login_time desc"
        + "</script>")
    List<LoginLogDTO> selectLoginLogList(LoginLogQuery loginLogQuery);

    @Select("<script>"
        + "select a.id, "
        + "a.location, "
        + "a.ip, "
        + "a.login_time, "
        + "a.nickname, "
        + "a.user_id, "
        + "b.avatar, "
        + "c.dept_name "
        + "from t_login_log a "
        + "JOIN t_user b ON a.user_id = b.id "
        + "JOIN t_dept c ON b.dept_id = c.id "
        + "order by login_time desc "
        + "limit 5"
        + "</script>")
    List<RecentLoginLogDTO> selectLoginLogTop5List();

    @Select("<script>"
        + "SELECT DATE(login_time) AS name, COUNT(*) AS count  "
        + "FROM t_login_log  "
        + "WHERE login_time >= DATE_SUB( NOW(), INTERVAL 1 WEEK )  "
        + "GROUP BY DATE ( login_time )"
        + "</script>")
    List<ChartDTO> selectLoginLogWeekChart();

}
