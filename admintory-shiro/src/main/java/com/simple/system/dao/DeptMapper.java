package com.simple.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simple.system.model.dto.DeptDTO;
import com.simple.system.model.dto.DeptTreeDTO;
import com.simple.system.model.dto.OptionDTO;
import com.simple.system.model.dto.TreeDTO;
import com.simple.system.model.entity.Dept;
import com.simple.system.model.vo.DeptCondition;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface DeptMapper extends BaseMapper<Dept> {

    @Select({" <script>" ,
            "select * from t_dept a join t_user b on a.create_user_id = b.user_id where parent_id = 0 and a.deleted = 0 ",
            "<if test='deptCondition.deptName != null and deptCondition.deptName  !=\"\"'>",
            "  and dept_name like concat('%', #{deptCondition.deptName}, '%') ",
            "</if>",
            "<if test='deptCondition.username != null and deptCondition.username  !=\"\"'>",
            "  and username like concat('%', #{deptCondition.username}, '%') ",
            "</if>",
            "order by order_num desc ",
            "limit #{pageStart}, #{pageSize}",
            "</script>"})
    @ResultMap("BaseResultMap")
    List<DeptDTO> listDeptWithMember(DeptCondition deptCondition, @Param("pageStart") int pageStart, @Param("pageSize") int pageSize);

    @Select({" <script>" ,
            "select count(*) from t_dept a join t_user b on a.create_user_id = b.user_id where parent_id = 0 and a.deleted = 0 ",
            "<if test='deptName != null and deptName  !=\"\"'>",
            "  and dept_name like concat('%', #{deptName}, '%')",
            "</if>",
            "<if test='username != null and username  !=\"\"'>",
            "  and username like concat('%', #{username}, '%') ",
            "</if>",
            "</script>"})
    @ResultType(Long.class)
    long countDept(DeptCondition deptCondition);

    @Select("select dept_name as name, count(*) as value from t_dept a join t_user b on a.dept_id  = b.dept_id where b.deleted  = 0 group by dept_name order by count(*) desc")
    List<Map<String, Integer>> countDeptMember();

    @Select({" <script>" ,
            "select * from t_dept where parent_id = #{parentId} and deleted = 0 ",
            "order by order_num desc ",
            "</script>"})
    @ResultMap("BaseResultMap")
    List<DeptDTO> listDeptWithMemberByParentId(int parentId);

    @Select({" <script>" ,
            "select * from t_dept where dept_id = #{deptId} ",
            "order by order_num desc ",
            "</script>"})
    @ResultMap("BaseResultMap")
    DeptDTO getDeptWithMemberById(int deptId);

    @Select({" <script>" ,
            "select dept_name from t_dept where dept_id = #{deptId} ",
            "</script>"})
    String getDeptNameById(Integer deptId);

    @Select({" <script>" ,
            "select dept_id, dept_name from t_dept where parent_id = #{parentId} and deleted = 0 ",
//            "<if test='deptCondition.deptName != null'>",
//            "  and dept_name like %#{deptCondition.deptName}% ",
//            "</if>",
            "order by order_num desc ",
            "</script>"})
    @ResultMap("OptionResultMap")
    List<OptionDTO> listDeptOptionByParentId(int parentId);

    @Select("select dept_id as id, dept_name as label, '0' as nodeType from t_dept where parent_id = #{parentId} and deleted = 0 union all select user_id as id, nickname as label, '1' as nodeType from t_user where dept_id = #{parentId} and deleted = 0")
    @ResultMap("TreeResultMap")
    List<DeptTreeDTO> listDeptWithUserTreeModelByParentId(int parentId);

}
