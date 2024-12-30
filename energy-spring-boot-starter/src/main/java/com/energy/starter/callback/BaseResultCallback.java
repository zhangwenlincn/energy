package com.energy.starter.callback;

import com.energy.base.result.BaseResult;

/**
 * @author zhangwenlin
 * @since 2024-12-30
 */
public interface BaseResultCallback extends ResultCallback {

    BaseResult doProcess();
}
