package com.wxh.cloud.controller;

import com.wxh.cloud.mapper.AccountMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AccountController {
    @Resource
    AccountMapper accountMapper;

    @RequestMapping("/test")
    public String test(){
        accountMapper.test();
        return "account";
    }
}
