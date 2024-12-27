package com.energy.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zhangwenlin
 * @since 2024-12-27
 */
@EnableFeignClients
@SpringBootApplication
public class CloudServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudServerApplication.class, args);
    }
}
