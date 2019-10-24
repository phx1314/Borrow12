//
//  HdtjTop
//
//  Created by DELL on 2018-11-07 17:21:58
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.system.xmqb.item;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.framewidget.view.DfCirleCurr;
import com.mdx.framework.activity.TitleAct;
import com.mdx.framework.utility.Helper;
import com.mdx.framework.widget.MImageView;
import com.system.xmqb.R;
import com.system.xmqb.ada.AdaBanner;
import com.system.xmqb.frg.FrgLogin;
import com.system.xmqb.frg.FrgProductDetail;
import com.system.xmqb.model.ModelBanner;
import com.system.xmqb.model.ModelKa;
import com.system.xmqb.model.ModelRecommend;

import static com.framewidget.F.mModelLogin;
import static com.system.xmqb.F.BANNER;
import static com.system.xmqb.F.CREDITCARD;
import static com.system.xmqb.F.RECOMMEND;
import static com.system.xmqb.F.json2Model;


public class HdtjTop extends BaseItem {
    public DfCirleCurr mDfCirleCurr;
    public TextView mTextView_name1;
    public TextView mTextView_content1;
    public MImageView mImageView1;
    public TextView mTextView_name2;
    public TextView mTextView_content2;
    public MImageView mImageView2;
    public TextView mTextView_name3;
    public TextView mTextView_content3;
    public MImageView mImageView3;
    public TextView mTextView_name4;
    public TextView mTextView_content4;
    public MImageView mImageView4;
    public TextView mTextView_name5;
    public TextView mTextView_content5;
    public MImageView mImageView5;
    public TextView mTextView_p1;
    public TextView mTextView_ed1;
    public TextView mTextView_ly1;
    public TextView mTextView_remark1;
    public TextView mTextView_p2;
    public TextView mTextView_ed2;
    public TextView mTextView_ly2;
    public TextView mTextView_remark2;
    public LinearLayout mLinearLayout1;
    public LinearLayout mLinearLayout2;
    public ModelRecommend mModelRecommend;

    @SuppressLint("InflateParams")
    public static View getView(Context context, ViewGroup parent) {
        LayoutInflater flater = LayoutInflater.from(context);
        View convertView = flater.inflate(R.layout.item_hdtj_top, null);
        convertView.setTag(new HdtjTop(convertView));
        return convertView;
    }

    public HdtjTop(View view) {
        this.contentview = view;
        this.context = contentview.getContext();
        initView();
    }

    private void initView() {
        this.contentview.setTag(this);
        findVMethod();
    }

