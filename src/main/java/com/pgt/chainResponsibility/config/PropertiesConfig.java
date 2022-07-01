package com.pgt.chainResponsibility.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Map;

@Data
@Component
@PropertySource(value = "classpath:config/myChain.properties",ignoreResourceNotFound = false)
@ConfigurationProperties(prefix = "chainconfig")
public class PropertiesConfig {
    private Map<String,String> chainsName;
}
