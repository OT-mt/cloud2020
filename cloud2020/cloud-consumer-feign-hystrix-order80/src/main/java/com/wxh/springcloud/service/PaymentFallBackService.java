package com.wxh.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallBackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "注解返回类";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "注解";
    }
}
