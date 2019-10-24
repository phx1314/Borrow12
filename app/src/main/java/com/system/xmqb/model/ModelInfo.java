package com.system.xmqb.model;

import java.io.Serializable;

/**
 * Created by DELL on 2018/1/9.
 */

public class ModelInfo implements Serializable {


    /**
     * statusCode : 200
     * message :
     * data : {"id":42200,"name":"戴尔","headImg":"/images/null","mobile":"13915079457","age":"23","sex":"男","cityId":0,"city":"英国","selfCard":"32128555566632233","socialAccounts":"无","eBusinessAccounts":"无","contactName":"爸爸","contactMobile":"1391562251","marriage":"对","education":"","profession":"","incomeType":"","income":"","companyType":"不","workTime":"","companyName":"","housingFund":"","haveCreditCard":"有","houseProperty":"有","carProperty":"有","haveLoan":"无","haveHouseLoan":"无","creditCase":0,"ticket":"e41b3f12ffacf12086b72286e3815067dcb88ed94904c059f9eff72c5316853b","socialSecurity":"","hireDate":"","enrollmentYear":"","schoolName":"","qualification":"","enterpriseIdentity":"","enterpriseShare":"","operatingAge":"","licenseTime":"","monthPublicFinance":"","monthPrivateFinance":""}
     */

    public int statusCode;
    public String message;
    public DataBean data;

    public static class DataBean {
        /**
         * id : 42200
         * name : 戴尔
         * headImg : /images/null
         * mobile : 13915079457
         * age : 23
         * sex : 男
         * cityId : 0
         * city : 英国
         * selfCard : 32128555566632233
         * socialAccounts : 无
         * eBusinessAccounts : 无
         * contactName : 爸爸
         * contactMobile : 1391562251
         * marriage : 对
         * education :
         * profession :
         * incomeType :
         * income :
         * companyType : 不
         * workTime :
         * companyName :
         * housingFund :
         * haveCreditCard : 有
         * houseProperty : 有
         * carProperty : 有
         * haveLoan : 无
         * haveHouseLoan : 无
         * creditCase : 0
         * ticket : e41b3f12ffacf12086b72286e3815067dcb88ed94904c059f9eff72c5316853b
         * socialSecurity :
         * hireDate :
         * enrollmentYear :
         * schoolName :
         * qualification :
         * enterpriseIdentity :
         * enterpriseShare :
         * operatingAge :
         * licenseTime :
         * monthPublicFinance :
         * monthPrivateFinance :
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
        public String contactName;
        public String contactMobile;
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
        public String socialSecurity;
        public String hireDate;
        public String enrollmentYear;
        public String schoolName;
        public String qualification;
        public String enterpriseIdentity;
        public String enterpriseShare;
        public String operatingAge;
        public String licenseTime;
        public String monthPublicFinance;
        public String monthPrivateFinance;
        public String sesameCredit;
    }
}
