package com.example.ndileber.ndilebertest.mvp.chart;

import com.drcosu.ndileber.mvp.presenter.BasePresenter;
import com.drcosu.ndileber.mvp.view.BaseView;
import com.example.ndileber.ndilebertest.mvp.home.HomeContract;

/**
 * Created by WaTaNaBe on 2017/9/30.
 */

public class ChartContract {
    public interface Presenter extends BasePresenter {

    }

    public interface View<T extends Presenter> extends BaseView<T> {

    }
}
