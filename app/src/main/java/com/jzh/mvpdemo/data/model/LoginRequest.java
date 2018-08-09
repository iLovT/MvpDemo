package com.jzh.mvpdemo.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Author:jzh
 * desc:登录request
 * Date:2018/08/09 08:39
 * Email:jzh970611@163.com
 */

public class LoginRequest {
    @Expose
    @SerializedName("username")
    private String username;
    @Expose
    @SerializedName("password")
    private String password;

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
