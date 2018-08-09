package com.jzh.mvpdemo;

import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.jzh.mvpdemo.data.LoginService;
import com.jzh.mvpdemo.data.model.LoginRequest;
import com.jzh.mvpdemo.data.model.LoginResponse;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author:jzh
 * desc:p类，实现具体业务逻辑
 * Date:2018/08/08 16:55
 * Email:jzh970611@163.com
 */

public class MainPresenter<V extends MainMvpView> implements MainMvpView.MainMvpPresenter<V> {
    private CompositeDisposable mCompositeDisposable;
    private V mMvpView;
    private Retrofit retrofit;

    @Inject
    public MainPresenter(CompositeDisposable compositeDisposable) {
        mCompositeDisposable = compositeDisposable;
        /*
        retrofit实例化，与gson和rxjava绑定，可以抽取到basePresenter中，就不需要单独实现
         */
        retrofit = new Retrofit.Builder().baseUrl("http://www.wanandroid.com/").
                addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Override
    public void doLoginCall(String userName, String password) {
        mCompositeDisposable.add(retrofit.create(LoginService.class).
                doLoginCall(new LoginRequest(userName, password)).
                subscribeOn(Schedulers.io())//被观察者置于io线程      至于为何觉得反了，表面说这样更好看，实际...鬼知道
                .observeOn(AndroidSchedulers.mainThread()).//观察者置于主线程
                subscribe(new Consumer<LoginResponse>() {
            @Override
            public void accept(LoginResponse response) throws Exception {//成功回调，还应该通过code判断，这里只是示例
                mMvpView.onSucc(response);
            }
        }, new Consumer<Throwable>() { //错误回调 也可以单独抽出，比如对常见错误码 404 400....进行集中提示
            @Override
            public void accept(Throwable throwable) throws Exception {
                mMvpView.onFail("error " + throwable.getMessage());
            }
        }));
    }


    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void onDetach() {
        mCompositeDisposable.dispose();
        mMvpView = null;
    }

}
