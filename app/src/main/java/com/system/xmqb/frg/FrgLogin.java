//
//  FrgLogin
//
//  Created by DELL on 2018-11-07 14:21:59
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.system.xmqb.frg;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.framewidget.model.ModelLogin;
import com.mdx.framework.Frame;
import com.mdx.framework.activity.TitleAct;
import com.mdx.framework.utility.Helper;
import com.mdx.framework.widget.ActionBar;
import com.system.xmqb.F;
import com.system.xmqb.R;

import static com.framewidget.F.mModelLogin;
import static com.system.xmqb.F.LOGIN;
import static com.system.xmqb.F.SEND_CODE;
import static com.system.xmqb.F.json2Model;


public class FrgLogin extends BaseFrg {

    public LinearLayout mLinearLayout_1;
    public TextView mTextView_1;
    public ImageView mImageView_1;
    public LinearLayout mLinearLayout_2;
    public TextView mTextView_2;
    public ImageView mImageView_2;
    public LinearLayout mLinearLayout_left;
    public EditText mEditText_1;
    public EditText mEditText_2;
    public TextView mTextView_fs;
    public TextView mImageView_dl;
    public TextView mTextView_zc;
    public LinearLayout mLinearLayout_right;
    public EditText mEditText_phone;
    public EditText mEditText_mm;
    public ImageView mImageView_kan;
    public int type;
    private int times = 60;
    private Handler handler;
    private Runnable runnable;
    private boolean isChecked = true;

    @Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.frg_login);
        initView();
        loaddata();
    }

    private void initView() {
        findVMethod();
    }

    private void findVMethod() {
        mLinearLayout_1 = (LinearLayout) findViewById(R.id.mLinearLayout_1);
        mTextView_1 = (TextView) findViewById(R.id.mTextView_1);
        mImageView_1 = (ImageView) findViewById(R.id.mImageView_1);
        mLinearLayout_2 = (LinearLayout) findViewById(R.id.mLinearLayout_2);
        mTextView_2 = (TextView) findViewById(R.id.mTextView_2);
        mImageView_2 = (ImageView) findViewById(R.id.mImageView_2);
        mLinearLayout_left = (LinearLayout) findViewById(R.id.mLinearLayout_left);
        mEditText_1 = (EditText) findViewById(R.id.mEditText_1);
        mEditText_2 = (EditText) findViewById(R.id.mEditText_2);
        mTextView_fs = (TextView) findViewById(R.id.mTextView_fs);
        mImageView_dl = (TextView) findViewById(R.id.mImageView_dl);
        mTextView_zc = (TextView) findViewById(R.id.mTextView_zc);
        mLinearLayout_right = (LinearLayout) findViewById(R.id.mLinearLayout_right);
        mEditText_phone = (EditText) findViewById(R.id.mEditText_phone);
        mEditText_mm = (EditText) findViewById(R.id.mEditText_mm);
        mImageView_kan = (ImageView) findViewById(R.id.mImageView_kan);
        mImageView_kan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isChecked) {
                    //如果选中，显示密码
                    mEditText_mm.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    mImageView_kan.setImageResource(R.drawable.mima2);
                } else {
                    //否则隐藏密码
                    mEditText_mm.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    mImageView_kan.setImageResource(R.drawable.mima1);
                }
                mEditText_mm.setSelection(mEditText_mm.length());
                isChecked = !isChecked;
            }
        });
        mTextView_zc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Helper.startActivity(getContext(), FrgZc.class, TitleAct.class, "type", type);
            }
        });
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
                loadUrlPost(SEND_CODE, "mobile", mEditText_1.getText().toString(), "type", "2");
            }
        });

        mLinearLayout_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type = 0;
                mTextView_1.setTextColor(getResources().getColor(R.color.A));
                mTextView_2.setTextColor(getResources().getColor(R.color.black));
                mImageView_1.setVisibility(View.VISIBLE);
                mLinearLayout_left.setVisibility(View.VISIBLE);
                mLinearLayout_right.setVisibility(View.GONE);
                mImageView_2.setVisibility(View.INVISIBLE);
                mTextView_zc.setText("注册");
            }
        });
        mLinearLayout_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type = 1;
                mTextView_1.setTextColor(getResources().getColor(R.color.black));
                mTextView_2.setTextColor(getResources().getColor(R.color.A));
                mImageView_1.setVisibility(View.INVISIBLE);
                mImageView_2.setVisibility(View.VISIBLE);
                mLinearLayout_left.setVisibility(View.GONE);
                mLinearLayout_right.setVisibility(View.VISIBLE);
                mTextView_zc.setText("忘记密码");
            }
        });
        mImageView_dl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (type == 0) {
                    if (TextUtils.isEmpty(mEditText_1.getText().toString())) {
                        Helper.toast("请输入手机号", getContext());
                        return;
                    }
                    if (TextUtils.isEmpty(mEditText_2.getText().toString())) {
                        Helper.toast("请输入验证码", getContext());
                        return;
                    }
                    loadUrlPost(LOGIN, "mobile", mEditText_1.getText().toString(), "code", mEditText_2.getText().toString());
                } else {
                    if (TextUtils.isEmpty(mEditText_phone.getText().toString())) {
                        Helper.toast("请输入账号", getContext());
                        return;
                    }
                    if (TextUtils.isEmpty(mEditText_mm.getText().toString())) {
                        Helper.toast("请输入密码", getContext());
                        return;
                    }
                    loadUrlPost(LOGIN, "mobile", mEditText_phone.getText().toString(), "password", mEditText_mm.getText().toString());
                }
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
        if (methodName.equals(LOGIN)) {
            Helper.toast("登录成功", getContext());
            mModelLogin = (ModelLogin) json2Model(content, ModelLogin.class);
            F.saveJson("mModelLogin", content);
            Frame.HANDLES.sentAll("FrgWd", 0, null);
            finish();
            com.framewidget.F.closeSoftKey(getActivity());
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
        mHeadlayout.setTitle("登录");
    }
}