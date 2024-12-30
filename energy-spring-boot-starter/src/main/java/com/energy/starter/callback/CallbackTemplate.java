package com.energy.starter.callback;

import com.energy.base.code.BaseCode;
import com.energy.base.exception.EnergyException;
import com.energy.base.result.BaseResult;
import com.energy.base.result.ListResult;
import com.energy.base.result.ObjectResult;
import com.energy.base.result.PageResult;
import com.energy.base.result.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhangwenlin
 * @since 2024-12-30
 */
public class CallbackTemplate {

    private static final Logger log = LoggerFactory.getLogger(CallbackTemplate.class);

    public static BaseResult execute(BaseResultCallback baseResultCallback) {
        try {
            baseResultCallback.checkParams();
            return baseResultCallback.doProcess();
        } catch (EnergyException e) {
            return Results.baseResult(e.getCode(), e.getMessage());
        } catch (RuntimeException e) {
            log.error("callback exception", e);
            return Results.baseResult(BaseCode.EXCEPTION_FAIL.getCode(), e.getMessage());
        } catch (Exception e) {
            log.error("callback exception", e);
            return Results.baseResult(BaseCode.EXCEPTION_FAIL);
        }
    }

    public static BaseResult execute(BaseResultCallback baseResultCallback, Object object) {
        try {
            baseResultCallback.checkParams(object);
            return baseResultCallback.doProcess();
        } catch (EnergyException e) {
            return Results.baseResult(e.getCode(), e.getMessage());
        } catch (RuntimeException e) {
            log.error("callback exception", e);
            return Results.baseResult(BaseCode.EXCEPTION_FAIL.getCode(), e.getMessage());
        } catch (Exception e) {
            log.error("callback exception", e);
            return Results.baseResult(BaseCode.EXCEPTION_FAIL);
        }
    }

    public static <T> ObjectResult<T> execute(ObjectResultCallback<T> objectResultCallback) {
        try {
            objectResultCallback.checkParams();
            return objectResultCallback.doProcess();
        } catch (EnergyException e) {
            return Results.objectResult(e.getCode(), e.getMessage());
        } catch (RuntimeException e) {
            log.error("callback exception", e);
            return Results.objectResult(BaseCode.EXCEPTION_FAIL.getCode(), e.getMessage());
        } catch (Exception e) {
            log.error("callback exception", e);
            return Results.objectResult(BaseCode.EXCEPTION_FAIL);
        }
    }

    public static <T> ObjectResult<T> execute(ObjectResultCallback<T> objectResultCallback, Object object) {
        try {
            objectResultCallback.checkParams(object);
            return objectResultCallback.doProcess();
        } catch (EnergyException e) {
            return Results.objectResult(e.getCode(), e.getMessage());
        } catch (RuntimeException e) {
            log.error("callback exception", e);
            return Results.objectResult(BaseCode.EXCEPTION_FAIL.getCode(), e.getMessage());
        } catch (Exception e) {
            log.error("callback exception", e);
            return Results.objectResult(BaseCode.EXCEPTION_FAIL);
        }
    }

    public static <T> ListResult<T> execute(ListResultCallback<T> listResultCallback) {
        try {
            listResultCallback.checkParams();
            return listResultCallback.doProcess();
        } catch (EnergyException e) {
            return Results.listResult(e.getCode(), e.getMessage());
        } catch (RuntimeException e) {
            log.error("callback exception", e);
            return Results.listResult(BaseCode.EXCEPTION_FAIL.getCode(), e.getMessage());
        } catch (Exception e) {
            log.error("callback exception", e);
            return Results.listResult(BaseCode.EXCEPTION_FAIL);
        }
    }

    public static <T> ListResult<T> execute(ListResultCallback<T> listResultCallback, Object object) {
        try {
            listResultCallback.checkParams(object);
            return listResultCallback.doProcess();
        } catch (EnergyException e) {
            return Results.listResult(e.getCode(), e.getMessage());
        } catch (RuntimeException e) {
            log.error("callback exception", e);
            return Results.listResult(BaseCode.EXCEPTION_FAIL.getCode(), e.getMessage());
        } catch (Exception e) {
            log.error("callback exception", e);
            return Results.listResult(BaseCode.EXCEPTION_FAIL);
        }
    }

    public static <T> PageResult<T> execute(PageResultCallback<T> pageResultCallback) {
        try {
            pageResultCallback.checkParams();
            return pageResultCallback.doProcess();
        } catch (EnergyException e) {
            return Results.pageResult(e.getCode(), e.getMessage());
        } catch (RuntimeException e) {
            log.error("callback exception", e);
            return Results.pageResult(BaseCode.EXCEPTION_FAIL.getCode(), e.getMessage());
        } catch (Exception e) {
            log.error("callback exception", e);
            return Results.pageResult(BaseCode.EXCEPTION_FAIL);
        }
    }

    public static <T> PageResult<T> execute(PageResultCallback<T> pageResultCallback, Object object) {
        try {
            pageResultCallback.checkParams(object);
            return pageResultCallback.doProcess();
        } catch (EnergyException e) {
            return Results.pageResult(e.getCode(), e.getMessage());
        } catch (RuntimeException e) {
            log.error("callback exception", e);
            return Results.pageResult(BaseCode.EXCEPTION_FAIL.getCode(), e.getMessage());
        } catch (Exception e) {
            log.error("callback exception", e);
            return Results.pageResult(BaseCode.EXCEPTION_FAIL);
        }
    }
}
