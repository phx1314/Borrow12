//
//  FrgWdjk
//
//  Created by DELL on 2018-11-07 11:09:50
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.system.xmqb.frg;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.mdx.framework.widget.ActionBar;
import com.system.xmqb.R;


public class FrgWdjk extends BaseFrg {

    public TextView mTextView1;
    public TextView mTextView_count1;
    public TextView mTextView2;
    public TextView mTextView_count2;
    public TextView mTextView3;
    public TextView mTextView_count3;
    public TextView mTextView4;
    public TextView mTextView_count4;


    @Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.frg_wdjk);
        initView();
        loaddata();
    }

    private void initView() {
        findVMethod();
    }

    private void findVMethod() {
        mTextView1 = (TextView) findViewById(R.id.mTextView1);
        mTextView_count1 = (TextView) findViewById(R.id.mTextView_count1);
        mTextView2 = (TextView) findViewById(R.id.mTextView2);
        mTextView_count2 = (TextView) findViewById(R.id.mTextView_count2);
        mTextView3 = (TextView) findViewById(R.id.mTextView3);
        mTextView_count3 = (TextView) findViewById(R.id.mTextView_count3);
        mTextView4 = (TextView) findViewById(R.id.mTextView4);
        mTextView_count4 = (TextView) findViewById(R.id.mTextView_count4);


    }

    public void loaddata() {

    }

    @Override
    public void setActionBar(ActionBar actionBar, Context context) {
        super.setActionBar(actionBar, context);
        mHeadlayout.setTitle("我的借款");
    }
}