package com.sx.common_base.constant;

/**
 * Author : Jack
 * Email  : jackzhonglyy@outlook.com
 * Date   : 2016/9/20
 * Desc   :
 */
public class Configuration {
    //assest 文件夹schema
    public static final String DB_PATH = "schema";

    //assest 文件夹json
    public static final String JSON_PATH = "json";

    //assest 配置文件地址
    public static final String PROPERTIES_FILE_PATH = "properties/smartmall.properties";

    //地区数据库名
    public static final String DB_NAME = "area.db";

    //地区表名
    public static final String TABLE_NAME = "system_area_dict";

    //第一次
    public static final String IS_FIRST_INIT = "is_first_init";

    //数据库版本
    public static final int DB_VERSION = 1;

    public static int oldVersion = -1;


    //配置参数 参数名
    public static final String PROPERTIES_KEY_MALL_BRAND_ID = "MAOWO_MALL_BRAND_ID";
    //配置参数 参数名
    public static final String PROPERTIES_KEY_MALL_ID = "MAOWO_MALL_ID";
    //配置参数 数据库名
    public static final String PROPERTIES_KEY_DATABASE_NAME = "MAOWO_DATABASE_NAME";
    //配置参数 app平台
    public static final String PROPERTIES_KEY_PLATFORM_APP = "MAOWO_PLATFORM_TYPE";
    //配置参数 api环境
    public static final String PROPERTIES_KEY_MAOWO_API_ENV = "MAOWO_API_ENV";
    //配置参数 谷歌推送id
    public static final String PROPERTIES_KEY_GMC_APPID = "MAOWO_GMC_PUSH_APPKEY";
    //配置参数 华为推送id
    public static final String PROPERTIES_KEY_HUAWEI_ID = "MAOWO_HUAWEI_PUSH_APPKEY";
    //配置参数 小米推送appid
    public static final String PROPERTIES_KEY_MI_APPID = "MAOWO_MI_PUSH_APPID";
    //配置参数 小米推送appkey
    public static final String PROPERTIES_KEY_MI_APPKEY = "MAOWO_MI_PUSH_APPKEY";

    public static final int NOTICE_TYPE_SYSTEM = 1;

    public static final int NOTICE_TYPE_ACTIVITY = 2;

    public static final int NOTICE_TYPE_STORE = 3;

    public static final int NOTICE_TYPE_MALL = 4;

    public static final int NOTICE_TYPE_ASK = 5;
    //活动中心
    public static final int CHANNEL_TYPE_3 = 3;
    //配置化页面
    public static final int CHANNEL_TYPE_1 = 1;

    public static final int GROUP_TYPE_NORMAL = 0;
    public static final int GROUP_TYPE_DATE = 2;
    public static final int GROUP_TYPE_HELP = 3;
    public static final int GROUP_TYPE_BUY = 1;


}
