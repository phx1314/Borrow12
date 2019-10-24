//
//  MainBottom
//
//  Created by DELL on 2018-11-22 09:09:25
//  Copyright (c) DELL All rights reserved.


/**
   
*/

package com.system.xmqb.item;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mdx.framework.activity.NoTitleAct;
import com.mdx.framework.utility.Helper;
import com.system.xmqb.R;
import com.system.xmqb.frg.FrgDkSearch;


public class MainBottom extends BaseItem{
    public TextView mTextView_more;


	@SuppressLint("InflateParams")
    public static View getView(Context context,ViewGroup parent){
	     LayoutInflater flater = LayoutInflater.from(context);
	     View convertView = flater.inflate(R.layout.item_main_bottom,null);
	     convertView.setTag( new MainBottom(convertView));
	     return convertView;
	}

	public MainBottom(View view){
		this.contentview=view;
		this.context=contentview.getContext();
		initView();
	}
    
    private void initView() {
    	this.contentview.setTag(this);
    	findVMethod();
    }

    private void findVMethod(){
        mTextView_more=(TextView)contentview.findViewById(R.id.mTextView_more);
		mTextView_more.setOnClickListener(Helper.delayClickLitener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Helper.startActivity(context, FrgDkSearch.class, NoTitleAct.class);
			}
		}));

    }

    public void set(String item){

    }
    
    

}