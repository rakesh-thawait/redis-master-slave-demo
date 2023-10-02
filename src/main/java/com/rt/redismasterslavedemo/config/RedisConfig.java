package com.rt.redismasterslavedemo.config;

import io.lettuce.core.ReadFrom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStaticMasterReplicaConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {

    @Autowired
    AppProperties properties;
    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        // Read from replica
        LettuceClientConfiguration clientConfig = LettuceClientConfiguration.builder()
                .readFrom(ReadFrom.REPLICA_PREFERRED)
                .build();

        // Redis in master-slave config mode (fail-over is not automatic)

        // Redis master details
        RedisStaticMasterReplicaConfiguration staticMasterReplicaConfiguration = new RedisStaticMasterReplicaConfiguration(properties.getMaster().getHost(),
                properties.getMaster().getPort());
        // Redis slave details
        properties.getSlaves().forEach(
                slave -> staticMasterReplicaConfiguration.addNode(slave.getHost(), slave.getPort())
        );

        return new LettuceConnectionFactory(staticMasterReplicaConfiguration, clientConfig);
    }

    @Bean
    public RedisTemplate<?, ?> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<?, ?> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);

        return template;
    }
}
