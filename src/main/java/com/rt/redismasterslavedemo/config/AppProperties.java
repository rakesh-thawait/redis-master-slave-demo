package com.rt.redismasterslavedemo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "spring.redis")
@Configuration
public class AppProperties {
    // The variable name should match the key in the properties file
    private String host;
    private int port;
    private AppProperties master;
    private List<AppProperties> slaves;
}
