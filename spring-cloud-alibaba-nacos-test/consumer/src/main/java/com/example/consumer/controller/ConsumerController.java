package com.example.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zengchzh
 * @description: TODO
 * @date 2020/8/28 10:36
 */
@RestController
@RequestMapping("consumer")
public class ConsumerController {

    /**
     * 负载均衡
     */
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    /**
     * http请求
     */
    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("hello/{msg}")
    public String helloMsg(@PathVariable String msg){
        //获取服务发现系统中一个实例
        ServiceInstance serviceInstance = loadBalancerClient.choose("provider");
        String path = String.format("http://%s:%s/provider/%s", serviceInstance.getHost(),serviceInstance.getPort(),msg);
        String result = restTemplate.getForObject(path,String.class);
        return String.format("%s from %s %s", result, serviceInstance.getHost(),serviceInstance.getPort());
    }
}
