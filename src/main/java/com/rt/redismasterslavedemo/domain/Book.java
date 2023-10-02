package com.rt.redismasterslavedemo.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

@Data
@RedisHash(timeToLive = 3600)
public class Book implements Serializable {

    @Id
    String id;

    @Indexed
    String isbn;
    String name;
    Author author;
}
