package com.system.xmqb.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by DELL on 2017/3/24.
 */

public class ModelKa implements Serializable {


    /**
     * statusCode : 200
     * message :
     * data : [{"id":2086,"img":"other/2018-11-20/1542689203351.jpg","name":"大额卡","value":"大额卡","typeName":"credit_card_category","parentId":null,"description":null,"bgImg":null,"recommend":null,"showIndex":1,"cdRecommend":null,"showQuickLoan":null,"createTime":"2018-11-20 12:46:43","lastUpdateTime":null}]
     */

    public int statusCode;
    public String message;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * id : 2086
         * img : other/2018-11-20/1542689203351.jpg
         * name : 大额卡
         * value : 大额卡
         * typeName : credit_card_category
         * parentId : null
         * description : null
         * bgImg : null
         * recommend : null
         * showIndex : 1
         * cdRecommend : null
         * showQuickLoan : null
         * createTime : 2018-11-20 12:46:43
         * lastUpdateTime : null
         */

        public int id;
        public String img;
        public String name;
        public String value;
        public String typeName;
        public Object parentId;
        public String description;
        public Object bgImg;
        public Object recommend;
        public int showIndex;
        public Object cdRecommend;
        public Object showQuickLoan;
        public String createTime;
        public Object lastUpdateTime;
    }
}
