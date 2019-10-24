//
//  FrgTjdk
//
//  Created by DELL on 2018-11-07 10:35:18
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.system.xmqb.frg;

import android.content.Context;
import android.os.Bundle;

import com.ab.view.listener.AbOnListViewListener;
import com.ab.view.pullview.AbPullListView;
import com.google.gson.Gson;
import com.mdx.framework.adapter.MAdapter;
import com.mdx.framework.widget.ActionBar;
import com.system.xmqb.R;
import com.system.xmqb.ada.AdaTjdk;
import com.system.xmqb.model.ModelMain;
import com.system.xmqb.model.ModelTjGood;

import java.util.ArrayList;
import java.util.List;

import static com.system.xmqb.F.LOAN_TUIJIAN;


public class FrgTjdk extends BaseFrg {

    public AbPullListView mMListView;


    @Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.frg_tjdk);
        initView();
        loaddata();
    }

    private void initView() {
        findVMethod();
    }

    private void findVMethod() {
        mMListView = (AbPullListView) findViewById(R.id.mMListView);


    }

    public void loaddata() {
        mMListView.setPageSize(Integer.MAX_VALUE);
        mMListView.setGetApiLoadParams(LOAN_TUIJIAN);
        mMListView.setAbOnListViewListener(new AbOnListViewListener() {
            @Override
            public MAdapter onSuccess(String methodName, String content) {
                ModelTjGood mModelTjGood = new Gson().fromJson(content, ModelTjGood.class);
                List<ModelMain.DataBean.DataListBean> dataList = new ArrayList ();
                for (ModelTjGood.DataBean mDataBean : mModelTjGood.data) {
                    for (ModelMain.DataBean.DataListBean item : mDataBean.dataList) {
                        item.flag_name = mDataBean.name;
                    }
                    dataList.addAll(mDataBean.dataList);
                }
                return new AdaTjdk(getContext(), dataList);
            }
        });
    }

    @Override
    public void setActionBar(ActionBar actionBar, Context context) {
        super.setActionBar(actionBar, context);
        mHeadlayout.setTitle("推荐贷款");
    }
}