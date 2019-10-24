//
//  FrgHdtj
//
//  Created by DELL on 2018-11-07 16:22:41
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.system.xmqb.frg;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.ab.view.pullview.AbPullListView;
import com.mdx.framework.widget.ActionBar;
import com.system.xmqb.R;
import com.system.xmqb.ada.AdaHdtj;
import com.system.xmqb.item.HdtjTop;
import com.system.xmqb.model.ModelXyk;

import java.util.ArrayList;

import static com.system.xmqb.F.HOTLIST;


public class FrgHdtj extends BaseFrg {

    public AbPullListView mAbPullListView;
    public View view_top;


    @Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.frg_hdtj);
        initView();
        loaddata();
    }

    private void initView() {
        findVMethod();
    }

    private void findVMethod() {
        mAbPullListView = (AbPullListView) findViewById(R.id.mAbPullListView);

        view_top = HdtjTop.getView(getContext(), null);
        mAbPullListView.addHeaderView(view_top);
    }

    public void loaddata() {
        mAbPullListView.setGetApiLoadParams(HOTLIST);
        mAbPullListView.setPageSize(Integer.MAX_VALUE);
        ((HdtjTop) view_top.getTag()).set();
        mAbPullListView.setAdapter(new AdaHdtj(getContext(), new ArrayList<ModelXyk.DataBean>()));
//        mAbPullListView.setAbOnListViewListener(new AbOnListViewListener() {
//            @Override
//            public MAdapter onSuccess(String methodName, String content) {
//                ((HdtjTop)view_top.getTag()).set();
//                ModelXyk mModelXyk = new Gson().fromJson(content, ModelXyk.class);
//                return new AdaHdtj(getContext(), mModelXyk.data);
//            }
//        });
    }


    @Override
    public void setActionBar(ActionBar actionBar, Context context) {
        super.setActionBar(actionBar, context);
        mHeadlayout.setTitle("活动推荐");
    }
}