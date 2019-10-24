//
//  AdaDialogChoose
//
//  Created by DELL on 2018-12-04 11:04:31
//  Copyright (c) DELL All rights reserved.


/**
   
*/

package com.framewidget.ada;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.framewidget.item.DialogChoose;
import com.mdx.framework.adapter.MAdapter;

import java.util.List;

public class AdaDialogChoose extends MAdapter<String>{

   public AdaDialogChoose(Context context, List<String> list) {
        super(context, list);
    }


 	@Override
    public View getview(int position, View convertView, ViewGroup parent) {
        String item = get(position);
        if (convertView == null) {
            convertView = DialogChoose.getView(getContext(), parent);;
        }
        DialogChoose mDialogChoose=(DialogChoose) convertView.getTag();
//        mDialogChoose.set(item);
        return convertView;
    }
}
