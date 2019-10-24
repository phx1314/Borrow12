//
//  AdaWshzl2
//
//  Created by DELL on 2018-11-07 16:12:33
//  Copyright (c) DELL All rights reserved.


/**
   
*/

package com.system.xmqb.ada;

import java.util.List;
import com.mdx.framework.adapter.MAdapter;
import android.content.Context;
import android.view.ViewGroup;
import android.view.View;

import com.system.xmqb.item.Wshzl2;

public class AdaWshzl2 extends MAdapter<String>{

   public AdaWshzl2(Context context, List<String> list) {
        super(context, list);
    }


 	@Override
    public View getview(int position, View convertView, ViewGroup parent) {
        String item = get(position);
        if (convertView == null) {
            convertView = Wshzl2.getView(getContext(), parent);;
        }
        Wshzl2 mWshzl2=(Wshzl2) convertView.getTag();
        mWshzl2.set(item);
        return convertView;
    }
}
