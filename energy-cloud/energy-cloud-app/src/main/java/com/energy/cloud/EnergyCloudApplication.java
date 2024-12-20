package com.energy.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhangwenlin
 * @since 2024-12-20
 */
@EnableDiscoveryClient
@SpringBootApplication
public class EnergyCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnergyCloudApplication.class, args);
    }
}
