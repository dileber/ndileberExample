package com.example.ndileber.ndilebertest.mvp.data.source;


import com.drcosu.ndileber.mvp.data.BaseRepository;
import com.example.ndileber.ndilebertest.mvp.data.source.local.UserLocalDataSource;
import com.example.ndileber.ndilebertest.mvp.data.source.remote.UserRemoteDataSource;

/**
 * Created by shidawei on 16/8/7.
 */
public class UserRepository extends BaseRepository<UserLocalDataSource,UserRemoteDataSource> implements UserDataSource{

    public static volatile UserRepository instance;

    protected UserRepository(UserLocalDataSource localDataSource, UserRemoteDataSource remoteDataSource) {
        super(localDataSource, remoteDataSource);
    }


    public static UserRepository getInstance(){
        if(instance==null){
            synchronized (UserRepository.class){
                if(instance==null){
                    instance = new UserRepository(UserLocalDataSource.getInstance(),UserRemoteDataSource.getInstance());
                }
            }
        }
        return instance;
    }

}
