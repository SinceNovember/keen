package com.simple.keen.attachment.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simple.keen.attachment.model.dto.AttachmentInfoDTO;
import com.simple.keen.attachment.model.entity.AttachmentStorage;
import com.simple.keen.attachment.model.query.AttachmentQuery;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AttachmentStorageMapper extends BaseMapper<AttachmentStorage> {

    @Select("<script> "
        + "select * from ("
        + "select "
        + "a.*, b.nickname 'fromName', c.nickname 'toName' "
        + "from "
        + "t_message_chat a "
        + "left join t_user b on a.from_id = b.id "
        + "left join t_user c on a.to_id = c.id "
        + ")a"
        + "<where>"
        + "<if test=\"fromName != null and fromName != ''\">"
        + "and fromName like concat('%', #{fromName}, '%') "
        + "</if>"
        + "</where>"
        + "</script>")
    List<AttachmentInfoDTO> selectAttachmentList(AttachmentQuery attachmentQuery);

}
