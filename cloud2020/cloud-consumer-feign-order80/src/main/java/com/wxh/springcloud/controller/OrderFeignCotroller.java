package com.wxh.springcloud.controller;

import com.wxh.springcloud.entities.CommonResult;
import com.wxh.springcloud.entities.Payment;
import com.wxh.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignCotroller {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable Long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/timeout")
    public String timeout(){
        return paymentFeignService.timeout();
    }
}
