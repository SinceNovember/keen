package com.simple.common.config;

import com.simple.common.service.UploadImageService;
import com.simple.common.service.impl.QiNiuUploadImageServiceImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * CloudStorageConfig
 *
 * @description 云存储配置类
 */
@Data
@Configuration
public class CloudStorageConfig {

    /**
     * 七牛域名domain
     */
    @Value("${oss.qiniu.domain}")
    private String qiniuDomain;
    /**
     * 七牛ACCESS_KEY
     */
    @Value("${oss.qiniu.accessKey}")
    private String qiniuAccessKey;
    /**
     * 七牛SECRET_KEY
     */
    @Value("${oss.qiniu.secretKey}")
    private String qiniuSecretKey;
    /**
     * 七牛空间名
     */
    @Value("${oss.qiniu.bucket}")
    private String qiniuBucketName;


    @ConditionalOnProperty(name = "oss.qiniu.enable", havingValue = "true")
    @Bean
    @Primary
    public UploadImageService uploadImageService(CloudStorageConfig config){
        return new QiNiuUploadImageServiceImpl(config);
    }
}
