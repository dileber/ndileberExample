package com.example.ndileber.ndilebertest.mvp;

import android.support.annotation.NonNull;

import com.drcosu.ndileber.mvp.presenter.DileberPresenter;
import com.drcosu.ndileber.mvp.presenter.NormalPresenter;
import com.drcosu.ndileber.mvp.presenter.NormalRxPresenter;
import com.example.ndileber.ndilebertest.mvp.data.source.UserRepository;

/**
 * Created by WaTaNaBe on 2017/9/30.
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
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void subscribe() {

    }
}
