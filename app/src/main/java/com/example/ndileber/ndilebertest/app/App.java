package com.example.ndileber.ndilebertest.app;

import com.drcosu.ndileber.app.SApplication;
import com.drcosu.ndileber.tools.annotation.SDefaultFont;
import com.drcosu.ndileber.tools.annotation.SFontdType;
import com.drcosu.ndileber.tools.net.RetCallback;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by WaTaNaBe on 2017/8/19.
 */
@SDefaultFont(true)
@SFontdType("defaultIcomoon.ttf")
public class App extends SApplication {
    @Override
    protected void init() {

    }

    @Override
    public void appForbidden(Call call, Response response, RetCallback retCallback) {

    }
}
