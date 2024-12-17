package com.energy.base.result;


import com.energy.base.code.BaseCode;
import com.energy.base.code.ICode;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @author zhangwenlin
 * @since 2024-12-17
 */
@Data
public class Results implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------------------
    public static BaseResult baseResult(Boolean success) {
        return new BaseResult(success);
    }

    public static <T> ObjectResult<T> objectResult(Boolean success) {
        return new ObjectResult<T>(success);
    }

    public static <T> ListResult<T> listResult(Boolean success) {
        return new ListResult<>(success);
    }

    public static <T> PageResult<T> pageResult(Boolean success) {
        return new PageResult<>(success);
    }

    //----------------------------------------------------------------------------------

    public static <CodeEnum extends ICode> BaseResult baseResult(CodeEnum codeEnum) {
        return new BaseResult(codeEnum);
    }

    public static <T, CodeEnum extends ICode> ObjectResult<T> objectResult(CodeEnum codeEnum) {
        return new ObjectResult<>(codeEnum);
    }

    public static <T, CodeEnum extends ICode> ListResult<T> listResult(CodeEnum codeEnum) {
        return new ListResult<>(codeEnum);
    }

    public static <T, CodeEnum extends ICode> PageResult<T> pageResult(CodeEnum codeEnum) {
        return new PageResult<>(codeEnum);
    }
    //----------------------------------------------------------------------------------

    public static BaseResult baseResult(String code, String message) {
        return new BaseResult(Objects.equals(BaseCode.SUCCESS.getCode(), code), code, message);
    }

    public static BaseResult baseResult(String message) {
        return new BaseResult(false, BaseCode.ERROR.getCode(), message);
    }

    public static <T> ObjectResult<T> objectResult(String code, String message) {
        return new ObjectResult<>(false, code, message);
    }

    public static <T> ListResult<T> listResult(String code, String message) {
        return new ListResult<>(false, code, message);
    }

    public static <T> ListResult<T> listResult(String message) {
        return new ListResult<>(false, BaseCode.ERROR.getCode(), message);
    }

    public static <T> PageResult<T> pageResult(String code, String message) {
        return new PageResult<>(false, code, message);
    }

    public static <T> PageResult<T> pageResult(String message) {
        return new PageResult<>(false, BaseCode.ERROR.getCode(), message);
    }

    //----------------------------------------------------------------------------------

    public static <T> ObjectResult<T> objectResult(T data) {
        return new ObjectResult<>(data);
    }

    public static <T> ListResult<T> listResult(List<T> data) {
        return new ListResult<>(data);
    }

    public static <T, Page extends Pager> PageResult<T> pageResult(Page page, List<T> data) {
        return new PageResult<>(page, data);
    }

}
