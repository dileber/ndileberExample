package com.example.ndileber.ndilebertest.mvp;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.drcosu.ndileber.dileberui.activity.AppDebugModeActivity;
import com.drcosu.ndileber.mvp.ubase.UBaseActivity;
import com.drcosu.ndileber.tools.permissions.PermissionsManager;
import com.drcosu.ndileber.tools.permissions.PermissionsResultAction;
import com.drcosu.ndileber.tools.statusbar.UStatusBar;
import com.drcosu.ndileber.utils.ActivityUtils;
import com.drcosu.ndileber.utils.UToolBar;
import com.example.ndileber.ndilebertest.R;
import com.example.ndileber.ndilebertest.mvp.chart.ChartFragment;
import com.example.ndileber.ndilebertest.mvp.chart.ChartPresenter;
import com.example.ndileber.ndilebertest.mvp.home.HomeFragment;
import com.example.ndileber.ndilebertest.mvp.home.HomePresenter;
import com.example.ndileber.ndilebertest.mvp.login.LoginActivity;
import com.example.ndileber.ndilebertest.mvp.main.MainFragment;
import com.example.ndileber.ndilebertest.mvp.setting.SettingsActivity;
import com.example.ndileber.ndilebertest.mvp.utils.UtilsFragment;
import com.jakewharton.rxbinding.view.RxView;

import rx.functions.Action1;

public class MainActivity extends UBaseActivity<MainPresenter>
        implements NavigationView.OnNavigationItemSelectedListener,MainContract.View<MainPresenter>{

    @Override
    protected MainPresenter createPresenterInstance() {
        return  new MainPresenter(this);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        UStatusBar.hideStatusBar(this);

        UToolBar toolBar = new UToolBar();
        toolBar.setTitleString("知らない");
        setToolBar(R.id.toolbar,toolBar);

        FloatingActionButton fab = findView(R.id.fab);
        mPresenter.add(RxView.clicks(fab).subscribe(new Action1<Void>() {
            @Override
            public void call(Void view) {
                Snackbar.make(findView(R.id.fab), "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        }));

        DrawerLayout drawer = findView(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, getToolBar(), R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findView(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActivityUtils.replaceFragment(this.getSupportFragmentManager(),R.id.main_layout, MainFragment.newInstance());

    }


    @Override
    public int layoutViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findView(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            SettingsActivity.start(this);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
//            HomeFragment homeFragment =ActivityUtils.replaceFragment(this.getSupportFragmentManager(),R.id.main_layout,HomeFragment.newInstance());
//            new HomePresenter(homeFragment);
            ActivityUtils.replaceFragment(this.getSupportFragmentManager(),R.id.main_layout,HomeFragment.newInstance());
        } else if (id == R.id.nav_gallery) {
            ActivityUtils.replaceFragment(this.getSupportFragmentManager(),R.id.main_layout,ChartFragment.newInstance());
        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {
            ActivityUtils.replaceFragment(this.getSupportFragmentManager(),R.id.main_layout, UtilsFragment.newInstance());

        } else if (id == R.id.nav_share) {
            AppDebugModeActivity.start(this,getString(R.string.app_name),R.drawable.ic_info_black_24dp);
        } else if (id == R.id.nav_send) {
            LoginActivity.start(this);
        }

        DrawerLayout drawer = findView(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @TargetApi(23)
    private void requestPermissions() {
        PermissionsManager.getInstance().requestAllManifestPermissionsIfNecessary(this, new PermissionsResultAction() {
            @Override
            public void onGranted() {
                //toast("权限OK",Toast.LENGTH_SHORT);
            }

            @Override
            public void onDenied(String permission) {
                //toast(permission+"没有权限，需要用户在设置中添加权限",Toast.LENGTH_SHORT);
            }
        });
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        PermissionsManager.getInstance().notifyPermissionsChange(permissions, grantResults);
    }

}
