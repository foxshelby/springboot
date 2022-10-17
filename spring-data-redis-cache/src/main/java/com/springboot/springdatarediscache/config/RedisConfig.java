package com.springboot.springdatarediscache.config;

import com.springboot.springdatarediscache.entity.Code;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.*;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:zdd
 * @Date： 2022/10/17 9:16
 */
@Configuration
public class RedisConfig {

    /**
     * @author zdd
     * @createTime 2022/10/17 15:43
     * @desc  redis连接工厂的设置
     * @Param []
     * @return org.springframework.data.redis.connection.RedisConnectionFactory
     */
    @Bean
    public RedisConnectionFactory redisConnectionFactory(){
        LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory("127.0.0.1", 6379);
        return lettuceConnectionFactory;
    }

    /**
     * @author zdd
     * @createTime 2022/10/17 15:43
     * @desc  操作redis的模板对象
     * @Param [redisConnectionFactory]
     * @return org.springframework.data.redis.core.RedisTemplate
     */
    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        //配置Template主要配置序列化的方式，因为写的是java程序，得到的是java类型的数据，最终要这个数据存储到数据库里面
        //就要指定一种序列化的方式，或者说数据转换的方式
        //设置key的序列化方式
        redisTemplate.setKeySerializer(RedisSerializer.string());
        //设置value的序列化方式
        redisTemplate.setValueSerializer(RedisSerializer.json());
        //设置hash的key的序列化方式
        redisTemplate.setHashKeySerializer(RedisSerializer.string());
        //设置hash的value的序列化方式
        redisTemplate.setHashValueSerializer(RedisSerializer.json());

        //开启redis的事务支持
        redisTemplate.setEnableTransactionSupport(true);
        redisTemplate.afterPropertiesSet();//使上面参数生效
        return redisTemplate;
    }

    //缓存管理器
    @Bean
    public CacheManager cacheManager( RedisConnectionFactory redisConnectionFactory) {
        //============================================================
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);

        // 配置序列化,及超时时间
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig();
        RedisCacheConfiguration redisCacheConfiguration = config.serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(redisSerializer))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer))
                .entryTtl(Duration.ofMinutes(5));

        RedisCacheManager cacheManager = RedisCacheManager.builder(redisConnectionFactory)
                .cacheDefaults(redisCacheConfiguration)
                .build();

        return cacheManager;
    }


}
