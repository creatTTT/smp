package com.tu.demo_s_mp.util;

import java.io.Serializable;

/**
 * @author zgc
 * @since 2019-09-23
 */
public class R<T> implements Serializable{

    private static final long serialVersionUID = -2825436079063723409L;

    private static final String OK = "200";
    private static final String FAILED = "500";
    private static final String BUSYNESS_FAILED = "550";
    private static final String UN_AUTHENTICATION = "501";

    private String retCode;
    private String message;
    private T data;

    private static <T> R<T> buildResponse(String retCode, String message, T data) {
        R<T> r = new R<>();
        r.retCode = retCode;
        r.message = message;
        if (data != null) {
            r.data = data;
        }
        return r;
    }

    public static <T> R<T> ok() {
        return buildResponse(R.OK, "成功。", null);
    }

    public static <T> R<T> ok(T data) {
        return buildResponse(R.OK, "成功。", data);

    }

    public static <T> R<T> ok(String message, T data) {
        return buildResponse(R.OK, message, data);
    }


    public static <T> R<T> failed(String message) {
        return buildResponse(R.FAILED, message, null);
    }

    public static <T> R<T> failed(String message, T data) {
        return buildResponse(R.FAILED, message, data);
    }

    public static <T> R<T> businessFailed(String message) {
        return buildResponse(R.BUSYNESS_FAILED, message, null);
    }

    public static <T> R<T> unAuthentication(String message) {
        return buildResponse(R.UN_AUTHENTICATION, message, null);
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static String getOK() {
        return OK;
    }

    public static String getFAILED() {
        return FAILED;
    }

    public static String getBusynessFailed() {
        return BUSYNESS_FAILED;
    }

    public static String getUnAuthentication() {
        return UN_AUTHENTICATION;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

