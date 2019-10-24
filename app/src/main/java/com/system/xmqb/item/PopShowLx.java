package com.system.xmqb.item;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.system.xmqb.R;
import com.system.xmqb.ada.AdaDialogSxLxson;
import com.system.xmqb.model.ModelLx;

public class PopShowLx implements OnClickListener {

    private Context context;
    private ListView mListView;
    private View view;
    private PopupWindow popwindow;
    private View popview;
    private ModelLx mModelLx;

    public PopShowLx(Context context, View view, ModelLx mModelLx
    ) {
        super();
        this.context = context;
        this.view = view;
        this.mModelLx = mModelLx;
        LayoutInflater flater = LayoutInflater.from(this.context);
        popview = flater.inflate(R.layout.item_dialog_sx_lx, null);
        popwindow = new PopupWindow(popview, view.getWidth(),
                LayoutParams.WRAP_CONTENT);
        mListView = (ListView) popview
                .findViewById(R.id.mListView);
        popwindow.setBackgroundDrawable(new BitmapDrawable(context
                .getResources()));
        popwindow.setTouchable(true);
        popwindow.setOutsideTouchable(true);
        popwindow.setFocusable(true);
        mListView.setAdapter(new AdaDialogSxLxson(context, mModelLx.data, this));
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

    }
}
