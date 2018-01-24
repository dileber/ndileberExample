package com.dileber.gold.alipaygold.data.model.response;

import com.drcosu.ndileber.mvp.data.model.SModel;

import java.util.List;
import java.util.Map;

/**
 * Created by hyy on 2018/1/18.
 */

public class FundNetValueResponse extends SModel {


    /**
     * errMsg : 成功
     * retCode : 0
     */

    public Data data;
    public String errMsg;
    public String retCode;

    public static class Data {


        public String title;
        public List<Map<String,String>> resultList;

    }
}
