package com.energy.starter.callback;

import com.energy.base.exception.EnergyException;
import com.energy.base.result.BaseResult;
import com.energy.base.result.ListResult;

/**
 * @author zhangwenlin
 * @since 2024-12-30
 */
public interface ListResultCallback<T> extends ResultCallback {


    ListResult<T> doProcess();
}
