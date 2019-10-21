package com.ww.springcloudzuulhystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringcloudZuulHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudZuulHystrixApplication.class, args);
    }

}
