//
//  FrgWshzl1
//
//  Created by DELL on 2018-11-14 14:04:05
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.system.xmqb.frg;

import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.framewidget.F;
import com.framewidget.item.DialogChoose;
import com.framewidget.view.CallBackOnly;
import com.system.xmqb.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.system.xmqb.frg.FrgWshzl.mModelInfo;


public class FrgWshzl1 extends BaseFrg {

    public EditText mEditText_1;
    public EditText mEditText_2;
    public TextView mEditText_3;
    public TextView mEditText_4;
    public String data_sex[] = {"男", "女"};
    public List<String> data = new ArrayList<String>();
    public EditText mEditText_zmf;

    @Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.frg_wshzl1);
        initView();
        loaddata();
    }

    @Override
    public void disposeMsg(int type, Object obj) {
        switch (type) {
            case 0:
                mEditText_3.setText(obj.toString());
                mModelInfo.data.sex = mEditText_3.getText().toString();
                break;
            case 1:
                mEditText_4.setText(obj.toString());
                mModelInfo.data.age = mEditText_4.getText().toString();
                break;
            case 2:
                if (obj.toString().equals("男") || obj.toString().equals("女")) {
                    mEditText_3.setText(obj.toString());
                    mModelInfo.data.sex = mEditText_3.getText().toString();
                } else {
                    mEditText_4.setText(obj.toString());
                    mModelInfo.data.age = mEditText_4.getText().toString();
                }
                break;
        }
    }

    private void initView() {
        findVMethod();
    }

    private void findVMethod() {
        mEditText_1 = (EditText) findViewById(R.id.mEditText_1);
        mEditText_2 = (EditText) findViewById(R.id.mEditText_2);
        mEditText_3 = (TextView) findViewById(R.id.mEditText_3);
        mEditText_4 = (TextView) findViewById(R.id.mEditText_4);
        mEditText_zmf = (EditText) findViewById(R.id.mEditText_zmf);
        mEditText_1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mModelInfo.data.name = mEditText_1.getText().toString();
            }
        });
        mEditText_zmf.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mModelInfo.data.sesameCredit = mEditText_zmf.getText().toString();
            }
        });
        mEditText_2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mModelInfo.data.selfCard = mEditText_2.getText().toString();
            }
        });
        mEditText_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final View view = DialogChoose.getView(getContext(), null);
                F.showBottomDialog(getContext(), view, new CallBackOnly() {
                    @Override
                    public void goReturnDo(Dialog mDialog) {
                        ((DialogChoose) view.getTag()).set(mDialog, data_sex, Arrays.asList(data_sex).indexOf(mEditText_3.getText().toString()));
                    }
                });
//                Helper.startActivity(getContext(), FrgList.class, TitleAct.class, "from", "FrgWshzl1", "type", 0, "title", "选择性别", "data", Arrays.asList(data_sex));

            }
        });
        mEditText_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final View view = DialogChoose.getView(getContext(), null);
                F.showBottomDialog(getContext(), view, new CallBackOnly() {
                    @Override
                    public void goReturnDo(Dialog mDialog) {
                        ((DialogChoose) view.getTag()).set(mDialog, (String[]) data.toArray(new String[data.size()]), data.indexOf(mEditText_4.getText().toString()));
                    }
                });
//                Helper.startActivity(getContext(), FrgList.class, TitleAct.class, "from", "FrgWshzl1", "type", 1, "title", "选择年龄", "data", data);
            }
        });

    }

    public void loaddata() {

        for (int i = 18; i < 56; i++) {
            data.add(i + "岁");
        }
    }

    public void setModelInfo() {
        mEditText_1.setText(mModelInfo.data.name);
        mEditText_2.setText(mModelInfo.data.selfCard);
        mEditText_3.setText(mModelInfo.data.sex);
        mEditText_4.setText(mModelInfo.data.age);
        mEditText_zmf.setText(mModelInfo.data.sesameCredit);
    }

}