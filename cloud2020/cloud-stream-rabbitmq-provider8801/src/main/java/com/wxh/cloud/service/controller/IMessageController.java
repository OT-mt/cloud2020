package com.wxh.cloud.service.controller;

import com.wxh.cloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class IMessageController {
    @Resource
    private IMessageProvider provider;

    @GetMapping("/sendMessage")
    public String send(){
        return provider.send();
    }
}
