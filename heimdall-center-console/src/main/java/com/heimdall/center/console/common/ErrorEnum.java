package com.heimdall.center.console.common;

public enum ErrorEnum {
    /*
     * 错误信息
     * */
    E_400("400", "请求处理异常，请稍后再试"),
    E_500("500", "服务器处理异常，请稍后再试"),
    E_501("501", "请求路径不存在"),
    E_10001("10001", "缺少必填参数"),


    E_0("0", "0");

    private String errorCode;

    private String errorMsg;

    ErrorEnum() {
    }

    ErrorEnum(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
