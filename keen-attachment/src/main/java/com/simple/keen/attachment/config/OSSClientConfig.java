package com.simple.keen.attachment.config;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import com.simple.keen.attachment.config.properties.OSSClientProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 上传文件到阿里云OSS配置
 *
 * @author SinceNovember
 * @date 2022/12/27
 */
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties({OSSClientProperties.class})
@ConditionalOnExpression("T(com.simple.keen.common.utils.StringUtils).isNotBlank('${aliyun.oss.endpoint}')")
public class OSSClientConfig {

    @Bean
    public OSSClient createOssClient(OSSClientProperties clientProperties) {
        return (OSSClient) new OSSClientBuilder().build(
            clientProperties.getEndpoint(),
            clientProperties.getAccessKeyId(),
            clientProperties.getAccessKeySecret());
    }

}
