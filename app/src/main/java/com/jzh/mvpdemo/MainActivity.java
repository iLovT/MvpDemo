package com.jzh.mvpdemo;

import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import com.jzh.mvpdemo.data.model.LoginResponse;
import com.jzh.mvpdemo.di.component.DaggerActivityComponent;
import com.jzh.mvpdemo.di.module.ActivityModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainMvpView {


    @BindView(R.id.ac_username)
    EditText acUsername;
    @BindView(R.id.ac_password)
    EditText acPassword;

    @Inject
    MainPresenter<MainMvpView> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
        dagger2注入 可以单独抽出一个baseActivity，对v层和dagger2等集中处理
         */
        DaggerActivityComponent.builder().activityModule(new ActivityModule(this)).build().inject(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        /*
        初始化p类，注入v层
         */
        mPresenter.onAttach(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /*
        销毁CompositeDisposable，保证页面销毁时清除请求，同时去除v层引用，防止内存泄露
         */
        mPresenter.onDetach();
    }

    /**
     * 登录成功
     *
     * @param response 登录返回体，具体实现
     */
    @Override
    public void onSucc(LoginResponse response) {
        onToast(response.getErrorMsg());
    }

    /**
     * 登录失败
     *
     * @param msg 失败message
     */
    @Override
    public void onFail(String msg) {
        onToast(msg);
    }

    @OnClick(R.id.ac_login)
    public void onViewClicked() {
        if (TextUtils.isEmpty(getUsername())) {
            onToast(R.string.username_null);
            return;
        }
        if (TextUtils.isEmpty(getPassword())) {
            onToast(R.string.password_null);
            return;
        }
        mPresenter.doLoginCall(getUsername(), getPassword());
    }

    private String getUsername() {
        return acUsername.getText().toString().trim();
    }

    private String getPassword() {
        return acPassword.getText().toString().trim();
    }

    /**
     * 这两个基于v层的方法，全部可以抽出到baseactivity中，就不需要写在这里，我这里只是做个示例
     *
     * @param msg 吐司消息
     */
    @Override
    public void onToast(String msg) {
        if (TextUtils.isEmpty(msg)) {
            msg = getString(R.string.fail);
        }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onToast(@StringRes int msg) {
        if (TextUtils.isEmpty(getString(msg))) {
            msg = R.string.fail;
        }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
