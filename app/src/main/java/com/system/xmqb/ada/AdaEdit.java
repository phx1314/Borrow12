//
//  AdaEdit
//
//  Created by DELL on 2018-11-20 11:55:26
//  Copyright (c) DELL All rights reserved.


/**
   
*/

package com.system.xmqb.ada;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.mdx.framework.adapter.MAdapter;
import com.system.xmqb.item.Edit;
import com.system.xmqb.model.ModelEdit;

import java.util.List;

public class AdaEdit extends MAdapter<ModelEdit>{

   public AdaEdit(Context context, List<ModelEdit> list) {
        super(context, list);
    }


 	@Override
    public View getview(int position, View convertView, ViewGroup parent) {
        ModelEdit item = get(position);
        if (convertView == null) {
            convertView = Edit.getView(getContext(), parent);;
        }
        Edit mEdit=(Edit) convertView.getTag();
        mEdit.set(item);
        return convertView;
    }
}
