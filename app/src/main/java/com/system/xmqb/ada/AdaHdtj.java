//
//  AdaHdtj
//
//  Created by DELL on 2018-11-07 16:37:53
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
import com.system.xmqb.item.Hdtj;
import com.system.xmqb.model.ModelXyk;

import java.util.List;

import static com.framewidget.F.mModelLogin;

public class AdaHdtj extends MAdapter<ModelXyk.DataBean> {

    public AdaHdtj(Context context, List<ModelXyk.DataBean> list) {
        super(context, list);
    }


    @Override
    public View getview(int position, View convertView, ViewGroup parent) {
        final ModelXyk.DataBean item = get(position);
        if (convertView == null) {
            convertView = Hdtj.getView(getContext(), parent);
        }
        Hdtj mHdtj = (Hdtj) convertView.getTag();
        mHdtj.set(item);
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
