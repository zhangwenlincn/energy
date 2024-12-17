package com.energy.base.result;

/**
 * @author zhangwenlin
 * @since 2024-12-17
 */
public interface IResult<T> {
    String getCode();

    boolean isSuccess();

    String getMessage();

    T getData();
}
