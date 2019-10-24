//
//  FrgMore
//
//  Created by DELL on 2018-11-07 09:46:09
//  Copyright (c) DELL All rights reserved.


/**
   
*/

package com.system.xmqb.frg;
import android.os.Bundle;

import com.system.xmqb.R;

import com.ab.view.pullview.AbPullListView;



public class FrgMore extends BaseFrg{

    public AbPullListView mMListView;


 	@Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.frg_more);
        initView();
        loaddata();
    }

    private void initView(){
        findVMethod();
    }
    
    private void findVMethod() {
        mMListView=(AbPullListView)findViewById(R.id.mMListView);


    }
    
    public void loaddata(){

    }
    
   
 
}