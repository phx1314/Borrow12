package com.ab.util;

/**
 * Created by DELL on 2017/3/29.
 */

public interface HttpResponseListenerSon {


    public void onFinish();

    public void onFailure(int statusCode, String content, Throwable error, String methodName);

    public void onSuccess(String methodName, String content);
}
