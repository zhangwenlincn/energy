package com.energy.cloud.openfeign;

import com.energy.base.result.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zhangwenlin
 * @since 2024-12-27
 */
@FeignClient(name = "cloud-server")
public interface CloudServerFeign {

    @GetMapping("/server")
    BaseResult server();
}
