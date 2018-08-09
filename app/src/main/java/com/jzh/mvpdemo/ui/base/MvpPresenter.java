package com.jzh.mvpdemo.ui.base;


/**
 * Author:jzh
 * desc:view 基本persenter 操作基础类，定义view 控件界面的基本操作功能
 * Date:2018/08/08 17:25
 * Email:jzh970611@163.com
 */

public interface MvpPresenter<V extends MvpView> {
    /*
    还可以定义一些其他p层的东西，比如对api的错误码统一管理
     */

    void onAttach(V mvpView);

    void onDetach();


}
