package com.energy.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangwenlin
 * @since 2024-12-19
 */
@RestController
public class NacosConfigController {

    //@Value("${yaml}")
    private String yamlConfig;

    @GetMapping("/yaml")
    public String getYamlConfig() {
        return yamlConfig;
    }
}
