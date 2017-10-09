package com.example.ndileber.ndilebertest.mvp.login;

import android.support.annotation.NonNull;

import com.drcosu.ndileber.mvp.presenter.NormalRxPresenter;

/**
 * Created by WaTaNaBe on 2017/10/9.
 */

public class LoginPresenter extends NormalRxPresenter<LoginContract.View> implements LoginContract.Presenter{

    public LoginPresenter(@NonNull LoginContract.View view) {
        super(view);
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void start() {

    }

    @Override
    public void onDestroy() {

    }
}