//
//  Wshzl2
//
//  Created by DELL on 2018-11-07 16:12:33
//  Copyright (c) DELL All rights reserved.


/**
   
*/

package com.system.xmqb.item;

import com.system.xmqb.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import android.view.View;
import android.widget.EditText;



public class Wshzl2 extends BaseItem{
    public EditText mEditText;


	@SuppressLint("InflateParams")
    public static View getView(Context context,ViewGroup parent){
	     LayoutInflater flater = LayoutInflater.from(context);
	     View convertView = flater.inflate(R.layout.item_wshzl2,null);
	     convertView.setTag( new Wshzl2(convertView));
	     return convertView;
	}

	public Wshzl2(View view){
		this.contentview=view;
		this.context=contentview.getContext();
		initView();
	}
    
    private void initView() {
    	this.contentview.setTag(this);
    	findVMethod();
    }

    private void findVMethod(){
        mEditText=(EditText)contentview.findViewById(R.id.mEditText);


    }

    public void set(String item){

    }
    
    

}