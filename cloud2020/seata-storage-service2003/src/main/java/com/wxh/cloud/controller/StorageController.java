package com.wxh.cloud.controller;

import com.wxh.cloud.mapper.StorageMapper;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
public class StorageController {
    @Resource
    StorageMapper storageMapper;

    @RequestMapping("/test")
    public String test(){
        System.out.println("全局事务id:{}"+RootContext.getXID());
        int a = 1/0;
        storageMapper.test();
        return "storage";
    }
}
