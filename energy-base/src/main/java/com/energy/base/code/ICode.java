package com.energy.base.code;

/**
 * @author zhangwenlin
 * @since 2024-12-17
 */
public interface ICode {
    /**
     * 获取错误码
     *
     * @return 错误码
     */
    String getCode();

    /**
     * 获取错误信息
     *
     * @return 错误信息
     */
    String getMessage();
}
