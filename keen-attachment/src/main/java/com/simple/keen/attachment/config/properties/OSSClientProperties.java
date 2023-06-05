package com.simple.keen.attachment.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * .
 *
 * @author SinceNovember
 * @date 2022/12/28
 */
@Data
@ConfigurationProperties(prefix = "aliyun.oss")
public class OSSClientProperties {

    private String endpoint;

    private String accessKeyId;

    private String accessKeySecret;

    private String bucketName;

    private String urlPrefix;

    private String dirPrefix;

}
