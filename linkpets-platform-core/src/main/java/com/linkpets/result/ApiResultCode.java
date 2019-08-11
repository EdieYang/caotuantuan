package com.linkpets.result;

public enum ApiResultCode {
	
    /*SUCCESS(200,"成功"),
    NO_PERMISSION(211,"权限不足"),
    SERVER_ERROR(10000,"服务器异常"),
    AUTH_ERROR(10001,"认证失败"),
    PARAMS_ERROR(10002,"参数错误"),
    JSON_PARSE_ERROR(10003,"Json解析错误"),
    ILLEAGAL_STRING(15001,"非法字符串"),
    UNKNOW_ERROR(16000,"未知错误");*/
	
	SUCCESS(200,"成功"), // 成功
	FAIL(400,"失败"), // 失败
	UNAUTHORIZED(401,"未认证"), // 未认证（签名错误）
	NOT_FOUND(404,"接口不存在"), // 接口不存在
	INTERNAL_SERVER_ERROR(500,"服务器内部错误"),// 服务器内部错误
	JSON_PARSE_ERROR(10001,"Json解析错误");


    private int code;
    private String msg;

    ApiResultCode(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}


