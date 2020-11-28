package com.example.springcloudalibabanacosconfig.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zengchzh
 * @description: TODO
 * @date 2020/8/28 11:20
 */

@RestController
@RefreshScope // 刷新配置
public class TestController {

    @Value("${msg:null}")
    private String msg;

    @Value("${msg-a:null}")
    private String configA;

    @Value("${msg-b:null}")
    private String configB;

    @GetMapping("msg")
    public String getMsg(){
        return this.msg;
    }

    @GetMapping("msg2")
    public String getMsg2(){
        return this.configA + "    " + this.configB;
    }
}
