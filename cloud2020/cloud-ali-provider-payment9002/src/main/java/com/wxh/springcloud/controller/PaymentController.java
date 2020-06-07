package com.wxh.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverport;

    @GetMapping(value = "/payment/nacos/{id}")
    public String getPyment(@PathVariable("id") Integer id){
        return "我是 nacos 注册,port:"+serverport+"\t id:"+id;
    }
}
