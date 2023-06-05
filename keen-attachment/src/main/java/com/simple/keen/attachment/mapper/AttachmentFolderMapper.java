package com.simple.keen.attachment.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simple.keen.attachment.model.dto.AttachmentFolderDTO;
import com.simple.keen.attachment.model.entity.AttachmentFolder;
import com.simple.keen.attachment.model.query.AttachmentFolderQuery;
import com.simple.keen.attachment.model.query.AttachmentQuery;
import java.util.List;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AttachmentFolderMapper extends BaseMapper<AttachmentFolder> {

    @Select("<script>"
        + "SELECT a.*, b.nickname as createUserNickname FROM t_attachment_folder a left join t_user b on a.create_user_id = b.id "
        + "WHERE pid IS NULL order by a.order_num desc "
        + "</script>")
    @Results(id = "BaseResultMap", value = {
        @Result(column = "id", property = "id"),
        @Result(column = "pid", property = "parentId"),
        @Result(column = "id", property = "children", many = @Many(
            select = "com.simple.keen.attachment.mapper.AttachmentFolderMapper.selectAttachmentFolderListByParentId"
        ))})
    List<AttachmentFolderDTO> selectAttachmentFolderList(AttachmentFolderQuery folderQuery);

    @Select("SELECT a.*, b.nickname as createUserNickname FROM t_attachment_folder a left join t_user b on a.create_user_id = b.id"
        + " where pid =#{pid} order by a.order_num desc")
    @ResultMap("BaseResultMap")
    List<AttachmentFolderDTO> selectAttachmentFolderListByParentId(@Param("pid") Integer pid);
}
