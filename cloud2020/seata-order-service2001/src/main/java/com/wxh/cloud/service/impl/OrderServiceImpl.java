package com.wxh.cloud.service.impl;

import com.wxh.cloud.mapper.OrderMapper;
import com.wxh.cloud.service.AccountService;
import com.wxh.cloud.service.OrderService;
import com.wxh.cloud.service.StroageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    OrderMapper orderMapper;
    @Resource
    AccountService accountService;
    @Resource
    StroageService stroageService;

    @Override
    @GlobalTransactional(rollbackFor = Exception.class)
    public void test() {
        log.info("order执行了");
        orderMapper.test();
        log.info("order结束啦");

        log.info("account开始了");
        accountService.test();
        log.info("account结束了");

        log.info("storage开始了");
        stroageService.test();
        log.info("storage结束啦");
    }
}
