package com.system.xmqb.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import cn.jpush.android.api.JPushInterface;

public class PushReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();

        if (JPushInterface.ACTION_REGISTRATION_ID.equals(intent.getAction())) {

        } else if (JPushInterface.ACTION_MESSAGE_RECEIVED.equals(intent
                .getAction())) {
            String extra = bundle.getString(JPushInterface.EXTRA_EXTRA);
            String content = bundle.getString(JPushInterface.EXTRA_MESSAGE);

            // 自定义消息不会展示在通知栏，完全要开发者写代码去处理
        } else if (JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals(intent
                .getAction())) {
            String extra = bundle.getString(JPushInterface.EXTRA_EXTRA);
            String content = bundle.getString(JPushInterface.EXTRA_MESSAGE);
        } else if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent
                .getAction())) {
            String extra = bundle.getString(JPushInterface.EXTRA_EXTRA);
//            Helper.startActivity(context, FrgPtDetail.class, NoTitleAct.class, "url", mModelProduct.data.url, "title", mModelProduct.data.name);
        } else {
        }
    }

}
