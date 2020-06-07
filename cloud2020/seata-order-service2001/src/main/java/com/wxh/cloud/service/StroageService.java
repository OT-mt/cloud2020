package com.wxh.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "seata-storage-service")
public interface StroageService {
    @RequestMapping("/test")
    public String test();
}
