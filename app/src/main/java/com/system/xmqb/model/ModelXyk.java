package com.system.xmqb.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by DELL on 2017/3/24.
 */

public class ModelXyk implements Serializable{


    /**
     * statusCode : 200
     * message :
     * data : [{"id":1,"img":"other/2018-11-21/1542762327605.png","name":"江南银行测试信用卡","rank":0,"supplierId":75,"cdRecommend":1,"sketch":"测试专用","applyCount":12,"url":"http://api.wo65.com","deleted":0,"createTime":"2018-11-21 09:05:28","lastUpdateTime":"2018-11-21 09:05:28","supplierName":null,"categoryId":null,"fromPageName":null,"fromCategoryId":null,"tagId":null,"pvCount":null,"uvCount":null,"tagList":[],"categoryList":[],"startDate":null,"endDate":null,"tagStr":""}]
     */

    public int statusCode;
    public String message;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * id : 1
         * img : other/2018-11-21/1542762327605.png
         * name : 江南银行测试信用卡
         * rank : 0
         * supplierId : 75
         * cdRecommend : 1
         * sketch : 测试专用
         * applyCount : 12
         * url : http://api.wo65.com
         * deleted : 0
         * createTime : 2018-11-21 09:05:28
         * lastUpdateTime : 2018-11-21 09:05:28
         * supplierName : null
         * categoryId : null
         * fromPageName : null
         * fromCategoryId : null
         * tagId : null
         * pvCount : null
         * uvCount : null
         * tagList : []
         * categoryList : []
         * startDate : null
         * endDate : null
         * tagStr :
         */

        public int id;
        public String img;
        public String name;
        public int rank;
        public int supplierId;
        public int cdRecommend;
        public String sketch;
        public int applyCount;
        public String url;
        public int deleted;
        public String createTime;
        public String lastUpdateTime;
        public Object supplierName;
        public Object categoryId;
        public Object fromPageName;
        public Object fromCategoryId;
        public Object tagId;
        public Object pvCount;
        public Object uvCount;
        public Object startDate;
        public Object endDate;
        public String tagStr;
        public List<?> tagList;
        public List<?> categoryList;
    }
}
