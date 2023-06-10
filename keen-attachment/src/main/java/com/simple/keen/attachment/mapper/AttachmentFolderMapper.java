package com.simple.keen.attachment.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simple.keen.attachment.model.dto.AttachmentFolderAndInfoDTO;
import com.simple.keen.attachment.model.entity.AttachmentFolder;
import com.simple.keen.attachment.model.query.AttachmentFolderAndInfoQuery;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AttachmentFolderMapper extends BaseMapper<AttachmentFolder> {


    @Select(
        "SELECT a.*, b.nickname as createUserNickname FROM t_attachment_folder a left join t_user b on a.create_user_id = b.id"
            + " where pid =#{pid} order by a.order_num desc")
    List<AttachmentFolderAndInfoDTO> selectAttachmentFolderListByParentId(@Param("pid") Integer pid);
}
