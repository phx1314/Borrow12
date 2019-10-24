//
//  AdaMainTop
//
//  Created by DELL on 2018-11-22 09:09:25
//  Copyright (c) DELL All rights reserved.


/**
   
*/

package com.system.xmqb.ada;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.mdx.framework.adapter.MAdapter;
import com.system.xmqb.item.MainTop;

import java.util.List;

public class AdaMainTop extends MAdapter<String>{

   public AdaMainTop(Context context, List<String> list) {
        super(context, list);
    }


 	@Override
    public View getview(int position, View convertView, ViewGroup parent) {
        String item = get(position);
        if (convertView == null) {
            convertView = MainTop.getView(getContext(), parent);;
        }
        MainTop mMainTop=(MainTop) convertView.getTag();
//        mMainTop.set(item);
        return convertView;
    }
}
