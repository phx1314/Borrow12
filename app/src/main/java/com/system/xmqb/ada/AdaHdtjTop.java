//
//  AdaHdtjTop
//
//  Created by DELL on 2018-11-07 17:21:58
//  Copyright (c) DELL All rights reserved.


/**
   
*/

package com.system.xmqb.ada;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.mdx.framework.adapter.MAdapter;
import com.system.xmqb.item.HdtjTop;

import java.util.List;

public class AdaHdtjTop extends MAdapter<String>{

   public AdaHdtjTop(Context context, List<String> list) {
        super(context, list);
    }


 	@Override
    public View getview(int position, View convertView, ViewGroup parent) {
        String item = get(position);
        if (convertView == null) {
            convertView = HdtjTop.getView(getContext(), parent);;
        }
        HdtjTop mHdtjTop=(HdtjTop) convertView.getTag();
//        mHdtjTop.set(item);
        return convertView;
    }
}
