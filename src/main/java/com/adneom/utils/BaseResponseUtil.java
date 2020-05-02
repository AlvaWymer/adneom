package com.adneom.utils;


import com.adneom.exception.BaseResponse;
import com.adneom.exception.ErrorCode;

import java.util.ArrayList;
import java.util.List;


/**
 * @ClassName: BaseResponseUtil
 * @Description: 内部远程接口调用 <br>
 * @Author: Yang Naihua
 * @Create: 2018-12-20 11:11:03
 **/
public class BaseResponseUtil {

    /**
     * 返回成功，传入返回体具体出參
     *
     * @param object
     * @return
     */
    public static BaseResponse success(Object object) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatus(200);
        baseResponse.setMessage("Success");
        baseResponse.setData((List<Object>) object);
        return baseResponse;
    }

    /**
     * 提供给部分不需要出參的接口
     *
     * @return
     */
    public static BaseResponse success() {
        return success(null);
    }

    /**
     * 自定义错误信息
     *
     * @param code
     * @param msg
     * @return
     */
    public static BaseResponse error(Integer code, String msg) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatus(code);
        baseResponse.setMessage(msg);
        baseResponse.setData(new ArrayList());
        return baseResponse;
    }

    /**
     * 返回异常信息，在已知的范围内,业务异常
     */
    public static BaseResponse error(ErrorCode errorCode) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatus(errorCode.getCode());
        baseResponse.setMessage(errorCode.getMessage());
        baseResponse.setData(new ArrayList());
        return baseResponse;
    }
}
