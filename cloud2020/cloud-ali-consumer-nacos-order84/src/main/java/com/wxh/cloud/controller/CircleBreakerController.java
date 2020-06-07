package com.wxh.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wxh.cloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class CircleBreakerController {
    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback")   // 没有配置
//    @SentinelResource(value = "fallback",fallback = "handlerFallback")//fallback
//    @SentinelResource(value = "fallback",blockHandler = "blockHandler")//blockhandler
//    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler")//fallback+blockhandler
    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler",exceptionsToIgnore = RuntimeException.class)
    public String fallback(@PathVariable("id") Long id){

        String result = restTemplate.getForObject(SERVICE_URL+"/payment/"+id,String.class,id);
        if (id==4){
            throw new RuntimeException("非法参数异常");
        }

        return result;
    }

    public String handlerFallback(@PathVariable Long id){
        return id+"异常";
    }

    public String blockHandler(Long id, BlockException e){
        return "blockHandler异常";
    }

    @Resource
    private PaymentService paymentService;
    @GetMapping("consumer/payment/{id}")
    public String payment(@PathVariable("id") Long id){
        return paymentService.payment(id);
    }
}
