package com.example.ndileber.ndilebertest.mvp.chart;

import android.support.annotation.NonNull;

import com.drcosu.ndileber.mvp.presenter.NormalRxPresenter;
import com.example.ndileber.ndilebertest.mvp.home.HomeContract;

/**
 * Created by WaTaNaBe on 2017/9/30.
 */

public class ChartPresenter  extends NormalRxPresenter<ChartContract.View> implements ChartContract.Presenter{
    public ChartPresenter(@NonNull ChartContract.View view) {
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