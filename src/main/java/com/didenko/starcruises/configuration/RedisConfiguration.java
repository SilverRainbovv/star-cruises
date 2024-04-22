package com.didenko.starcruises.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;


@Configuration
public class RedisConfiguration {

//    @Bean
//    public JedisConnectionFactory jedisConnectionFactory(){
//
//        return new JedisConnectionFactory();
//    }
//
//    @Bean
//    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory){
//
//        RedisTemplate<String, Object> template = new RedisTemplate<>();
//        template.setConnectionFactory(jedisConnectionFactory());
//        return template;
//    }

//    @Bean
//    public RedisCacheManager redisCacheManager(RedisConnectionFactory connectionFactory){
//        return RedisCacheManager.create(connectionFactory);
//    }


}