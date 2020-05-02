package com.adneom.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName: BaseResponse
 * @Description: BaseResponse 内部远程调用包装方法
 * @Author: Yang Naihua
 * @Create: 2018-12-19 22:47:46
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse<T> {

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
    private  List<T> data;

    public BaseResponse(List<T> data) {
        this.data = data;
    }
}