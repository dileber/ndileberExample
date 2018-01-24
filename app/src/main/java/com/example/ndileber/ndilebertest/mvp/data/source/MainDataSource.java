package com.example.ndileber.ndilebertest.mvp.data.source;

import com.dileber.gold.alipaygold.data.model.params.FundNetValueParams;
import com.dileber.gold.alipaygold.data.model.response.FundNetValueResponse;
import com.drcosu.ndileber.mvp.data.BaseDataSource;

import rx.Observable;

/**
 * Created by 自动生成.
 */

public interface MainDataSource extends BaseDataSource {

    Observable<FundNetValueResponse> fundNetValue(FundNetValueParams params);

    void saveFundNetValue(FundNetValueResponse fundNetValueResponse);

}
