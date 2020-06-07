package com.wxh.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wxh.springcloud.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {
    @GetMapping("/A")
    @SentinelResource(value = "A",blockHandler = "exceptionA")
    public String A(){
        return "a";
    }

    public String exceptionA(BlockException e){
        return "exceptionA";
    }

    @GetMapping("/B")
    @SentinelResource(value = "B",blockHandlerClass = ExceptionHandler.class,blockHandler = "handler1")
    public String B(){
        return "B";
    }
}
