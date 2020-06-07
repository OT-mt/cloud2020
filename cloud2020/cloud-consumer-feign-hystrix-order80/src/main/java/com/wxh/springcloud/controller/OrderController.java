package com.wxh.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.thoughtworks.xstream.annotations.XStreamImplicitCollection;
import com.wxh.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
    @Resource
    private PaymentHystrixService service;

    @GetMapping("/ok/{id}")
    public String paymentInfo_OK(@PathVariable Integer id) {
        return service.paymentInfo_OK(id);
    }

    // 设置超过 3 秒采用服务降级
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })
    @GetMapping("/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable Integer id) {
        return service.paymentInfo_Timeout(id);
    }

    public String paymentInfo_TimeoutHandler(Integer id){
        return "80异常，降级处理";
    }

    // 下面是全局 fallback
    public String paymentGlobalFallBack(){
        return "80：获取异常，调用方法为全局fallback";
    }
}
