package com.example.ndileber.ndilebertest.mvp;

import com.drcosu.ndileber.mvp.presenter.BasePresenter;
import com.drcosu.ndileber.mvp.view.BaseView;

/**
 * Created by WaTaNaBe on 2017/9/30.
 */

public class MainContract {

    public interface Presenter extends BasePresenter{

    }

    public interface View<T extends Presenter> extends BaseView<T>{

    }

}
