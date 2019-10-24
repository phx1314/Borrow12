//
//  AdaBanner
//
//  Created by DELL on 2018-11-13 09:13:31
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.system.xmqb.ada;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.framewidget.frg.FrgPtDetail;
import com.mdx.framework.activity.NoTitleAct;
import com.mdx.framework.adapter.MAdapter;
import com.mdx.framework.utility.Helper;
import com.system.xmqb.item.Banner;
import com.system.xmqb.model.ModelBanner;

import java.util.List;

public class AdaBanner extends MAdapter<ModelBanner.DataBean> {

    public AdaBanner(Context context, List<ModelBanner.DataBean> list) {
        super(context, list);
    }


    @Override
    public View getview(int position, View convertView, ViewGroup parent) {
        final ModelBanner.DataBean item = get(position);
        if (convertView == null) {
            convertView = Banner.getView(getContext(), parent);
        }
        Banner mBanner = (Banner) convertView.getTag();
        mBanner.set(item);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Helper.startActivity(getContext(), FrgPtDetail.class, NoTitleAct.class, "url", item.url, "title", "活动");
            }
        });
        return convertView;
    }
}
