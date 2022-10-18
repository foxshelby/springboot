package com.springboot.springdatarediscache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@MapperScan(basePackages = "com.springboot.springdatarediscache.mapper")
public class SpringDataRedisCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataRedisCacheApplication.class, args);
    }

}
