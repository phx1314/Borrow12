//
//  DialogSq
//
//  Created by DELL on 2018-11-14 15:23:05
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.system.xmqb.item;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.mdx.framework.Frame;
import com.mdx.framework.utility.Helper;
import com.system.xmqb.R;


public class DialogSq extends BaseItem {
    public EditText mEditText_name;
    public EditText mEditText_phone;
    public TextView mImageView_dl;
    public Dialog item;

    @SuppressLint("InflateParams")
    public static View getView(Context context, ViewGroup parent) {
        LayoutInflater flater = LayoutInflater.from(context);
        View convertView = flater.inflate(R.layout.item_dialog_sq, null);
        convertView.setTag(new DialogSq(convertView));
        return convertView;
    }

    public DialogSq(View view) {
        this.contentview = view;
        this.context = contentview.getContext();
        initView();
    }

    private void initView() {
        this.contentview.setTag(this);
        findVMethod();
    }

    private void findVMethod() {
        mEditText_name = (EditText) contentview.findViewById(R.id.mEditText_name);
        mEditText_phone = (EditText) contentview.findViewById(R.id.mEditText_phone);
        mImageView_dl = (TextView) contentview.findViewById(R.id.mImageView_dl);
        mImageView_dl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(mEditText_name.getText().toString())) {
                    Helper.toast("请输入姓名", context);
                    return;
                }
                if (TextUtils.isEmpty(mEditText_phone.getText().toString())) {
                    Helper.toast("请输入手机号", context);
                    return;
                }
                item.dismiss();
                Frame.HANDLES.sentAll("FrgProductDetail", 0, null);
            }
        });

    }

    public void set(Dialog item) {
        this.item = item;
    }


}