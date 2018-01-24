package com.example.ndileber.ndilebertest.mvp.data.source;


import com.dileber.gold.alipaygold.data.model.params.FundNetValueParams;
import com.dileber.gold.alipaygold.data.model.response.FundNetValueResponse;
import com.dileber.gold.alipaygold.data.source.local.MainLocalDataSource;
import com.dileber.gold.alipaygold.data.source.remote.MainRemoteDataSource;
import com.drcosu.ndileber.mvp.data.BaseRepository;
import com.drcosu.ndileber.tools.rx.RxTransformerHelper;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created by 自动生成.
 */

public class MainRepository extends BaseRepository<MainLocalDataSource, MainRemoteDataSource> implements MainDataSource {

    public static volatile MainRepository instance;


    protected MainRepository(MainLocalDataSource localDataSource, MainRemoteDataSource remoteDataSource) {
        super(localDataSource, remoteDataSource);
    }

    public static MainRepository getInstance() {
        if (instance == null) {
            synchronized (MainRepository.class) {
                if (instance == null) {
                    instance = new MainRepository(MainLocalDataSource.getInstance(), MainRemoteDataSource.getInstance());
                }
            }
        }
        return instance;
    }


    @Override
    public Observable<FundNetValueResponse> fundNetValue(FundNetValueParams params) {
        Observable<FundNetValueResponse> observable = Observable.
                concat(localDataSource.fundNetValue(params),
                        remoteDataSource.fundNetValue(params).
                                doOnNext(new Action1<FundNetValueResponse>() {
                            @Override
                            public void call(FundNetValueResponse fundNetValueResponse) {
                                if(fundNetValueResponse!=null){
                                    saveFundNetValue(fundNetValueResponse);
                                }
                            }
                        }).compose(RxTransformerHelper.<FundNetValueResponse>ioToUI())).first();
        return observable;
    }

    @Override
    public void saveFundNetValue(FundNetValueResponse fundNetValueResponse) {
        localDataSource.saveFundNetValue(fundNetValueResponse);
    }
}
