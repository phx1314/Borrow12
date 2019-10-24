//
//  FrgProductDetail
//
//  Created by DELL on 2018-11-07 13:54:00
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.system.xmqb.frg;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.framewidget.F;
import com.framewidget.frg.FrgPtDetail;
import com.mdx.framework.activity.NoTitleAct;
import com.mdx.framework.utility.Helper;
import com.mdx.framework.widget.ActionBar;
import com.mdx.framework.widget.MImageView;
import com.system.xmqb.R;
import com.system.xmqb.model.ModelProduct;

import static com.system.xmqb.F.LOAN_DETAIL;
import static com.system.xmqb.F.json2Model;


public class FrgProductDetail extends BaseFrg {

    public MImageView mMImageView;
    public TextView mTextView_title;
    public TextView mTextView_time;
    public TextView mTextView_count;
    public TextView mTextView_ed;
    public TextView mTextView_qx;
    public TextView mTextView_lf;
    public EditText mTextView_price;
    public EditText mTextView_qxr;
    public TextView mTextView_priceall;
    public TextView mImageView_dl;
    public TextView mTextView_tj;
    public TextView mTextView_cl;
    public TextView mTextView_yd;
    public String id;
    public ModelProduct mModelProduct;

    @Override
    protected void create(Bundle savedInstanceState) {
        id = getActivity().getIntent().getStringExtra("id");
        setContentView(R.layout.frg_product_detail);
        initView();
        loaddata();
    }

    @Override
    public void disposeMsg(int type, Object obj) {
        switch (type) {
            case 0:
                Helper.startActivity(getContext(), FrgPtDetail.class, NoTitleAct.class, "url", mModelProduct.data.url, "title", mModelProduct.data.name);
                break;
        }
    }

    private void initView() {
        findVMethod();
    }

    private void findVMethod() {
        mMImageView = (MImageView) findViewById(R.id.mMImageView);
        mTextView_title = (TextView) findViewById(R.id.mTextView_title);
        mTextView_time = (TextView) findViewById(R.id.mTextView_time);
        mTextView_count = (TextView) findViewById(R.id.mTextView_count);
        mTextView_ed = (TextView) findViewById(R.id.mTextView_ed);
        mTextView_qx = (TextView) findViewById(R.id.mTextView_qx);
        mTextView_lf = (TextView) findViewById(R.id.mTextView_lf);
        mTextView_price = (EditText) findViewById(R.id.mTextView_price);
        mTextView_qxr = (EditText) findViewById(R.id.mTextView_qxr);
        mTextView_priceall = (TextView) findViewById(R.id.mTextView_priceall);
        mImageView_dl = (TextView) findViewById(R.id.mImageView_dl);
        mTextView_tj = (TextView) findViewById(R.id.mTextView_tj);
        mTextView_cl = (TextView) findViewById(R.id.mTextView_cl);
        mTextView_yd = (TextView) findViewById(R.id.mTextView_yd);

        mImageView_dl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Helper.startActivity(getContext(), FrgPtDetail.class, NoTitleAct.class, "url", mModelProduct.data.url, "title", mModelProduct.data.name);
            }
        });

        mTextView_price.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(mTextView_price.getText().toString()) && !TextUtils.isEmpty(mTextView_qxr.getText().toString())) {
                    js();
                } else {
                    mTextView_priceall.setText("预计还款总额：0元");
                }
            }
        });
        mTextView_qxr.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(mTextView_price.getText().toString()) && !TextUtils.isEmpty(mTextView_qxr.getText().toString())) {
                    js();
                } else {
                    mTextView_priceall.setText("预计还款总额：0元");
                }
            }
        });
    }

    public void js() {
        double all;
        double price = Double.valueOf(mTextView_price.getText().toString());
        double qxr = Double.valueOf(mTextView_qxr.getText().toString());
        all = price + price * qxr * Double.valueOf(mModelProduct.data.monthRate.substring(0, mModelProduct.data.monthRate.length() - 1)) / 30;
        mTextView_priceall.setText("预计还款总额：" + F.go2Wei(all) + "元");
    }

    public void loaddata() {

        loadUrlGet(LOAN_DETAIL + id);
    }

    @Override
    public void onSuccess(String methodName, String content) {
        if (methodName.equals(LOAN_DETAIL + id)) {
            mModelProduct = (ModelProduct) json2Model(content, ModelProduct.class);
            mMImageView.setObj(com.system.xmqb.F.HOST + mModelProduct.data.img);
            mTextView_title.setText(mModelProduct.data.name);
//            mTextView_time.setText(mModelProduct.data.name);
            mTextView_count.setText("申请成功：" + mModelProduct.data.applyCount + "人");
            mTextView_ed.setText(mModelProduct.data.amount);
            mTextView_qx.setText(mModelProduct.data.deadline + "日");
            mTextView_lf.setText(mModelProduct.data.monthRate);
            mTextView_tj.setText(mModelProduct.data.conditionDesc);
            mTextView_cl.setText(mModelProduct.data.auditDesc);
            mTextView_yd.setText(mModelProduct.data.sketch);
        }
    }

    @Override
    public void setActionBar(ActionBar actionBar, Context context) {
        super.setActionBar(actionBar, context);
        mHeadlayout.setTitle("产品详情");
    }
}