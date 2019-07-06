package com.mmall.concurrency.example.cache;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.JedisPool;

@Configuration
public class RedisConfig {

    @Bean(name = "redisPool")
    public JedisPool jedisPool() {
        return new JedisPool("39.98.204.161", 6379);
    }
}
