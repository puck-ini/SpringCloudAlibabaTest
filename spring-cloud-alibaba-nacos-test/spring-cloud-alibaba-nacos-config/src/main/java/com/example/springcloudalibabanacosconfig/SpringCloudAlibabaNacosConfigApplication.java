package com.example.springcloudalibabanacosconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;


@SpringBootApplication
public class SpringCloudAlibabaNacosConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudAlibabaNacosConfigApplication.class, args);
    }

}
