package com.sx.common_base.result;

import android.webkit.JavascriptInterface;

import com.google.gson.JsonObject;

/**
 * Created by jacklyy on 2017/6/4.
 */

public class BaseMallResult {

    /**
     * errcode : 10058
     * errmsg : 失败原因
     * data : {}
     */

    public int code;
    public String msg;
    public JsonObject data;
    public Object pageModel;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public JsonObject getData() {
        return data;
    }

    public void setData(JsonObject data) {
        this.data = data;
    }

    public Object getPageModel() {
        return pageModel;
    }

    public void setPageModel(Object pageModel) {
        this.pageModel = pageModel;
    }
}
