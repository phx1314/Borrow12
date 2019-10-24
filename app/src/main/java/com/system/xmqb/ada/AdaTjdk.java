//
//  AdaTjdk
//
//  Created by DELL on 2018-11-07 10:42:31
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.system.xmqb.ada;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.mdx.framework.activity.TitleAct;
import com.mdx.framework.adapter.MAdapter;
import com.mdx.framework.utility.Helper;
import com.system.xmqb.frg.FrgLogin;
import com.system.xmqb.frg.FrgProductDetail;
import com.system.xmqb.item.Tjdk;
import com.system.xmqb.model.ModelMain;

import java.util.List;

import static com.framewidget.F.mModelLogin;

public class AdaTjdk extends MAdapter<ModelMain.DataBean.DataListBean> {

    public AdaTjdk(Context context, List<ModelMain.DataBean.DataListBean> list) {
        super(context, list);
    }


    @Override
    public View getview(int position, View convertView, ViewGroup parent) {
        final ModelMain.DataBean.DataListBean item = get(position);
        if (convertView == null) {
            convertView = Tjdk.getView(getContext(), parent);
        }
        Tjdk mTjdk = (Tjdk) convertView.getTag();
        mTjdk.set(item);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mModelLogin == null) {
                    Helper.startActivity(getContext(), FrgLogin.class, TitleAct.class);
                    return;
                }
                Helper.startActivity(getContext(), FrgProductDetail.class, TitleAct.class, "id", item.id + "");

//                Helper.startActivity(getContext(), FrgPtDetail.class, NoTitleAct.class, "url", item.url, "title", item.name);
            }
        });
        return convertView;
    }
}
