package com.example.ndileber.ndilebertest.mvp.home;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.drcosu.ndileber.mvp.ubase.UBaseFragment;
import com.drcosu.ndileber.tools.DialogLinstener;
import com.drcosu.ndileber.tools.UDialog;
import com.example.ndileber.ndilebertest.R;


public class HomeFragment extends UBaseFragment<HomePresenter> implements HomeContract.View<HomePresenter>,View.OnClickListener {

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
    protected HomePresenter createPresenterInstance() {
        return new HomePresenter(this);
    }


    @Override
    public int layoutViewId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        showSplash();
        setOnClickListener(this,R.id.button,R.id.button2,R.id.button3,R.id.button4,R.id.button5,R.id.button6,R.id.button7,R.id.button8);
    }

    class Splashhandler implements Runnable{

        public void run() {
            loadDialogDismiss();
        }

    }

    Splashhandler splashhandler;
    Handler x;
    public void showSplash() {

        x = new Handler();
        splashhandler = new Splashhandler();

    }


    @Override
    public void onClick(View v) {
        Button temp = null;
        if(v instanceof Button){
            temp = (Button) v;
        }
        switch (v.getId()){
            case R.id.button:
                dialogOk(temp.getText().toString(), new DialogLinstener() {
                    @Override
                    public void confirm(Dialog dialog) {
                        dialog.cancel();
                    }

                    @Override
                    public void cancel(Dialog dialog) {
                        dialog.cancel();
                    }
                });
                break;
            case R.id.button2:
                loading();
                if(x!=null&&splashhandler!=null){
                    x.postDelayed(splashhandler, 3000);
                }
                break;
            case R.id.button3:
                showAlert(UDialog.DIALOG_ERROR,temp.getText().toString());
                break;
            case R.id.button4:
                showAlert(UDialog.DIALOG_NORMAL,temp.getText().toString());

                break;
            case R.id.button5:
                showAlert(UDialog.DIALOG_SUCCESS,temp.getText().toString());

                break;
            case R.id.button6:
                showAlert(UDialog.DIALOG_WARNING,temp.getText().toString());

                break;
            case R.id.button7:
                toast(temp.getText().toString(), Toast.LENGTH_SHORT);
                break;
            case R.id.button8:
                break;
        }
    }


    @Override
    public void onPause() {
        super.onPause();
        if(x!=null&&splashhandler!=null){
            x.removeCallbacks(splashhandler);
        }
    }


    @Override
    public void onResume() {
        super.onResume();
        if(x!=null&&splashhandler!=null){
            x.postDelayed(splashhandler, 3000);
        }
    }
}
