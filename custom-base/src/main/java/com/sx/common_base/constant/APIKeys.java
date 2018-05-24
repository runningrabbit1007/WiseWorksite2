package com.sx.common_base.constant;

/**
 * Author : Jack
 * Email  : jackzhonglyy@outlook.com
 * Date   : 2017/6/15
 * Desc   : 对应API.xml中每个Node节点中的Key值。
 * 命名规则：
 * 1. KEY的字母全部大写
 * 2. KEY的前缀是API_
 * 3. KEY的前缀之后是功能描述
 * 4. VALUE值可以同KEY,也可以自定义，但是一定保证value值在整个类中唯一
 * <p>
 * 其他：
 * 每个模块在改类中创建内部类，以模块为单位管理KEY.
 * 每个模块在该类中创建内部类，以模块为单位管理KEY.
 * 类名使用模块名的大写.
 */
public class APIKeys {

    /**
     * shell模块
     */
    public static final class SHELL {
        /**
         * 获取地区
         */
        public static final String API_GET_AREA_LISR = "API_GET_AREA_LISR";

        /**
         * 获取站点
         */
        public static final String API_GET_SITE_LISR = "API_GET_SITE_LISR";

        /**获取配置字段*/
        public static final String API_GET_UPDATEDICT = "API_GET_UPDATEDICT";

        /**检查版本更新*/
        public static final String API_CHECK_VERSION_URL = "API_CHECK_VERSION_URL";


    }

    public static final class LOGIN{
        public static final String API_GET_LOGIN_URL = "API_GET_LOGIN_URL";  //登录
        public static final String API_GET_REGISTER_URL = "API_GET_REGISTER_URL"; //注册

        public static final String API_GET_DEALER_REGISTER_URL = "API_GET_DEALER_REGISTER_URL"; //注册

        public static final String API_GET_PHONE_MESSAGE_CODE_URL = "API_GET_PHONE_MESSAGE_CODE_URL"; //获取短信验证码
        public static final String API_GET_FASTER_LOGIN_URL = "API_GET_FASTER_LOGIN_URL"; //快捷登录
        public static final String API_FORGETPASSWORD_URL = "API_FORGETPASSWORD_URL"; //忘记密码
        public static final String API_UPDATEPASSWORD_URL = "API_UPDATEPASSWORD_URL"; //经销商修改密码
        public static final String API_UPDATEPASSWORD_SALE_URL = "API_UPDATEPASSWORD_SALE_URL"; //业务员修改密码
        public static final String API_UPDATEPASSWORD_SUPPLIER_URL = "API_UPDATEPASSWORD_SUPPLIER_URL"; //供应商修改密码
        public static final String API_LOGIN_OUT_URL = "API_LOGIN_OUT_URL"; //登出

    }


    public static final class COMMON {
        /**
         * 上传文件
         */
        public static final String API_UPLOAD_FILE = "API_UPLOAD_FILE";

        /**
         * 上传多张图片
         */
        public static final String API_UPLOAD_FILES = "API_UPLOAD_FILES";

        /**
         * 经销商支付
         */
        public static final String API_PAYMENT_URL = "API_PAYMENT_URL";

        /**
         * 经销商提交支付
         */
        public static final String API_PAYMENT_SUBMIT_URL = "API_PAYMENT_SUBMIT_URL";

    }

    public static final class MESSAGE{
        /**获取消息列表*/
        public static final String API_GET_MEAASGE_LIST_URL = "API_GET_MEAASGE_LIST_URL";

        /**获取消息详情*/
        public static final String API_GET_MESSAGE_DETAIL_URL = "API_GET_MESSAGE_DETAIL_URL";
    }

    /**
     * 供求信息
     */
        public static final class DEMAND{
        /**供求列表*/
        public static final String API_GET_DEMAND_LIST_URL = "API_GET_DEMAND_LIST_URL";

        /**添加供求信息*/
        public static final String API_ADD_DEMAND_URL = "API_ADD_DEMAND_URL";

        /**编辑供求信息*/
        public static final String API_EDIT_DEMAND_URL = "API_EDIT_DEMAND_URL";

        /**删除供求信息*/
        public static final String API_DELETE_DEMAND_URL = "API_DELETE_DEMAND_URL";


    }

    public static final class Dealer{

        /**首页*/
        public static final String API_DEALER_INDEX = "API_DEALER_INDEX";


        /**修改真实姓名*/
        public static final String API_EDIT_NAME = "API_EDIT_NAME";

        /**地址列表*/
        public static final String API_ADDRESS_LIST_URL = "API_ADDRESS_LIST_URL";

        /**添加地址*/
        public static final String API_SAVE_RECEIVER_URL = "API_SAVE_RECEIVER_URL";

        /**修改地址*/
        public static final String API_UPDATE_RECEIVER_URL = "API_UPDATE_RECEIVER_URL";

