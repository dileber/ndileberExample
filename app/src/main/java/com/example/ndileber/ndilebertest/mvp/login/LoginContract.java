package com.example.ndileber.ndilebertest.mvp.login;

import com.drcosu.ndileber.mvp.presenter.BasePresenter;
import com.drcosu.ndileber.mvp.view.BaseView;

/**
 * Created by WaTaNaBe on 2017/10/9.
 */

public class LoginContract {
    public interface Presenter extends BasePresenter {

    }

    public interface View<T extends Presenter> extends BaseView<T> {

    }
}
