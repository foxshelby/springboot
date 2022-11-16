package com.springboot.kafkaprovider.template;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author:zdd
 * @Date： 2022/11/16 10:22
 */
@Component
public class KafkaTemplateConfig {

    @Resource
    private KafkaTemplate kafkaTemplate;
}
