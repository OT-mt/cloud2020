package com.wxh.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import com.wxh.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.runtime.Log;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String port;

    @GetMapping("/ok/{id}")
    public String paymentInfo_OK(@PathVariable Integer id){
        return paymentService.paymentInfo_OK(id);
    }

    @GetMapping("/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable Integer id){
        log.info("timeout");
        return paymentService.paymentInfo_Timeout(id);
    }

    // 服务熔断
    @GetMapping("/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("************"+result);
        return result;
    }
}
