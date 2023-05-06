package com.simple.keen.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simple.keen.common.base.TreeModel;
import com.simple.keen.system.model.dto.DeptDTO;
import com.simple.keen.system.model.entity.Dept;
import com.simple.keen.system.model.query.DeptQuery;
import java.util.List;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DeptMapper extends BaseMapper<Dept> {

    @Select("<script>"
        + "select * from t_dept where parent_id is null and deleted = 0 "
        + "<if test=\"deptName != null and deptName != ''\">"
        + "and dept_name like concat('%', #{deptName}, '%') "
        + "</if>"
        + "</script>")
    @Results(id = "BaseResultMap", value = {
        @Result(column = "id", property = "id"),
        @Result(column = "id", property = "children", many = @Many(
            select = "com.simple.keen.system.mapper.DeptMapper.selectDeptListByParentId"
        )),
        @Result(column = "id", property = "users", many = @Many(
            select = "com.simple.keen.system.mapper.UserMapper.selectUserListByDeptId"
        ))})
    List<DeptDTO> selectDeptList(DeptQuery deptQuery);


    @Select("select * from t_dept where parent_id =#{parentId} and deleted = 0 order by order_num desc")
    @ResultMap("BaseResultMap")
    List<DeptDTO> selectDeptListByParentId(@Param("parentId") Integer parentId);

    @Select("<script>"
        + "select id as value, dept_name as label from t_dept "
        + "where deleted = 0 "
        + "<if test=\"parentId == null or parentId == ''  \">"
        + " and parent_id is null"
        + "</if>"
        + "<if test=\"parentId != null and parentId != ''  \">"
        + " and parent_id = #{parentId}"
        + "</if>"
        + "</script>")
    @Results(id = "DeptTreeModelResultMap", value = {
        @Result(column = "value", property = "value"),
        @Result(column = "label", property = "label"),
        @Result(column = "value", property = "children", many = @Many(
            select = "com.simple.keen.system.mapper.DeptMapper.selectDeptTreeModelList"
        ))})
    List<TreeModel> selectDeptTreeModelList(@Param("parentId") Integer parentId);

}
