package com.framewidget.model;

import java.io.Serializable;

/**
 * Created by DELL on 2018/1/9.
 */

public class ModelLogin implements Serializable {


    /**
     * statusCode : 200
     * message :
     * data : {"id":42200,"name":"","headImg":"/images/null","mobile":"13915079457","age":"","sex":"1","cityId":0,"city":"","selfCard":"","socialAccounts":"","eBusinessAccounts":"","contactName":null,"contactMobile":null,"marriage":"","education":"","profession":"","incomeType":"","income":"","companyType":"","workTime":"","companyName":"","housingFund":"","haveCreditCard":"","houseProperty":"","carProperty":"","haveLoan":"","haveHouseLoan":"","creditCase":0,"ticket":"322c0c665d7daf806a2a5c3063cdd2f01cdc4d7be32b2a5d578ae52c1bcf3eae"}
     */

    public int statusCode;
    public String message;
    public DataBean data;

    public static class DataBean {
        /**
         * id : 42200
         * name :
         * headImg : /images/null
         * mobile : 13915079457
         * age :
         * sex : 1
         * cityId : 0
         * city :
         * selfCard :
         * socialAccounts :
         * eBusinessAccounts :
         * contactName : null
         * contactMobile : null
         * marriage :
         * education :
         * profession :
         * incomeType :
         * income :
         * companyType :
         * workTime :
         * companyName :
         * housingFund :
         * haveCreditCard :
         * houseProperty :
         * carProperty :
         * haveLoan :
         * haveHouseLoan :
         * creditCase : 0
         * ticket : 322c0c665d7daf806a2a5c3063cdd2f01cdc4d7be32b2a5d578ae52c1bcf3eae
         */

        public int id;
        public String name;
        public String headImg;
        public String mobile;
        public String age;
        public String sex;
        public int cityId;
        public String city;
        public String selfCard;
        public String socialAccounts;
        public String eBusinessAccounts;
        public Object contactName;
        public Object contactMobile;
        public String marriage;
        public String education;
        public String profession;
        public String incomeType;
        public String income;
        public String companyType;
        public String workTime;
        public String companyName;
        public String housingFund;
        public String haveCreditCard;
        public String houseProperty;
        public String carProperty;
        public String haveLoan;
        public String haveHouseLoan;
        public int creditCase;
        public String ticket;
    }
}
