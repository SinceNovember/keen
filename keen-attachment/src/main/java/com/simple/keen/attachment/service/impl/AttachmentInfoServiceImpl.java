package com.simple.keen.attachment.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.io.FileUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageSerializable;
import com.simple.keen.attachment.mapper.AttachmentInfoMapper;
import com.simple.keen.attachment.mapping.AttachmentFolderMapping;
import com.simple.keen.attachment.mapping.AttachmentInfoMapping;
import com.simple.keen.attachment.model.dto.AttachmentFolderAndInfoDTO;
import com.simple.keen.attachment.model.dto.AttachmentInfoDTO;
import com.simple.keen.attachment.model.dto.AttachmentInfoSummaryDTO;
import com.simple.keen.attachment.model.entity.AttachmentInfo;
import com.simple.keen.attachment.model.query.AttachmentFolderAndInfoQuery;
import com.simple.keen.attachment.model.vo.AttachmentFolderAndInfoVO;
import com.simple.keen.attachment.model.vo.AttachmentInfoSummaryVO;
import com.simple.keen.attachment.service.IAttachmentInfoService;
import com.simple.keen.attachment.service.IAttachmentStorageService;
import com.simple.keen.common.utils.PageHelperUtils;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/5/25
 */
@Slf4j
@Service
@RequiredArgsConstructor
@ConditionalOnMissingBean(AliyunOSSAttachmentServiceImpl.class)
public class AttachmentInfoServiceImpl extends
    ServiceImpl<AttachmentInfoMapper, AttachmentInfo> implements
    IAttachmentInfoService {

    private final IAttachmentStorageService attachmentStorageService;

    private static final String DEFAULT_ORDER_BY = " isFolder desc, order_num desc, create_time desc";

    @Override
    public PageSerializable<AttachmentFolderAndInfoVO> pageAttachmentFolderAndInfo(
        AttachmentFolderAndInfoQuery folderQuery) {
        PageHelperUtils.startPage(folderQuery, DEFAULT_ORDER_BY);
        List<AttachmentFolderAndInfoDTO> attachmentFolderDTOS = baseMapper.selectAttachmentList(
            folderQuery);
        attachmentFolderDTOS.forEach(
            item -> item.setSize(formatAttachmentSize(item.getAttachmentSize())));

        return PageHelperUtils.convertPageDto2Vo(attachmentFolderDTOS,
            AttachmentFolderMapping.INSTANCE::toAttachmentFolderVOList);
    }

    @Override
    public AttachmentInfoDTO getAttachmentInfoAndStorageById(Integer id) {
        AttachmentInfo attachment = getById(id);
        AttachmentInfoDTO attachmentInfoDTO = AttachmentInfoMapping.INSTANCE.toAttachmentInfoDTO(
            attachment);
        attachmentInfoDTO.setStorageData(attachmentStorageService.getStorageDataByAttachmentId(id));
        return attachmentInfoDTO;
    }

    @Override
    public String getAttachmentStorageDataBase64ById(Integer id) {
        return attachmentStorageService.getStorageDataBase64ByAttachmentId(id);
    }

    @Override
    public void addOrUpdateAttachmentInfo(AttachmentFolderAndInfoQuery query) {
        AttachmentInfoDTO attachmentInfoDTO = AttachmentInfoMapping.INSTANCE.toAttachmentInfoDTO(
            query);
        if (attachmentInfoDTO.getId() == null) {
            attachmentInfoDTO.setCreateTime(LocalDateTime.now());
            attachmentInfoDTO.setCreateUserId(StpUtil.getLoginIdAsInt());
        }
        this.saveOrUpdate(AttachmentInfoMapping.INSTANCE.toAttachment(attachmentInfoDTO));
    }

    @Override
    public AttachmentInfo addAttachmentInfoByFile(MultipartFile file, Integer folderId) {
        AttachmentInfo attachment = new AttachmentInfo();
        attachment.setAttachmentName(file.getOriginalFilename());
        attachment.setMineType(file.getContentType());
        attachment.setAttachmentSource(file.getOriginalFilename());
        attachment.setContentType(file.getContentType());
        attachment.setAttachmentSuffix(FileUtil.getSuffix(file.getOriginalFilename()));
        attachment.setAttachmentSize(file.getSize());
        attachment.setCreateUserId(StpUtil.getLoginIdAsInt());
        attachment.setCreateTime(LocalDateTime.now());
        attachment.setFolderId(folderId);
        save(attachment);
        return attachment;
    }

    @Override
    public AttachmentInfoSummaryVO countItemAndSumStorageSize() {
        AttachmentInfoSummaryDTO attachmentInfoSummaryDTO = baseMapper.selectItemCountAndStorageSizeSum();
        attachmentInfoSummaryDTO.setFormatStorageSize(
            formatAttachmentSize(attachmentInfoSummaryDTO.getStorageSize()));
        return AttachmentInfoMapping.INSTANCE.toAttachmentInfoSummaryVO(attachmentInfoSummaryDTO);
    }


    /**
     * 格式附件大小 字节-> B|KB|MB|GB|TB
     *
     * @param size 大小
     * @return size B|KB|MB|GB|TB
     */
    private String formatAttachmentSize(long size) {
        if (size <= 0) {
            return "";
        }
        final String[] units = new String[]{"B", "KB", "MB", "GB", "TB"};
        int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
        return new DecimalFormat("#,##0.00")
            .format(size / Math.pow(1024, digitGroups)) + " " + units[digitGroups];
    }

}
