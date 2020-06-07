package com.wxh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderCSMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderCSMain80.class,args);
    }
}
