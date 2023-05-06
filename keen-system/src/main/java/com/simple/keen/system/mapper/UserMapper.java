package com.simple.keen.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simple.keen.common.base.TreeModel;
import com.simple.keen.system.model.dto.UserDTO;
import com.simple.keen.system.model.entity.User;
import com.simple.keen.system.model.query.UserQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * .
 *
 * @author SinceNovember
 * @date 2022/12/16
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("<script>"
        + "select a.*, b.dept_name"
        + " from t_user a left join t_dept b on a.dept_id = b.id and b.deleted = 0"
        + " where a.deleted = 0 "
        + "<if test=\"nickname != null and nickname != ''\">"
        + "and nickname like concat('%', #{nickname}, '%') "
        + "</if>"
        + "order by order_num desc"
        + "</script>")
    List<UserDTO> selectUserList(UserQuery userQuery);

    @Select("<script>"
        + "select * from t_user where deleted = 0 "
        + "<if test=\"deptId != null \">"
        + "and dept_id =#{deptId} "
        + "</if>"
        + "order by order_num desc"
        + "</script>")
    List<UserDTO> selectUserListByDeptId(@Param("deptId") Integer deptId);

    @Select("<script>"
        + "select id as value, nickname as label from t_user where deleted = 0 "
        + "order by order_num desc"
        + "</script>")
    List<TreeModel> selectUserTreeModelList();
}
