package com.energy.cloud.controller;

import com.energy.base.result.BaseResult;
import com.energy.cloud.openfeign.CloudServerFeign;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangwenlin
 * @since 2024-12-27
 */
@RestController
public class CloudController {

    @Resource
    private CloudServerFeign cloudServerFeign;

    @RequestMapping("/server")
    public BaseResult server() {
        return cloudServerFeign.server();
    }
}
