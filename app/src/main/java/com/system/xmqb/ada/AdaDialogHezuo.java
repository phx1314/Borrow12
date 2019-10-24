//
//  AdaDialogHezuo
//
//  Created by DELL on 2018-11-14 14:28:48
//  Copyright (c) DELL All rights reserved.


/**
   
*/

package com.system.xmqb.ada;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.mdx.framework.adapter.MAdapter;
import com.system.xmqb.item.DialogHezuo;

import java.util.List;

public class AdaDialogHezuo extends MAdapter<String>{

   public AdaDialogHezuo(Context context, List<String> list) {
        super(context, list);
    }


 	@Override
    public View getview(int position, View convertView, ViewGroup parent) {
        String item = get(position);
        if (convertView == null) {
            convertView = DialogHezuo.getView(getContext(), parent);;
        }
        DialogHezuo mDialogHezuo=(DialogHezuo) convertView.getTag();
//        mDialogHezuo.set(item);
        return convertView;
    }
}
