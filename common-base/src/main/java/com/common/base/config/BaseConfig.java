package com.common.base.config;



/**
 * Created by Jack on 2016/5/5.
 * Common modle的配置项
 */
public class BaseConfig {
    public static final String TAG = "maowo";

    /**
     * 基本信息状态标志，为1表示信息操作正常，为其他值则表示信息操作失败
     */
    public static final int BASE_INFO_CODE = 1;

    /**
     * 基本信息提示框类型1,显示土司提示
     */
    public static final int BASE_DIALOG_TYPE_1 = 1;
    /**
     * 基本信息提示框类型2，显示一个按钮的提示框
     */
    public static final int BASE_DIALOG_TYPE_2 = 2;

    /**
     * AES加密key
     */
    public static final String AES_KEY = "fgY83j5FD38HNJDF";

    /**
     * AES偏移向量
     */
    public static final String AES_IV = "n8fh3nFD955fe39J";
    /**
     * AES Mode
     */
    public static final String AES_MODE = "AES/CBC/PKCS5Padding";

    /**
     * AES 编码设置
     */
    public static final String AES_CHARSET = "UTF-8";

    /**
     * AES
     */
    public static final String _AES = "AES";

    /**
     * 请求相机拍照功能
     */
    public static final int REQUEST_CODE_CAMERA = 1000;
    /**
     * 打开相册选择图片
     */
    public static final int REQUEST_CODE_GALLERY = 1001;
    /**
     * 裁剪图片功能
     */
    public static final int REQUEST_CODE_CROP = 1002;
    /**
     * 编辑图片功能
     */
    public static final int REQUEST_CODE_EDIT = 1003;



    /**
     * 配置图片选择器的默认多选值
     */
    public static final int MULTI_MAX_SIZE = 5;

    /**
     * 配置图片选择器占位数据标志值
     */
    public static final int MULTI_NULL_NUM = -1;

    /**
     * 图片不为空数据标志，结合CommonAdapter使用
     */
    public static final int SIGLE_NOT_NULL = 1;




    public static final int headPicWidth = 180;
    public static final int headPicHeight = 180;

    /**
     * 是否登录的数据KEY
     */
    public static final String PRE_KEY_LOGIN = "isLogin";
    /**
     * 用户token
     */
    public static final String TOKEN = "accessToken";

    /**
     * 用户token
     */
    public static final String USER_ID = "userId";
    /**
     * 用户名
     */
    public static final String PRE_KEY_USER_NAME = "userName";




    /**
     * 用户IM信息
     */
    public static final String PRE_KEY_IM = "imBean";

    /**
     * 用户信息
     */
    public static final String PRE_KEY_USER_INFO = "userInfo";

    /**
     * 是否有过登陆信息
     */
    public static final String PRE_IS_LOGIN_BEFORE = "isLoginBefore";
    /**
     * 昵称
     */
    public static final String PRE_KEY_NICKNAME = "nickname";

    /**
     * 头像
     */
    public static final String PRE_KEY_AVATAR_URL = "avatar_url";
    /**
     *
     */
    public static final String PRE_KEY_CHANNEL_DATA = "channel_data";
    /**
     *
     */
    public static final String PRE_KEY_URL_ENTITES = "url_entites";

    /**
     * DH加密默认KEY
     */
    public static final String DH_DEFAULT_KEY = "maowo dh key";



    /**
     * 文件下载目录
     */
    public static final String DOWNLOAD_FILE_PATH = "BaseDownload/";
    /**
     * 默认版本跟新文件名
     */
    public static final String UPGRADE_FILE_NAME = "upgrade_";
    /**
     * 默认下载文件名
     */
    public static final String DOWNLOAD_FILE_NAME = "download";

    /**
     * 传递参数名：down_url
     */
    public static final String PARAM_DOWNLOAD_URL = "down_url";
    /**
     * 传递参数名：down_type
     */
    public static final String PARAM_DOWNLOAD_TYPE = "down_type";
    /**
     * 传递参数名：upload_url
     */
    public static final String PARAM_UPLOAD_URL = "upload_url";
    /**
     * 传递参数名：upload_map_params
     */
    public static final String PARAM_UPLOAD_MAP_PARAM = "upload_map_params";

    /**
     * 传递参数名：upload_map_heads
     */
    public static final String PARAM_UPLOAD_MAP_HEAD = "upload_map_heads";


    /**
     * 传递参数名：upload_list
     */
    public static final String PARAM_UPLOAD_LIST = "upload_list";


    /**
     * 跳转系统升级
     */
    public static final String START_UPGRADE_JUMP = "application/vnd.android.package-archive";

    /**
     * 通用状态1
     */
    public static final int STATUS_1001 = -1001;
    /**
     * 通用状态2
     */
    public static final int STATUS_1002 = -1002;
    /**
     * 通用状态3
     */
    public static final int STATUS_1003 = -1003;
    /**
     * 通用状态4
     */
    public static final int STATUS_1004 = -1004;

    public static final int NOTIC_ID_1001 = 1001;

    public static final int NOTIC_ID_1002 = 1002;

    /**
     * 服务状态标志：成功
     */
    public static final int SERVICE_STATUS_SUCCESS  = 1;
    /**
     * 服务状态标志：失败
     */
    public static final int SERVICE_STATUS_FAILED  = 2;

    /**
     * 网络提示
     */
    public static final String NET_WORK_POOR = "你的网络不给力~ 稍后再试";

    /**
     * 默认加载数据的条数，列表
     */
    public static int REFRESH_LOAD_DATA_DEFAULT_COUNT = 8;

    public static final String APP_ID = "1";

    public static final String DEBUG_ID = "1";


    public static String SIMPLE_DATE_FORMAT_MIN = "yyyy-MM-dd HH:mm";
    public static String SIMPLE_DATE_FORMAT_SS = "yyyy-MM-dd HH:mm:ss";
    public static String SIMPLE_DATE_FORMAT_HH = "yyyy-MM-dd HH";
    public static String SIMPLE_DATE_FORMAT_DAY = "yyyy-MM-dd";

    public static final int PAGE_COUNT = 8;




}
