package com.system.xmqb.model;

import java.io.Serializable;

/**
 * Created by DELL on 2018/1/9.
 */

public class ModelProduct implements Serializable {


    /**
     * statusCode : 200
     * message :
     * data : {"id":538,"img":"http://api.wo65.com//images/other/2018-11-02/1541133180571.png","name":"蟋蟀易贷","supplierId":75,"amount":"500-3000元","applyCount":3584,"monthRate":"0.03%","deadline":"7","auditDesc":"手机号注册，身份证信息填写+芝麻分认证，即可！\r\n","sketch":"最快3分钟审核，最长12小时","conditionDesc":"芝麻分550以上；20-55周岁","description":"最快3分钟审核，最长12小时\r\n","url":"http://easy.hulyfei.cn/ajax/regist?s=zz108","special":2,"createTime":1541133212000,"lastUpdateTime":1541133213000,"supplierName":"泓海网络","flag":1}
     */

    public int statusCode;
    public String message;
    public DataBean data;

    public static class DataBean {
        /**
         * id : 538
         * img : http://api.wo65.com//images/other/2018-11-02/1541133180571.png
         * name : 蟋蟀易贷
         * supplierId : 75
         * amount : 500-3000元
         * applyCount : 3584
         * monthRate : 0.03%
         * deadline : 7
         * auditDesc : 手机号注册，身份证信息填写+芝麻分认证，即可！

         * sketch : 最快3分钟审核，最长12小时
         * conditionDesc : 芝麻分550以上；20-55周岁
         * description : 最快3分钟审核，最长12小时

         * url : http://easy.hulyfei.cn/ajax/regist?s=zz108
         * special : 2
         * createTime : 1541133212000
         * lastUpdateTime : 1541133213000
         * supplierName : 泓海网络
         * flag : 1
         */

        public int id;
        public String img;
        public String name;
        public int supplierId;
        public String amount;
        public int applyCount;
        public String monthRate;
        public String deadline;
        public String auditDesc;
        public String sketch;
        public String conditionDesc;
        public String description;
        public String url;
        public int special;
        public long createTime;
        public long lastUpdateTime;
        public String supplierName;
        public int flag;
    }
}
