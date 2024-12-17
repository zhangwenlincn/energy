package com.energy.base.result;

import com.energy.base.code.BaseCode;
import com.energy.base.code.ICode;
import lombok.Data;

import java.beans.Transient;
import java.io.Serial;
import java.io.Serializable;

/**
 * @author zhangwenlin
 * @since 2024-12-17
 */
@Data
public class BaseResult implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 是否成功
     */
    private Boolean success = false;

    /**
     * 错误码 (正确码 10000)
     */
    private String code = BaseCode.ERROR.getCode();

    /**
     * 错误信息
     */
    private String message = BaseCode.ERROR.getMessage();

    public BaseResult() {

    }


    public BaseResult(boolean success) {
        if (success) {
            this.success = true;
            this.code = BaseCode.SUCCESS.getCode();
            this.message = BaseCode.SUCCESS.getMessage();
        }
    }

    public BaseResult(boolean success, String code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public BaseResult(ICode code) {
        this.success = code.getCode().equals(BaseCode.SUCCESS.getCode());
        this.message = code.getMessage();
        this.code = code.getCode();
    }

    @Transient
    public boolean isNotSuccess() {
        return !success;
    }

    public boolean isSuccess() {
        return success;
    }
}
