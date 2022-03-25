package com.theoxao.duraemon.good.common

enum class ResponseCode(val code: Int, val message: String) {

    COOKIE_MUST_NOT_BE_NULL(401, "用户登陆信息已过期"),

    AUTH_EXPIRE(401, "用户登陆信息已过期"),
    NOT_FOLLOW(801, "未关注"),
    NOT_INVITED(403, ""),
    PERMISSION_DENIED(403, "无权限访问"),
    NEED_PERMISSION(500, "无权限访问"),
    RECORD_NOT_FOUND(404, "记录不存在"),
    RECORD_EXIST(500, "记录已存在"),
    USER_NOT_EXIST(500, "用户不存在"),
    USER_NOT_FOUND(500, "找不到视频号账号"),
    INTERNAL_SERVER_ERROR(500, "服务内部错误"),
    PARAMETER_ERROR(500, "请求参数有误"),
    FILE_EXTENSION_ERROR(500, "文件后缀名有误"),
    INVALID_CAPTCHA(500, "验证码有误"),
    MOBILE_ALREADY_BOUND(500, "手机号已被绑定"),
    SMS_SEND_OVER_LIMIT(500, "手机号超过当前发送限制，请稍后再试"),
    BIND_SMS_ERROR(500, "该账号已绑定手机号"),
    SMS_SEND_FAILED(500, "发送失败，请稍后再试"),
    HIGH_FREQUENT_REQUEST(500, "请求太频繁"),
    SERVER_UNAVAILABLE(503, "服务升级维护中"),
    NEED_LOGIN(500, "请先登陆"),
    REQUEST_FAILED(500, "请求失败")
}