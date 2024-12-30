package com.energy.starter.callback;

import com.energy.base.exception.EnergyException;
import com.energy.base.result.ListResult;
import com.energy.base.result.PageResult;
import com.energy.starter.validator.ValidatorUtil;

/**
 * @author zhangwenlin
 * @since 2024-12-30
 */
public interface PageResultCallback<T> extends ResultCallback{


    PageResult<T> doProcess();
}
