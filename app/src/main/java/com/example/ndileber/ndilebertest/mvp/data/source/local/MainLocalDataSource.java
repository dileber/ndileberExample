package com.example.ndileber.ndilebertest.mvp.data.source.local;

import com.dileber.gold.alipaygold.data.model.params.FundNetValueParams;
import com.dileber.gold.alipaygold.data.model.response.FundNetValueResponse;
import com.dileber.gold.alipaygold.data.source.MainDataSource;
import com.drcosu.ndileber.mvp.data.source.local.BaseLocalDataSource;
import com.drcosu.ndileber.tools.log.ULog;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by 自动生成.
 */

public class MainLocalDataSource extends BaseLocalDataSource implements MainDataSource {

    private static volatile MainLocalDataSource instance;

    private MainLocalDataSource() {

    }

    public static MainLocalDataSource getInstance() {
        if (instance == null) {
            synchronized (MainLocalDataSource.class) {
                if (instance == null) {
                    instance = new MainLocalDataSource();
                }
            }
        }
        return instance;
    }

    public Observable<FundNetValueResponse> fundNetValue(FundNetValueParams params){
        Observable<FundNetValueResponse> fundNetValue = Observable.create(new Observable.OnSubscribe<FundNetValueResponse>() {
            @Override
            public void call(Subscriber<? super FundNetValueResponse> subscriber) {
                if(fundNetValueResponse!=null){
                    subscriber.onNext(fundNetValueResponse);
                }
                subscriber.onCompleted();
            }
        });

        return fundNetValue;
    }

    FundNetValueResponse fundNetValueResponse = null;
    @Override
    public void saveFundNetValue(FundNetValueResponse fundNetValueResponse) {
        ULog.o(fundNetValueResponse);
        this.fundNetValueResponse = fundNetValueResponse;
    }
}
