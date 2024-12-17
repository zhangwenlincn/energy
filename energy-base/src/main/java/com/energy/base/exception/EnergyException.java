package com.energy.base.exception;

import com.energy.base.code.BaseCode;
import com.energy.base.code.ICode;
import lombok.Getter;

@Getter
public class EnergyException extends RuntimeException {


    private final String code;

    private final String message;

    public EnergyException(ICode code) {
        super(code.getMessage());
        this.code = code.getCode();
        this.message = code.getMessage();
    }

    public EnergyException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }


    public EnergyException(String message) {
        super(message);
        this.code = BaseCode.EXCEPTION_FAIL.getCode();
        this.message = message;
    }
}
