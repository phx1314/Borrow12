package com.system.xmqb.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by DELL on 2017/3/24.
 */

public class ModelBanner implements Serializable {


    /**
     * statusCode : 200
     * message :
     * data : [{"img":"http://api.91tatadai.com:4061/images/banner/2018-10-16/1539689616605.png","flag":0,"dataId":0,"url":"http://papi.musitech8.com/h5/channelReg.html?channelCode=TTJ&pointCode=TTJ&style=2&modelType=1"}]
     */

    public int statusCode;
    public String message;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * img : http://api.91tatadai.com:4061/images/banner/2018-10-16/1539689616605.png
         * flag : 0
         * dataId : 0
         * url : http://papi.musitech8.com/h5/channelReg.html?channelCode=TTJ&pointCode=TTJ&style=2&modelType=1
         */

        public String img;
        public int flag;
        public int dataId;
        public String url;
    }
}
