package com.springboot.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

import javax.annotation.Resource;

@SpringBootApplication
@EnableCaching
public class CacheApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(CacheApplication.class, args);
        LettuceConnectionFactory bean = run.getBean(LettuceConnectionFactory.class);


    }

}
