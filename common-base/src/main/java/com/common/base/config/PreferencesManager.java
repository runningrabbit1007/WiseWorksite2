package com.common.base.config;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;

import com.common.base.App;
import com.common.utils.system.AppUtil;
import com.google.gson.JsonObject;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * ============================================================
 * <p>
 * <p>
 * description : 保存信息的工具类
 * <p>
 * revision history :v1.0
 * <p>
 * ============================================================
 */
@SuppressLint("NewApi")
public class PreferencesManager {
    private SharedPreferences preferences = null;
    private SharedPreferences.Editor editor = null;
    private Object object;
    public static PreferencesManager preferencesHelper;
    private static final String PREFERENCE_NAME = "maowo";

    public final String USERID = "userId";
    public final String MODE = "mode";
    public final String VERSION = "version";
    public final String TIEM = "time";
    public final String USERTYPE = "userType";
    public final String MSG = "msg";
    public final String USERNAME = "username";
    public final String NAME = "name";
    public final String EMAIL = "email";
    public final String MOBILE = "mobile";
    public final String POINT = "point";
    public final String BALANCE = "balance";
    public final String PASSWORD = "password";
    public final String SESSIONID = "sessionid";
    public final String signature = "signature";

    public final String MESSAGE_RUSH = "message_rush";
    public final String MESSAGE_UPDATE_TIME = "message_update_time";
    public final String INFORMATION_FRAGMENT = "save_name";

    public final String IS_CERTIFICATION = "is_certification";
    public final String PROFIT = "profit";
    public final String PUBLISH_CERTIFICATION = "publish_certification";
    public final String SEACH_LIST = "search_list";   //搜索字段集合

    public final int SITE_ID = 0;
    public final String SITE_ID_STR = "SITE_ID";

    public final Boolean ISSALESMEMBER = false;

    public final String ISSALESMEMBER_STR = "ISSALESMEMBER";

    public final String Avatar = "avatar";

    public  final String currencySymbol = "currencySymbol";



    public String getInformationFragment(String newsId) {
        return (String) getParam(INFORMATION_FRAGMENT+newsId, "");
    }
    public void setInformationFragment(String newsId,String result) {

        saveParam(INFORMATION_FRAGMENT+newsId, result);
    }

    private PreferencesManager() {

    }

    public static synchronized void init(Context cxt) {
        if (preferencesHelper == null) {
            preferencesHelper = new PreferencesManager(cxt);
        }
    }

    public static PreferencesManager getInstance() {
        init(App.INSTANCE);
        if (preferencesHelper == null) {
            throw new RuntimeException("please init first!");
        }
        return preferencesHelper;
    }

    /**
     * 问题在于，这个Context哪来的我们不能确定，很大的可能性，你在某个Activity里面为了方便，直接传了个this;
     * 这样问题就来了，我们的这个类中的sInstance是一个static且强引用的，在其内部引用了一个Activity作为Context，也就是说，
     * 我们的这个Activity只要我们的项目活着，就没有办法进行内存回收。而我们的Activity的生命周期肯定没这么长，造成了内存泄漏。
     * 所以这里使用context.getApplicationContext()
     *
     * @param context
     */
    private PreferencesManager(Context context) {
        preferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    /**
     * 保存数据 , 所有的类型都适用
     *
     * @param key
     * @param object
     */
    public synchronized void saveParam(String key, Object object) {
        if (editor == null)
            editor = preferences.edit();
        // 得到object的类型
        if(object != null) {
            String type = object.getClass().getSimpleName();
            if ("String".equals(type)) {
                // 保存String 类型
                editor.putString(key, (String) object);
            } else if ("Integer".equals(type)) {
                // 保存integer 类型
                editor.putInt(key, (Integer) object);
            } else if ("Boolean".equals(type)) {
                // 保存 boolean 类型
                editor.putBoolean(key, (Boolean) object);
            } else if ("Float".equals(type)) {
                // 保存float类型
                editor.putFloat(key, (Float) object);
            } else if ("Long".equals(type)) {
                // 保存long类型
                editor.putLong(key, (Long) object);
            } else {
                // 不是基本类型则是保存对象
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(baos);
                    oos.writeObject(object);
                    String productBase64 = Base64.encodeToString(
                            baos.toByteArray(), Base64.DEFAULT);
                    editor.putString(key, productBase64);
                    Log.d(this.getClass().getSimpleName(), "save object success");
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.e(this.getClass().getSimpleName(), "save object error");
                }
            }
        }else{
            editor.putString(key, "");
        }
        editor.commit();
        editor = null;
    }

