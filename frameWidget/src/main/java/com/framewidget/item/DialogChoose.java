//
//  DialogChoose
//
//  Created by DELL on 2018-12-04 11:04:31
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.framewidget.item;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.framewidget.R;
import com.mdx.framework.Frame;
import com.mdx.framework.widget.spinnerwheel.WheelVerticalView;
import com.mdx.framework.widget.spinnerwheel.adapters.ArrayWheelAdapter;


public class DialogChoose extends BaseItem {
    public TextView choose_cancel;
    public TextView choose_cam;
    public WheelVerticalView mWheelVerticalView;
    public Dialog item;
    public String[] strs;

    @SuppressLint("InflateParams")
    public static View getView(Context context, ViewGroup parent) {
        LayoutInflater flater = LayoutInflater.from(context);
        View convertView = flater.inflate(R.layout.item_dialog_choose, null);
        convertView.setTag(new DialogChoose(convertView));
        return convertView;
    }

    public DialogChoose(View view) {
        this.contentview = view;
        this.context = contentview.getContext();
        initView();
    }

    private void initView() {
        this.contentview.setTag(this);
        findVMethod();
    }

    private void findVMethod() {
        choose_cancel = (TextView) contentview.findViewById(R.id.choose_cancel);
        choose_cam = (TextView) contentview.findViewById(R.id.choose_cam);
        mWheelVerticalView = (WheelVerticalView) contentview.findViewById(R.id.mWheelVerticalView);
        choose_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item.dismiss();
            }
        });
        choose_cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item.dismiss();
                Frame.HANDLES.sentAll("FrgWshzl1", 2, strs[mWheelVerticalView.getCurrentItem()]);
            }
        });

    }

    public void set(Dialog item, String[] strs, int position) {
        this.item = item;
        this.strs = strs;
        mWheelVerticalView.setViewAdapter(new ArrayWheelAdapter<String>(context, strs));
        mWheelVerticalView.setCurrentItem(position != -1 ? position : 0);
    }


}