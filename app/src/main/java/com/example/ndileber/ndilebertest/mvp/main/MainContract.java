package com.example.ndileber.ndilebertest.mvp.main;

import com.drcosu.ndileber.mvp.presenter.BasePresenter;
import com.drcosu.ndileber.mvp.view.BaseView;
import com.example.ndileber.ndilebertest.mvp.home.HomeContract;

/**
 * Created by WaTaNaBe on 2017/10/26.
 */

public class MainContract {
    public interface Presenter extends BasePresenter {

    }

    public interface View<T extends Presenter> extends BaseView<T> {

    }
}
