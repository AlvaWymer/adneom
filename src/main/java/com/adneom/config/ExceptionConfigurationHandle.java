package com.adneom.config;

import com.adneom.exception.BusinessException;
import com.adneom.exception.ErrorCode;
import com.adneom.exception.Result;
import com.adneom.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Yang Naihua<br>
 * Description:  ExceptionConfigurationHandle<br>
 * @since 2018/09/24<br>
 * Modified By:
 */

@Configuration
@ControllerAdvice
public class ExceptionConfigurationHandle {

    private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionConfigurationHandle.class);

    /**
     * 判断错误是否是已定义的已知错误，不是则由未知错误代替，同时记录在log中
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result exceptionGet(Exception e) {
        if (e instanceof BusinessException) {
            BusinessException MyException = (BusinessException) e;
            return ResultUtil.error(MyException.getCode(), MyException.getMessage());
        }

        LOGGER.error("【系统异常】:", e);
        return ResultUtil.error(ErrorCode.SERVER_ERROR);
    }
}
