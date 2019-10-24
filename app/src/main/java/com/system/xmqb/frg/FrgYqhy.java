//
//  FrgYqhy
//
//  Created by DELL on 2018-11-14 14:05:38
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.system.xmqb.frg;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.mdx.framework.widget.ActionBar;
import com.system.xmqb.R;


public class FrgYqhy extends BaseFrg {

    public TextView mTextView1;
    public TextView mTextView2;
    public TextView mTextView3;
    public TextView mTextView4;


    @Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.frg_yqhy);
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
        mTextView4 = (TextView) findViewById(R.id.mTextView4);


    }

    public void loaddata() {

    }

    @Override
    public void setActionBar(ActionBar actionBar, Context context) {
        super.setActionBar(actionBar, context);
        mHeadlayout.setTitle("邀请好友");
    }
}