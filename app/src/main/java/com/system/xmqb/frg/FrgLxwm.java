//
//  FrgLxwm
//
//  Created by DELL on 2018-11-15 09:19:47
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.system.xmqb.frg;

import android.content.Context;
import android.os.Bundle;

import com.mdx.framework.widget.ActionBar;
import com.system.xmqb.R;


public class FrgLxwm extends BaseFrg {


    @Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.frg_lxwm);
        initView();
        loaddata();
    }

    private void initView() {
        findVMethod();
    }

    private void findVMethod() {


    }

    public void loaddata() {

    }

    @Override
    public void setActionBar(ActionBar actionBar, Context context) {
        super.setActionBar(actionBar, context);
        mHeadlayout.setTitle("联系我们");
    }
}