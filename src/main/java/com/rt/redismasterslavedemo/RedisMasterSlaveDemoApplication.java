package com.rt.redismasterslavedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
public class RedisMasterSlaveDemoApplication {

	// https://faun.pub/redis-master-slave-configuration-and-tested-in-spring-boot-3a68e7314b90
	public static void main(String[] args) {
		SpringApplication.run(RedisMasterSlaveDemoApplication.class, args);
	}

}
