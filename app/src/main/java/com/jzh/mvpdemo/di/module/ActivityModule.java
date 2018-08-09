package com.jzh.mvpdemo.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;


import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;


/**
 * Author:jzh
 * desc:dagger2 注入  定义注入实现 相当于 new 某个对象实现
 * Date:2018/08/08 17:08
 * Email:jzh970611@163.com
 */
@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

}
