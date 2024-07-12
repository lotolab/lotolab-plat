package com.lotolab.plat.obs.config.properties;

import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@ConditionalOnProperty(name="loto.obs.type",havingValue = "tencent")
@Configuration
@ConfigurationProperties(prefix = "loto.obs.tencent")
public class TencentCosProperties {

    private String appId;
    private String bucket;
    private String cdn;
    private String region;
    private String secretId;
    private String secretKey;

}
