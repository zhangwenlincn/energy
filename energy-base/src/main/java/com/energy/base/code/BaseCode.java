package com.energy.base.code;

import lombok.Getter;

/**
 * @author zhangwenlin
 * @since 2024-12-17
 */
@Getter
public enum BaseCode implements ICode {
    SUCCESS("10000", "操作成功"),
    ERROR("10001", "操作失败"),
    EXCEPTION_FAIL("10002", "操作异常"),
    PARAMETER_FAIL("10003", "参数异常"),
    PARSE_EXCEPTION("10004", "Parse Exception"),
    ;
    private final String code;

    private final String message;

    BaseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
