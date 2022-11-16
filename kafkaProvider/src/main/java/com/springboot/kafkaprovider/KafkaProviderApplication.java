package com.springboot.kafkaprovider;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;

import javax.annotation.Resource;
import java.util.concurrent.CompletableFuture;

@SpringBootApplication
public class KafkaProviderApplication {

    @Resource
    private KafkaTemplate kafkaTemplate;

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(KafkaProviderApplication.class, args);
        KafkaTemplate kafkaTemplate = run.getBean(KafkaTemplate.class);
        kafkaTemplate.send("thing1", "测试kafkaTemplate");
    }

}
