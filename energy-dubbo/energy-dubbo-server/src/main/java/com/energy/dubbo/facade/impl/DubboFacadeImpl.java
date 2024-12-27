package com.energy.dubbo.facade.impl;

import com.energy.base.result.ObjectResult;
import com.energy.base.result.Results;
import com.energy.dubbo.facade.DubboFacade;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhangwenlin
 * @since 2024-12-24
 */
@DubboService
public class DubboFacadeImpl implements DubboFacade {
    private static final Logger log = LoggerFactory.getLogger(DubboFacadeImpl.class);

    @Override
    public ObjectResult<String> dubbo(String req) {
        log.info("dubbo req:{}", req);
        return Results.objectResult("hello dubbo");
    }
}
