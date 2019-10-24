//
//  AdaMain
//
//  Created by DELL on 2018-11-07 10:31:33
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.system.xmqb.ada;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.mdx.framework.adapter.MAdapter;
import com.system.xmqb.item.Main;
import com.system.xmqb.model.ModelData;

import java.util.List;

public class AdaMain extends MAdapter<ModelData> {

    public AdaMain(Context context, List<ModelData> list) {
        super(context, list);
    }


    @Override
    public View getview(int position, View convertView, ViewGroup parent) {
        final ModelData item = get(position);
        if (convertView == null) {
            convertView = Main.getView(getContext(), parent);
        }
        Main mMain = (Main) convertView.getTag();
        mMain.set(item);
        return convertView;
    }
}
