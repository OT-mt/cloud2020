package com.wxh.cloud.controller;

import com.wxh.cloud.service.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {
    @Resource
    private OrderService orderService;
    @RequestMapping("/test")
    public String test(){
        orderService.test();
        return "test";
    }
}
