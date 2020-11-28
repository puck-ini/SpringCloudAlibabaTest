package com.example.consumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author zengchzh
 * @description: TODO
 * @date 2020/8/28 10:42
 */
@Configuration
public class ConsumerConfig {


    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
