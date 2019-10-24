package com.system.xmqb.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by DELL on 2017/3/24.
 */

public class ModelTjGood implements Serializable{


    /**
     * statusCode : 200
     * message :
     * data : [{"id":2073,"name":"最新推荐","flag":1,"bannerDTO":{"img":"","flag":0,"dataId":0,"url":""},"dataList":[{"id":526,"img":"/images/other/2018-10-24/1540370148820.jpg","name":"新网牛","applyCount":1896,"monthRate":"免息","tag":"额度1000，超低门槛，最快3分钟下款","amount":"1000-6000元","special":2,"url":"https://wn.51haoping.com/h5/register.html?code=wdm","flag":1,"currentCategoryId":2073,"currentTagId":0,"open":false}]},{"id":2074,"name":"大额贷款","flag":1,"bannerDTO":{"img":"","flag":0,"dataId":0,"url":""},"dataList":[]},{"id":2075,"name":"热门口子","flag":1,"bannerDTO":{"img":"","flag":0,"dataId":0,"url":""},"dataList":[]}]
     */

    public int statusCode;
    public String message;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * id : 2073
         * name : 最新推荐
         * flag : 1
         * bannerDTO : {"img":"","flag":0,"dataId":0,"url":""}
         * dataList : [{"id":526,"img":"/images/other/2018-10-24/1540370148820.jpg","name":"新网牛","applyCount":1896,"monthRate":"免息","tag":"额度1000，超低门槛，最快3分钟下款","amount":"1000-6000元","special":2,"url":"https://wn.51haoping.com/h5/register.html?code=wdm","flag":1,"currentCategoryId":2073,"currentTagId":0,"open":false}]
         */

        public int id;
        public String name;
        public int flag;
        public BannerDTOBean bannerDTO;
        public List<ModelMain.DataBean.DataListBean> dataList;

        public static class BannerDTOBean {
            /**
             * img :
             * flag : 0
             * dataId : 0
             * url :
             */

            public String img;
            public int flag;
            public int dataId;
            public String url;
        }


    }
}
