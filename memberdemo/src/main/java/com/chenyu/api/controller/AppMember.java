package com.chenyu.api.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AppMember {

    //@EnableEurekaClient将当前服务注册到Eureka
    public static void main(String[] args) {
        SpringApplication.run(AppMember.class, args);
    }
}
