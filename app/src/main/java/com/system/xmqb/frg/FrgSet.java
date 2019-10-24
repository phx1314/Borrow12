//
//  FrgSet
//
//  Created by DELL on 2018-11-07 14:37:26
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.system.xmqb.frg;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.framewidget.F;
import com.framewidget.view.CallBackOnly;
import com.mdx.framework.Frame;
import com.mdx.framework.activity.TitleAct;
import com.mdx.framework.utility.Helper;
import com.mdx.framework.widget.ActionBar;
import com.system.xmqb.R;
import com.system.xmqb.item.DialogHezuo;

import static com.framewidget.F.mModelLogin;


public class FrgSet extends BaseFrg {

    public TextView mTextView1;
    public TextView mTextView2;
    public TextView mTextView3;
    public TextView mImageView_dl;


    @Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.frg_set);
        initView();
        loaddata();
    }

    private void initView() {
        findVMethod();
    }

    private void findVMethod() {
        mTextView1 = (TextView) findViewById(R.id.mTextView1);
        mTextView2 = (TextView) findViewById(R.id.mTextView2);
        mTextView3 = (TextView) findViewById(R.id.mTextView3);
        mImageView_dl = (TextView) findViewById(R.id.mImageView_dl);
        mTextView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Helper.startActivity(getContext(), FrgXgmm.class, TitleAct.class);
            }
        });
        mTextView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Helper.startActivity(getContext(), FrgLxwm.class, TitleAct.class);
            }
        });
        mImageView_dl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mModelLogin = null;
                com.system.xmqb.F.saveJson("mModelLogin", "");
                Frame.HANDLES.sentAll("FrgHome", 0, null);
                Frame.HANDLES.sentAll("FrgWd", 1, null);
                FrgSet.this.finish();
            }
        });
        mTextView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final View view1 = DialogHezuo.getView(getContext(), null);
                F.showCenterDialog(getContext(), view1, new CallBackOnly() {
                    @Override
                    public void goReturnDo(Dialog mDialog) {
                        ((DialogHezuo) view1.getTag()).set(mDialog);
                    }
                });
            }
        });
    }

    public void loaddata() {

    }

    @Override
    public void setActionBar(ActionBar actionBar, Context context) {
        super.setActionBar(actionBar, context);
        mHeadlayout.setTitle("设置");
    }
}