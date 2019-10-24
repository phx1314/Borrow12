//
//  Hdtj
//
//  Created by DELL on 2018-11-07 16:37:53
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.system.xmqb.item;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mdx.framework.widget.MImageView;
import com.system.xmqb.R;
import com.system.xmqb.model.ModelXyk;


public class Hdtj extends BaseItem {
    public MImageView mMImageView;
    public TextView mTextView_title;
    public TextView mTextView_content;
    public TextView mTextView_count;


    @SuppressLint("InflateParams")
    public static View getView(Context context, ViewGroup parent) {
        LayoutInflater flater = LayoutInflater.from(context);
        View convertView = flater.inflate(R.layout.item_hdtj, null);
        convertView.setTag(new Hdtj(convertView));
        return convertView;
    }

    public Hdtj(View view) {
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
        mTextView_content = (TextView) contentview.findViewById(R.id.mTextView_content);
        mTextView_count = (TextView) contentview.findViewById(R.id.mTextView_count);


    }

    public void set(ModelXyk.DataBean item) {
        mMImageView.setObj(com.system.xmqb.F.HOST + item.img);
        mTextView_title.setText(item.name);
        mTextView_content.setText(item.sketch);
        mTextView_count.setText("申请人数  " + item.applyCount);
    }


}