//
//  AdaDialogSq
//
//  Created by DELL on 2018-11-14 15:23:05
//  Copyright (c) DELL All rights reserved.


/**
   
*/

package com.system.xmqb.ada;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.mdx.framework.adapter.MAdapter;
import com.system.xmqb.item.DialogSq;

import java.util.List;

public class AdaDialogSq extends MAdapter<String>{

   public AdaDialogSq(Context context, List<String> list) {
        super(context, list);
    }


 	@Override
    public View getview(int position, View convertView, ViewGroup parent) {
        String item = get(position);
        if (convertView == null) {
            convertView = DialogSq.getView(getContext(), parent);;
        }
        DialogSq mDialogSq=(DialogSq) convertView.getTag();
//        mDialogSq.set(item);
        return convertView;
    }
}
