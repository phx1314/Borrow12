//
//  Banner
//
//  Created by DELL on 2018-11-13 09:13:31
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.system.xmqb.item;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mdx.framework.widget.MImageView;
import com.system.xmqb.R;
import com.system.xmqb.model.ModelBanner;


public class Banner extends BaseItem {
    public MImageView mMImageView;


    @SuppressLint("InflateParams")
    public static View getView(Context context, ViewGroup parent) {
        LayoutInflater flater = LayoutInflater.from(context);
        View convertView = flater.inflate(R.layout.item_banner, null);
        convertView.setTag(new Banner(convertView));
        return convertView;
    }

    public Banner(View view) {
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


    }

    public void set(ModelBanner.DataBean item) {
        mMImageView.setRound((int) context.getResources().getDimension(R.dimen.j5dp));
        mMImageView.setObj(com.system.xmqb.F.HOST + item.img);
    }


}