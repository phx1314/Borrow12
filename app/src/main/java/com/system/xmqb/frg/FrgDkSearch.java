//
//  FrgDkSearch
//
//  Created by DELL on 2018-11-07 14:04:12
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.system.xmqb.frg;

import android.content.Context;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.ab.view.listener.AbOnListViewListener;
import com.ab.view.pullview.AbPullListView;
import com.framewidget.F;
import com.mdx.framework.adapter.MAdapter;
import com.mdx.framework.widget.ActionBar;
import com.system.xmqb.R;
import com.system.xmqb.ada.AdaTjdk;
import com.system.xmqb.model.ModelSearchGood;

import static com.system.xmqb.F.LOAN_LIST_BY_TAG;
import static com.system.xmqb.F.json2Model;


public class FrgDkSearch extends BaseFrg {

    public EditText mEditText;
    public TextView mTextView_ss;
    public RadioButton mRadioButton1;
    public RadioButton mRadioButton2;
    public RadioButton mRadioButton3;
    public RadioButton mRadioButton4;
    public AbPullListView mMListView;

    public String tagId = "2";
    public RadioGroup mRadioGroup;
    public ImageButton mImageButton_back;
    public static String key = "";

    @Override
    protected void create(Bundle savedInstanceState) {
        key = "";
        setContentView(R.layout.frg_dk_search);
        initView();
        loaddata();
    }

    private void initView() {
        findVMethod();
    }

    private void findVMethod() {
        mEditText = (EditText) findViewById(R.id.mEditText);
        mTextView_ss = (TextView) findViewById(R.id.mTextView_ss);
        mRadioButton1 = (RadioButton) findViewById(R.id.mRadioButton1);
        mRadioButton2 = (RadioButton) findViewById(R.id.mRadioButton2);
        mRadioButton3 = (RadioButton) findViewById(R.id.mRadioButton3);
        mRadioButton4 = (RadioButton) findViewById(R.id.mRadioButton4);
        mMListView = (AbPullListView) findViewById(R.id.mMListView);
        mRadioGroup = (RadioGroup) findViewById(R.id.mRadioGroup);
        mImageButton_back = (ImageButton) findViewById(R.id.mImageButton_back);
        mImageButton_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FrgDkSearch.this.finish();
                F.closeSoftKey(getActivity());
            }
        });
        mTextView_ss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                key = mEditText.getText().toString();
                mMListView.setGetApiLoadParams(LOAN_LIST_BY_TAG, "tagId", tagId, "keyword", mEditText.getText().toString());
                F.closeSoftKey(getActivity());
            }
        });
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                TextPaint tp1 = mRadioButton1.getPaint();
                tp1.setFakeBoldText(false);
                TextPaint tp2 = mRadioButton2.getPaint();
                tp2.setFakeBoldText(false);
                TextPaint tp3 = mRadioButton3.getPaint();
                tp3.setFakeBoldText(false);
                TextPaint tp4 = mRadioButton4.getPaint();
                tp4.setFakeBoldText(false);
                TextPaint tp_t = null;
                switch (i) {
                    case R.id.mRadioButton1:
                        tp_t = mRadioButton1.getPaint();
                        tagId = "2";
                        break;
                    case R.id.mRadioButton2:
                        tp_t = mRadioButton2.getPaint();
                        tagId = "6";
                        break;
                    case R.id.mRadioButton3:
                        tp_t = mRadioButton3.getPaint();
                        tagId = "2059";
                        break;
                    case R.id.mRadioButton4:
                        tp_t = mRadioButton4.getPaint();
                        tagId = "7";
                        break;
                }
                tp_t.setFakeBoldText(true);
                mMListView.setGetApiLoadParams(LOAN_LIST_BY_TAG, "tagId", tagId, "keyword", mEditText.getText().toString());
                F.closeSoftKey(getActivity());
            }
        });
    }

    public void loaddata() {

//        mMListView.setPageSize(Integer.MAX_VALUE);
        mMListView.setGetApiLoadParams(LOAN_LIST_BY_TAG, "tagId", tagId);
        mMListView.setAbOnListViewListener(new AbOnListViewListener() {
            @Override
            public MAdapter onSuccess(String methodName, String content) {
                ModelSearchGood mModelSearchGood = (ModelSearchGood) json2Model(content, ModelSearchGood.class);
                return new AdaTjdk(getContext(), mModelSearchGood.data);
            }
        });
    }


    @Override
    public void setActionBar(ActionBar actionBar, Context context) {
        super.setActionBar(actionBar, context);
        mHeadlayout.setTitle("贷款搜索");
    }
}