package com.example.ndileber.ndilebertest.mvp.data.source.remote;

import com.dileber.gold.alipaygold.app.GOLDConfig;
import com.dileber.gold.alipaygold.data.model.params.FundNetValueParams;
import com.dileber.gold.alipaygold.data.model.response.FundNetValueResponse;
import com.dileber.gold.alipaygold.data.service.MainService;
import com.dileber.gold.alipaygold.data.source.MainDataSource;
import com.drcosu.ndileber.mvp.data.source.remote.BaseRemoteDataSource;
import com.drcosu.ndileber.tools.HRetrofit;

import rx.Observable;

/**
 * Created by 自动生成.
 */

public class MainRemoteDataSource extends BaseRemoteDataSource implements MainDataSource {

    private static volatile MainRemoteDataSource instance;


    HRetrofit hRetrofit;
    MainService service;

    private MainRemoteDataSource() {

        hRetrofit = HRetrofit.getInstence(GOLDConfig.BOSERA_URL);
        service = hRetrofit.retrofit.create(MainService.class);
    }

    public static MainRemoteDataSource getInstance() {
        if (instance == null) {
            synchronized (MainRemoteDataSource.class) {
                if (instance == null) {
                    instance = new MainRemoteDataSource();
                }
            }
        }
        return instance;
    }

    @Override
    public Observable<FundNetValueResponse> fundNetValue(FundNetValueParams params) {
        return service.fundNetValue(params);
    }

    @Override
    public void saveFundNetValue(FundNetValueResponse fundNetValueResponse) {

    }
}
