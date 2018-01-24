package com.dileber.gold.alipaygold.data.model.params;

import com.drcosu.ndileber.mvp.data.model.SModel;

import java.util.HashMap;

/**
 * Created by hyy on 2018/1/18.
 */

public class FundNetValueParams extends SModel {

    public String netValueType = "";
    public String fundCode = "";
    public String startDate;
    public String endDate;
    public static class Builder {

        FundNetValueParams params;
        public Builder(){
            params = new FundNetValueParams();
        }

        public FundNetValueParams.Builder setData(String startDate,String endDate){
            params.startDate = startDate;
            params.endDate = endDate;
            return this;
        }

        public FundNetValueParams build() {
            return params;
        }

    }
}
