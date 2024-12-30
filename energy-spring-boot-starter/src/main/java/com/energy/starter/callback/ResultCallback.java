package com.energy.starter.callback;

import com.energy.base.exception.EnergyException;
import com.energy.starter.validator.ValidatorUtil;

/**
 * @author zhangwenlin
 * @since 2024-12-30
 */
public interface ResultCallback {

    default void checkParams() throws EnergyException {
    }

    default void checkParams(Object obj) throws EnergyException {
        ValidatorUtil.validate(obj);
    }
}
