//
//  Edit
//
//  Created by DELL on 2018-11-20 11:55:26
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.system.xmqb.item;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.system.xmqb.R;
import com.system.xmqb.model.ModelEdit;

import static com.system.xmqb.frg.FrgWshzl.mModelInfo;


public class Edit extends BaseItem {
    public TextView TextView;
    public EditText mEditText;
    public ModelEdit item;

    @SuppressLint("InflateParams")
    public static View getView(Context context, ViewGroup parent) {
        LayoutInflater flater = LayoutInflater.from(context);
        View convertView = flater.inflate(R.layout.item_edit, null);
        convertView.setTag(new Edit(convertView));
        return convertView;
    }

    public Edit(View view) {
        this.contentview = view;
        this.context = contentview.getContext();
        initView();
    }

    private void initView() {
        this.contentview.setTag(this);
        findVMethod();
    }

    private void findVMethod() {
        TextView = (TextView) contentview.findViewById(R.id.TextView);
        mEditText = (EditText) contentview.findViewById(R.id.mEditText);
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                item.text = mEditText.getText().toString();
                if (item.hint.equals("所在城市")) {
                    mModelInfo.data.city = item.text;
                } else if (item.hint.equals("公司类型")) {
                    mModelInfo.data.companyType = item.text;
                } else if (item.hint.equals("工作单位全称")) {
                    mModelInfo.data.companyName = item.text;
                } else if (item.hint.equals("工作年限")) {
                    mModelInfo.data.workTime = item.text;
                } else if (item.hint.equals("工资发放方式")) {
                    mModelInfo.data.incomeType = item.text;
                } else if (item.hint.equals("月收入(元)")) {
                    mModelInfo.data.income = item.text;
                } else if (item.hint.equals("连续半年缴纳公积金")) {
                    mModelInfo.data.housingFund = item.text;
                } else if (item.hint.equals("连续半年缴纳社保")) {
                    mModelInfo.data.housingFund = item.text;
                } else if (item.hint.equals("当前公司入职时间")) {
                    mModelInfo.data.housingFund = item.text;
                } else if (item.hint.equals("有无信用卡")) {
                    mModelInfo.data.haveCreditCard = item.text;
                } else if (item.hint.equals("名下房产")) {
                    mModelInfo.data.houseProperty = item.text;
                } else if (item.hint.equals("名下车产")) {
                    mModelInfo.data.carProperty = item.text;
                } else if (item.hint.equals("有无房贷")) {
                    mModelInfo.data.haveHouseLoan = item.text;
                } else if (item.hint.equals("有无成功贷款记录")) {
                    mModelInfo.data.haveLoan = item.text;
                } else if (item.hint.equals("社交账号")) {
                    mModelInfo.data.socialAccounts = item.text;
                } else if (item.hint.equals("拥有的电商账号")) {
                    mModelInfo.data.eBusinessAccounts = item.text;
                } else if (item.hint.equals("婚姻状况")) {
                    mModelInfo.data.marriage = item.text;
                } else if (item.hint.equals("紧急联系人姓名")) {
                    mModelInfo.data.contactName = item.text;
                } else if (item.hint.equals("紧急联系人电话")) {
                    mModelInfo.data.contactMobile = item.text;
                }
            }
        });

    }

    public void set(ModelEdit item) {
        this.item = item;
        mEditText.setHint(item.hint);
        mEditText.setText(item.text);
    }


}