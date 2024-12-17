package com.energy.base.result;

import com.energy.base.code.BaseCode;
import com.energy.base.code.ICode;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;
import java.util.Optional;

/**
 * @author zhangwenlin
 * @since 2024-12-17
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ObjectResult<T> extends BaseResult implements IResult<T>, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 业务数据
     */
    private T data;

    public ObjectResult() {
    }

    public ObjectResult(boolean success) {
        super(success);
    }

    public ObjectResult(ICode code) {
        super(code);
    }

    public ObjectResult(T t) {
        super(Optional.ofNullable(t).map(e -> BaseCode.SUCCESS).orElse(BaseCode.ERROR));
        this.data = t;
    }

    public ObjectResult(boolean success, String code, String message) {
        super(success, code, message);
    }
}