package com.jzh.mvpdemo.di.component;


import com.jzh.mvpdemo.MainActivity;
import com.jzh.mvpdemo.di.PerActivity;
import com.jzh.mvpdemo.di.module.ActivityModule;

import dagger.Component;


/**
 * Author:jzh
 * desc:依赖注入 activity 基本依赖：定义需要注入的业务类，具体实现
 * Date:2018/08/08 17:10
 * Email:jzh970611@163.com
 */
@PerActivity
@Component(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);


}
