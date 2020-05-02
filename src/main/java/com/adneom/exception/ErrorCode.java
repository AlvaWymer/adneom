package com.adneom.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @ClassName: ErrorCode
 * @Description: ErrorCode
 * @Author: Yang Naihua
 * @Create: 2018-06-21 13:55
 **/
@NoArgsConstructor
@AllArgsConstructor
public enum ErrorCode {
    // TODO i18n
    /**
     * 服务器内部错误
     */
    SERVER_ERROR(-1, "SERVER_ERROR - 服务器内部错误"),
    /**
     * 未知异常
     */
    UPDATE_ERROR(-2, " UPDATE_ERROR - 待更新资源不存在，请查验ID"),
    /**
     *  发送邮件失败
     */
    EMAIL_ATTACHMENT_ERROR(-3, "邮件绑定附件失败"),
    /**
     * S3 下载资源不存在
     */
    S3_DOWNLOAD_RESOURCE_NOT_EXIST(-4, "下载对象为空"),
    /**
     * S3 远程服务器发生错误
     */
    S3_REMOTE_SREVER_ERROR(-5, "S3远程服务发生错误"),
    /**
     * S3 客户服务发生错误
     */
    S3_CLEINT_ERROR(-5, "S3客户服务发生错误"),


    /**
     * 客户不存在
     */
    CLIENT_NOT_FOUND(-1000, "客户不存在"),
    /**
     * 注册用户名已经存在
     */
    CLIENT_USERNAME_ALERDY_EXIST(-1001, "注册用户名已经存在"),
    /**
     * 上传头像失败
     */
    CLIENT_IMAGE_UPLAOD_ERROR(-1002, "上传头像失败"),


    /**
     * 产品不存在
     */
    PRODUCT_NOT_FOUND(-2000, "产品不存在"),




    /**
     * 图片等级
     */
    IMAGE_GRADE_ERROR(-3000, "图片等级获取失败"),
    /**
     * 图片上传S3失败
     */
    IMAGE_UPLAOD_ERROR(-3001, "图片上传失败"),



    /**
     * 已存订单查询失败，用来查询已经存在的订单，远程调用
     */
    REMOTE_COMMAND_SEARCH_ERROR(-4000, "远程调用:已存订单查询失败"),


    /**
     * 订单不存在
     */
    COMMAND_NOT_FOUND(-5000, "订单不存在"),



    ;

    @Getter
    private Integer code;
    @Getter
    private String message;

}