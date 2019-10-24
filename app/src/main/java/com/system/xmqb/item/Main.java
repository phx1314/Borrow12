//
//  Main
//
//  Created by DELL on 2018-11-07 10:31:33
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

import com.mdx.framework.activity.TitleAct;
import com.mdx.framework.utility.Helper;
import com.mdx.framework.widget.MImageView;
import com.system.xmqb.R;
import com.system.xmqb.frg.FrgLogin;
import com.system.xmqb.frg.FrgProductDetail;
import com.system.xmqb.model.ModelData;
import com.system.xmqb.model.ModelMain;

import static com.framewidget.F.mModelLogin;


public class Main extends BaseItem {
    public LinearLayout mLinearLayout_1;
    public MImageView mMImageView;
    public TextView mTextView_title;
    public TextView mTextView_price;
    public TextView mTextView_content;
    public LinearLayout mLinearLayout_2;
    public MImageView mMImageView2;
    public TextView mTextView_title2;
    public TextView mTextView_price2;
    public TextView mTextView_content2;
    public ModelData item;

    @SuppressLint("InflateParams")
    public static View getView(Context context, ViewGroup parent) {
        LayoutInflater flater = LayoutInflater.from(context);
        View convertView = flater.inflate(R.layout.item_main, null);
        convertView.setTag(new Main(convertView));
        return convertView;
    }

    public Main(View view) {
        this.contentview = view;
        this.context = contentview.getContext();
        initView();
    }

    private void initView() {
        this.contentview.setTag(this);
        findVMethod();
    }

    private void findVMethod() {
        mLinearLayout_1 = (LinearLayout) contentview.findViewById(R.id.mLinearLayout_1);
        mMImageView = (MImageView) contentview.findViewById(R.id.mMImageView);
        mTextView_title = (TextView) contentview.findViewById(R.id.mTextView_title);
        mTextView_price = (TextView) contentview.findViewById(R.id.mTextView_price);
        mTextView_content = (TextView) contentview.findViewById(R.id.mTextView_content);
        mLinearLayout_2 = (LinearLayout) contentview.findViewById(R.id.mLinearLayout_2);
        mMImageView2 = (MImageView) contentview.findViewById(R.id.mMImageView2);
        mTextView_title2 = (TextView) contentview.findViewById(R.id.mTextView_title2);
        mTextView_price2 = (TextView) contentview.findViewById(R.id.mTextView_price2);
        mTextView_content2 = (TextView) contentview.findViewById(R.id.mTextView_content2);
        mLinearLayout_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mModelLogin == null) {
                    Helper.startActivity(context, FrgLogin.class, TitleAct.class);
                    return;
                }
                Helper.startActivity(context, FrgProductDetail.class, TitleAct.class, "id", ((ModelMain.DataBean.DataListBean) item.mList.get(0)).id + "");
            }
        });
        mLinearLayout_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mModelLogin == null) {
                    Helper.startActivity(context, FrgLogin.class, TitleAct.class);
                    return;
                }
                Helper.startActivity(context, FrgProductDetail.class, TitleAct.class, "id", ((ModelMain.DataBean.DataListBean) item.mList.get(1)).id + "");
            }
        });

    }

    public void set(ModelData item) {
        this.item = item;
        setShow(item.mList.size());
        for (int i = 0; i < item.mList.size(); i++) {
            ModelMain.DataBean.DataListBean mMPhoto = (ModelMain.DataBean.DataListBean) item.mList.get(i);
            if (i == 0) {
                mTextView_title.setText(mMPhoto.name);
                mMImageView.setObj(com.system.xmqb.F.HOST + mMPhoto.img);
                mTextView_price.setText(mMPhoto.amount);
                mTextView_content.setText(mMPhoto.tag);
            } else if (i == 1) {
                mTextView_title2.setText(mMPhoto.name);
                mMImageView2.setObj(com.system.xmqb.F.HOST + mMPhoto.img);
                mTextView_price2.setText(mMPhoto.amount);
                mTextView_content2.setText(mMPhoto.tag);
            }
        }
    }

    void setShow(int count) {
        mLinearLayout_1.setVisibility(count > 0 ? View.VISIBLE : View.INVISIBLE);
        mLinearLayout_2.setVisibility(count > 1 ? View.VISIBLE : View.INVISIBLE);
    }


}