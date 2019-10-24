//
//  DialogSxLxson
//
//  Created by Administrator on 2018-11-18 18:58:51
//  Copyright (c) Administrator All rights reserved.


/**
   
*/

package com.system.xmqb.item;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.system.xmqb.R;
import com.system.xmqb.model.ModelLx;



public class DialogSxLxson extends BaseItem{
    public TextView mTextView_1;


	@SuppressLint("InflateParams")
    public static View getView(Context context,ViewGroup parent){
	     LayoutInflater flater = LayoutInflater.from(context);
	     View convertView = flater.inflate(R.layout.item_dialog_sx_lxson,null);
	     convertView.setTag( new DialogSxLxson(convertView));
	     return convertView;
	}

	public DialogSxLxson(View view){
		this.contentview=view;
		this.context=contentview.getContext();
		initView();
	}
    
    private void initView() {
    	this.contentview.setTag(this);
    	findVMethod();
    }

    private void findVMethod(){
        mTextView_1=(TextView)contentview.findViewById(R.id.mTextView_1);


    }

    public void set(ModelLx.DataBean item){
		mTextView_1.setText(item.name);
    }
    
    

}