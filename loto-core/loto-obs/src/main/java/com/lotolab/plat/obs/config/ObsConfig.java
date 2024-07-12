package com.lotolab.plat.obs.config;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@Accessors(chain = true,fluent = true)
public class ObsConfig {

    @Value("${loto.obs.avatar.prefix:avatar}")
    private String avatarPath;

    @Value("${loto.obs.avatar.maxSize:20}")
    private Integer maxSize;

}
