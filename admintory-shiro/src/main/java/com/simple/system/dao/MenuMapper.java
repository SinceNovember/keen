package com.simple.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simple.system.model.dto.MenuDTO;
import com.simple.system.model.dto.TreeDTO;
import com.simple.system.model.entity.Menu;
import com.simple.system.model.vo.MenuCondition;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    @Select("select * from t_menu where pid =#{pid} and deleted = 0 order by order_num desc")
    @ResultMap("BaseWithChildrenResultMap")
    List<MenuDTO> listMenuByParentId(@Param("pid")int pid);

    @Select("select * from t_menu where pid is null and deleted = 0 order by order_num desc")
    @ResultMap("BaseWithChildrenResultMap")
    List<MenuDTO> listRootMenu();


    @Select({" <script>" ,
            "select * from t_menu where pid is null and deleted = 0 ",
            "<if test='menuCondition.title != null and menuCondition.title  !=\"\"'>",
            "  and title like concat('%', #{menuCondition.title}, '%') ",
            "</if>",
            "order by order_num desc ",
            "limit #{pageStart}, #{pageSize}",
            "</script>"})
    @ResultMap("BaseWithChildrenResultMap")
    List<MenuDTO> listMenu(MenuCondition menuCondition, @Param("pageStart") int pageStart, @Param("pageSize") int pageSize);

    /**
     * 根据路径和请求方法获取按钮
     * @param path
     * @param requestMethod
     * @return
     */
    @Select("select * from t_menu where path = #{path} and request_method =#{requestMethod} and deleted = 0")
    MenuDTO getButtonByPathAndRequestMethod(String path, String requestMethod);

    @Select("select * from t_menu where id =#{menuId} and deleted = 0 ")
    @ResultMap("BaseResultMap")
    MenuDTO getMenuBaseInfoById(Integer menuId);

    @Select({" <script>" ,
            "select count(*) from t_menu where pid is null and deleted = 0 ",
            "<if test='title != null and title  !=\"\"'>",
            "  and title like concat('%', #{title}, '%') ",
            "</if>",
            "</script>"})
    int countMenu(MenuCondition menuCondition);

    @Select({" <script>" ,
            "select id, title as label from t_menu where deleted = 0  ",
            "<if test='parentId != null '>",
            "  and pid =#{parentId} ",
            "</if>",
            "<if test='parentId == null '>",
            "  and pid is null ",
            "</if>",
            "</script>"})
    @ResultMap("TreeResultMap")
    List<TreeDTO> listMenuTree(Integer parentId);

    @Insert({" <script>" ,
            "insert into t_menu (path, pid, component,name,redirect, title, icon,is_expand, hidden, always_show, affix, order_num, type, request_method, create_time, update_time, deleted) ",
            "values(",
            "#{path},#{parentId},#{component},#{name},#{redirect},#{meta.title},#{meta.icon},#{isExpand},#{hidden},#{alwaysShow},#{meta.affix},#{orderNum},  #{menuType}, #{requestMethod}, #{createTime},#{updateTime}, #{deleted}",
            ")",
            "</script>"
    })
    boolean insertMenu(Menu menu);

    @Update({" <script>" ,
            " update t_menu ",
            "<set>",
            " <if test='path != null'>path = #{path},</if>",
            " pid = #{parentId},",
            " <if test='component != null'>component = #{component},</if>",
            " <if test='name != null'>name = #{name},</if>",
            " <if test='redirect != null'>redirect = #{redirect},</if>",
            " <if test='meta.title != null'>title = #{meta.title},</if>",
            " <if test='meta.icon != null'>icon = #{meta.icon},</if>",
            " <if test='isExpand != null'>is_expand = #{isExpand},</if>",
            " <if test='hidden != null'>hidden = #{hidden},</if>",
            " <if test='meta.affix != null'>affix = #{meta.affix},</if>",
            " <if test='updateTime != null'>update_time = #{updateTime},</if>",
            " <if test='alwaysShow != null'>always_show = #{alwaysShow},</if>",
            " <if test='orderNum != null'>order_num = #{orderNum},</if>",
            " <if test='menuType != null'>type = #{menuType},</if>",
            " <if test='requestMethod != null'>request_method = #{requestMethod},</if>",
            "</set>",
            " where id = #{id}",
            "</script>"
    })
    boolean updateMenu(Menu menu);


}
