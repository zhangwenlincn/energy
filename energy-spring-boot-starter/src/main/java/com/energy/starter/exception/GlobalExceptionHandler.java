package com.energy.starter.exception;

import com.energy.base.code.BaseCode;
import com.energy.base.exception.EnergyException;
import com.energy.base.result.BaseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

/**
 * @author zhangwenlin
 * @since 2024-12-17
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResult handleException(MethodArgumentNotValidException e) {
        String message = e.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(","));
        log.error("参数校验未通过:{}", message, e);
        return new BaseResult(false, BaseCode.PARAMETER_FAIL.getCode(), message);
    }

    @ExceptionHandler(EnergyException.class)
    public BaseResult handleException(EnergyException e) {
        log.error("自定义异常 SkiffException:{}", e.getMessage(), e);
        return new BaseResult(false, e.getCode(), e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public BaseResult handleRuntimeException(RuntimeException e) {
        log.error("运行时异常 RuntimeException:{}", e.getMessage(), e);
        return new BaseResult(false, BaseCode.EXCEPTION_FAIL.getCode(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public BaseResult handleException(Exception e) {
        log.error("系统异常 Exception:{}", e.getMessage(), e);
        return new BaseResult(false, BaseCode.EXCEPTION_FAIL.getCode(), e.getMessage());
    }
}
