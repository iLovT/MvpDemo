package com.jzh.mvpdemo;

import com.jzh.mvpdemo.data.model.LoginResponse;
import com.jzh.mvpdemo.ui.base.MvpPresenter;
import com.jzh.mvpdemo.ui.base.MvpView;

/**
 * Author:jzh
 * desc:v层接口，提供回调方法
 * Date:2018/08/08 16:53
 * Email:jzh970611@163.com
 */

public interface MainMvpView extends MvpView {
    void onSucc(LoginResponse response);

    void onFail(String msg);

    interface MainMvpPresenter<v extends MainMvpView> extends MvpPresenter<v> {
        /*
        登录
         */
        void doLoginCall(String userName, String password);
    }

}
