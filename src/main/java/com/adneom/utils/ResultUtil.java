package com.adneom.utils;


import com.adneom.exception.ErrorCode;
import com.adneom.exception.Result;

/**
 * @ClassName: ResultUtil
 * @Description: 返回结果处理类 <br>
 * @Author: Yang Naihua
 * @Create: 2018/09/2
 **/
public class ResultUtil {

    /**
     * 返回成功，传入返回体具体出參
     *
     * @param object
     * @return
     */
    public static Result success(Object object) {
        Result result = new Result();
        result.setStatus(200);
        result.setMessage("Success");
        result.setData(object);
        return result;
    }

    /**
     * 提供给部分不需要出參的接口
     *
     * @return
     */
    public static Result success() {
        return success(null);
    }

    /**
     * 自定义错误信息
     *
     * @param code
     * @param msg
     * @return
     */
    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setStatus(code);
        result.setMessage(msg);
        result.setData(null);
        return result;
    }

    /**
     * 返回异常信息，在已知的范围内,业务异常
     */
    public static Result error(ErrorCode errorCode) {
        Result result = new Result();
        result.setStatus(errorCode.getCode());
        result.setMessage(errorCode.getMessage());
        result.setData(null);
        return result;
    }
}