    /**
     * 得到保存数据的方法，所有类型都适用
     *
     * @param key
     * @param defaultObject
     * @return
     */
    public Object getParam(String key, Object defaultObject) {
        String type = defaultObject.getClass().getSimpleName();

        if ("String".equals(type)) {
            return preferences.getString(key, (String) defaultObject);
        } else if ("Integer".equals(type)) {
            return preferences.getInt(key, (Integer) defaultObject);
        } else if ("Boolean".equals(type)) {
            return preferences.getBoolean(key, (Boolean) defaultObject);
        } else if ("Float".equals(type)) {
            return preferences.getFloat(key, (Float) defaultObject);
        } else if ("Long".equals(type)) {
            return preferences.getLong(key, (Long) defaultObject);
        }
        return null;
    }


    /**
     * 得到版本号相应的是都第一次运行的布尔值
     *
     * @param versionName 版本号
     * @return
     */
    public boolean isFirstNavigation(String versionName) {
        return (Boolean) getParam(versionName, true);
    }

    /**
     * 保存版本号来存储是否是第一次运行
     *
     * @param versionName 版本名
     * @param isFirst     是都第一次
     */
    public void setFirstNavigation(String versionName, Boolean isFirst) {
        saveParam(versionName, isFirst);
    }


    /**
     * Set up the first time login
     *
     * @return
     */
    public boolean isLogin() {
        return (Boolean) getParam(BaseConfig.PRE_KEY_LOGIN, false);
    }

    /**
     * @return
     */
    public void setLogin(Boolean isLogin) {
        saveParam(BaseConfig.PRE_KEY_LOGIN, isLogin);
    }

    /**
     * 保存用户名
     *
     * @param pUserName
     */
    public void setUserName(String pUserName) {
        saveParam(BaseConfig.PRE_KEY_USER_NAME, pUserName);
    }

    /**
     * 获取用户名
     *
     * @return
     */
    public String getUserName() {
        return (String) getParam(BaseConfig.PRE_KEY_USER_NAME, "");
    }

    public String getEMAIL() {
        return (String)getParam(EMAIL,"");
    }

    public String getMODE() {
        return (String)getParam(MODE,"");
    }

    public String getBALANCE() {
        return (String)getParam(BALANCE,"");
    }

    public String getMOBILE() {
        return (String)getParam(MOBILE,"");
    }

    public String getMSG() {
        return (String)getParam(MSG,"");
    }

    public String getNAME() {
        return (String)getParam(NAME,"");
    }

    public String getPASSWORD() {
        return (String)getParam(PASSWORD,"");
    }

    public String getPOINT() {
        return (String)getParam(POINT,"");
    }

    public String getUSERID() {
        return (String)getParam(USERID,"");
    }

    public String getVERSION() {
        return (String)getParam(VERSION,"");
    }

    public String getUSERTYPE() {
        return (String)getParam(USERTYPE,"");
    }

    public String getUSERNAME() {
        return (String)getParam(USERNAME,"");
    }

    public String getTIEM() {
        return (String)getParam(TIEM,"");
    }

    public String getSESSIONID() {
        return (String)getParam(SESSIONID,"");
    }

    public void setBALANCE(String BALANCE) {
        saveParam(this.BALANCE, BALANCE);
    }

    public void setEMAIL(String EMAIL) {
        saveParam(this.EMAIL, EMAIL);
    }

