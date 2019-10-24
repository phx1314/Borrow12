//
//  FrgJk
//
//  Created by DELL on 2018-11-07 15:07:27
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.system.xmqb.frg;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ab.view.listener.AbOnListViewListener;
import com.ab.view.pullview.AbPullListView;
import com.google.gson.Gson;
import com.mdx.framework.adapter.MAdapter;
import com.system.xmqb.R;
import com.system.xmqb.ada.AdaTjdk;
import com.system.xmqb.item.PopShowJe;
import com.system.xmqb.item.PopShowLx;
import com.system.xmqb.model.ModelJk;
import com.system.xmqb.model.ModelLx;

import static com.system.xmqb.F.LOAN_LIST_BY_TAG;
import static com.system.xmqb.F.LOAN_TAGS;
import static com.system.xmqb.F.json2Model;


public class FrgJk extends BaseFrg {

    public TextView mTextView_pax;
    public AbPullListView mMListView;
    public LinearLayout mLinearLayout1;
    public LinearLayout mLinearLayout2;
    public ModelLx mModelLx;
    public String ownId;
    public String amount;
    public int sort;
    public TextView mTextView_left;
    public TextView mTextView_right;

    @Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.frg_jk);
        initView();
        loaddata();
    }

    @Override
    public void disposeMsg(int type, Object obj) {
        switch (type) {
            case 0:
                amount = obj.toString();
                mMListView.setGetApiLoadParams(LOAN_LIST_BY_TAG, "ownId", ownId, "amount", amount, "sort", sort);
                break;
            case 1:
                ownId = obj.toString();
                mMListView.setGetApiLoadParams(LOAN_LIST_BY_TAG, "ownId", ownId, "amount", amount, "sort", sort);
                break;
            case 2:
                mTextView_left.setText(obj.toString());
                break;
            case 3:
                mTextView_right.setText(obj.toString());
                break;
        }
    }

    private void initView() {
        findVMethod();
    }

    private void findVMethod() {
        mTextView_pax = (TextView) findViewById(R.id.mTextView_pax);
        mMListView = (AbPullListView) findViewById(R.id.mMListView);
        mLinearLayout1 = (LinearLayout) findViewById(R.id.mLinearLayout1);
        mLinearLayout2 = (LinearLayout) findViewById(R.id.mLinearLayout2);
        mTextView_left = (TextView) findViewById(R.id.mTextView_left);
        mTextView_right = (TextView) findViewById(R.id.mTextView_right);

        mLinearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopShowJe mPopShowJe = new PopShowJe(getContext(), mLinearLayout1);
                mPopShowJe.show();
            }
        });
        mLinearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopShowLx mPopShowJe = new PopShowLx(getContext(), mLinearLayout2, mModelLx);
                mPopShowJe.show();
            }
        });

        mTextView_pax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sort == 0) {
                    sort = 1;
                } else if (sort == 1) {
                    sort = 2;
                } else {
                    sort = 1;
                }
                mMListView.setGetApiLoadParams(LOAN_LIST_BY_TAG, "ownId", ownId, "amount", amount, "sort", sort);
            }
        });
    }

    public void loaddata() {
//        mMListView.setPageSize(Integer.MAX_VALUE);
        mMListView.setGetApiLoadParams(LOAN_LIST_BY_TAG);
        mMListView.setAbOnListViewListener(new AbOnListViewListener() {
            @Override
            public MAdapter onSuccess(String methodName, String content) {
                ModelJk mModelJk = new Gson().fromJson(content, ModelJk.class);
                return new AdaTjdk(getContext(), mModelJk.data);
            }
        });

        loadUrlGet(LOAN_TAGS);
    }

    @Override
    public void onSuccess(String methodName, String content) {
        if (methodName.equals(LOAN_TAGS)) {
            mModelLx = (ModelLx) json2Model(content, ModelLx.class);
            mModelLx.data.add(0, new ModelLx.DataBean("类型不限"));
        }
    }
}