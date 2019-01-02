package com.walker.common.exception;

import com.walker.common.util.ExceptionUtil;

/**
 * @author walker
 * @date 2019/1/2
 */
public enum CommonError {

    /**
     *
     */
    AUTH_EMPTY_ERROR(10001, "the user is null, please check");

    private Integer code;

    private String message;

    CommonError(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getCodeEn() {
        return ExceptionUtil.errorToCodeEn(this);
    }
}
