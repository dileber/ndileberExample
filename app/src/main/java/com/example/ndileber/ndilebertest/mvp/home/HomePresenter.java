package com.example.ndileber.ndilebertest.mvp.home;

import android.support.annotation.NonNull;

import com.drcosu.ndileber.mvp.presenter.NormalRxPresenter;

/**
 * Created by WaTaNaBe on 2017/9/30.
 */

public class HomePresenter extends NormalRxPresenter<HomeContract.View> implements HomeContract.Presenter{
    public HomePresenter(@NonNull HomeContract.View view) {
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
