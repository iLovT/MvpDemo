package com.jzh.mvpdemo.ui.base;

import android.support.annotation.StringRes;

/**
 * Author:jzh
 * desc: view 控件基本功能接口，服务于界面
 * Date:2018/08/08 17:26
 * Email:jzh970611@163.com
 */

public interface MvpView {
    /*
    这两个只是示例，还可以定义一些加载条之类的v层方法
     */
    void onToast(String msg);

    void onToast(@StringRes int msg);

}
