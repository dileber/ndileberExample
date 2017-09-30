package com.example.ndileber.ndilebertest.mvp.home;

import android.os.Bundle;

import com.drcosu.ndileber.mvp.ubase.UBaseFragment;
import com.example.ndileber.ndilebertest.R;


public class HomeFragment extends UBaseFragment<HomePresenter> implements HomeContract.View<HomePresenter> {

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected boolean retain() {
        return false;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected HomePresenter createPresenterInstance() {
        return new HomePresenter(this);
    }


    @Override
    public int layoutViewId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }
}
