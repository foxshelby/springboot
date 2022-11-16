package com.springboot.kafkaconsumer.topic;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:zdd
 * @Date： 2022/11/16 10:15
 * 这里是kafka的Topic的配置类
 */
@Configuration
public class TopicConfig {

    /**
     * @return org.springframework.kafka.core.KafkaAdmin
     * @author zdd
     * @createTime 2022/11/16 10:17
     * @desc 只要在IOC容器中配置了这个类 就可以自行创建Topic
     * @Param []
     */
    @Bean
    public KafkaAdmin admin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        return new KafkaAdmin(configs);
    }


    @Bean
    public NewTopic topic1() {
        return TopicBuilder.name("thing1")
                .partitions(10)
                .replicas(3)
                .compact()
                .build();
    }

    @Bean
    public NewTopic topic2() {
        return TopicBuilder.name("thing2")
                .partitions(10)
                .replicas(3)
                .compact()
                .build();
    }

}
