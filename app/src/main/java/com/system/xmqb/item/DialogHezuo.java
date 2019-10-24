//
//  DialogHezuo
//
//  Created by DELL on 2018-11-14 14:28:48
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.system.xmqb.item;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.system.xmqb.R;


public class DialogHezuo extends BaseItem {
    public TextView tv_name;
    public TextView tv_sure;


    @SuppressLint("InflateParams")
    public static View getView(Context context, ViewGroup parent) {
        LayoutInflater flater = LayoutInflater.from(context);
        View convertView = flater.inflate(R.layout.item_dialog_hezuo, null);
        convertView.setTag(new DialogHezuo(convertView));
        return convertView;
    }

    public DialogHezuo(View view) {
        this.contentview = view;
        this.context = contentview.getContext();
        initView();
    }

    private void initView() {
        this.contentview.setTag(this);
        findVMethod();
    }

    private void findVMethod() {
        tv_name = (TextView) contentview.findViewById(R.id.tv_name);
        tv_sure = (TextView) contentview.findViewById(R.id.tv_sure);


    }

    public void set(final Dialog item) {
        tv_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item.dismiss();
            }
        });
    }


}