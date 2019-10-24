//
//  FrgLoading
//
//  Created by DELL on 2018-11-07 08:50:36
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.system.xmqb.frg;

import android.os.Bundle;
import android.os.Handler;
import android.widget.LinearLayout;

import com.mdx.framework.activity.IndexAct;
import com.mdx.framework.utility.Helper;
import com.mdx.framework.widget.MImageView;
import com.system.xmqb.R;


public class FrgLoading extends BaseFrg {

    public LinearLayout activity_main;
    public MImageView mImageView;


    @Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.frg_loading);
        initView();
        loaddata();
    }

    private void initView() {
        findVMethod();
    }

    private void findVMethod() {
        activity_main = (LinearLayout) findViewById(R.id.activity_main);
        mImageView = (MImageView) findViewById(R.id.mImageView);
//        JPushInterface.resumePush(getActivity());
//        Set<String> s = new HashSet<String>();
//        s.add("Borrow");
//        JPushInterface.setAliasAndTags(getActivity(), "Borrow",
//                s,
//                new TagAliasCallback() {
//                    @Override
//                    public void gotResult(int code, String s, Set<String> set) {
//                        FrgLoading.this.finish();
//                        switch (code) {
//                            case 0:
//                                Log.i("JPush", "设置别名成功");
//                                break;
//                            case 6002:
//                                Log.i("JPush", "失败,错误码= " + code);
//                                break;
//                            default:
//                                Log.i("JPush", "失败,错误码= " + code);
//                        }
//                    }
//                });

    }

    public void loaddata() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Helper.startActivity(getContext(), FrgHome.class, IndexAct.class);
            }
        }, 3000);
    }


}