    public void setMOBILE(String MOBILE) {
        saveParam(this.MOBILE, MOBILE);
    }

    public void setMODE(String MODE) {
        saveParam(this.MODE, MODE);
    }

    public void setMSG(String MSG) {
        saveParam(this.MSG, MSG);
    }

    public void setNAME(String NAME) {
        saveParam(this.NAME, NAME);
    }

    public void setVERSION(String VERSION) {
        saveParam(this.VERSION, VERSION);
    }

    public void setUSERTYPE(String USERTYPE) {
        saveParam(this.USERTYPE, USERTYPE);
    }

    public void setUSERNAME(String USERNAME) {
        saveParam(this.USERNAME, USERNAME);
    }

    public void setUSERID(String USERID) {
        saveParam(this.USERID, USERID);
    }

    public void setTIEM(String TIEM) {
        saveParam(this.TIEM, TIEM);
    }

    public void setSESSIONID(String SESSIONID) {
        saveParam(this.SESSIONID, SESSIONID);
    }

    public void setPOINT(String POINT) {
        saveParam(this.POINT, POINT);
    }

    public void setPASSWORD(String PASSWORD) {
        saveParam(this.PASSWORD, PASSWORD);
    }

    public String getAvatar() {
            return (String)getParam(Avatar,"");
    }

    public void setAvatar(String avatar) {
        saveParam(this.Avatar, avatar);
    }

    public String getSignature() {
        return (String)getParam(signature,"");
    }

    public void setSignature(String signature) {
        saveParam(this.signature, signature);
    }

    public Boolean getISSALESMEMBER() {
        return (Boolean)getParam(ISSALESMEMBER_STR,false);
    }

    public void setISSALESMEMBER(Boolean ISSALESMEMBER) {
        saveParam(this.ISSALESMEMBER_STR, ISSALESMEMBER);
    }

    public int getSITE_ID() {
        return (int)getParam(SITE_ID_STR,0);

    }

    public void setSITE_ID(int SITE_ID) {
        saveParam(this.SITE_ID_STR, SITE_ID);
    }


    public String getCurrencySymbol() {
        return (String)getParam(currencySymbol,"");
    }

    public void setCurrencySymbol(String currencySymbol) {
        saveParam(this.currencySymbol,currencySymbol);
    }



    public void setLogo(int resId) {
        saveParam("logo", resId);
    }

    public int getLogo() {
        return (int) getParam("logo", 0);
    }

    public int getDictVersion(){
        return (int) getParam("dict_version", 0);
    }

    public void setDictVersion(int version){
        saveParam("dict_version",version);
    }

    public void setDictData(String dictJson){
        saveParam("dict_data",dictJson);
    }

    public String getDictData(){
        return (String) getParam("dict_data","");
    }

    public void setShareData(String shareData){
        saveParam("share_data",shareData);
    }

    public String getShareData(){
        return (String) getParam("share_data","");
    }

    public void setUrlsData(String urlsData){
        saveParam("urls_data",urlsData);
    }

    public String getUrlsData(){
        return (String) getParam("urls_data","");
    }

    /*public String getRealName() {
        return (String)getParam(REAL_NAME,"");
    }

    public void setRealName(String realName) {
        saveParam(REAL_NAME,realName);
    }

    public String getNickName() {
        return (String)getParam(NICK_NAME,"");
    }

    public void setNickName(String nickName) {
        saveParam(NICK_NAME,nickName);
    }

    public String getAvatar() {
        return (String)getParam(AVATAR,"");
    }

    public void setAvatar(String avatar) {
        saveParam(AVATAR,avatar);
    }

    public String getCellPhone() {
        return (String)getParam(CELL_PHONE,"");
    }

    public void setCellPhone(String cellPhone) {
        saveParam(CELL_PHONE,cellPhone);
    }*/



    public boolean getIsMessageRush() {
        return (boolean)getParam(MESSAGE_RUSH,false);
    }

    public void setIsMessageRush(boolean isRush) {
        saveParam(MESSAGE_RUSH,isRush);
    }



