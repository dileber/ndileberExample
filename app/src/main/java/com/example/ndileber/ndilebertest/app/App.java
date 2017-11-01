package com.example.ndileber.ndilebertest.app;

import com.drcosu.ndileber.app.SApplication;
import com.drcosu.ndileber.tools.annotation.SDefaultFont;
import com.drcosu.ndileber.tools.annotation.SFontdType;
import com.drcosu.ndileber.tools.net.RetCallback;
import com.mcxiaoke.packer.helper.PackerNg;


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
// 如果没有使用PackerNg打包添加渠道，默认返回的是""
// com.mcxiaoke.packer.helper.PackerNg
        final String channel = PackerNg.getMarket(this);
// 或者使用 PackerNg.getMarket(Context,defaultValue)
// 之后就可以使用了，比如友盟可以这样设置
//        AnalyticsConfig.setChannel(market);
    }

    @Override
    public void appForbidden(Call call, Response response, RetCallback retCallback) {

    }
}
