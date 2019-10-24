//
//  BaseFrg
//
//  Created by DELL on 2018-11-07 08:50:36
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.system.xmqb.frg;

import android.content.Context;
import android.view.View;

import com.ab.http.HttpUtil;
import com.ab.util.HttpResponseListener;
import com.ab.util.HttpResponseListenerSon;
import com.framewidget.view.Headlayout;
import com.mdx.framework.activity.MFragment;
import com.mdx.framework.widget.ActionBar;
import com.system.xmqb.R;

public abstract class BaseFrg extends MFragment implements View.OnClickListener, HttpResponseListenerSon {
    public Headlayout mHeadlayout;

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

    @Override
    public void setActionBar(ActionBar actionBar, Context context) {
        mHeadlayout = new Headlayout(context);
        mHeadlayout.setLeftBackground(R.drawable.arrows_left);
        mHeadlayout.setGoBack(getActivity());
        actionBar.addView(mHeadlayout);
    }

    public void loadUrlPost(String methodName, Object... mparams) {
        HttpUtil.loadUrl(getContext(), "POST", methodName, new HttpResponseListener(getContext(), this, methodName, true), mparams);
    }

    public void loadUrlGet(String methodName, Object... mparams) {
        HttpUtil.loadUrl(getContext(), "GET", methodName, new HttpResponseListener(getContext(), this, methodName, true), mparams);
    }

    public void loadUrlPostNS(String methodName, Object... mparams) {
        HttpUtil.loadUrl(getContext(), "POST", methodName, new HttpResponseListener(getContext(), this, methodName, false), mparams);
    }


}
