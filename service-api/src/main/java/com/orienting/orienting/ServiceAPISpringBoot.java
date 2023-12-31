package com.orienting.orienting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { //
        "com.orienting.orienting.spring.configuration", //
        "com.orienting.orienting.spring.controller"
})
public class ServiceAPISpringBoot {

    public static void main(String[] args) {
        SpringApplication.run(ServiceAPISpringBoot.class, args);
    }

}
