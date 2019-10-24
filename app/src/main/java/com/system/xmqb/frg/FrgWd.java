//
//  FrgWd
//
//  Created by DELL on 2018-11-07 11:01:32
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.system.xmqb.frg;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.framewidget.F;
import com.framewidget.view.CallBackOnly;
import com.mdx.framework.activity.TitleAct;
import com.mdx.framework.utility.Helper;
import com.system.xmqb.R;
import com.system.xmqb.item.DialogGzh;

import static com.framewidget.F.mModelLogin;


public class FrgWd extends BaseFrg {

    public TextView mTextView_name;
    public TextView mTextView1;
    public TextView mTextView2;
    public TextView mTextView3;
    public TextView mTextView4;
    public TextView mTextView5;
    public TextView mTextView6;
    public com.mdx.framework.widget.MImageView mMImageView;
    public LinearLayout mLinearLayout_gr;


    @Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.frg_wd);
        initView();
        loaddata();
    }

    @Override
    public void disposeMsg(int type, Object obj) {
        switch (type) {
            case 0:
                mMImageView.setObj(com.system.xmqb.F.HOST + mModelLogin.data.headImg);
                mTextView_name.setText(Html.fromHtml("用户名:<br>" + mModelLogin.data.mobile));
                break;
            case 1:
                mTextView_name.setText("立即登录");
                break;
        }
    }

    private void initView() {
        findVMethod();
    }

    private void findVMethod() {
        mTextView_name = (TextView) findViewById(R.id.mTextView_name);
        mTextView1 = (TextView) findViewById(R.id.mTextView1);
        mTextView2 = (TextView) findViewById(R.id.mTextView2);
        mTextView3 = (TextView) findViewById(R.id.mTextView3);
        mTextView4 = (TextView) findViewById(R.id.mTextView4);
        mTextView5 = (TextView) findViewById(R.id.mTextView5);
        mTextView6 = (TextView) findViewById(R.id.mTextView6);
        mMImageView = (com.mdx.framework.widget.MImageView) findViewById(R.id.mMImageView);
        mLinearLayout_gr = (LinearLayout) findViewById(R.id.mLinearLayout_gr);

        mTextView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mModelLogin == null) {
                    Helper.startActivity(getContext(), FrgLogin.class, TitleAct.class);
                    return;
                }
                Helper.startActivity(getContext(), FrgWshzl.class, TitleAct.class);
            }
        });
        mLinearLayout_gr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mModelLogin == null) {
                    Helper.startActivity(getContext(), FrgLogin.class, TitleAct.class);
                    return;
                }
                Helper.startActivity(getContext(), FrgWshzl.class, TitleAct.class);
            }
        });
        mTextView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Helper.startActivity(getContext(), FrgWdjk.class, TitleAct.class);
            }
        });
        mTextView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareText("分享", "http://api.us233.com");
//                Helper.startActivity(getContext(), FrgYqhy.class, TitleAct.class);
            }
        });
        mTextView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mModelLogin == null) {
                    Helper.startActivity(getContext(), FrgLogin.class, TitleAct.class);
                    return;
                }
                Helper.startActivity(getContext(), FrgHelp.class, TitleAct.class);
            }
        });
        mTextView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final View view1 = DialogGzh.getView(getContext(), null);
                F.showCenterDialog(getContext(), view1, new CallBackOnly() {
                    @Override
                    public void goReturnDo(Dialog mDialog) {
                        ((DialogGzh) view1.getTag()).set(mDialog);
                    }
                });
            }
        });
        mTextView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mModelLogin == null) {
                    Helper.startActivity(getContext(), FrgLogin.class, TitleAct.class);
                    return;
                }
                Helper.startActivity(getContext(), FrgSet.class, TitleAct.class);
            }
        });
    }

    public void loaddata() {
        if (mModelLogin != null) {
            mMImageView.setObj(com.system.xmqb.F.HOST + mModelLogin.data.headImg);
            mTextView_name.setText(Html.fromHtml("用户名:<br>" + mModelLogin.data.mobile));
        }
    }

    /**
     * 分享文字内容
     *
     * @param dlgTitle 分享对话框标题
     * @param content  分享内容（文字）
     */
    private void shareText(String dlgTitle, String content) {
        if (content == null || "".equals(content)) {
            return;
        }
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, content);
        // 设置弹出框标题
        if (dlgTitle != null && !"".equals(dlgTitle)) { // 自定义标题
            startActivity(Intent.createChooser(intent, dlgTitle));
        } else { // 系统默认标题
            startActivity(intent);
        }
    }

}