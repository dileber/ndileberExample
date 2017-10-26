package com.example.ndileber.ndilebertest.mvp.main;

import android.support.annotation.NonNull;

import com.drcosu.ndileber.mvp.presenter.NormalRxPresenter;

/**
 * Created by WaTaNaBe on 2017/10/26.
 */

public class MainPresenter extends NormalRxPresenter<MainContract.View> implements MainContract.Presenter{
    public MainPresenter(@NonNull MainContract.View view) {
        super(view);
    }

    @Override
    public void start() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void subscribe() {

    }
}
