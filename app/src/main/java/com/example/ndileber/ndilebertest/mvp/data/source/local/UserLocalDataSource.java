package com.example.ndileber.ndilebertest.mvp.data.source.local;

import android.support.annotation.NonNull;
import com.drcosu.ndileber.mvp.data.source.local.BaseLocalDataSource;
import com.example.ndileber.ndilebertest.mvp.data.source.UserDataSource;

/**
 * Created by shidawei on 16/8/6.
 */
public class UserLocalDataSource extends BaseLocalDataSource implements UserDataSource {


    private static volatile UserLocalDataSource instance;

    private UserLocalDataSource(){

    }

    public static UserLocalDataSource getInstance(){
        if (instance==null){
            synchronized (UserLocalDataSource.class){
                if(instance==null){
                    instance = new UserLocalDataSource();
                }
            }
        }
        return instance;
    }

}
