//
//  AdaDialogGzh
//
//  Created by DELL on 2018-11-14 14:57:26
//  Copyright (c) DELL All rights reserved.


/**
   
*/

package com.system.xmqb.ada;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.mdx.framework.adapter.MAdapter;
import com.system.xmqb.item.DialogGzh;

import java.util.List;

public class AdaDialogGzh extends MAdapter<String>{

   public AdaDialogGzh(Context context, List<String> list) {
        super(context, list);
    }


 	@Override
    public View getview(int position, View convertView, ViewGroup parent) {
        String item = get(position);
        if (convertView == null) {
            convertView = DialogGzh.getView(getContext(), parent);;
        }
        DialogGzh mDialogGzh=(DialogGzh) convertView.getTag();
//        mDialogGzh.set(item);
        return convertView;
    }
}
