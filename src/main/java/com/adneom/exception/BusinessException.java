package com.adneom.exception;

/**
 * @ClassName: BusinessException
 * @Description: BusinessException 业务异常
 * @Author: Yang Naihua
 * @Create: 2018-06-21 13:55
 **/
public class BusinessException extends RuntimeException {
    private Integer code;

    /**
     * 继承exception，加入错误状态值
     *
     * @param errorCode
     */
    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }

    /**
     * 自定义错误信息
     *
     * @param message
     * @param code
     */
    public BusinessException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}