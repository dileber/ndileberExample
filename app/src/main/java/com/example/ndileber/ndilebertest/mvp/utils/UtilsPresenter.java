package com.example.ndileber.ndilebertest.mvp.utils;

import android.support.annotation.NonNull;

import com.drcosu.ndileber.mvp.presenter.NormalRxPresenter;

/**
 * Created by WaTaNaBe on 2017/10/9.
 */

public class UtilsPresenter extends NormalRxPresenter<UtilsContract.View> implements UtilsContract.Presenter{
    public UtilsPresenter(@NonNull UtilsContract.View view) {
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