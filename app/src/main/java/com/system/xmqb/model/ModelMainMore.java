package com.system.xmqb.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by DELL on 2017/3/24.
 */

public class ModelMainMore implements Serializable {


    /**
     * statusCode : 200
     * message :
     * data : [{"id":545,"img":"http://api.wo65.com//images/other/2018-11-10/1541835489482.png","name":"融789","applyCount":3675,"monthRate":"0.03%","tag":"申请到放款最快3分钟","amount":"1000-1万元","special":2,"url":"http://rongqibajiu.xingyunqianbao.net/Fast/index/index/source/ce6d","flag":1,"currentCategoryId":2076,"currentTagId":0,"open":false},{"id":540,"img":"http://api.wo65.com//images/other/2018-11-02/1541138158101.png","name":"开心分期","applyCount":6204,"monthRate":"0.02%","tag":"最快3分钟审核，最长12小时","amount":"800-3000元","special":2,"url":"http://channel.kaixinfenqi.cn/h5/extension?invite_code=2nug7o&user_from=1075&appName=kxfq&channelType=1","flag":1,"currentCategoryId":2076,"currentTagId":0,"open":false},{"id":531,"img":"http://api.wo65.com//images/other/2018-10-25/1540445741909.png","name":"滴滴钱包","applyCount":4367,"monthRate":"0.1%起","tag":"流程简单，三步申请，极速审核，超高通过，十秒下款","amount":"1000-2000元","special":2,"url":"https://ddwallet.niuyanwo.xyz/mobile/index.php/twologin/login?location=honghai","flag":1,"currentCategoryId":2076,"currentTagId":0,"open":false},{"id":530,"img":"http://api.wo65.com//images/other/2018-10-25/1540445513491.png","name":"CF贷","applyCount":2349,"monthRate":"10%","tag":"只需身份证即可下款","amount":"1000-6000元","special":2,"url":"http://cf.creditxb.com/?h=ej5uXT","flag":1,"currentCategoryId":2076,"currentTagId":0,"open":false},{"id":534,"img":"http://api.wo65.com//images/other/2018-10-25/1540446694654.png","name":"小木鱼","applyCount":1833,"monthRate":"0.03%","tag":"快至3分钟下款","amount":"1000-3000元","special":2,"url":"http://u.xiaomuyu.net/download/registerM092.html","flag":1,"currentCategoryId":2076,"currentTagId":0,"open":false},{"id":526,"img":"http://api.wo65.com//images/other/2018-10-24/1540370148820.jpg","name":"新网牛","applyCount":1896,"monthRate":"免息","tag":"额度1000，超低门槛，最快3分钟下款","amount":"1000-6000元","special":2,"url":"https://wn.51haoping.com/h5/register.html?code=wdm","flag":1,"currentCategoryId":2076,"currentTagId":0,"open":false},{"id":535,"img":"http://api.wo65.com//images/other/2018-10-26/1540560747792.jpeg","name":"花猫乐租","applyCount":2531,"monthRate":"1.2","tag":"额度1000，超低门槛，最快3分钟下款","amount":"1000-6000元","special":2,"url":"www.baidu.com","flag":1,"currentCategoryId":2076,"currentTagId":0,"open":false},{"id":533,"img":"http://api.wo65.com//images/other/2018-10-25/1540446520661.png","name":"萝卜","applyCount":3476,"monthRate":"免息","tag":"额度1000，超低门槛，最快3分钟下款","amount":"1000-6000元","special":2,"url":"https://newModel.xianjinsuo.cn/h5/register.html?code=wdm1","flag":1,"currentCategoryId":2076,"currentTagId":0,"open":false}]
     */

    public int statusCode;
    public String message;
    public List<ModelMain.DataBean.DataListBean> data;

}
