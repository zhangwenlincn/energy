package com.energy.dubbo;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhangwenlin
 * @since 2024-12-24
 */
@EnableDubbo
@SpringBootApplication
public class EnergyDubboApplication {
    public static void main(String[] args) {
        SpringApplication.run(EnergyDubboApplication.class, args);
    }
}