    public int getMessageUpdate() {
        return (int)getParam(MESSAGE_UPDATE_TIME,0);
    }

    public void setMessageUpdate(int updateTime) {
        saveParam(MESSAGE_UPDATE_TIME,updateTime);
    }

    public boolean getIsCertification() {
        return (boolean)getParam(IS_CERTIFICATION,false);
    }

    public void setIsCertification(boolean isCertification) {
        saveParam(IS_CERTIFICATION,isCertification);
    }

    public String getProfit() {
        return (String)getParam(PROFIT,"");
    }

    public void setProfit(String profit) {
        saveParam(PROFIT,profit);
    }

    public boolean getPublishCertification() {
        return (boolean)getParam(PUBLISH_CERTIFICATION,false);
    }

    public void setPublishCertification(boolean publishCertification) {
        saveParam(PUBLISH_CERTIFICATION,publishCertification);
    }

    public String getSeachList(){
        return (String)getParam(SEACH_LIST,"");
    }

    public void setSeachList(String seachList){
        saveParam(SEACH_LIST,seachList);
    }
    public void cleanUserCache() {
        setBALANCE("");
        setVERSION("");
        setEMAIL("");
        setVERSION("");
        setMOBILE("");
        setUSERTYPE("");
        setUSERNAME("");
        setUSERID("");
        setMODE("");
        setMSG("");
        setAvatar("");
        setSESSIONID("");
        setTIEM("");
        setPASSWORD("");
        setPOINT("");
        setSignature("");
        setCurrencySymbol("");
        setISSALESMEMBER(false);
        setSITE_ID(0);
        setLogin(false);
        setIsMessageRush(false);
//        setProfit("今日推广收益：0.00元");
    }


    public void setIsLoginBefore(boolean pIsLoginBefore) {
        saveParam(BaseConfig.PRE_IS_LOGIN_BEFORE, pIsLoginBefore);
    }

    public boolean isLoginBefore() {
        return (boolean) getParam(BaseConfig.PRE_IS_LOGIN_BEFORE, false);
    }


    public Object getObject(String key) {
        String wordBase64 = preferences.getString(key, "");
        byte[] base64 = Base64.decode(wordBase64.getBytes(), Base64.DEFAULT);
        ByteArrayInputStream bais = new ByteArrayInputStream(base64);
        try {
            ObjectInputStream bis = new ObjectInputStream(bais);
            object = bis.readObject();
            Log.d(this.getClass().getSimpleName(), "Get object success");
            return object;
        } catch (Exception e) {
        }
        Log.e(this.getClass().getSimpleName(), "Get object is error");
        return null;
    }

    public static String getReport(){
        int appid = 1;
        int version = AppUtil.getVersionCode(App.INSTANCE);
        String userId = PreferencesManager.getInstance().getUSERID();
        String sessionid = PreferencesManager.getInstance().getSESSIONID();
//        String cookie = PreferencesManager.getInstance().getCookie();
//        String push_id = PreferencesManager.getInstance().getPushId();
//        String location = PreferencesManager.getInstance().getLocation();
        int debug = 0;

        return "appid="+appid+"&"+"version="+version+"&"+"userid="+userId+"&"+"sessionid="+sessionid+"debug="+debug;
    }

    public static String getReportNoDebug(){
        int appid = 1;
        int version = AppUtil.getVersionCode(App.INSTANCE);
        String userId = PreferencesManager.getInstance().getUSERID();
        String sessionid = PreferencesManager.getInstance().getSESSIONID();
//        String cookie = PreferencesManager.getInstance().getCookie();
//        String push_id = PreferencesManager.getInstance().getPushId();
//        String location = PreferencesManager.getInstance().getLocation();

        return "appid="+appid+"&"+"version="+version+"&"+"userid="+userId+"&"+"sessionid="+sessionid;
    }

    public void savePublish(String tag, String saveStr){
        saveParam(tag,saveStr);
    }

    public String getPublishSaveData(String tag){
        return (String) getParam(tag,"");
    }
}