package com.energy.dubbo.facade.impl;

import com.energy.base.result.ObjectResult;
import com.energy.base.result.Results;
import com.energy.dubbo.facade.DubboFacade;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author zhangwenlin
 * @since 2024-12-24
 */
@DubboService
public class DubboFacadeImpl implements DubboFacade {
    @Override
    public ObjectResult<String> dubbo(String req) {
        return Results.objectResult("hello dubbo");
    }
}
