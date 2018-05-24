package com.sx.common_base.modle.request;

import com.common.base.App;
import com.common.base.config.PreferencesManager;
import com.common.utils.system.AppUtil;

/**
 * Created by jacklyy on 2017/6/4.
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
//    private String location;
    private String userId;
    private String sessionid;
//    private String push_id;
    private int debug;

    public ReportBean() {
        appid = 1;
        version = AppUtil.getVersionCode(App.INSTANCE);
        userId = PreferencesManager.getInstance().getUSERID();
        sessionid = PreferencesManager.getInstance().getSESSIONID();
        /*push_id = PreferencesManager.getInstance().getPushId();
        location = PreferencesManager.getInstance().getLocation();
        if(location.equals("4.9E-324,4.9E-324")){
            location = "28.17074,113.009387";
        }*/
        debug = 0;
    }

    public int getAppid() {
        return appid;
    }

    public void setAppid(int appid) {
        this.appid = appid;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getUserId() {
        return userId;
    }

    public String getSessionid() {
        return sessionid;
    }

    public void setSessionid(String sessionid) {
        this.sessionid = sessionid;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setDebug(int debug) {
        this.debug = debug;
    }

    public int getDebug() {
        return debug;
    }

    /*public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public String getPush_id() {
        return push_id;
    }

    public void setPush_id(String push_id) {
        this.push_id = push_id;
    }

    public int getDebug() {
        return debug;
    }

    public void setDebug(int debug) {
        this.debug = debug;
    }*/
}