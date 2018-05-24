package com.sx.common_base.util;

/**
 * Created by Jack on 2016/7/26.
 * 功能模块配置文件
 */
public class ViewConfigs{

    public static final String LAYOUT_TYPE_IMAGE = "image";

    public static final String LAYOUT_TYPE_ANNOUNCEMENT = "announcement";

    public static final String LAYOUT_TYPE_APP_CENTER = "app_center";

    public static final String LAYOUT_TYPE_ACTIVITY = "activity";

    public static final String LAYOUT_TYPE_TITLE_CENTER = "title";

    public static final String LAYOUT_TYPE_SEPARATOR = "separator";

    public static final String LAYOUT_TEXT_ALIGN_CENTER = "center";

    public static final String LAYOUT_TEXT_ALIGN_LEFT = "left";

    public static final String LAYOUT_TYPE_COUPON = "coupon";



    public static final String PARAM_LAYOUT_TEMPLATE_CODE = "layoutTemplateCode";
    public static final String PARAM_LAYOUT_CODE = "layoutCode";
    public static final String PARAM_CONTENT = "content";
    public static final String PARAM_ATTR = "attr";

    public static final String TEMPLATE_CODE_00 = "00";
    public static final String TEMPLATE_CODE_01 = "01";
    public static final String TEMPLATE_CODE_02 = "02";
    public static final String TEMPLATE_CODE_03 = "03";
    public static final String TEMPLATE_CODE_04 = "04";
    public static final String TEMPLATE_CODE_05 = "05";
    public static final String TEMPLATE_CODE_06 = "06";
    public static final String TEMPLATE_CODE_07 = "07";
    public static final String TEMPLATE_CODE_08 = "08";
    public static final String TEMPLATE_CODE_09 = "09";
    public static final String TEMPLATE_CODE_10 = "10";
    public static final String TEMPLATE_CODE_11 = "11";
    public static final String TEMPLATE_CODE_12 = "12";

    public static final String IP_MAOWO_APP_GOOD_SHOW_PARAMS = "maowo://apps.mw/goods/show?goodsId=";
    public static final String IP_MAOWO_APP_STORE_SHOW_PARAMS = "maowo://apps.mw/store/show?storeId=";
    public static final String IP_MAOWO_APP_MEMBERCARD_SHOW_PARAMS = "maowo://apps.mw/mall/membercard/me?mallId=";
    public static final String IP_MAOWO_APP_BOX_SHOW_PARAMS = "maowo://apps.mw/box/show?boxId=";
    public static final String IP_MAOWO_APP_STORE_SUBJECT = "maowo://apps.mw/store_subject/show?subjectId=";
    public static final String IP_MAOWO_APP_SKILL_SHOW_PARAMS = "maowo://apps.mw/skill/show?skillId=";
    public static final String IP_MAOWO_APP_APPOINTMENT_SHOW_PARAMS = "maowo://apps.mw/appointment/show?appointmentId=";
    public static final String IP_MAOWO_APP_SEEK_HELP_SHOW_PARAMS = "maowo://apps.mw/seek_help/show?seekHelpId=";
    public static final String IP_MAOWO_APP_ORDER_SHOW_PARAMS = "maowo://apps.mw/order/show?orderId=";


    public static final String IP_MAOWO_APP_ADD_CART_PARAMS = "maowo://apps.mw/cart/item/add?";

    public static final String IP_MAOWO_APP_ORDER_ME = "maowo://apps.mw/order/me";
    public static final String IP_MAOWO_APP_ATTENTION_ME = "maowo://apps.mw/attention/me";
    public static final String IP_MAOWO_APP_GOODS_TICKET_ME = "maowo://apps.mw/goods_ticket/me";
    public static final String IP_MAOWO_APP_ACTIVITY_ME = "maowo://apps.mw/activity/me";
    public static final String IP_MAOWO_APP_APPOINTMENT_ME = "maowo://apps.mw/appointment/me";
    public static final String IP_MAOWO_APP_DELIVER_ADDRESS_ME = "maowo://apps.mw/deliver_address/me";
    public static final String IP_MAOWO_APP_CART_ME = "maowo://apps.mw/cart/show";





    public static final String getGoodShowParamsIP(Long goodID) {
        return IP_MAOWO_APP_GOOD_SHOW_PARAMS + String.valueOf(goodID);
    }

    public static final String getStoreShowParamsIP(Long storeId) {
        return IP_MAOWO_APP_STORE_SHOW_PARAMS + String.valueOf(storeId);
    }

    public static final String getBoxShowParamsIP(Long boxId) {
        return IP_MAOWO_APP_BOX_SHOW_PARAMS + String.valueOf(boxId);
    }

    public static final String getMemberCardShowParamsIP(Long memberCardId) {
        return IP_MAOWO_APP_MEMBERCARD_SHOW_PARAMS + memberCardId;
    }

    public static final String getSkillParamsIP(Long skillId) {
        return IP_MAOWO_APP_SKILL_SHOW_PARAMS + String.valueOf(skillId);
    }

