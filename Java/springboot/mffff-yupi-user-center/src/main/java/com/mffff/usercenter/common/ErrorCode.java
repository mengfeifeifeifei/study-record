package com.mffff.usercenter.common;

/**
 * 错误码
 */
public enum ErrorCode {

    PARAMS_ERROR(40000, "请求参数错误"),
    NULL_ERROR(40001, "请求数据为空"),
    NO_AUTH(40100, "无权限"),
    NO_LOGIN(40101, "未登录"),
    REGISTER_ERR(50100, "注册失败"),
    SYSTEM_ERR(50000, "系统异常");

    private final int code;

    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
