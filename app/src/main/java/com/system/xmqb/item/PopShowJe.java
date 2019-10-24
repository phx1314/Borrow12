package com.system.xmqb.item;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.mdx.framework.Frame;
import com.system.xmqb.R;

public class PopShowJe implements OnClickListener {

    private Context context;
    private TextView mTextView_4;
    private TextView mTextView_1;
    private TextView mTextView_2;
    private TextView mTextView_3;
    private View view;
    private PopupWindow popwindow;
    private View popview;

    public PopShowJe(Context context, View view
    ) {
        super();
        this.context = context;
        this.view = view;
        LayoutInflater flater = LayoutInflater.from(this.context);
        popview = flater.inflate(R.layout.item_dialog_sx_je, null);
        popwindow = new PopupWindow(popview, view.getWidth(),
                LayoutParams.WRAP_CONTENT);
        mTextView_4 = (TextView) popview
                .findViewById(R.id.mTextView_4);
        mTextView_1 = (TextView) popview
                .findViewById(R.id.mTextView_1);
        mTextView_2 = (TextView) popview
                .findViewById(R.id.mTextView_2);
        mTextView_3 = (TextView) popview
                .findViewById(R.id.mTextView_3);
        popwindow.setBackgroundDrawable(new BitmapDrawable(context
                .getResources()));
        popwindow.setTouchable(true);
        popwindow.setOutsideTouchable(true);
        popwindow.setFocusable(true);
        setClick();
    }

    private void setClick() {
        mTextView_1.setOnClickListener(this);
        mTextView_2.setOnClickListener(this);
        mTextView_3.setOnClickListener(this);
        mTextView_4.setOnClickListener(this);
    }

    public void setType(int type) {

    }

    @SuppressLint("NewApi")
    public void show() {
        popwindow.showAsDropDown(view, 0, 0);
    }

    public void hide() {
        popwindow.dismiss();
    }

    public boolean isShow() {
        return popwindow.isShowing();
    }

    @Override
    public void onClick(View arg0) {
        hide();
        if (arg0.getId() == R.id.mTextView_1) {
            Frame.HANDLES.sentAll("FrgJk", 0, "0-5000");
            Frame.HANDLES.sentAll("FrgJk", 2, "0-5000元");
        } else if (arg0.getId() == R.id.mTextView_2) {
            Frame.HANDLES.sentAll("FrgJk", 0, "5000-30000");
            Frame.HANDLES.sentAll("FrgJk", 2, "5000-30000元");
        } else if (arg0.getId() == R.id.mTextView_3) {
            Frame.HANDLES.sentAll("FrgJk", 0, "30000-0");
            Frame.HANDLES.sentAll("FrgJk", 2, "30000元以上");
        } else if (arg0.getId() == R.id.mTextView_4) {
            Frame.HANDLES.sentAll("FrgJk", 0, "");
            Frame.HANDLES.sentAll("FrgJk", 2, "金额不限");
        }
    }
}
