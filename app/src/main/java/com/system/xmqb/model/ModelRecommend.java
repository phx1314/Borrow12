package com.system.xmqb.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by DELL on 2017/3/24.
 */

public class ModelRecommend implements Serializable {


    /**
     * statusCode : 200
     * message :
     * data : [{"amountStart":1000,"name":"小木鱼","id":560,"sketch":"最高额度30000元 一键申请   极速审批 门槛低、无抵押、无担保 小木鱼，救你所急。","amountEnd":30000},{"amountStart":800,"name":"惠普钱包","id":580,"sketch":"芝麻分570分以上，秒下款","amountEnd":10000}]
     */

    public int statusCode;
    public String message;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * amountStart : 1000
         * name : 小木鱼
         * id : 560
         * sketch : 最高额度30000元 一键申请   极速审批 门槛低、无抵押、无担保 小木鱼，救你所急。
         * amountEnd : 30000
         */

        public int amountStart;
        public String name;
        public int id;
        public String sketch;
        public int amountEnd;
    }
}
