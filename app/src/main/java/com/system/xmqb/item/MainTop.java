//
//  MainTop
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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.framewidget.view.DfCirleCurr;
import com.mdx.framework.Frame;
import com.mdx.framework.activity.NoTitleAct;
import com.mdx.framework.activity.TitleAct;
import com.mdx.framework.utility.Helper;
import com.system.xmqb.R;
import com.system.xmqb.ada.AdaBanner;
import com.system.xmqb.frg.FrgDkSearch;
import com.system.xmqb.frg.FrgHdtj;
import com.system.xmqb.frg.FrgTjdk;
import com.system.xmqb.model.ModelBanner;
import com.system.xmqb.model.ModelFlipper;

import static com.system.xmqb.F.HOME_CHANGE;


public class MainTop extends BaseItem{
    public DfCirleCurr mDfCirleCurr;
    public TextView mTextView_tj;
    public TextView mTextView_ss;
    public TextView mTextView_hdtj;
    public LinearLayout mLinearLayout_zixun;
    public ViewFlipper mViewFlipper;
    public TextView mTextView_hyp;


	@SuppressLint("InflateParams")
    public static View getView(Context context,ViewGroup parent){
	     LayoutInflater flater = LayoutInflater.from(context);
	     View convertView = flater.inflate(R.layout.item_main_top,null);
	     convertView.setTag( new MainTop(convertView));
	     return convertView;
	}

	public MainTop(View view){
		this.contentview=view;
		this.context=contentview.getContext();
		initView();
	}
    
    private void initView() {
    	this.contentview.setTag(this);
    	findVMethod();
    }

    private void findVMethod(){
        mDfCirleCurr=(DfCirleCurr)contentview.findViewById(R.id.mDfCirleCurr);
        mTextView_tj=(TextView)contentview.findViewById(R.id.mTextView_tj);
        mTextView_ss=(TextView)contentview.findViewById(R.id.mTextView_ss);
        mTextView_hdtj=(TextView)contentview.findViewById(R.id.mTextView_hdtj);
        mLinearLayout_zixun=(LinearLayout)contentview.findViewById(R.id.mLinearLayout_zixun);
        mViewFlipper=(ViewFlipper)contentview.findViewById(R.id.mViewFlipper);
        mTextView_hyp=(TextView)contentview.findViewById(R.id.mTextView_hyp);
        mTextView_tj.setOnClickListener(Helper.delayClickLitener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Helper.startActivity(context, FrgTjdk.class, TitleAct.class);
            }
        }));
        mTextView_ss.setOnClickListener(Helper.delayClickLitener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Helper.startActivity(context, FrgDkSearch.class, NoTitleAct.class);
            }
        }));
        mTextView_hdtj.setOnClickListener(Helper.delayClickLitener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Helper.startActivity(context, FrgHdtj.class, TitleAct.class);
            }
        }));
        mTextView_hyp.setOnClickListener(Helper.delayClickLitener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  Frame.HANDLES.sentAll("FrgMain", 0, null);
            }
        }));


    }

    public void set(ModelBanner  mModelBanner){
        mDfCirleCurr.setAdapter(new AdaBanner(context, mModelBanner.data));
    }
    public void set(ModelFlipper mModelFlipper){
        for (final String str : mModelFlipper.data) {
            TextView mTextView = new TextView(context);
            mTextView.setText(str);
            mTextView.setSingleLine();
            mViewFlipper.addView(mTextView);
        }
    }

    

}