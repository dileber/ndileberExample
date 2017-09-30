package com.example.ndileber.ndilebertest.mvp.data.source.remote;

import android.support.annotation.NonNull;


import com.drcosu.ndileber.mvp.data.DataSourceException;
import com.drcosu.ndileber.mvp.data.source.remote.BaseRemoteDataSource;
import com.drcosu.ndileber.tools.HRetrofit;
import com.example.ndileber.ndilebertest.mvp.data.source.UserDataSource;

/**
 * Created by shidawei on 16/8/6.
 */
public class UserRemoteDataSource extends BaseRemoteDataSource implements UserDataSource {

    private static volatile UserRemoteDataSource instance;

//    HRetrofit hRetrofit;
//    UserService userService;

    private UserRemoteDataSource(){
//
//        hRetrofit = HRetrofit.getInstence(SHOPConfig.URL);
//        userService = hRetrofit.retrofit.create(UserService.class);
    }


    public static UserRemoteDataSource getInstance(){
        if (instance==null){
            synchronized (UserRemoteDataSource.class){
                if(instance==null){
                    instance = new UserRemoteDataSource();
                }
            }
        }
        return instance;
    }


}
