package com.mffff.usercenter.exception;

import com.mffff.usercenter.common.ErrorCode;

/**
 * 自定义异常类
 */
public class BusinessException extends RuntimeException {
    private final int code;

    public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }

    public BusinessException(ErrorCode errorCode, String message) {
        super(message);
        this.code = errorCode.getCode();
    }

    public int getCode() {
        return code;
    }
}
