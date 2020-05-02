package com.adneom.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: Result
 * @Description: Result 返回的基类
 * @Author: Yang Naihua
 * @Create: 2018-09-24 12:21
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    /**
     * error_code 状态值：0 为成功，其他数值代表失败
     */
    private Integer status;
    /**
     * error_msg 错误信息，若status为200时，为success
     */
    private String message;
    /**
     * content 返回体报文的出参，使用泛型兼容不同的类型
     */
    private T data;
}
