//
//  FrgZc
//
//  Created by DELL on 2018-11-07 11:57:43
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.system.xmqb.frg;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.framewidget.frg.FrgPtDetail;
import com.mdx.framework.activity.NoTitleAct;
import com.mdx.framework.utility.Helper;
import com.mdx.framework.widget.ActionBar;
import com.system.xmqb.R;

import static com.system.xmqb.F.REGISTER;
import static com.system.xmqb.F.RESET;
import static com.system.xmqb.F.SEND_CODE;


public class FrgZc extends BaseFrg {

    public EditText mEditText_1;
    public EditText mEditText_2;
    public TextView mTextView_fs;
    public EditText mEditText_3;
    public CheckBox mCheckBox;
    public TextView mTextView_xy;
    public TextView mImageView_dl;
    public int type;
    public LinearLayout mLinearLayout_xy;
    private int times = 60;
    private Handler handler;
    private Runnable runnable;

    @Override
    protected void create(Bundle savedInstanceState) {
        type = getActivity().getIntent().getIntExtra("type", 0);
        setContentView(R.layout.frg_zc);
        initView();
        loaddata();
    }

    private void initView() {
        findVMethod();
    }

    private void findVMethod() {
        mEditText_1 = (EditText) findViewById(R.id.mEditText_1);
        mEditText_2 = (EditText) findViewById(R.id.mEditText_2);
        mTextView_fs = (TextView) findViewById(R.id.mTextView_fs);
        mEditText_3 = (EditText) findViewById(R.id.mEditText_3);
        mCheckBox = (CheckBox) findViewById(R.id.mCheckBox);
        mTextView_xy = (TextView) findViewById(R.id.mTextView_xy);
        mImageView_dl = (TextView) findViewById(R.id.mImageView_dl);
        mLinearLayout_xy = (LinearLayout) findViewById(R.id.mLinearLayout_xy);
        mTextView_fs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(mEditText_1.getText().toString())) {
                    Helper.toast("请输入手机号", getContext());
                    return;
                }
                if (mEditText_1.getText().toString().length() != 11) {
                    Helper.toast("请输入正确的手机号", getContext());
                    return;
                }
                loadUrlPost(SEND_CODE, "mobile", mEditText_1.getText().toString(), "type", type == 0 ? "1" : "3");
            }
        });
        mImageView_dl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(mEditText_1.getText().toString())) {
                    Helper.toast("请输入手机号", getContext());
                    return;
                }
                if (TextUtils.isEmpty(mEditText_2.getText().toString())) {
                    Helper.toast("请输入验证码", getContext());
                    return;
                }
                if (TextUtils.isEmpty(mEditText_3.getText().toString())) {
                    Helper.toast("请输入密码", getContext());
                    return;
                }
                if (type == 0) {
                    loadUrlPost(REGISTER, "mobile", mEditText_1.getText().toString(), "code", mEditText_2.getText().toString(), "password", mEditText_3.getText().toString());
                } else {
                    loadUrlPost(RESET, "mobile", mEditText_1.getText().toString(), "code", mEditText_2.getText().toString(), "password", mEditText_3.getText().toString());
                }
            }
        });
        mTextView_xy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Helper.startActivity(getContext(), FrgPtDetail.class, NoTitleAct.class, "url", "http://h5.wo65.com/pages.html?type=1", "title", "注册协议");
//                Helper.startActivity(getContext(), FrgXy.class, TitleAct.class);
            }
        });
    }

    private void doTimer() {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                if (times > 0) {
                    times--;
                    mTextView_fs.setText(times + "s");
                    mTextView_fs.setClickable(false);
                    handler.postDelayed(runnable, 1000);
                } else if (times == 0) {
                    mTextView_fs.setClickable(true);
                    mTextView_fs.setText("发送验证码");
                }
            }
        };
        handler.post(runnable);
    }

    @Override
    public void onSuccess(String methodName, String content) {
        if (methodName.equals(REGISTER)) {
            Helper.toast("注册成功", getContext());
            finish();
            com.framewidget.F.closeSoftKey(getActivity());
        } else if (methodName.equals(RESET)) {
            Helper.toast("设置成功", getContext());
            finish();
        } else if (methodName.equals(SEND_CODE)) {
            Helper.toast("短信已发送,请注意查收", getContext());
            times = 60;
            doTimer();
        }
    }

    public void loaddata() {

    }

    @Override
    public void setActionBar(ActionBar actionBar, Context context) {
        super.setActionBar(actionBar, context);
        mHeadlayout.setTitle(type == 0 ? "注册" : "忘记密码");
    }
}