//
//  AdaDialogSxLxson
//
//  Created by Administrator on 2018-11-18 18:58:51
//  Copyright (c) Administrator All rights reserved.


/**

 */

package com.system.xmqb.ada;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.mdx.framework.Frame;
import com.mdx.framework.adapter.MAdapter;
import com.system.xmqb.item.DialogSxLxson;
import com.system.xmqb.item.PopShowLx;
import com.system.xmqb.model.ModelLx;

import java.util.List;

public class AdaDialogSxLxson extends MAdapter<ModelLx.DataBean> {
    PopShowLx mPopShowLxl;

    public AdaDialogSxLxson(Context context, List<ModelLx.DataBean> list, PopShowLx mPopShowLxl) {
        super(context, list);
        this.mPopShowLxl = mPopShowLxl;
    }


    @Override
    public View getview(int position, View convertView, ViewGroup parent) {
        final ModelLx.DataBean item = get(position);
        if (convertView == null) {
            convertView = DialogSxLxson.getView(getContext(), parent);
        }
        DialogSxLxson mDialogSxLxson = (DialogSxLxson) convertView.getTag();
        mDialogSxLxson.set(item);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Frame.HANDLES.sentAll("FrgJk", 1, item.id==0?"":item.id);
                Frame.HANDLES.sentAll("FrgJk", 3, item.name);
                mPopShowLxl.hide();
            }
        });
        return convertView;
    }
}
