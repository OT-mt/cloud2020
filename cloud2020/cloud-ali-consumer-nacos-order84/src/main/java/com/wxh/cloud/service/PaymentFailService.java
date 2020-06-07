package com.wxh.cloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFailService implements PaymentService {
    @Override
    public String payment(Long id) {
        return "feign失败调用";
    }
}