        /**设置默认地址*/
        public static final String API_SET_RECEIVERDEFAULT_URL = "API_SET_RECEIVERDEFAULT_URL";

        /**根据ID删除地址*/
        public static final String API_DELETE_ADDRESS_URL = "API_DELETE_ADDRESS_URL";

        /**商品总分类*/
        public static final String API_PRODUCT_INDEX_LIST_URL = "API_PRODUCT_INDEX_LIST_URL";

        /**商品列表*/
        public static final String API_PRODUCT_LIST_URL = "API_PRODUCT_LIST_URL";

        /**商品详情*/
        public static final String API_PRODUCT_DETAIL_URL = "API_PRODUCT_DETAIL_URL";

        /**商品收藏*/
        public static final String API_PRODUCT_FAVORITE_URL = "API_PRODUCT_FAVORITE_URL";

        /**商品取消收藏*/
        public static final String API_CANCEL_FAVORITE_PRODUCT_URL = "API_CANCEL_FAVORITE_PRODUCT_URL";

        /**商品取消收藏或收藏*/
        public static final String API_PRODUCT_FAVORITE_OR_DEL_URL = "API_PRODUCT_FAVORITE_OR_DEL_URL";

        /**商品收藏列表*/
        public static final String API_FAVORITE_PRODUCT_URL = "API_FAVORITE_PRODUCT_URL";

        /**商品加入购物车*/
        public static final String API_CART_ADD = "API_CART_ADD";

        /**商品购物车信息*/
        public static final String API_CART_INFO = "API_CART_INFO";

        /**商品购物车修改*/
        public static final String API_CART_MODIFY = "API_CART_MODIFY";

        /**商品购物车移除*/
        public static final String API_CART_REMOVE = "API_CART_REMOVE";

        /**商品购物车结算*/
        public static final String API_CART_CHECK_OUT = "API_CART_CHECK_OUT";

        /**订单列表*/
        public static final String API_ORDER_LIST_URL = "API_ORDER_LIST_URL";

        /**退换货*/
        public static final String API_ORDER_EXCHANGE_LIST_URL = "API_ORDER_EXCHANGE_LIST_URL";

        /**退换货详情*/
        public static final String API_ORDER_EXCHANGE_DETAIL_URL = "API_ORDER_EXCHANGE_DETAIL_URL";

        /**退换货申请列表*/
        public static final String API_ORDER_APPLY_EXCHANGE_LIST_URL = "API_ORDER_APPLY_EXCHANGE_LIST_URL";

        /**添加退换货申请*/
        public static final String API_ORDER_EXCHANGE_ADD_URL = "API_ORDER_EXCHANGE_ADD_URL";

        /**添加物流信息*/
        public static final String API_ADD_SHIP_COMPANY_URL = "API_ADD_SHIP_COMPANY_URL";


        /**添加退换货申请提交*/
        public static final String API_ORDER_EXCHANGE_ADD_SUBMIT_URL = "API_ORDER_EXCHANGE_ADD_SUBMIT_URL";


        /**订单列表详情*/
        public static final String API_ORDER_DETAIL_URL = "API_ORDER_DETAIL_URL";

        /**订单创建*/
        public static final String API_ORDER_CREATE_URL = "API_ORDER_CREATE_URL";


        /**订单收货*/
        public static final String API_ORDER_RECEIVE_URL = "API_ORDER_RECEIVE_URL";

        /**订单取消*/
        public static final String API_ORDER_CANCEL_URL = "API_ORDER_CANCEL_URL";


        /**公司信息*/
        public static final String API_COMPANY_INFO_URL = "API_COMPANY_INFO_URL";

        /**公司信息保存*/
        public static final String API_COMPANY_INFO_SAVE_URL = "API_COMPANY_INFO_SAVE_URL";

    }


    /**经销商个人中心模块*/
    public static final class DEALERCENTER{
        /**更新头像*/
        public static final String API_MY_UPDATE_AVATAR_URL = "API_MY_UPDATE_AVATAR_URL";

    }

    /**
     * 业务员
     */
    public static final class Salesman{

        /**客户订单排行*/
        public static final String API_SALESMAN_LIST_INDEX_URL = "API_SALESMAN_LIST_INDEX_URL";

        /**商品分类排行*/
        public static final String API_SALESMAN_CHART_INDEX_URL = "API_SALESMAN_CHART_INDEX_URL";

        /**商品详情*/
        public static final String API_SALESMEMBER_PRODUCT_DETAIL_URL = "API_SALESMEMBER_PRODUCT_DETAIL_URL";


        /**个人中心*/
        public static final String API_SALESMAN_CENTER_URL = "API_SALESMAN_CENTER_URL";

        /**提现记录*/

        public static final String API_SALESMAN_WITHDRAL_LIST_URL = "API_SALESMAN_WITHDRAL_LIST_URL";

        /**添加提现申请*/

        public static final String API_SALESMAN_WITHDRAW_ADD_URL = "API_SALESMAN_WITHDRAW_ADD_URL";

