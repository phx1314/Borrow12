//
//  FrgXgmm
//
//  Created by DELL on 2018-11-14 14:36:22
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.system.xmqb.frg;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.mdx.framework.utility.Helper;
import com.mdx.framework.widget.ActionBar;
import com.system.xmqb.R;

import static com.system.xmqb.F.RESET;
import static com.system.xmqb.F.SEND_CODE;


public class FrgXgmm extends BaseFrg {

    public EditText mEditText_1;
    public EditText mEditText_2;
    public TextView mTextView_fs;
    public EditText mEditText_3;
    public EditText mEditText_4;
    public TextView mImageView_dl;
    private int times = 60;
    private Handler handler;
    private Runnable runnable;

    @Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.frg_xgmm);
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
        mEditText_4 = (EditText) findViewById(R.id.mEditText_4);
        mImageView_dl = (TextView) findViewById(R.id.mImageView_dl);
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
                loadUrlPost(SEND_CODE, "mobile", mEditText_1.getText().toString(), "type", "3");
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
                    Helper.toast("请输入新密码", getContext());
                    return;
                }
                if (!mEditText_3.getText().toString().equals(mEditText_4.getText().toString())) {
                    Helper.toast("两次密码输入不一致", getContext());
                    return;
                }
                loadUrlPost(RESET, "mobile", mEditText_1.getText().toString(), "code", mEditText_2.getText().toString(), "password", mEditText_3.getText().toString());
            }
        });

    }

    public void loaddata() {

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
        if (methodName.equals(RESET)) {
            Helper.toast("修改成功", getContext());
            finish();
        } else if (methodName.equals(SEND_CODE)) {
            Helper.toast("短信已发送,请注意查收", getContext());
            times = 60;
            doTimer();
        }
    }

    @Override
    public void setActionBar(ActionBar actionBar, Context context) {
        super.setActionBar(actionBar, context);
        mHeadlayout.setTitle("修改密码");
    }
}