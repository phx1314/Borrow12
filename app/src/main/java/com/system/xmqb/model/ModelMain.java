package com.system.xmqb.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by DELL on 2017/3/24.
 */

public class ModelMain implements Serializable{


    /**
     * statusCode : 200
     * message :
     * data : [{"id":2076,"name":"为您推荐","flag":1,"bannerDTO":{"img":"","flag":0,"dataId":0,"url":""},"dataList":[{"id":746,"img":"http://api.91tatadai.com:4061/images/other/2018-10-08/1538985487296.png","name":"闪到","applyCount":640521,"monthRate":"0.72%","tag":" 3分钟审批30秒下款","amount":"1000-1万元","special":1,"url":"http://papi.musitech8.com/h5/channelReg.html?channelCode=TTJ&pointCode=TTJ&style=2&modelType=1","flag":1,"currentCategoryId":2076,"currentTagId":0,"open":true},{"id":873,"img":"http://api.91tatadai.com:4061/images/other/2018-11-02/1541155154558.png","name":"易融花","applyCount":550814,"monthRate":"0.67%","tag":"纯信用，下款快","amount":"1000-1500元","special":1,"url":"http://share.yironghua.cn/?channelName=he03","flag":1,"currentCategoryId":2076,"currentTagId":0,"open":true},{"id":684,"img":"http://api.91tatadai.com:4061/images/other/2018-08-09/1533805769194.png","name":"7秒贷","applyCount":354410,"monthRate":"0.68%","tag":"超低门槛，十分钟借到2000元","amount":"500-1万元","special":1,"url":"https://7md.yihuabao.cn/qmd_wap/index.php/Login/index?channel=tatajie","flag":1,"currentCategoryId":2076,"currentTagId":0,"open":true},{"id":847,"img":"http://api.91tatadai.com:4061/images/other/2018-10-25/1540457975745.png","name":"大额贷款","applyCount":813625,"monthRate":"0.4%","tag":"0服务费，门槛低","amount":"500-5万元","special":1,"url":"https://ka.niwodai.com/loans-mobile/product.do?method=index&nwd_ext_aid=5020162630395888&source_id=2","flag":1,"currentCategoryId":2076,"currentTagId":0,"open":true},{"id":545,"img":"http://api.91tatadai.com:4061/images/other/2018-09-29/1538197853134.png","name":"坚果贷","applyCount":234457,"monthRate":"0.76%","tag":"最快3分钟到账","amount":"500-1万元","special":2,"url":"https://jianguodai-fe.happycheer.com/down?site=jianguodai&utm_source=tatajie","flag":1,"currentCategoryId":2076,"currentTagId":0,"open":true}]}]
     */

    public int statusCode;
    public String message;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * id : 2076
         * name : 为您推荐
         * flag : 1
         * bannerDTO : {"img":"","flag":0,"dataId":0,"url":""}
         * dataList : [{"id":746,"img":"http://api.91tatadai.com:4061/images/other/2018-10-08/1538985487296.png","name":"闪到","applyCount":640521,"monthRate":"0.72%","tag":" 3分钟审批30秒下款","amount":"1000-1万元","special":1,"url":"http://papi.musitech8.com/h5/channelReg.html?channelCode=TTJ&pointCode=TTJ&style=2&modelType=1","flag":1,"currentCategoryId":2076,"currentTagId":0,"open":true},{"id":873,"img":"http://api.91tatadai.com:4061/images/other/2018-11-02/1541155154558.png","name":"易融花","applyCount":550814,"monthRate":"0.67%","tag":"纯信用，下款快","amount":"1000-1500元","special":1,"url":"http://share.yironghua.cn/?channelName=he03","flag":1,"currentCategoryId":2076,"currentTagId":0,"open":true},{"id":684,"img":"http://api.91tatadai.com:4061/images/other/2018-08-09/1533805769194.png","name":"7秒贷","applyCount":354410,"monthRate":"0.68%","tag":"超低门槛，十分钟借到2000元","amount":"500-1万元","special":1,"url":"https://7md.yihuabao.cn/qmd_wap/index.php/Login/index?channel=tatajie","flag":1,"currentCategoryId":2076,"currentTagId":0,"open":true},{"id":847,"img":"http://api.91tatadai.com:4061/images/other/2018-10-25/1540457975745.png","name":"大额贷款","applyCount":813625,"monthRate":"0.4%","tag":"0服务费，门槛低","amount":"500-5万元","special":1,"url":"https://ka.niwodai.com/loans-mobile/product.do?method=index&nwd_ext_aid=5020162630395888&source_id=2","flag":1,"currentCategoryId":2076,"currentTagId":0,"open":true},{"id":545,"img":"http://api.91tatadai.com:4061/images/other/2018-09-29/1538197853134.png","name":"坚果贷","applyCount":234457,"monthRate":"0.76%","tag":"最快3分钟到账","amount":"500-1万元","special":2,"url":"https://jianguodai-fe.happycheer.com/down?site=jianguodai&utm_source=tatajie","flag":1,"currentCategoryId":2076,"currentTagId":0,"open":true}]
         */

        public int id;
        public String name;
        public int flag;
        public BannerDTOBean bannerDTO;
        public List<DataListBean> dataList;

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

        public static class DataListBean {
            /**
             * id : 746
             * img : http://api.91tatadai.com:4061/images/other/2018-10-08/1538985487296.png
             * name : 闪到
             * applyCount : 640521
             * monthRate : 0.72%
             * tag :  3分钟审批30秒下款
             * amount : 1000-1万元
             * special : 1
             * url : http://papi.musitech8.com/h5/channelReg.html?channelCode=TTJ&pointCode=TTJ&style=2&modelType=1
             * flag : 1
             * currentCategoryId : 2076
             * currentTagId : 0
             * open : true
             */
            public String flag_name;
            public int id;
            public String img;
            public String name;
            public int applyCount;
            public String monthRate;
            public String tag;
            public String amount;
            public int special;
            public String url;
            public int flag;
            public int currentCategoryId;
            public int currentTagId;
            public boolean open;


        }
    }
}
