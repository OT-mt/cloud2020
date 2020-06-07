package com.wxh.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long,String> hashMap = new HashMap<>();
    static {
        hashMap.put(1l,"aaaaaaaaaaaaaa");
        hashMap.put(2l,"bbbbbbbbbbbbbb");
        hashMap.put(3l,"cccccccccccccc");
    }

    @GetMapping("/payment/{id}")
    public String payment(@PathVariable("id") Long id){
        return hashMap.get(id)+serverPort;
    }
}
