package com.example.ndileber.ndilebertest.mvp.chart;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.drcosu.ndileber.dileberui.timetable.singleline.CalenderSingleView;
import com.drcosu.ndileber.dileberui.timetable.singleline.CalenderViewPageAdapter;
import com.drcosu.ndileber.mvp.ubase.UBaseFragment;
import com.drcosu.ndileber.tools.UTime;
import com.drcosu.ndileber.tools.log.ULog;
import com.example.ndileber.ndilebertest.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
    CalenderSingleView calenderSingleView;
    @Override
    protected void initView(Bundle savedInstanceState) {
        calenderSingleView = (CalenderSingleView) findView(R.id.calenderSingleView);
        List<Date> temp = new ArrayList<>();
        temp.add(new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,-10);
        temp.add(calendar.getTime());

        calenderSingleView.setGuanxiDate(temp);
        calenderSingleView.setDateSelectedDelegate(new CalenderViewPageAdapter.DateSelectedDelegate() {
            @Override
            public void onDateSelected(View view, Date date) {
                Snackbar.make(view, UTime.getDateStr(UTime.Pattern.y_m_d_h_m_s,date), Snackbar.LENGTH_INDEFINITE)
                        .setAction(android.R.string.ok, new View.OnClickListener() {
                            @Override
                            @TargetApi(Build.VERSION_CODES.M)
                            public void onClick(View v) {
                            }
                        }).show();
            }
        });
    }

    @Override
    public int layoutViewId() {
        return R.layout.fragment_chart;
    }
}
