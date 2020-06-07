package com.wxh.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient
@EnableConfigServer
public class ConfigMain3344 {
//    public static void main(String[] args) {
//        SpringApplication.run(ConfigMain3344.class,args);
//    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
