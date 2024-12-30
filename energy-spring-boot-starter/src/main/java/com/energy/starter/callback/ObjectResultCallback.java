package com.energy.starter.callback;

import com.energy.base.exception.EnergyException;
import com.energy.base.result.BaseResult;
import com.energy.base.result.ObjectResult;

/**
 * @author zhangwenlin
 * @since 2024-12-30
 */
public interface ObjectResultCallback<T> extends ResultCallback{

    ObjectResult<T> doProcess();
}
