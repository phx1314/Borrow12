//
//  AdaMainBottom
//
//  Created by DELL on 2018-11-22 09:09:25
//  Copyright (c) DELL All rights reserved.


/**
   
*/

package com.system.xmqb.ada;

import java.util.List;
import com.mdx.framework.adapter.MAdapter;
import android.content.Context;
import android.view.ViewGroup;
import android.view.View;

import com.system.xmqb.item.MainBottom;

public class AdaMainBottom extends MAdapter<String>{

   public AdaMainBottom(Context context, List<String> list) {
        super(context, list);
    }


 	@Override
    public View getview(int position, View convertView, ViewGroup parent) {
        String item = get(position);
        if (convertView == null) {
            convertView = MainBottom.getView(getContext(), parent);;
        }
        MainBottom mMainBottom=(MainBottom) convertView.getTag();
        mMainBottom.set(item);
        return convertView;
    }
}