        /**更新头像*/
        public static final String API_UPDATE_HEAD_IMAGE_URL = "API_UPDATE_HEAD_IMAGE_URL";

        /**业务员发展的经销商列表*/
        public static final String API_SALESMAN_SALESMAN_LIST = "API_SALESMAN_SALESMAN_LIST";

        /**拜访记录列表*/
        public static final String API_SALESMAN_VISIT_RECORD_LIST_URL = "API_SALESMAN_VISIT_RECORD_LIST_URL";

        /**新增拜访记录*/
        public static final String API_SALESMAN_ADD_VISIT_RECORD_URL = "API_SALESMAN_ADD_VISIT_RECORD_URL";

        /**新增拜访后记录*/
        public static final String API_SALESMAN_ADD_AFTER_VISIT_RECORD_URL = "API_SALESMAN_ADD_AFTER_VISIT_RECORD_URL";

        /**业务员订单列表*/
        public static final String API_GET_SALES_ORDER_LIST_URL = "API_GET_SALES_ORDER_LIST_URL";

        /**申请特价*/
        public static final String API_ADD_SPECIAL_PRICE_RECORD = "API_ADD_SPECIAL_PRICE_RECORD";

        /**个性签名*/
        public static final String API_EDIT_SIGNATURE_URL = "API_EDIT_SIGNATURE_URL";

        /**业务表现和历史明细*/
        public static final String API_SALESMAN_ACHIEVEMENT_AND_HISTORY_URL = "API_SALESMAN_ACHIEVEMENT_AND_HISTORY_URL";

        /**今日统计*/
        public static final String API_SALESMAN_TODAY_STATISTIC_URL = "API_SALESMAN_TODAY_STATISTIC_URL";

        /**区域经理拜访列表*/
        public static final String API_SALESMAN_MANAGER_VISIT_RECORD_LIST_URL = "API_SALESMAN_MANAGER_VISIT_RECORD_LIST_URL";

        /**区域经理获取业务员列表*/
        public static final String API_SALESMAN_MANAGER_SALES_LIST = "API_SALESMAN_MANAGER_SALES_LIST";

        /**区域经理-业务员客户列表*/
        public static final String API_SALESMAN_MANAGER_CUSTOM_LIST = "API_SALESMAN_MANAGER_CUSTOM_LIST";

    }

    /**
     * 供应商
     */

    public static final class Supplier{
        /**首页-获取订单金额*/
        public static final String API_SUPPLIER_INDEX_GET_ORDER_AMOUNT_URL = "API_SUPPLIER_INDEX_GET_ORDER_AMOUNT_URL";
        /**首页-获取收款金额*/
        public static final String API_SUPPLIER_INDEX_GET_PAYMENT_AMOUNT_URL = "API_SUPPLIER_INDEX_GET_PAYMENT_AMOUNT_URL";
        /**首页-获取折线图数据*/
        public static final String API_SUPPLIER_INDEX_BUSINESS_TREND_URL = "API_SUPPLIER_INDEX_BUSINESS_TREND_URL";
        /**首页-获取排行数据*/
        public static final String API_SUPPLIER_INDEX_ORDER_PRODUCT_URL = "API_SUPPLIER_INDEX_ORDER_PRODUCT_URL";

        /**个人中心*/
        public static final String API_SUPPLIER_CENTER_URL = "API_SUPPLIER_CENTER_URL";
        /**更新头像*/
        public static final String API_SUPPLIER_UPDATE_HEAD_IMAGE_URL = "API_SUPPLIER_UPDATE_HEAD_IMAGE_URL";
        /**修改公司信息*/
        public static final String API_SUPPLIER_SAVE_COMPANY_INFO_URL = "API_SUPPLIER_SAVE_COMPANY_INFO_URL";

        /**商品列表*/
        public static final String API_SUPPLIER_GOOD_LIST_URL = "API_SUPPLIER_GOOD_LIST_URL";

        /**商品详情*/
        public static final String API_SUPPLIER_GOOD_DETAIL_URL = "API_SUPPLIER_GOOD_DETAIL_URL";

        /**订单列表*/
        public static final String API_SUPPLIER_ORDER_LIST_URL = "API_SUPPLIER_ORDER_LIST_URL";

        /**订单详情*/
        public static final String API_SUPPLIER_ORDER_DETAIL_URL = "API_SUPPLIER_ORDER_DETAIL_URL";

        /**订单详情-商品清单*/
        public static final String API_SUPPLIER_ORDER_DETAIL_GOOD_LIST_URL = "API_SUPPLIER_ORDER_DETAIL_GOOD_LIST_URL";

        /**订单详情-发货记录*/
        public static final String API_SUPPLIER_ORDER_DETAIL_SHIP_LIST_URL = "API_SUPPLIER_ORDER_DETAIL_SHIP_LIST_URL";


    }

}
