package com.example.consumer;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

/**
 * @author zengchzh
 * @date 2020/9/10 23:03
 * @description TODO
 */

@Service
@Slf4j
public class TestService {

//    @StreamListener(Sink.INPUT)
    public void testStream(String msg){
        log.info("spring cloud stream test : " + msg);
    }
}
