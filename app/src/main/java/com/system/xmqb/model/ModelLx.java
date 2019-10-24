package com.system.xmqb.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by DELL on 2018/1/9.
 */

public class ModelLx implements Serializable {

    /**
     * statusCode : 200
     * message :
     * data : [{"id":2061,"name":"上班族"},{"id":2062,"name":"学生"},{"id":2063,"name":"企业主"},{"id":2064,"name":"自由职业"}]
     */

    public int statusCode;
    public String message;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * id : 2061
         * name : 上班族
         */

        public int id;
        public String name;

        public DataBean(String name) {
            this.name = name;
        }
    }
}
