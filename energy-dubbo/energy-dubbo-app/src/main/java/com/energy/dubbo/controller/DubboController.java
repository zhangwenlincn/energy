package com.energy.dubbo.controller;

import com.energy.base.result.ObjectResult;
import com.energy.dubbo.facade.DubboFacade;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangwenlin
 * @since 2024-12-24
 */
@RestController
public class DubboController {

    @DubboReference
    private DubboFacade dubboFacade;

    @RequestMapping("/dubbo")
    public ObjectResult<String> dubbo() {
        return dubboFacade.dubbo("test dubbo");
    }

}
