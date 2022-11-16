package com.springboot.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

import javax.annotation.Resource;
import java.time.Duration;
import java.time.LocalDateTime;

@SpringBootApplication
@EnableCaching
public class CacheApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(CacheApplication.class, args);
        LettuceConnectionFactory bean = run.getBean(LettuceConnectionFactory.class);
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime = now.plusHours(1);
        LocalDateTime startTime = LocalDateTime.of(2020, 10, 1, 0, 0, 0);
        LocalDateTime endTime = LocalDateTime.of(2022, 10, 1, 0, 0, 0);
        Duration duration = Duration.between(startTime, endTime);
        long days = duration.toDays();
        long hours = duration.toHours();
        long minutes = duration.toMinutes();
// long seconds = duration.toSeconds();
        long millis = duration.toMillis();
        long nanos = duration.toNanos();

        System.out.println("相差天数：" + days);
        System.out.println("相差小时数：" + hours);
        System.out.println("相差分钟数：" + minutes);
        System.out.println("相差毫秒数：" + millis);
        System.out.println("相差纳秒数：" + nanos);
    }

}
