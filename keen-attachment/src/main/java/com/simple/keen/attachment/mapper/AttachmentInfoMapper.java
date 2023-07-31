package com.simple.keen.attachment.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simple.keen.attachment.model.dto.AttachmentFolderAndInfoDTO;
import com.simple.keen.attachment.model.dto.AttachmentInfoSummaryDTO;
import com.simple.keen.attachment.model.entity.AttachmentInfo;
import com.simple.keen.attachment.model.query.AttachmentFolderAndInfoQuery;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AttachmentInfoMapper extends BaseMapper<AttachmentInfo> {

    @Select("<script>"
        + "select a.*, b.nickname as createUserNickname from (SELECT "
        + "id, "
        + "folder_name as name, "
        + "create_user_id, "
        + "create_time, "
        + "order_num, "
        + "1 AS isFolder, "
        + "'dir' as suffix,"
        + "0 as attachment_size "
        + "FROM  t_attachment_folder "
        + "WHERE pid is not null "
        + "<choose>"
        + "<when test=\"name != null and name != ''\">"
        + "and folder_name like concat('%', #{name} ,'%') "
        + "</when>"
        + "<otherwise>"
        + "and pid =#{parentId} "
        + "</otherwise>"
        + "</choose>"
        + "<if test=\"includeFile\">"
        + "union ALL "
        + "select   "
        + "id, "
        + "attachment_name as `name`, "
        + "create_user_id, "
        + "create_time, "
        + "null as order_num, "
        + "0 as isFolder, "
        + "attachment_suffix as suffix, "
        + "attachment_size "
        + "from t_attachment_info "
        + " where folder_id is not null "
        + "<choose>"
        + "<when test=\"name != null and name != ''\">"
        + "and attachment_name like concat('%', #{name} ,'%') "
        + "</when>"
        + "<otherwise>"
        + "and folder_id = #{parentId} "
        + "</otherwise>"
        + "</choose>"
        + "</if>"
        + ") a left join t_user b on a.create_user_id = b.id "
        + "order by isFolder desc, create_time desc"
        + "</script>")
    List<AttachmentFolderAndInfoDTO> selectAttachmentList(AttachmentFolderAndInfoQuery folderQuery);

    @Select("<script> "
        + "select count(*) as itemCount, sum(attachment_size) as storageSize "
        + "from t_attachment_info where folder_id is not null"
        + "</script>")
    AttachmentInfoSummaryDTO selectItemCountAndStorageSizeSum();
}
