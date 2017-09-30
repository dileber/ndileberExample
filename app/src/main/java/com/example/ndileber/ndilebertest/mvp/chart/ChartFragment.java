package com.example.ndileber.ndilebertest.mvp.chart;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.drcosu.ndileber.mvp.ubase.UBaseFragment;
import com.example.ndileber.ndilebertest.R;

public class ChartFragment extends UBaseFragment<ChartPresenter> implements  ChartContract.View<ChartPresenter>{

    public ChartFragment() {
        // Required empty public constructor
    }

    public static ChartFragment newInstance() {
        ChartFragment fragment = new ChartFragment();
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
    protected ChartPresenter createPresenterInstance() {
        return new ChartPresenter(this);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    public int layoutViewId() {
        return R.layout.fragment_chart;
    }
}
