package com.energy.dubbo.facade;

import com.energy.base.result.ObjectResult;

/**
 * @author zhangwenlin
 * @since 2024-12-24
 */
public interface DubboFacade {

    ObjectResult<String> dubbo(String req);
}
