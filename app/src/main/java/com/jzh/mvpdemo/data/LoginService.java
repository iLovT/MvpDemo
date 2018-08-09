package com.jzh.mvpdemo.data;

import com.jzh.mvpdemo.data.model.LoginRequest;
import com.jzh.mvpdemo.data.model.LoginResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Author:jzh
 * desc:接口服务类
 * Date:2018/08/08 17:28
 * Email:jzh970611@163.com
 */

public interface LoginService {
    @POST("user/login")
    Observable<LoginResponse> doLoginCall(@Body LoginRequest request);
}
