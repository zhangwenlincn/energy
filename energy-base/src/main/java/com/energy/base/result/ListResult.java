package com.energy.base.result;

import com.energy.base.code.BaseCode;
import com.energy.base.code.ICode;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * @author zhangwenlin
 * @since 2024-12-17
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ListResult<T> extends BaseResult implements IResult<List<T>>, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * 列表数据
     */
    private List<T> data;

    public ListResult() {
    }

    public ListResult(boolean success) {
        super(success);
    }

    public ListResult(ICode code) {
        super(code);
    }

    public ListResult(List<T> list) {
        super(Optional.ofNullable(list).map(e -> BaseCode.SUCCESS).orElse(BaseCode.ERROR));
        this.data = list;
    }

    public ListResult(boolean success, String code, String message) {
        super(success, code, message);
    }

}