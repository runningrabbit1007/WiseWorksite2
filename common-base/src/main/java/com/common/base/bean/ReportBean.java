package com.common.base.bean;

import com.common.base.App;
import com.common.base.config.PreferencesManager;
import com.common.utils.system.AppUtil;

/**
 * Created by yonggege on 2017/8/21.
 */

public class ReportBean {
    /**
     * appid : 2
     * version : 114
     * location : 29.42,111.11
     * uid : 10568
     * cookie : hgfyeuiow
     * push_id : cbe7cabb4033d
     * debug : 0
     */

    private int appid;
    private int version;
    private String location;
    private String userId;
    private String sessionid;
//    private String cookie;
//    private String push_id;

    public ReportBean() {
        appid = 1;
        version = AppUtil.getVersionCode(App.INSTANCE);
        userId = PreferencesManager.getInstance().getUSERID();
        sessionid = PreferencesManager.getInstance().getSESSIONID();
//        cookie = PreferencesManager.getInstance().getCookie();
//        push_id = PreferencesManager.getInstance().getPushId();
//        location = PreferencesManager.getInstance().getLocation();
    }

    public int getAppid() {
        return appid;
    }

    public void setAppid(int appid) {
        this.appid = appid;
    }

    /*public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }*/

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getVersion() {
        return version;
    }

    public String getSessionid() {
        return sessionid;
    }

    public void setSessionid(String sessionid) {
        this.sessionid = sessionid;
    }

    /*public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }*/
/*
    public String getPush_id() {
        return push_id;
    }

    public void setPush_id(String push_id) {
        this.push_id = push_id;
    }*/
}
