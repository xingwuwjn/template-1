package com.template.enums;

import lombok.Getter;

/**
 *返回状态码以及信息
 */
@Getter
public enum ResultEnum {

    SUCCESS(200, "成功"),
    ERROR(500, "操作失败"),


    DELETE_SUCCESS(200, "删除成功"),

    UPDATE_SUCCESS(200, "更新成功"),

    ADD_SUCCESS(200, "添加成功"),

    REGISTER_SUCCESS(200, "注册成功"),

    LOGOUT_SUCCESS(200, "登出成功"),



    AUTHORIZE_ERROR(3001,"用户名或密码错误"),

    TOKEN_FAILURE(3002,"登录过期"),

    TOKEN_ERROR(3003,"请求出错"),




    DELETE_ERROR(200, "删除失败"),

    ADD_ERROR(200, "添加失败"),

    UPDATE_ERROR(200, "更新失败"),

    REGISTER_ERROR(200, "注册失败"),


    ;

    private Integer code;   //状态码

    private String message; //消息

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
