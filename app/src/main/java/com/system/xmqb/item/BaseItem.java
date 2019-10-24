//
//  BaseItem
//
//  Created by DELL on 2018-11-07 10:31:33
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.system.xmqb.item;

import android.content.Context;
import android.view.View;

import com.ab.http.HttpUtil;
import com.ab.util.HttpResponseListener;
import com.ab.util.HttpResponseListenerSon;

public class BaseItem implements View.OnClickListener, HttpResponseListenerSon {
    protected Context context;
    protected View contentview;

    @Override
    public void onClick(View v) {

    }


    @Override
    public void onFinish() {

    }

    @Override
    public void onFailure(int statusCode, String content, Throwable error, String methodName) {

    }

    @Override
    public void onSuccess(String methodName, String content) {
    }

    public void loadUrlGet(String methodName, Object... mparams) {
        HttpUtil.loadUrl(context, "GET", methodName, new HttpResponseListener(context, this, methodName, false), mparams);
    }

    public View findViewById(int id) {
        return this.contentview.findViewById(id);
    }

}

