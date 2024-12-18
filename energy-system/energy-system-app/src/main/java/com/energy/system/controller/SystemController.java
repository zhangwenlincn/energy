package com.energy.system.controller;

import com.energy.base.code.BaseCode;
import com.energy.base.exception.EnergyException;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/system")
public class SystemController {

    @RequestMapping("/test")
    public String test() {
        throw new EnergyException(BaseCode.EXCEPTION_FAIL);
    }

}

