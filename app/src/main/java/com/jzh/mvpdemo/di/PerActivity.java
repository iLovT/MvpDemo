package com.jzh.mvpdemo.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Author:jzh
 * desc:依赖注入：定义注入体
 * Date:2018/08/08 17:15
 * Email:jzh970611@163.com
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