    public static final String getAppointmPentIP(Long appoinId) {
        return IP_MAOWO_APP_APPOINTMENT_SHOW_PARAMS + String.valueOf(appoinId);
    }

    public static final String getSeekHelpIP(Long skId) {
        return IP_MAOWO_APP_SEEK_HELP_SHOW_PARAMS + String.valueOf(skId);
    }

    public static final String getCouponIP(Long skId) {
        return IP_MAOWO_APP_SEEK_HELP_SHOW_PARAMS + String.valueOf(skId);
    }

    public static final String getStoreSubjectIP(Long storeId) {
        return IP_MAOWO_APP_STORE_SUBJECT + String.valueOf(storeId);
    }


    public static final String JUMP_PATH_GOODS = "/goods/show";
    public static final String JUMP_PATH_STORE = "/store/show";
    public static final String JUMP_PATH_MEMBER_CARD = "/mall/membercard/me";
    public static final String JUMP_PATH_STORE_SUBJECT = "/store_subject/show";
    public static final String JUMP_PATH_BOX = "/box/show";
    public static final String JUMP_PATH_LOGIN = "/login";
    public static final String JUMP_PATH_SEEK_HELP = "/seek_help/show";
    public static final String JUMP_PATH_APPOINTMENT = "/appointment/show";
    public static final String JUMP_PATH_SKILL = "/skill/show";
    public static final String JUMP_PATH_COUPON = "/coupon/show";
    public static final String JUMP_PATH_CART_ME = "/cart/show";
    public static final String JUMP_PATH_CART_ADD = "/cart/item/add";
    public static final String JUMP_PATH_ORDER_ME = "/order/me";
    public static final String JUMP_PATH_ATTENTION_ME = "/attention/me";
    public static final String JUMP_PATH_GOODS_TICKET_ME = "/goods_ticket/me";
    public static final String JUMP_PATH_ACTIVITY_ME = "/activity/me";
    public static final String JUMP_PATH_APPOINTMENT_ME = "/appointment/me";
    public static final String JUMP_PATH_DELIVER_ADDRESS_ME = "/deliver_address/me";
    public static final String JUMP_PATH_COUPON_ME = "/coupon/me";
    public static final String JUMP_PATH_ORDER_SHOW = "/order/show";
    public static final String JUMP_PATH_COUPON_USED = "/coupon/me_used";
    public static final String JUMP_PATH_TICKET_USED = "/goods_ticket/me_used";
    public static final String JUMP_PATH_MALL_NOTIFICATION = "/mall/notification";


    public static final String JUMP_PARAMS_GOODS = "goodsId";
    public static final String JUMP_PARAMS_STORE = "storeId";
    public static final String JUMP_PARAMS_MALL = "mallId";
    public static final String JUMP_PARAMS_STORE_SUBJECT = "subjectId";
    public static final String JUMP_PARAMS_BOX = "boxId";
    public static final String JUMP_PARAMS_REDIRECT_URL = "redirectUrl";
    public static final String JUMP_PARAMS_APPOINTMENT= "appointmentId";
    public static final String JUMP_PARAMS_SEEK_HELP= "seekHelpId";
    public static final String JUMP_PARAMS_SKILL= "skillId";
    public static final String JUMP_PARAMS_COUPON_ID = "couponId";
    public static final String JUMP_PARAMS_PROMOTION_TYPE = "promotionType";
    public static final String JUMP_PARAMS_PROMOTION_ID = "promotionId";
    public static final String JUMP_PARAMS_GOODS_ID = "goodsId";
    public static final String JUMP_PARAMS_COUNT = "count";
    public static final String JUMP_PARAMS_ACTIVITY_TYPE = "activityType";
    public static final String JUMP_PARAMS_ACTIVITY_ID = "activityId";
    public static final String JUMP_PARAMS_SOURCE_PROMOTION_TYPE = "sourcePromotionType";
    public static final String JUMP_PARAMS_SOURCE_PROMOTION_ID = "sourcePromotionId";
    public static final String JUMP_PARAMS_ORDER_ID = "orderId";


    public static final String JUMP_PROTOCOL_MAOWO = "maowo";
    public static final String JUMP_PROTOCOL_HTTP = "http";
    public static final String JUMP_PROTOCOL_HTTPS = "https";

    //店铺首页 布局类型
    public static final String LAYOUT_TYPE_GOODS = "goods";
    public static final String LAYOUT_TYPE_TEXT_LINK = "title";
    public static final String LAYOUT_TYPE_SLABA = "slaba";
    public static final String LAYOUT_TYPE_IMAGE_LINK = "image_link";
    public static final String LAYOUT_TYPE_COUPONS = "coupon";
    public static final String LAYOUT_TYPE_PHONE = "phone";

    //主题馆 布局类型
    public static final String LAYOUT_TYPE_IMAGE_BANNER = "image_banner";
    public static final String LAYOUT_TYPE_IMAGE_TEXT = "image_text";
    public static final String LAYOUT_TYPE_IMAGE_TITLE = "image_title";
    public static final String LAYOUT_TYPE_IMAGE_STORE = "image_store";
    public static final String LAYOUT_TYPE_MORE_BRAND = "more_brand";


}
