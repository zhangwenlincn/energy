package com.energy.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhangwenlin
 * @since 2024-12-17
 */
@EnableDiscoveryClient
@SpringBootApplication
public class EnergySystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(EnergySystemApplication.class, args);
    }
}
