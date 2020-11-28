package com.example.springcloudalibabasentineltest.controller;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.sun.org.apache.xpath.internal.functions.FuncTrue;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author zengchzh
 * @description: TODO
 * @date 2020/9/1 10:41
 */

@RestController
public class TestController {

    @Async
    @GetMapping("test1")
    public CompletableFuture<String> test1() throws ExecutionException, InterruptedException {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return "test1";
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        });
    }


    @GetMapping("test2")
    public CompletableFuture<String> test2() throws ExecutionException, InterruptedException {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return "test2";
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        });
    }



    @Async("taskExecutor")
    @GetMapping("test3")
    public Future<String> test3(){
        return AsyncResult.forValue("test3");
    }

    @GetMapping("test4")
    public String test4(){
        this.initFlowQpsRule();
        return "test4";
    }
    
    
    private String getString() throws InterruptedException {
//        TimeUnit.SECONDS.sleep(5);

        return "test1";
    }

    private void initFlowQpsRule() {
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule("resourceName");
        // set limit qps to 20
        rule.setCount(20);
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setLimitApp("default");
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }
}
