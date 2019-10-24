package com.system.xmqb;


import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ab.util.AbMd5;
import com.framewidget.model.ModelLogin;
import com.google.gson.Gson;
import com.mdx.framework.Frame;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import static com.framewidget.F.mModelLogin;

public class F {
    //    public static final String HOST = "http://api.91tatadai.com";
    public static final String HOST = "http://api.us233.com";
    /**
     * 发送验证码
     */
    public static final String SEND_CODE = HOST + "/api/customer/sendCaptcha";
    /**
     * 注册
     */
    public static final String REGISTER = HOST + "/api/customer/reg";
    /**
     * banner
     */
    public static final String BANNER = HOST + "/api/banner/list";
    public static final String CREDITCARD = HOST + "/api/creditCard/category/list";
    public static final String RECOMMEND = HOST + "/api/loan/recommend";
    /**
     * 首页数据列表
     */
    public static final String HOME_LIST = HOST + "/api/general/index";
    /**
     * 贷款分类
     */
    public static final String LOAN_LIST = HOST + "/api/loan/category/list";

    /**
     * 登陆接口
     */
    public static final String LOGIN = HOST + "/api/customer/login";

    /**
     * 重置密码
     */
    public static final String RESET = HOST + "/api/customer/resetPassword";
    /**
     * 首页为您推荐
     */
    public static final String HOME_LOAN = HOST + "/api/general/index/loan";

    /**
     * 首页信用卡
     */
    public static final String HOME_XYK = HOST + "/api/general/index/creditCard";

    /**
     * 换一批
     */
    public static final String HOME_CHANGE = HOST + "/api/general/indexRandom";
    /**
     * 贷款搜索上面tag
     */
    public static final String SEARCH_TAGS = HOST + "/api/dictionary/tag";
    /**
     * 贷款标签
     */
    public static final String LOAN_TAGS = HOST + "/api/dictionary/ownList";
    /**
     * 贷款列表
     */
    public static final String LOAN_LIST_BY_TAG = HOST + "/api/loan/list";
    public static final String HOTLIST = HOST + "/api/creditCard/hotList";
    /**
     * 贷款推荐页面
     */
    public static final String LOAN_TUIJIAN = HOST + "/api/general/loanRecommend";
    /**
     * 信用卡页面
     */
    public static final String XYK_LIST = HOST + "/api/general/creditCardRecommend";
    /**
     * 活动列表
     */
    public static final String ACTION_LIST = HOST + "/api/activity/list";
    /**
     * 产品详情
     */
    public static final String LOAN_DETAIL = HOST + "/api/loan/details/";

    /**
     * 退出登录
     */
    public static final String EXIT = HOST + "/api/customer/logout";

    /**
     * 反馈意见
     */
    public static final String COUPLE_BACK = HOST + "/api/general/feedback/save";
    /**
     * 添加浏览记录
     */
    public static final String ADD_LLOK = HOST + "/api/pv/save";
    /**
     * 消息列表
     */
    public static final String MSG_LIST = HOST + "/api/messageRecord/list";
    /**
     * 浏览记录
     */
    public static final String LOOK_LIST = HOST + "/api/loan/browse/history";
    /**
     * 上传头像
     */
    public static final String UPLOAD = HOST + "/api/customer/upload/headImg";
    public static final String INFO = HOST + "/api/customer/info";

    /**
     * 修改个人资料
     */
    public static final String EDIT = HOST + "/api/customer/edit";

    /**
     * 地区
     */
    public static final String ADDRESS = HOST + "/api/dictionary/cityList";
    /**
     * 贷款成功数据
     */
    public static final String SUCCESS_LOAN = HOST + "/api/customer/successLoan";
    /**
     * 大额贷款
     */
    public static final String HOME_DAE = HOST + "/api/general/index/specialLoan";
    public static final String CHARS = "0123456789abcdefghijklmnopqrstuvwxyz";


    public static void init() {
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(Frame.CONTEXT);
        if (!TextUtils.isEmpty(getJson("mModelLogin"))) {
            mModelLogin = (ModelLogin) json2Model(getJson("mModelLogin"), ModelLogin.class);
        }
    }

    public static void saveJson(String key, String json) {
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(Frame.CONTEXT);
        sp.edit().putString(key, json).commit();

    }

    public static String getJson(String key) {
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(Frame.CONTEXT);
        return sp.getString(key, "");
    }

    public static Object json2Model(String json, Class<?> mclass) {
        return new Gson().fromJson(json, mclass);

    }

