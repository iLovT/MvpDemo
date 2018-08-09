package com.jzh.mvpdemo.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Author:jzh
 * desc:登录response
 * Date:2018/08/09 08:42
 * Email:jzh970611@163.com
 */

public class LoginResponse {

    /**
     * data : null
     * errorCode : -1
     * errorMsg : 账号密码不匹配！
     */

    @Expose
    @SerializedName("data")
    private String data;
    @Expose
    @SerializedName("errorCode")
    private Integer errorCode;
    @Expose
    @SerializedName("errorMsg")
    private String errorMsg;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
