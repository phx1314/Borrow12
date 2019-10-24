//
//  FrgWshzl2
//
//  Created by DELL on 2018-11-14 14:04:05
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.system.xmqb.frg;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.framewidget.view.MListView;
import com.system.xmqb.R;
import com.system.xmqb.ada.AdaEdit;
import com.system.xmqb.model.ModelEdit;

import java.util.ArrayList;
import java.util.List;

import static com.system.xmqb.frg.FrgWshzl.mModelInfo;


public class FrgWshzl2 extends BaseFrg {

    public RadioButton mRadioButton1;
    public RadioButton mRadioButton2;
    public RadioButton mRadioButton3;
    public RadioButton mRadioButton4;
    public RadioButton mRadioButton5;
    public RadioButton mRadioButton6;
    public RadioButton mRadioButton7;
    public MListView mListView;
    public String[] data_1_1 = {"所在城市", "公司类型", "工作单位全称", "工作年限", "工资发放方式", "月收入(元)", "连续半年缴纳公积金", "连续半年缴纳社保", "当前公司入职时间"};
    public String[] data_1_2 = {"所在城市", "入学年份", "学校名称", "在读学历"};
    public String[] data_1_3 = {"所在城市", "企业中个人身份", "企业中的股份", "经营年限", "营业执照时间", "每月对公流水(元)", "每月对私流水(元)"};
    public String[] data_1_4 = {"所在城市", "月收入(元)"};
    public String[] data_2 = {"有无信用卡", "名下房产", "名下车产", "有无房贷", "有无成功贷款记录", "社交账号", "拥有的电商账号"};
    public String[] data_3 = {"婚姻状况", "紧急联系人姓名", "紧急联系人电话"};
    public List<String> dataV_1_1 = new ArrayList<>();
    public List<String> dataV_1_2 = new ArrayList<>();
    public List<String> dataV_1_3 = new ArrayList<>();
    public List<String> dataV_1_4 = new ArrayList<>();
    public List<String> dataV_2 = new ArrayList<>();
    public List<String> dataV_3 = new ArrayList<>();
    public RadioGroup mRadioGroup1;
    public RadioGroup mRadioGroup2;

    @Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.frg_wshzl2);
        initView();
        loaddata();
    }

    private void initView() {
        findVMethod();
    }

    private void findVMethod() {
        mRadioButton1 = (RadioButton) findViewById(R.id.mRadioButton1);
        mRadioButton2 = (RadioButton) findViewById(R.id.mRadioButton2);
        mRadioButton3 = (RadioButton) findViewById(R.id.mRadioButton3);
        mRadioButton4 = (RadioButton) findViewById(R.id.mRadioButton4);
        mRadioButton5 = (RadioButton) findViewById(R.id.mRadioButton5);
        mRadioButton6 = (RadioButton) findViewById(R.id.mRadioButton6);
        mRadioButton7 = (RadioButton) findViewById(R.id.mRadioButton7);
        mListView = (MListView) findViewById(R.id.mListView);
        mRadioGroup1 = (RadioGroup) findViewById(R.id.mRadioGroup1);
        mRadioGroup2 = (RadioGroup) findViewById(R.id.mRadioGroup2);

        mRadioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.mRadioButton1:
                        changeData(data_1_1, dataV_1_1);
                        mRadioGroup2.setVisibility(View.VISIBLE);
                        break;
                    case R.id.mRadioButton2:
                        changeData(data_2, dataV_2);
                        mRadioGroup2.setVisibility(View.GONE);
                        break;
                    case R.id.mRadioButton3:
                        changeData(data_3, dataV_3);
                        mRadioGroup2.setVisibility(View.GONE);
                        break;
                }
            }
        });
        mRadioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.mRadioButton4:
                        changeData(data_1_1, dataV_1_1);
                        break;
                    case R.id.mRadioButton5:
                        changeData(data_1_2,dataV_1_2);
                        break;
                    case R.id.mRadioButton6:
                        changeData(data_1_3,dataV_1_3);
                        break;
                    case R.id.mRadioButton7:
                        changeData(data_1_4, dataV_1_4);
                        break;
                }
            }
        });
    }

    public void changeData(String[] data, List<String> dataV) {
        dataV_1_1.clear();
        dataV_1_2.clear();
        dataV_1_3.clear();
        dataV_1_4.clear();
        dataV_2.clear();
        dataV_3.clear();

        dataV_1_1.add(mModelInfo.data.city);
        dataV_1_1.add(mModelInfo.data.companyType);
        dataV_1_1.add(mModelInfo.data.companyName);
        dataV_1_1.add(mModelInfo.data.workTime);
        dataV_1_1.add(mModelInfo.data.incomeType);
        dataV_1_1.add(mModelInfo.data.income);
        dataV_1_1.add(mModelInfo.data.housingFund);
        dataV_1_1.add(mModelInfo.data.socialSecurity);
        dataV_1_1.add(mModelInfo.data.hireDate);

        dataV_1_2.add(mModelInfo.data.city);
        dataV_1_2.add(mModelInfo.data.enrollmentYear);
        dataV_1_2.add(mModelInfo.data.schoolName);
        dataV_1_2.add(mModelInfo.data.qualification);

        dataV_1_3.add(mModelInfo.data.city);
        dataV_1_3.add(mModelInfo.data.enterpriseIdentity);
        dataV_1_3.add(mModelInfo.data.enterpriseShare);
        dataV_1_3.add(mModelInfo.data.operatingAge);
        dataV_1_3.add(mModelInfo.data.licenseTime);
        dataV_1_3.add(mModelInfo.data.monthPublicFinance);
        dataV_1_3.add(mModelInfo.data.monthPrivateFinance);

        dataV_1_4.add(mModelInfo.data.city);
        dataV_1_4.add(mModelInfo.data.income);

        dataV_2.add(mModelInfo.data.haveCreditCard);
        dataV_2.add(mModelInfo.data.houseProperty);
        dataV_2.add(mModelInfo.data.carProperty);
        dataV_2.add(mModelInfo.data.haveHouseLoan);
        dataV_2.add(mModelInfo.data.haveLoan);
        dataV_2.add(mModelInfo.data.socialAccounts);
        dataV_2.add(mModelInfo.data.eBusinessAccounts);

        dataV_3.add(mModelInfo.data.marriage);
        dataV_3.add(mModelInfo.data.contactName);
        dataV_3.add(mModelInfo.data.contactMobile);


        List<ModelEdit> mModelEdits = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            ModelEdit mModelEdit = new ModelEdit();
            mModelEdit.hint = data[i];
            mModelEdit.text = dataV.get(i);
            mModelEdits.add(mModelEdit);
        }

        mListView.setAdapter(new AdaEdit(getContext(), mModelEdits));
    }



    public void loaddata() {
        changeData(data_1_1, dataV_1_1);
    }

}