    public static String changePhone(String code) {
        if (!TextUtils.isEmpty(code) && code.length() == 11) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < code.length(); i++) {
                char c = code.charAt(i);
                if (i >= 3 && i < code.length() - 4) {
                    sb.append('*');
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
        return code;
    }

    public static String secToTime(int time) {
        String timeStr = null;
        int minute = 0;
        int second = 0;
        minute = time / 60;
        second = time % 60;
        if (minute > 0) {
            timeStr = minute + "分" + second + "秒";
        } else {
            timeStr = second + "秒";
        }

        return timeStr;
    }

    public static void changeFonts(ViewGroup root, Activity act) {

        Typeface tf = Typeface.createFromAsset(act.getAssets(),
                "fonts/xxx.ttf");

        for (int i = 0; i < root.getChildCount(); i++) {
            View v = root.getChildAt(i);
            if (v instanceof TextView) {
                ((TextView) v).setTypeface(tf);
            } else if (v instanceof Button) {
                ((Button) v).setTypeface(tf);
            } else if (v instanceof EditText) {
                ((EditText) v).setTypeface(tf);
            } else if (v instanceof ViewGroup) {
                changeFonts((ViewGroup) v, act);
            }
        }

    }

    /**
     * 用来遍历对象属性和属性值
     */
    public static String readClassAttr(Object tb) {
        HashMap map = new HashMap();
        List<String> list = new ArrayList<>();
        String str = "";
        try {
            Field[] fields = tb.getClass().getDeclaredFields();
            System.out.println(fields.length);
            for (Field field : fields) {
                field.setAccessible(true);
                if (!field.getName().equals("sign")) {
                    map.put(field.getName(), TextUtils.isEmpty(field.get(tb).toString()) ? "" : field.get(tb).toString());
                    if (!field.getName().equals("timestamp"))
                        list.add(field.getName());
                }
            }
            if (tb.getClass().getSuperclass() != null && (tb.getClass().getSuperclass().getSimpleName().equals("BeanBase") || tb.getClass().getSuperclass().getSimpleName().equals("BeanListBase"))) {
                Field[] fields_father = tb.getClass().getSuperclass().getDeclaredFields();
                for (Field field : fields_father) {
                    field.setAccessible(true);
                    if (!field.getName().equals("sign")) {
                        map.put(field.getName(), TextUtils.isEmpty(field.get(tb).toString()) ? "" : field.get(tb).toString());
                        if (!field.getName().equals("timestamp"))
                            list.add(field.getName());
                    }
                }
            }
            Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
            for (String key : list) {
                str += key + "=" + map.get(key) + "&";
            }
            str += "timestamp=" + map.get("timestamp");
            Log.i("sign=", str);
            return AbMd5.MD5(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 验证身份证号是否符合规则
     *
     * @return
     */
    public static boolean isIDCard(String IDCard) {
        if (IDCard != null) {
            String IDCardRegex = "(^\\d{15}$)|(^\\d{18}$)|(^\\d{17}(\\d|X|x|Y|y)$)";
            return IDCard.matches(IDCardRegex);
        }
        return false;
    }
    public static String changeSFZ(String code) {
        if (!TextUtils.isEmpty(code) && code.length() > 10) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < code.length(); i++) {
                char c = code.charAt(i);
                if (i >= 6 && i < code.length() - 4) {
                    sb.append('*');
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
        return code;
    }


//    /**
//     * 针对URL进行签名，关于这几个参数的作用，详细请看
//     * http://www.cnblogs.com/bestzrz/archive/2011/09/03/2164620.html
//     */
//    public static void sign(AbRequestParams params) {
//        params.put("nonce", getRndStr(6 + new Random().nextInt(8)));
//        params.put("timestamp", "" + (System.currentTimeMillis() / 1000L));
//        StringBuilder sb = new StringBuilder();
//        for (Map.Entry<String, List<String>> entry : getSortedMapByKey(params.getUrlParams()).entrySet()) {
//            sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
//        }
//        sb.delete(sb.length() - 1, sb.length());
//        String sign = MD5Utils.encode(sb.toString());
//        params.put("sign", sign);
//    }

    /**
     * 获取随机数
     */
    public static String getRndStr(int length) {
        StringBuilder sb = new StringBuilder();
        char ch;
        for (int i = 0; i < length; i++) {
            ch = CHARS.charAt(new Random().nextInt(CHARS.length()));
            sb.append(ch);
        }
        return sb.toString();
    }

    /**
     * 按照key的自然顺序进行排序，并返回
     */
    public static Map<String, List<String>> getSortedMapByKey(ConcurrentHashMap<String, List<String>> map) {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String lhs, String rhs) {
                return lhs.compareTo(rhs);
            }
        };
        TreeMap<String, List<String>> treeMap = new TreeMap<>(comparator);
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            treeMap.put(entry.getKey(), entry.getValue());
        }
        return treeMap;
    }
}
