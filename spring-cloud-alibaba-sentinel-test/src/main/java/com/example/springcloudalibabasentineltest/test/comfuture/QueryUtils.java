package com.example.springcloudalibabasentineltest.test.comfuture;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * @author zengchzh
 * @description: TODO
 * @date 2020/9/4 10:21
 */
public class QueryUtils {

    //模拟查询返回car信息
    public String queryCar(Integer carId){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "car_desc";
    }
    //模拟查询返回job信息
    public String queryJob(Integer jobId){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "job_desc";
    }
    //模拟查询返回home信息
    public String queryHome(Integer homeId){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "home_desc";
    }
}
