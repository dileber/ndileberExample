package com.example.ndileber.ndilebertest.mvp.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.drcosu.ndileber.dileberui.emptypage.EmptyPageLayout;
import com.drcosu.ndileber.mvp.ubase.UBaseFragment;
import com.example.ndileber.ndilebertest.R;

public class UtilsFragment extends UBaseFragment<UtilsPresenter> implements  UtilsContract.View<UtilsPresenter>{


    public UtilsFragment() {
    }

    public static UtilsFragment newInstance() {
        UtilsFragment fragment = new UtilsFragment();
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
        if (getArguments() != null) {
        }
    }

    @Override
    protected UtilsPresenter createPresenterInstance() {
        return new UtilsPresenter(this);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        empty = findView(R.id.empty);
        empty.setEmptyType(EmptyPageLayout.networkError);
    }
    EmptyPageLayout empty;

    @Override
    public int layoutViewId() {
        return R.layout.fragment_utils;
    }
}
