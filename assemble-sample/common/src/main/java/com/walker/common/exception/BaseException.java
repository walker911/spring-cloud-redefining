package com.walker.common.exception;

/**
 * @author walker
 * @date 2019/1/2
 */
public class BaseException extends RuntimeException {
    private Long businessId;

    private Integer code;

    private String codeEn;

    private String businessMessage;

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getCodeEn() {
        return codeEn;
    }

    public void setCodeEn(String codeEn) {
        this.codeEn = codeEn;
    }

    public String getBusinessMessage() {
        return businessMessage;
    }

    public void setBusinessMessage(String businessMessage) {
        this.businessMessage = businessMessage;
    }

    public BaseException(Long businessId, Integer code, String codeEn, String businessMessage) {
        this.businessId = businessId;
        this.code = code;
        this.codeEn = codeEn;
        this.businessMessage = businessMessage;
    }

    public BaseException(String message, Throwable cause, Long businessId, Integer code, String codeEn) {
        super(message, cause);
        this.businessId = businessId;
        this.code = code;
        this.codeEn = codeEn;
        this.businessMessage = message;
    }
}
