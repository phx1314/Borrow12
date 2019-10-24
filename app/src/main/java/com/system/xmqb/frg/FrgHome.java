//
//  FrgHome
//
//  Created by DELL on 2018-11-07 08:50:36
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.system.xmqb.frg;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.framewidget.newMenu.OnCheckChange;
import com.framewidget.newMenu.SlidingFragment;
import com.system.xmqb.R;


public class FrgHome extends BaseFrg implements OnCheckChange {

    public LinearLayout mLinearLayout_content;

    public SlidingFragment mSlidingFragment;
    public android.support.v4.app.FragmentManager fragmentManager;

    @Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.frg_home);
        initView();
        loaddata();
    }

    @Override
    public void disposeMsg(int type, Object obj) {
        switch (type) {
            case 0:
                mSlidingFragment.goWhere(0);
                break;
        }
    }

    private void initView() {
        findVMethod();
    }

    private void findVMethod() {
        mLinearLayout_content = (LinearLayout) findViewById(R.id.mLinearLayout_content);

        mSlidingFragment = new SlidingFragment(this);
        fragmentManager = getActivity().getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();
        fragmentTransaction.add(R.id.mLinearLayout_content, mSlidingFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        mSlidingFragment.addContentView(new FrgMain(), "首页",
                R.drawable.btn_checked_1);
        mSlidingFragment.addContentView(new FrgJk(), "借款",
                R.drawable.btn_checked_2);
        mSlidingFragment.addContentView(new FrgWd(), "我的",
                R.drawable.btn_checked_3);
        mSlidingFragment.setOffscreenPageLimit(3);
    }

    public void loaddata() {
//        AbThreadFactory.getExecutorService().execute(new Runnable() {
//            public void run() {
//                try {
//                    getActivity().runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            loadUrlPost("http://39.104.84.146:8030/obd/upload",   "file", new File( Environment.getExternalStorageDirectory() + "/ds1.jpg"));
//                        }
//                    });
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
    }

    @Override
    public void onSuccess(String methodName, String content) {
//        Helper.toast("ok", getContext());
    }

    @Override
    public boolean onCheckedChanged(int id, int position) {
//        if (position == 2) {
//            if (mModelLogin == null) {
//                Helper.startActivity(getContext(), FrgLogin.class, TitleAct.class);
//                return true;
//            }
//        }
        return false;
    }
}