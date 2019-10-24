//
//  DialogGzh
//
//  Created by DELL on 2018-11-14 14:57:26
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.system.xmqb.item;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.ClipboardManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mdx.framework.activity.MActivityActionbar;
import com.mdx.framework.utility.Helper;
import com.system.xmqb.R;


public class DialogGzh extends BaseItem {
    public TextView mImageView_dl;
    public ImageView mImageView_close;

    public Dialog item;

    @SuppressLint("InflateParams")
    public static View getView(Context context, ViewGroup parent) {
        LayoutInflater flater = LayoutInflater.from(context);
        View convertView = flater.inflate(R.layout.item_dialog_gzh, null);
        convertView.setTag(new DialogGzh(convertView));
        return convertView;
    }

    public DialogGzh(View view) {
        this.contentview = view;
        this.context = contentview.getContext();
        initView();
    }

    private void initView() {
        this.contentview.setTag(this);
        findVMethod();
    }

    private void findVMethod() {
        mImageView_dl = (TextView) contentview.findViewById(R.id.mImageView_dl);
        mImageView_close = (ImageView) findViewById(R.id.mImageView_close);
        mImageView_dl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item.dismiss();
                try {
                    ClipboardManager clip = (ClipboardManager) ((MActivityActionbar) context)
                            .getSystemService(Context.CLIPBOARD_SERVICE);
                    clip.setText("泓海网络"); // 复制
                    Intent intent = new Intent();
                    ComponentName cmp = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI");
                    intent.setAction(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_LAUNCHER);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setComponent(cmp);
                    context.startActivity(intent);
                } catch (Exception e) {
                    Helper.toast("请先安装微信", context);
                    e.printStackTrace();
                }
            }
        });
        mImageView_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item.dismiss();
            }
        });
    }

    public void set(Dialog item) {
        this.item = item;

    }


}