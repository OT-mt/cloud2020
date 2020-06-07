package com.wxh.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "seata-account-service")
public interface AccountService {
    @RequestMapping("/test")
    public String test();
}