    private void findVMethod() {
        mDfCirleCurr = (DfCirleCurr) contentview.findViewById(R.id.mDfCirleCurr);
        mTextView_name1 = (TextView) findViewById(R.id.mTextView_name1);
        mTextView_content1 = (TextView) findViewById(R.id.mTextView_content1);
        mImageView1 = (MImageView) findViewById(R.id.mImageView1);
        mTextView_name2 = (TextView) findViewById(R.id.mTextView_name2);
        mTextView_content2 = (TextView) findViewById(R.id.mTextView_content2);
        mImageView2 = (MImageView) findViewById(R.id.mImageView2);
        mTextView_name3 = (TextView) findViewById(R.id.mTextView_name3);
        mTextView_content3 = (TextView) findViewById(R.id.mTextView_content3);
        mImageView3 = (MImageView) findViewById(R.id.mImageView3);
        mTextView_name4 = (TextView) findViewById(R.id.mTextView_name4);
        mTextView_content4 = (TextView) findViewById(R.id.mTextView_content4);
        mImageView4 = (MImageView) findViewById(R.id.mImageView4);
        mTextView_name5 = (TextView) findViewById(R.id.mTextView_name5);
        mTextView_content5 = (TextView) findViewById(R.id.mTextView_content5);
        mImageView5 = (MImageView) findViewById(R.id.mImageView5);
        mTextView_p1 = (TextView) findViewById(R.id.mTextView_p1);
        mTextView_ed1 = (TextView) findViewById(R.id.mTextView_ed1);
        mTextView_ly1 = (TextView) findViewById(R.id.mTextView_ly1);
        mTextView_remark1 = (TextView) findViewById(R.id.mTextView_remark1);
        mTextView_p2 = (TextView) findViewById(R.id.mTextView_p2);
        mTextView_ed2 = (TextView) findViewById(R.id.mTextView_ed2);
        mTextView_ly2 = (TextView) findViewById(R.id.mTextView_ly2);
        mTextView_remark2 = (TextView) findViewById(R.id.mTextView_remark2);
        mLinearLayout1 = (LinearLayout) findViewById(R.id.mLinearLayout1);
        mLinearLayout2 = (LinearLayout) findViewById(R.id.mLinearLayout2);

        mLinearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mModelLogin == null) {
                    Helper.startActivity(context, FrgLogin.class, TitleAct.class);
                    return;
                }
                if (mModelRecommend.data != null && mModelRecommend.data.size() > 0)
                    Helper.startActivity(context, FrgProductDetail.class, TitleAct.class, "id", mModelRecommend.data.get(0).id + "");
            }
        });
        mLinearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mModelLogin == null) {
                    Helper.startActivity(context, FrgLogin.class, TitleAct.class);
                    return;
                }
                if (mModelRecommend.data != null && mModelRecommend.data.size() > 0)
                    Helper.startActivity(context, FrgProductDetail.class, TitleAct.class, "id", mModelRecommend.data.get(1).id + "");
            }
        });
    }

    public void set() {
        loadUrlGet(BANNER, "position", "3");
        loadUrlGet(CREDITCARD);
        loadUrlGet(RECOMMEND);
    }

    @Override
    public void onSuccess(String methodName, String content) {
        if (methodName.equals(BANNER)) {
            ModelBanner mModelBanner = (ModelBanner) json2Model(content, ModelBanner.class);
            mDfCirleCurr.setAdapter(new AdaBanner(context, mModelBanner.data));
        } else if (methodName.equals(CREDITCARD)) {
            ModelKa mModelKa = (ModelKa) json2Model(content, ModelKa.class);
            for (int i = 0; i < mModelKa.data.size(); i++) {
                if (i == 0) {
                    mTextView_name1.setText(mModelKa.data.get(i).name);
                    mTextView_content1.setText(mModelKa.data.get(i).value);
                    mImageView1.setObj(com.system.xmqb.F.HOST + mModelKa.data.get(i).img);
                } else if (i == 1) {
                    mTextView_name2.setText(mModelKa.data.get(i).name);
                    mTextView_content2.setText(mModelKa.data.get(i).value);
                    mImageView2.setObj(com.system.xmqb.F.HOST + mModelKa.data.get(i).img);
                } else if (i == 2) {
                    mTextView_name3.setText(mModelKa.data.get(i).name);
                    mTextView_content3.setText(mModelKa.data.get(i).value);
                    mImageView3.setObj(com.system.xmqb.F.HOST + mModelKa.data.get(i).img);
                } else if (i == 3) {
                    mTextView_name4.setText(mModelKa.data.get(i).name);
                    mTextView_content4.setText(mModelKa.data.get(i).value);
                    mImageView4.setObj(com.system.xmqb.F.HOST + mModelKa.data.get(i).img);
                } else if (i == 4) {
                    mTextView_name5.setText(mModelKa.data.get(i).name);
                    mTextView_content5.setText(mModelKa.data.get(i).value);
                    mImageView5.setObj(com.system.xmqb.F.HOST + mModelKa.data.get(i).img);
                }
            }
        } else if (methodName.equals(RECOMMEND)) {
            mModelRecommend = (ModelRecommend) json2Model(content, ModelRecommend.class);
            for (int i = 0; i < mModelRecommend.data.size(); i++) {
                if (i == 0) {
                    mTextView_p1.setText(mModelRecommend.data.get(i).amountStart + "-" + mModelRecommend.data.get(i).amountEnd);
                    mTextView_ly1.setText("推荐理由：" + mModelRecommend.data.get(i).sketch);
                    mTextView_remark1.setText(mModelRecommend.data.get(i).name);
                } else if (i == 1) {
                    mTextView_p2.setText(mModelRecommend.data.get(i).amountStart + "-" + mModelRecommend.data.get(i).amountEnd);
                    mTextView_ly2.setText("推荐理由：" + mModelRecommend.data.get(i).sketch);
                    mTextView_remark2.setText(mModelRecommend.data.get(i).name);
                }
            }
        }
    }
}