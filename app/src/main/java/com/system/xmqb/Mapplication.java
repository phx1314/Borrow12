package com.system.xmqb;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.mdx.framework.Frame;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by bob on 2015/1/30.
 */
public class Mapplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Frame.init(getApplicationContext());
        F.init();
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
