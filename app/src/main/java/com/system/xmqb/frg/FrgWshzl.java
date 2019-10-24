//
//  FrgWshzl
//
//  Created by DELL on 2018-11-14 14:04:05
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.system.xmqb.frg;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.framewidget.F;
import com.mdx.framework.utility.Helper;
import com.mdx.framework.widget.ActionBar;
import com.system.xmqb.R;
import com.system.xmqb.model.ModelInfo;

import static com.system.xmqb.F.EDIT;
import static com.system.xmqb.F.INFO;
import static com.system.xmqb.F.json2Model;


public class FrgWshzl extends BaseFrg {

    public RadioButton mRadioButton1;
    public RadioButton mRadioButton2;
    public LinearLayout mLinearLayout_content;
    public TextView mImageView_dl;
    public TextView mTextView_zc;
    public FrgWshzl1 mFrgWshzl1 = new FrgWshzl1();
    public FrgWshzl2 mFrgWshzl2 = new FrgWshzl2();
    public RadioGroup mRadioGroup;
    public static ModelInfo mModelInfo;
    public ScrollView mScrollView;

    @Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.frg_wshzl);
        initView();
        loaddata();
    }

    private void initView() {
        findVMethod();
    }

    private void findVMethod() {
        mRadioButton1 = (RadioButton) findViewById(R.id.mRadioButton1);
        mRadioButton2 = (RadioButton) findViewById(R.id.mRadioButton2);
        mLinearLayout_content = (LinearLayout) findViewById(R.id.mLinearLayout_content);
        mImageView_dl = (TextView) findViewById(R.id.mImageView_dl);
        mTextView_zc = (TextView) findViewById(R.id.mTextView_zc);
        mRadioGroup = (RadioGroup) findViewById(R.id.mRadioGroup);
        mScrollView = (ScrollView) findViewById(R.id.mScrollView);

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.mRadioButton1) {
                    chageFrgment(mFrgWshzl1);
                    mImageView_dl.setText("下一步");
                } else {
                    chageFrgment(mFrgWshzl2);
                    mImageView_dl.setText("保存");
                }
                mScrollView.post(new Runnable() {
                    @Override
                    public void run() {
                        mScrollView.scrollTo(0, 0);
                    }
                });
            }
        });

        mImageView_dl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(mModelInfo.data.name)) {
                    Helper.toast("请输入姓名", getContext());
                    return;
                }
                if (mModelInfo.data.name.length() < 2) {
                    Helper.toast("姓名长度至少两位", getContext());
                    return;
                }
                if (TextUtils.isEmpty(mModelInfo.data.selfCard)) {
                    Helper.toast("请输入身份证号", getContext());
                    return;
                }
                if (!com.system.xmqb.F.isIDCard(mModelInfo.data.selfCard)) {
                    Helper.toast("请输入正确的身份证号", getContext());
                    return;
                }
                if (TextUtils.isEmpty(mModelInfo.data.sex)) {
                    Helper.toast("请输入性别", getContext());
                    return;
                }
                if (TextUtils.isEmpty(mModelInfo.data.age)) {
                    Helper.toast("请输入年龄", getContext());
                    return;
                }
                if (mImageView_dl.getText().toString().trim().equals("下一步")) {
                    mRadioGroup.check(R.id.mRadioButton2);
                } else {
                    loadUrlPost(EDIT, "sesameCredit", mModelInfo.data.sesameCredit, "name", mModelInfo.data.name, "selfCard", mModelInfo.data.selfCard, "sex", mModelInfo.data.sex, "age", mModelInfo.data.age, "city", mModelInfo.data.city, "incomeType", mModelInfo.data.incomeType, "income", mModelInfo.data.income, "companyType", mModelInfo.data.companyType, "companyName", mModelInfo.data.companyName, "workTime", mModelInfo.data.workTime, "housingFund", mModelInfo.data.housingFund, "haveCreditCard", mModelInfo.data.haveCreditCard, "houseProperty", mModelInfo.data.houseProperty, "carProperty", mModelInfo.data.carProperty, "haveHouseLoan", mModelInfo.data.haveHouseLoan, "haveLoan", mModelInfo.data.haveLoan, "socialAccounts", mModelInfo.data.socialAccounts, "eBusinessAccounts", mModelInfo.data.eBusinessAccounts, "contactName", mModelInfo.data.contactName, "contactMobile", mModelInfo.data.contactMobile, "marriage", mModelInfo.data.marriage, "education", mModelInfo.data.education);
                }
            }
        });
    }

    public void loaddata() {
        loadUrlGet(INFO);
        chageFrgment(mFrgWshzl1);
    }

    private void chageFrgment(Fragment fragment) {
        getChildFragmentManager().beginTransaction()
                .replace(R.id.mLinearLayout_content, fragment)
                .commitAllowingStateLoss();
    }

    @Override
    public void onSuccess(String methodName, String content) {
        if (methodName.equals(INFO)) {
            mModelInfo = (ModelInfo) json2Model(content, ModelInfo.class);
            mFrgWshzl1.setModelInfo();
        } else if (methodName.equals(EDIT)) {
            Helper.toast("保存成功", getContext());
            finish();
            F.closeSoftKey(getActivity());
        }
    }

    @Override
    public void setActionBar(ActionBar actionBar, Context context) {
        super.setActionBar(actionBar, context);
        mHeadlayout.setTitle("完善资料");
    }
}