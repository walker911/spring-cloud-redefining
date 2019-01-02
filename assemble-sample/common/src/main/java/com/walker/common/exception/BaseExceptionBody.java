package com.walker.common.exception;

/**
 * @author walker
 * @date 2019/1/2
 */
public class BaseExceptionBody {
    private Long businessId;

    private Integer code;

    private String codeEn;

    private String businessMessage;

    private String exceptionType;

    public BaseExceptionBody() {
    }

    public BaseExceptionBody(BaseException baseException) {
        this.businessId = baseException.getBusinessId();
        this.code = baseException.getCode();
        this.codeEn = baseException.getCodeEn();
        this.businessMessage = baseException.getBusinessMessage();
        this.exceptionType = baseException.getClass().getName();
    }

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

    public String getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(String exceptionType) {
        this.exceptionType = exceptionType;
    }
}
