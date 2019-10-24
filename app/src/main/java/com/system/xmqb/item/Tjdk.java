//
//  Tjdk
//
//  Created by DELL on 2018-11-07 10:42:31
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.system.xmqb.item;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mdx.framework.widget.MImageView;
import com.system.xmqb.R;
import com.system.xmqb.frg.FrgDkSearch;
import com.system.xmqb.model.ModelMain;


public class Tjdk extends BaseItem {
    public MImageView mMImageView;
    public TextView mTextView_title;
    public TextView mTextView_type;
    public TextView mTextView_content;
    public TextView mTextView_content2;
    public TextView mTextView_content3;


    @SuppressLint("InflateParams")
    public static View getView(Context context, ViewGroup parent) {
        LayoutInflater flater = LayoutInflater.from(context);
        View convertView = flater.inflate(R.layout.item_tjdk, null);
        convertView.setTag(new Tjdk(convertView));
        return convertView;
    }

    public Tjdk(View view) {
        this.contentview = view;
        this.context = contentview.getContext();
        initView();
    }

    private void initView() {
        this.contentview.setTag(this);
        findVMethod();
    }

    private void findVMethod() {
        mMImageView = (MImageView) contentview.findViewById(R.id.mMImageView);
        mTextView_title = (TextView) contentview.findViewById(R.id.mTextView_title);
        mTextView_type = (TextView) contentview.findViewById(R.id.mTextView_type);
        mTextView_content = (TextView) contentview.findViewById(R.id.mTextView_content);
        mTextView_content2 = (TextView) contentview.findViewById(R.id.mTextView_content2);
        mTextView_content3 = (TextView) contentview.findViewById(R.id.mTextView_content3);


    }

    public void set(ModelMain.DataBean.DataListBean item) {
        mMImageView.setObj(com.system.xmqb.F.HOST + item.img);
        String name = TextUtils.isEmpty(FrgDkSearch.key) ? item.name : item.name.replace(FrgDkSearch.key, "<b><tt>" + FrgDkSearch.key + "</tt></b>");
        String tag = TextUtils.isEmpty(FrgDkSearch.key) ? item.tag : item.tag.replace(FrgDkSearch.key, "<b><tt>" + FrgDkSearch.key + "</tt></b>");
        mTextView_title.setText(Html.fromHtml(name));
        mTextView_content.setText(Html.fromHtml(tag));
        if (item.special == 1) {
            mTextView_type.setText("热门");
            mTextView_type.setVisibility(View.VISIBLE);
        } else if (item.special == 2) {
            mTextView_type.setText("最新");
            mTextView_type.setVisibility(View.VISIBLE);
        } else {
            mTextView_type.setVisibility(View.GONE);
        }

//        if (TextUtils.isEmpty(item.flag_name)) {
//            mTextView_type.setVisibility(View.GONE);
//        } else {
//            mTextView_type.setVisibility(View.VISIBLE);
//        }
//        mTextView_type.setText(item.flag_name);
        mTextView_content2.setText(item.monthRate);
        mTextView_content3.setText(item.amount);
    }


}