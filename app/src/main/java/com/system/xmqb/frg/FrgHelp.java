//
//  FrgHelp
//
//  Created by DELL on 2018-11-07 13:13:15
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.system.xmqb.frg;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.mdx.framework.utility.Helper;
import com.mdx.framework.utility.permissions.PermissionRequest;
import com.mdx.framework.widget.ActionBar;
import com.system.xmqb.R;

import java.util.List;


public class FrgHelp extends BaseFrg {

    public LinearLayout mLinearLayout_phone;
    public LinearLayout mLinearLayout_qq;

    @Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.frg_help);
        initView();
        loaddata();
    }

    private void initView() {
        findVMethod();
    }

    private void findVMethod() {


        mLinearLayout_phone = (LinearLayout) findViewById(R.id.mLinearLayout_phone);
        mLinearLayout_qq = (LinearLayout) findViewById(R.id.mLinearLayout_qq);
    }

    public void loaddata() {
        mLinearLayout_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Helper.requestPermissions(new String[]{"android.permission.CALL_PHONE", Manifest.permission.WRITE_EXTERNAL_STORAGE}, new PermissionRequest() {
                    public void onGrant(String[] permissions, int[] grantResults) {
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_CALL);
                        Uri data = Uri.parse("tel:0519-83726606");
                        intent.setData(data);
                        startActivity(intent);
                    }
                });
            }
        });
        mLinearLayout_qq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// 跳转之前，可以先判断手机是否安装QQ
                if (isQQClientAvailable(getContext())) {
                    // 跳转到客服的QQ
                    String url = "mqqwpa://im/chat?chat_type=wpa&uin=2957908840";
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    // 跳转前先判断Uri是否存在，如果打开一个不存在的Uri，App可能会崩溃
                    if (isValidIntent(getContext(), intent)) {
                        startActivity(intent);
                    }
                }
            }
        });
    }

    /**
     * 判断 用户是否安装QQ客户端
     */
    public static boolean isQQClientAvailable(Context context) {
        final PackageManager packageManager = context.getPackageManager();
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);
        if (pinfo != null) {
            for (int i = 0; i < pinfo.size(); i++) {
                String pn = pinfo.get(i).packageName;
                if (pn.equalsIgnoreCase("com.tencent.qqlite") || pn.equalsIgnoreCase("com.tencent.mobileqq")) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断 Uri是否有效
     */
    public static boolean isValidIntent(Context context, Intent intent) {
        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(intent, 0);
        return !activities.isEmpty();
    }

    @Override
    public void setActionBar(ActionBar actionBar, Context context) {
        super.setActionBar(actionBar, context);
        mHeadlayout.setTitle("帮助中心");
    }
}