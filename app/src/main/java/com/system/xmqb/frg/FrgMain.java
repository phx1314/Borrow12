//
//  FrgMain
//
//  Created by DELL on 2018-11-07 09:41:50
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.system.xmqb.frg;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.system.xmqb.R;
import com.system.xmqb.ada.AdaMain;
import com.system.xmqb.item.MainBottom;
import com.system.xmqb.item.MainTop;
import com.system.xmqb.model.ModelBanner;
import com.system.xmqb.model.ModelData;
import com.system.xmqb.model.ModelFlipper;
import com.system.xmqb.model.ModelMainMore;

import java.util.ArrayList;
import java.util.List;

import static com.system.xmqb.F.BANNER;
import static com.system.xmqb.F.HOME_CHANGE;
import static com.system.xmqb.F.SUCCESS_LOAN;
import static com.system.xmqb.F.json2Model;


public class FrgMain extends BaseFrg {

    public ListView mMListView;
    public View view_top;
    public View view_bottom;

    @Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.frg_main);
        initView();
        loaddata();
    }

    @Override
    public void disposeMsg(int type, Object obj) {
        switch (type) {
            case 0:
                loadUrlGet(HOME_CHANGE);
                break;
        }
    }

    private void initView() {
        findVMethod();
    }

    private void findVMethod() {
        mMListView = (ListView) findViewById(R.id.mMListView);
        view_top = MainTop.getView(getContext(), null);
        view_bottom = MainBottom.getView(getContext(), null);
        mMListView.addHeaderView(view_top);
        mMListView.addFooterView(view_bottom);

    }

    public void loaddata() {
        loadUrlGet(BANNER, "position", "1");
        loadUrlGet(SUCCESS_LOAN);
        loadUrlGet(HOME_CHANGE);
    }

    @Override
    public void onSuccess(String methodName, String content) {
        if (methodName.equals(BANNER)) {
            ModelBanner mModelBanner = (ModelBanner) json2Model(content, ModelBanner.class);
            ((MainTop) view_top.getTag()).set(mModelBanner);
        } else if (methodName.equals(SUCCESS_LOAN)) {
            ModelFlipper mModelFlipper = (ModelFlipper) json2Model(content, ModelFlipper.class);
            ((MainTop) view_top.getTag()).set(mModelFlipper);
        } else if (methodName.equals(HOME_CHANGE)) {
            ModelMainMore mModelMain = (ModelMainMore) json2Model(content, ModelMainMore.class);
            List data = new ArrayList();
            for (int i = 0; i < mModelMain.data.size(); i++) {
                if (i % 2 == 0) {
                    ModelData mModelData = new ModelData();
                    for (int j = i; j < Math.min(mModelMain.data.size(), i + 2); j++) {
                        mModelData.mList.add(mModelMain.data.get(j));
                    }
                    data.add(mModelData);
                }
            }
            mMListView.setAdapter(new AdaMain(getContext(), data));
        }
    }
}