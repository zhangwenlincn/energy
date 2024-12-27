package com.energy.cloud.controller;

import com.energy.base.result.BaseResult;
import com.energy.base.result.Results;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangwenlin
 * @since 2024-12-27
 */
@RestController
public class ServerController {

    @GetMapping("/server")
    public BaseResult server(){
        return Results.baseResult(true);
    }
}
