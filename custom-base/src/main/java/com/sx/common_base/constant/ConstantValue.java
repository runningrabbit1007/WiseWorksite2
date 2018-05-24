package com.sx.common_base.constant;

/**
 * Author : Jack
 * Email  : jackzhonglyy@outlook.com
 * Date   : 2016/8/3
 * Desc   : 一些常量值
 */
public class ConstantValue{

    /**
     * "${indexUrl}"
     */
    public static final String INDEX_PLACEHOLDER = "${indexUrl}";

    public static final String NET_METHOD_GET = "GET";
    public static final String NET_METHOD_POST = "POST";

    public static final String DEF_CAPTCHA = "100860";
    public static final String EMPTYREQUSET = "{}";
    public static final String EMPTY_STR = "";

    public static final String DATA_FROM_MM_DD = "MM-dd";

    public static final int C1001 = 1001;
    public static final int C1002 = 1002;
    public static final int C1003 = 1003;
    public static final int C1004 = 1004;
    public static final int C1005 = 1005;
    public static final int C1006 = 1006;

    public static final int SEX_MAN = 1;
    public static final int SEX_WOMAN = 0;
    public static final int SEX_SECRECY = 2;

    public static final int YES_INT_TAG = 1;
    public static final int NO_INT_TAG = 0;
    public static final int EMPTY_CODE = 0;

    public static final String DATA = "data";
    public static final String VERSION = "version";
    public static final String UPDATE = "updated";

    public static final String EXTRA_CHAT_TYPE = "chatType";
    public static final String EXTRA_USER_ID = "userId";

    public static final int CHANNEL_TYPE_0 = 0;
    public static final int CHANNEL_TYPE_1 = 1;
    public static final int CHANNEL_TYPE_2 = 2;
    public static final int CHANNEL_TYPE_3 = 3;

    public static final int CHATTYPE_SINGLE = 1;
    public static final int CHATTYPE_GROUP = 2;
    public static final int CHATTYPE_CHATROOM = 3;
    public static final int CHATTYPE_SKILL_STRANGER = 4;

    public static final String SOCIALHISTORY = "SocialHistory";
    public static final String GOODSHISTORY = "GoodsHistory";
    public static final String STORYHISTORY = "StoryHistory";

    public static final String CONDITIONTYPE1 = "满%s元可用";
    public static final String CONDITIONTYPE2 = "满%s件可用";
    public static final String COUPONSDATE = "{0} - {1}";
    public static final String ZHEKOUQUAN = "%s折";
    public static final String NUMBER = "NO: %s";
    public static final String address = "收货地址: %s";
    public static final String addressPerson = "收货人: %s";
    public static final String transportation = "运费(%s）";
    public static final String totalGoods = "共%s件";
    public static final String goodsNumber = "x %s";
    public static final String totalPostage = "运费%s元";
    public static final String totalPostageType = "订单满%s元免邮";
    public static final String questonNumber = "提问（%s条）";
    public static final String getGfitnumber = "已领取%s/%s件";
    public static final String NeedSubscribe = "至少提前%s小时";
    public static final String TotalQaList = "关于“{0}”的{1}个问题";
    public static final String Bracket = "(%s)";
    public static final String searchNumber = "%s条约吧信息";
    public static final String searchChatNumber = "%s条相关聊天记录";
    public static final String LocalCity = "当前已定位城市：%s";
    public static final String transportState = "物流状态：%s";
    public static final String transportCompany = "物流公司：%s";
    public static final String transportNumber = "运单编号：%s";
    public static final String goodsCount = "%s件商品";
    public static final String sendPhone = "发送提货码到我的手机(%s)";
    public static final String totalPrice = "总计: %s";

    public static final String CMD_TYPE_AVATAR = "AVATAR";
    public static final String CMD_TYPE_NAME = "NAME";
    public static final String CMD_TYPE_OTHER = "OTHER";

    public static final String PRE_MALL_ID = "pre/mall/id";

    public final class other{
        public static final int SEARCH_TYPE_MAIN = 3;
        public static final int SEARCH_TYPE_GOODS_LIST = 4;

        public static final int C1001 = 1001;
        public static final int C1002 = 1002;
        public static final int C1003 = 1003;
    }

    public final class App {
        // 是否是调试阶段
        public static final boolean IS_DEBUGE = true;
        // 请求数据条数（page size）
        public static final int PAGE_SZIE = 8;

        public static final String DESCRIPTOR = "com.umeng.share";

        // -------------------第三方登陆参数 start-------------------
        public static final String QQ_APP_ID = "1104504049";
        public static final String QQ_APP_KEY = "X6XZuVddSmDAgsPa";

        // 注意：在微信授权的时候，必须传递appSecret
        // wx967daebe835fbeac是你在微信开发平台注册应用的AppID, 这里需要替换成你注册的AppID
        public static final String WX_APP_ID = "wx967daebe835fbeac";
        public static final String WX_APP_SECRET = "5bb696d9ccd75a38c8a0bfe0675559b3";
        // -------------------第三方登陆参数 end-------------------

    }

    public final class Share {
//		public final int DEFAULT_ICON = R.drawable.publish_map;
    }

    public final class MyMessageType {
        public static final String LABOUR_ORDER_DETAIL = "labour_order_detail";
        public static final String EXPERT_TECH_ORDER_DETAIL = "expert_tech_order_detail";
        public static final String MY_TECH_ORDER_DETAIL = "my_tech_order_detail";
        public static final String MATERIAL_DETAIL_URL = "material_order_detail";
    }

    /**
     * 访问路径（接口）
     */
    public final class UrlAddress {
        // 主域名
        public static final String MAIN_URL = "http://v2.ffu365.com";

        public static final String MAIN_URL_V3 = "https://v3.ffu365.com";

        public static final String MAIN_URL_V4 = "http://v4.ffu365.com";
        // public static final String MAIN_URL ="http://192.168.1.199";

        // 首页前面数据获取
        public static final String REQUEST_HOME_DATA_URL = "/index.php?m=Api&c=Index&a=home";

        // 首页下面找服务获取
        public static final String HOME_FIND_SERVICE_URL = "/index.php?m=Api&c=Home&a=homeServiceList";

        // 首页下面找团队获取
        public static final String HOME_FIND_TEAM_URL = "/index.php?m=Api&c=Home&a=homeTeamList";

        // 首页下面找人才获取
        public static final String HOME_FIND_TALENTS_URL = "/index.php?m=Api&c=Home&a=homeResumeList";

        // 获取服务列表
        public static final String REQUEST_SERVICE_LIST_URL = "/index.php?m=Api&c=Service&a=serviceList";

        // 获取所有字典项
        public static final String UPDATE_DICT_DATA_URL = "/index.php?m=Api&c=Util&a=updateDict";

        // 帅选价格区间
        public static final String SCREEN_PRICE_RANGE_URL = "/index.php?m=Api&c=Util&a=price";

        // 获取工人列表数据
        public static final String REQUEST_WORKER_LIST_URL = "/index.php?m=Api&c=Worker&a=workerList";

        // 获取团队列表数据
        public static final String REQUEST_TEAM_LIST_URL = "/index.php?m=Api&c=Team&a=teamList";

        // 请求团队详情
        public static final String REQUEST_TEAM_DETAIL_URL = "/index.php?m=Api&c=Team&a=teamBase";

        // 服务详情
        public static final String REQEST_SERVICE_DETAIL_URL = "/index.php?m=Api&c=Service&a=serviceBase";

        // 用户添加收藏
        public static final String USER_COLLECT_ADD_URL = "/index.php?m=Api&c=Favorite&a=addFavorite";

        // 用户取消收藏
        public static final String USER_COLLECT_CANCLE_URL = "/index.php?m=Api&c=Favorite&a=cancelFavorite";

        // 用户登录
        public static final String USER_LOGIN_URL = "/index.php?m=Api&c=Member&a=login";

        // 用户收藏的列表
        public static final String USER_COLLECT_LIST_DATA_URL = "/index.php?m=Api&c=Favorite&a=favoriteList";

        // 用户注册
        public static final String USER_REGISTER_URL = "/index.php?m=Api&c=Member&a=register";

        // 快捷登录
        public static final String USER_FAST_LOGIN_URL = "/index.php?m=Api&c=Member&a=verifycodeLogin";

        // 人才详情
        public static final String TALENTS_DETAL_URL = "/index.php?m=Api&c=Resume&a=resumeBase";

        // 获取金币账单
        public static final String REQUEST_BILL_LIST_URL = "/index.php?m=Api&c=Member&a=coinRecord";

        // 获取钱包账单
        public static final String REQUEST_MONEY_BILL_LIST_URL = "/index.php?m=Api&c=Wallet&a=balanceRecord";

        // 查看订单节点详情
        public static final String ORDER_REC_DETAIL_URL = "/index.php?m=Api&c=ServiceOrder&a=orderServiceNode";

        // 订单详情
        public static final String ORDER_DETAIL_URL = "/index.php?m=Api&c=ServiceOrder&a=orderDetail";

        // 订单服务评价
        public static final String SERVICE_EVALUATE_URL = "/index.php?m=Api&c=ServiceOrder&a=commentOrder";

        // 获取验证码
        public static final String USER_CODE_URL = "/index.php?m=Api&c=Util&a=sendVerifyCode";

        // 完成交易操作
        public static final String FINISH_ORDER_SERVICE_URL = "/index.php?m=Api&c=ServiceOrder&a=finishOrderService";

        // 请求服务评价
        public static final String REQUEST_SERVICE_COMMENT_LIST_DATA = "/index.php?m=Api&c=Service&a=serviceComment";

        // 上传用户头像
        public static final String UPLOAD_USER_HEAD_IMAGE = "/index.php?m=Api&c=Member&a=userUploadAvatar";

        // 发布工人简历
        public static final String SUBMIT_RESUME_APPLY_INFOR_URL = "/index.php?m=Api&c=Worker&a=publishWorker";

        // 编辑简历
        public static final String EDIT_RESUME_URL = "/index.php?m=Api&c=Resume&a=editResume";

        // 请求个人信息
        public static final String REQUEST_PERSONAL_INFOR = "/index.php?m=Api&c=Member&a=memberInfo";

        // 修改用户资料
        public static final String COMPLETE_MEMBER_INFO = "/index.php?m=Api&c=Member&a=memberInfoComplete";

        // 提交用户建议
        public static final String SUBMIT_SUGGEST_COTENT = "/index.php?m=Api&c=Util&a=feedback";

        // 消息列表
        public static final String MESSAGE_LIST_URL = "/index.php?m=Api&c=Message&a=MessageList";

        // 消息列表是否有未读
        public static final String CHECK_MESSAGE_STATUS_URL = "/index.php?m=Api&c=Message&a=newMessage";

        // 消息详情
        public static final String MESSAGE_DETAIL_URL = "/index.php?m=Api&c=Message&a=MessageDetail";

        // 删除消息
        public static final String DELETE_MESSAGE_URL = "/index.php?m=Api&c=Message&a=deleteMessage";

        // 消息置为已读
        public static final String MESSAGE_READED_URL = "/index.php?m=Api&c=Message&a=readMessage";

        // 用户找回密码
        public static final String USER_FIND_PASSWORD_URL = "/index.php?m=Api&c=Member&a=findPassword";

        // 用户修改密码
        public static final String USER_EXCHANGE_PASSWORD_URL = "/index.php?m=Api&c=Member&a=modifyPassword";

        // 我的评论
        public static final String MY_COMMENT_LIST_URL = "/index.php?m=Api&c=ServiceOrder&a=commentList";

        // 新版本检测
        public static final String NEW_VERSION_UPDATE_URL = "/index.php?m=Api&c=Util&a=newVersion";

        // 工龄区间
        public static final String SCREEN_EXPERIENCE_RANGE_URL = "/index.php?m=Api&c=Util&a=experience";

        // // 关闭或者打开简历操作
        // public static final String SWITCH_RESUME_URL =
        // "/index.php?m=Api&c=Worker&a=switchResume";
        // 这两个接口将会关闭
        // // 关闭或者打开团队操作
        // public static final String SWITCH_TEAM_URL =
        // "/index.php?m=Api&c=TeamCenter&a=switchTeam";

        // 单张图片的上传
        public static final String MULTIPLE_SINGLE_UPLOAD_IMAGE_URL = "/index.php?m=Api&c=Upload&a=multipleUploadImg";

        // 提交申请团队
        public static final String SUBMIT_TEAM_APPLY_INFOR_URL = "/index.php?m=Api&c=TeamCenter&a=publishTeam";

        // 保存团队申请的信息
        public static final String SAVE_TEAM_APPLY_INFOR_URL = "/index.php?m=Api&c=TeamCenter&a=saveTeam";

        // 保存工人申请的信息
        public static final String SAVE_RESUME_APPLY_INFOR_URL = "/index.php?m=Api&c=Worker&a=saveWorker";

        // 获取已提交的团队信息
        public static final String RQUEST_SELF_PUBLISH_TEMA_INFO = "/index.php?m=Api&c=TeamCenter&a=selfTeamDetail";

        // 团队管理中心判断信息
        public static final String TEMA_MANAGE_JUDGE_INFO_URL = "/index.php?m=Api&c=TeamCenter&a=Home";

        // 第三方支付
        public static final String THRID_PAY_URL = "/index.php?m=Api&c=Payment&a=prepareToPay";

        // 我发布的工程列表
        public static final String MY_PUBLISH_PROJECT_LIST_URL = "/index.php?m=Api&c=MemberCenter&a=selfProjectJobList";

        // 找活列表
        public static final String REQUEST_ACTIVE_LIST_URL = "/index.php?m=Api&c=Project&a=projectList";

        // 工程信息详情
        public static final String MY_ACTIVE_DETAL_URL = "/index.php?m=Api&c=ProjectCenter&a=selfJobDetail";

        // 重新付款
        public static final String RESUBMIT_ORDER_LIST_URL = "/index.php?m=Api&c=Payment&a=repayInfoFee";

        // 申请加入工程
        public static final String APPLY_PROJECT_URL = "/index.php?m=Api&c=Project&a=projectSignUp";

        // 提交现场查勘人员
        public static final String SUBMIT_SITE_SURVEYMEMBER_URL = "/index.php?m=Api&c=ServiceOrder&a=addOrderWorker";

        // 请求报名活动列表数据
        public static final String REQUEST_APPLY_ACTIVE_LIST_URL = "/index.php?m=Api&c=Project&a=getProjectOrderList";

        // 支付现场查勘费
        public static final String BOSS_AFFIRM_SITESURVEY_FEE_URL = "/index.php?m=Api&c=Payment&a=agreeToPay";

        // 获取查勘人员信息
        public static final String AFFIRM_SITESURVEY_MEMBER_INFO_URL = "/index.php?m=Api&c=ServiceOrder&a=getOrderWorker";

        // 计算支付费用
        public static final String CALCULATE_PAYMENT_FEE_URL = "/index.php?m=Api&c=Payment&a=calcPaymentFee";

        // 支付查勘或是试工费用
        public static final String BEFORE_PREPARE_TO_PAY = "/index.php?m=Api&c=Payment&a=beforePrepareToPay";

        // 重新支付查勘或是试工费用
        public static final String REPAY_PREPARE_TO_PAY = "/index.php?m=Api&c=Payment&a=generalRepay";

        // 得到查勘或者试工人员列表
        public static final String GET_MEMBER_LIST_URL = "/index.php?m=Api&c=ServiceOrder&a=getGoodsWorkers";

        // 获取通用数据介绍
        public static final String REQUEST_GENERAL_INTRODUCTION_URL = "";

        // 老板否认支付费用
        public static final String BOSS_DENY_PAY_FEE_URL = "/index.php?m=Api&c=Payment&a=disAgreeToPay";

        // 无忧币支付
        public static final String FFU365_PAY_URL = "/index.php?m=Api&c=Payment&a=ffu365Pay";

        // 购买无忧币
        public static final String COIN_PREPARE_TOPAY_URL = "/index.php?m=Api&c=Payment&a=coinPrepareToPay";

        // 无忧币消费记录
        public static final String EASY_MONEY_CONSUMPTION_LIST_URL = "/index.php?m=Api&c=Member&a=memberCoin";

        // 二次支付（无忧币购买费）
        public static final String REPAY_EASY_MONEY_FEE_URL = "/index.php?m=Api&c=Payment&a=repayCoinFee";

        // 取消订单
        public static final String CANCLE_ORDER_URL = "/index.php?m=Api&c=ServiceOrder&a=cancelOrder";

        // 评价关键字
        public static final String COMMET_KEY_URL = "/index.php?m=Api&c=Util&a=commentTags";

        // 评价提交
        public static final String COMEENT_SUBMIT_URL = "/index.php?m=Api&c=ServiceOrder&a=commentOrder";

        // 评论详情
        public static final String COMMET_DETAIL_URL = "/index.php?m=Api&c=ServiceOrder&a=commentDetail";

        // 添加支付工具施工人员信息
        public static final String GET_TOOLS_WORKER_URL = "/index.php?m=Api&c=Tools&a=getTeamWorkerList";

        // 获取已经发布的支付工具列表
        public static final String PAYMENT_TOOLS_LIST_URL = "/index.php?m=Api&c=Tools&a=paymentToolsList";

        // 支付工具详情
        public static final String PAYMENT_TOOL_DETAIL_URL = "/index.php?m=Api&c=Tools&a=paymentToolsBase";

        // APP获取打包的杂项文本，包含无忧币说明、查勘费说明、试工费说明
        public static final String ARTICLE_PACKAGE_URL = "/index.php?m=Api&c=Util&a=articlePackage";

        // 确实、否认支付工具
        public static final String SWITCH_PAYMENT_TOOLS_URL = "/index.php?m=Api&c=Tools&a=switchPaymentTools";

        // 完善支付工具信息
        public static final String UPDATE_PAYMENT_INFO_URL = "/index.php?m=Api&c=Tools&a=updatePaymentInfo";

        // 支付工具人员信息修改
        public static final String UPDATE_WORKER_LIST_URL = "/index.php?m=Api&c=Tools&a=updateWorkerList";

        // 修改支付工具信息
        public static final String EDIT_PAYMENT_INFO_URL = "/index.php?m=Api&c=Tools&a=editPaymentInfo";

        // 提交投诉订单的数据
        public static final String COMPLAIN_ORDER_URL = "/index.php?m=Api&c=ServiceOrder&a=complainOrder";

        // 线下支付
        public static final String OFFLINE_REPAY_URL = "/index.php?m=Api&c=Payment&a=offlineRepay";

        // 委托申请团队
        public static final String COMMISSIONED_APPLY_TEAM_URL = "/index.php?m=Api&c=TeamApply&a=addContactInfo";

        // 获取投诉信息
        public static final String REQUEST_COMPLAIN_INFO_URL = "/index.php?m=Api&c=ServiceOrder&a=complainOrderView";

        // 项目自动生成订单
        public static final String PROJECT_SELECT_ORDER_URL = "/index.php?m=Api&c=Project&a=projectOrder";

        // 获取支付工具付费列表
        public static final String GET_PAYMENTINFO_LIST_URL = "/index.php?m=Api&c=Tools&a=getPayInfo";

        // 确认和否认
        public static final String SWITCH_FINAL_SETTLEMENT_URL = "/index.php?m=Api&c=Tools&a=switchBalance";

        // 支付工具支付接口
        public static final String TOOLS_TO_PAY_URL = "/index.php?m=Api&c=Tools&a=toolsToPay";

        // 质量标准
        public static final String QUALITY_STANDARD_WAY_URL = "/index.php?m=Api&c=Util&a=qualityStandard";

        // 获取结算方式
        public static final String SETTLEMENT_WAY_URL = "/index.php?m=Api&c=Util&a=settlement";

        // 删除订单
        public static final String DELETE_ORDER_URL = "/index.php?m=Api&c=ServiceOrder&a=deleteOrder";

        // 首页行业资讯列表
        public static final String INFORMATION_INDUSTRY_URL = "/index.php?m=Api&c=News&a=newsList";

        // Insurance list url 保险订单列表
        public static final String INSURANCE_LIST_URL = "/index.php?m=Api&c=Insurance&a=insuranceList";

        // The policy staff list data
        public static final String REQUEST_INSURANCE_MEMBER_URL = "/index.php?m=Api&c=Insurance&a=submitInsuranceView";

        // Submit 保单，得到支付票据
        public static final String SUBMIT_ACCIDENT_INSURANCE_URL = "/index.php?m=Api&c=V2Payment&a=submitInsuranceOrder";

        // To get the policy details
        public static final String INSURANCE_DETAIL_URL = "/index.php?m=Api&c=Insurance&a=insuranceDetail";

        // 动态获取保单人员名单列表
        public static final String DYNAMIC_REQUEST_INSURANCE_MEMBER_URL = "/index.php?m=Api&c=Insurance&a=workerList";

        // 保险的二次支付
        public static final String INSURANCE_REPAY_URL = "/index.php?m=Api&c=Payment&a=insuranceRepay";

        // 支付保险费，预支付
        public static final String INSURANCE_PREPARETOPAY_URL = "/index.php?m=Api&c=Payment&a=insurancePrepareToPay";

        // 获取交流列表数据
        public static final String REQUEST_COMMLIST_URL = "/index.php?m=Api&c=Topic&a=topicList";

        // 发布技术主题
        public static final String PUBLISH_TECHNOLOGY_THEME_URL = "/index.php?m=Api&c=Topic&a=publishTopic";

        // 获取专家技术
        public static final String REQUEST_EXPERT_SKILL_URL = "/index.php?m=Api&c=Util&a=expertSkill";

        // 发布的技术主题详情
        public static final String TECHNOLOGY_THEME_DETAIL_URL = "/index.php?m=Api&c=Topic&a=topicBase";

        // 删除主题评论
        public static final String DELETE_THEME_URL = "/index.php?m=Api&c=Topic&a=deleteTopicReply";

        // 新增技术交流主题回复
        public static final String REPLY_TECHNOLOGY_THEME_URL = "/index.php?m=Api&c=Topic&a=replyTopic";

        // 获取专家申请信息
        public static final String REQUEST_EXPERT_APPLYINFO_URL = "/index.php?m=Api&c=Expert&a=getExpertBase";

        // 获取专家学历
        public static final String REQUEST_EXPERT_DEGREE_URL = "/index.php?m=Api&c=Util&a=degree";

        // 专家入住申请
        public static final String APPLY_EXPERT_URL = "/index.php?m=Api&c=Expert&a=applyExpert";

        // 专家撤销申请
        public static final String EXPERT_CANCLE_APPLY_URL = "/index.php?m=Api&c=Expert&a=cancelApply";

        // 修改入驻申请
        public static final String EDIT_APPLY_EXPERT_URL = "/index.php?m=Api&c=Expert&a=editApplyExpert";

        // 获取专家列表数据
        public static final String REQUEST_EXPERT_LIST_URL = "/index.php?m=Api&c=Expert&a=expertList";

        // 请求专家详情
        public static final String REQUEST_EXPERT_DETAIL_URL = "/index.php?m=Api&c=Expert&a=getExpertInfo";

        // 专家完善信息
        public static final String COMPLETE_EXPERT_INFO_URL = "/index.php?m=Api&c=Expert&a=saveInfo";

        // 发布需求
        public static final String PUBLISH_NEED_URL = "/index.php?m=Api&c=Demand&a=publishDemand";

        // 获取需求列表
        public static final String REQUEST_DEMAND_LIST_URL = "/index.php?m=Api&c=Demand&a=demandList";

        // 获取需求详情
        public static final String REQUEST_DEMAND_DETAIL_URL = "/index.php?m=Api&c=Demand&a=getDemandInfo";

        // 预支付advance payment
        public static final String ADVANCE_PAYMENT_URL = "/index.php?m=Api&c=V2Payment&a=ffuPrepareToPay";

        // 需求支付
        public static final String DEMAND_PAY_URL = "/index.php?m=Api&c=Payment&a=prepayDemand";

        // 获取我的需求列表
        public static final String REQUEST_MINE_DEMAND_LIST_URL = "/index.php?m=Api&c=Demand&a=getMyDemandList";

        // 取消需求信息
        public static final String CANCEL_DEMAND_URL = "/index.php?m=Api&c=Demand&a=cancelDemand";

        // 获取我发布的需求详情
        public static final String REQUEST_MINE_DEMAND_DETAIL_URL = "/index.php?m=Api&c=Demand&a=getMyDemandBase";

        // 编辑我的需求
        public static final String EDIT_MINE_DEMAND_URL = "/index.php?m=Api&c=Demand&a=editDemand";

        // 提交需求
        public static final String SUBMIT_DEMAND_ONETOONE_URL = "/index.php?m=Api&c=Demand&a=submitOrder";

        // 用户在抢单列表和需求详情中的下单操作
        public static final String BOOK_ORDER_URL = "/index.php?m=Api&c=Demand&a=demandDeal";

        // 获取技术板块订单列表
        public static final String REQUEST_TECHNOLOGY_ORDER_LIST_URL = "/index.php?m=Api&c=Demand&a=orderList";

        // 获取技术板块订单详情
        public static final String TECHNOLOGY_ORDER_DETAIL_URL = "/index.php?m=Api&c=Demand&a=orderDetails";

        // 技术订单二次支付
        public static final String TECHNOLOGY_ORDER_REPAY_URL = "/index.php?m=Api&c=Payment&a=repayDemand";

        // 打开、关闭专家省外服务按钮
        public static final String SWITCH_OUTSIDE_URL = "/index.php?m=Api&c=Expert&a=switchOutside";

        // 获取技术板块普通订单费用
        public static final String CALCULATE_DEMAND_FEE_URL = "/index.php?m=Api&c=Demand&a=calcDemandFee";

        // 打开、关闭专家服务按钮
        public static final String SWITCH_EXPERT_SERVICE_URL = "/index.php?m=Api&c=Expert&a=switchExpert";

        // request text description of the one to one order demand
        public static final String REQUEST_TEXT_DESCRIPTION_URL = "/index.php?m=Api&c=Demand&a=initDemandDesc";

        // Get earning list data of the expert
        public static final String REQUEST_EARNING_LIST_URL = "/index.php?m=Api&c=Expert&a=getEarningList";

        // 订单完成操作
        public static final String BOSS_SURE_COMPLETE_ORDER_URL = "/index.php?m=Api&c=Demand&a=confirmOrder";

        // 订单取消操作
        public static final String EXPERT_CANCLE_ORDER_URL = "/index.php?m=Api&c=Expert&a=cancelOrder";

        // 获取订单受理记录信息
        public static final String REQUEST_ACCPET_RECORD_URL = "/index.php?m=Api&c=Demand&a=getDemandDealList";

        // 获取我发布的主题列表
        public static final String REQUEST_MY_PUBLISH_THEME_LIST_URL = "/index.php?m=Api&c=Topic&a=getMyTopicList";

        // 获取我回复的帖子列表
        public static final String REQUEST_MY_REPLY_THEME_LIST_URL = "/index.php?m=Api&c=Topic&a=getMyReplyList";

        // 获取筛选和排序内容
        public static final String SORT_SCREEN_LIST_URL = "/index.php?m=Api&c=Util&a=sortAndFilterList";

        // 用户投诉功能路径
        public static final String COMPLAIN_GENERAL_URL = "/index.php?m=Api&c=Home&a=addComplain";

        // 删除需求信息
        public static final String DELETE_DEMAND_URL = "/index.php?m=Api&c=Demand&a=deleteDemand";

        // 初始化追加佣金界面
        public static final String INIT_ADDITIONAL_FEE_URL = "/index.php?m=Api&c=Demand&a=initExtraCost";

        // 需求追加佣金
        public static final String EXTRA_DEMAND_COST_URL = "/index.php?m=Api&c=Demand&a=extraDemandCost";

        // 技术板块删除订单
        public static final String TECHNOLOGY_DELETE_ORDER = "/index.php?m=Api&c=Demand&a=deleteOrder";

        // 技术板块取消订单
        public static final String TECHNOLOGY_CANCEL_ORDER = "/index.php?m=Api&c=Demand&a=cancelOrder";

        // 技术板块评价提交
        public static final String TECHNOLOGY_COMEENT_URL = "/index.php?m=Api&c=Home&a=addComment";

        // 技术板块的查看详情
        public static final String TECHNOLOGY_COMMENT_DETAIL_URL = "/index.php?m=Api&c=Demand&a=getCommentInfo";

        // 请求专家评价
        public static final String REQUEST_EXPERT_COMMENT_LIST_DATA = "/index.php?m=Api&c=Expert&a=getServiceList";

        // 检查配置项和字典版本
        public static final String CHECK_DATA_VERSION_STRING_INFO_URL = "/index.php?m=Api&c=Util&a=version";

        // 获取最新服务端配置项内容
        public static final String UPDATE_INNER_CONFIG_URL = "/index.php?m=Api&c=Util&a=updateConfig";

        // 上报客户端信息，包含极光推送ID和地理位置
        public static final String REPORT_CLIENT_INFORMATION_URL = "/index.php?m=Api&c=Util&a=report";

        // 用户上传身份证正反面照，进行认证
        public static final String USER_CERTIFICATION_URL = "/index.php?m=Api&c=Member&a=memberCertification";

        // 查看用户信息详情
        public static final String REQUEST_MEMBER_INFOR = "/index.php?m=Api&c=Member&a=memberInfoDetail";

        // 获取实名认证信息
        public static final String GET_NAME_CERTIFICATION_INFO_URL = "/index.php?m=Api&c=Member&a=certification";

        // 个人简历发布的信息
        public static final String RQUEST_SELF_PUBLISH_RESUME_INFO = "/index.php?m=Api&c=Worker&a=getResumeStatus";

        // 工人管理中心判断信息
        public static final String WORKER_MANAGE_JUDGE_INFO_URL = "/index.php?m=Api&c=Worker&a=home";

        // 工人简历发布信息初始化
        public static final String PUBLISH_PROJECT_INIT_INFO_URL = "/index.php?m=Api&c=Project&a=projectPublishInit";

        // 发布工程
        public static final String PROJECT_PUBLISH_URL = "/index.php?m=Api&c=Project&a=projectPublish";

        // 删除我发布的工程
        public static final String DELETE_MYPROJECT_URL = "/index.php?m=Api&c=Project&a=projectDelete";

        // 获得工程详情
        public static final String MYPROJECT_DETAIL_INFO_URL = "/index.php?m=Api&c=Project&a=getProjectInfo";

        // 发布招工信息
        public static final String RECRUITMENT_INFO_PUBLISH_URL = "/index.php?m=Api&c=Project&a=recruitmentPublish";

        // 获得更多正常招工信息
        public static final String MORE_RECRUITMENT_INFO_URL = "/index.php?m=Api&c=Project&a=getMoreRecruitment";

        // 获得更多异常招工信息
        public static final String MORE_ABNORMITY_INFO_URL = "/index.php?m=Api&c=Project&a=getMoreAbnormity";

        // 删除招工信息
        public static final String DELETE_RECRUITMENT_INFO_URL = "/index.php?m=Api&c=Project&a=recruitmentDelete";

        // 招工信息详情
        public static final String REC_DETAIL_INFO_URL = "/index.php?m=Api&c=Project&a=recruitmentInfo";

        // 发布招工信息
        public static final String PUBLISH_PROJECT_INFO_URL = "/index.php?m=Api&c=ProjectCenter&a=publishJob";

        // 获取用户金币主页数据
        public static final String MY_COIN_INFO_URL = "/index.php?m=Api&c=Member&a=coinHome";

        // 冲值金币列表信息
        public static final String RECHARGE_COIN_INFO_URL = "/index.php?m=Api&c=Member&a=coinSale";

        // 获取金币支付票据
        public static final String PAY_RECHARGE_COIN_URL = "/index.php?m=Api&c=V2Payment&a=coinPrepareToPay";

        // 支付招工信息
        public static final String PAY_RECRUITMENT_INFO_URL = "/index.php?m=Api&c=V2Payment&a=recCoinPay";

        // 工程列表
        public static final String PROJECT_LIST_URL = "/index.php?m=Api&c=Project&a=jobList";

        // 招工详情
        public static final String PROJECT_TEAM_DETAIL_URL = "/index.php?m=Api&c=Project&a=jobDetail";

        // 工人详情
        public static final String WORKER_DETAIL_URL = "/index.php?m=Api&c=Worker&a=workerDetail";

        // 团队详情
        public static final String TEAM_DETAIL_URL = "/index.php?m=Api&c=Team&a=teamDetail";

        // 获得附近的劳务信息
        public static final String ENVIRON_MAP_DATA_URL = "/index.php?m=Api&c=Environs&a=environsAll";

        // 出租设备
        public static final String PUBLISH_EQUIPMENT_RENT_URL = "/index.php?m=Api&c=DeviceCenter&a=publishRent";

        // 转让设备
        public static final String PUBLISH_EQUIPMENT_TRANSFER_URL = "/index.php?m=Api&c=DeviceCenter&a=publishSale";

        // 我的发布 设备列表
        public static final String SELF_EQUIPMENT_LIST_URL = "/index.php?m=Api&c=MemberCenter&a=selfDeviceList";

        public static final String SELF_EQUIPMENT_RENT_DETAIL_URL = "/index.php?m=Api&c=DeviceCenter&a=selfRentDetail";

        // 转让设备编辑界面数据
        public static final String SELF_EQUIPMENT_TRANSFER_DETAIL_URL = "/index.php?m=Api&c=DeviceCenter&a=selfSaleDetail";

        // 设备求购发布/编辑
        public static final String PUBLISH_EQUIPMENT_ASKBUY_URL = "/index.php?m=Api&c=DeviceCenter&a=publishAskSale";

        // 设备求购编辑界面数据
        public static final String SELF_EQUIPMENT_ASKBUY_DETAIL_URL = "/index.php?m=Api&c=DeviceCenter&a=selfAskSaleDetail";

        // 发布/编辑设备求租
        public static final String PUBLISH_EQUIPMENT_ASKRENT_URL = "/index.php?m=Api&c=DeviceCenter&a=publishAskRent";

        // 设备求购编辑界面数据
        public static final String SELF_EQUIPMENT_ASKRENT_DETAIL_URL = "/index.php?m=Api&c=DeviceCenter&a=selfAskRentDetail";

        // 设备出租列表
        public static final String EQUIPMENT_RENT_LIST_URL = "/index.php?m=Api&c=Device&a=rentList";

        // 设备转让列表
        public static final String EQUIPMENT_TRANSFER_LIST_URL = "/index.php?m=Api&c=Device&a=saleList";

        // 设备求租列表
        public static final String EQUIPMENT_ASKRENT_LIST_URL = "/index.php?m=Api&c=Device&a=askRentList";

        // 设备求购列表
        public static final String EQUIPMENT_ASKBUY_LIST_URL = "/index.php?m=Api&c=Device&a=askSaleList";

        // 设备出租详情
        public static final String EQUIPMENT_RENT_DETAIL_URL = "/index.php?m=Api&c=Device&a=rentDetail";

        // 设备转让详情
        public static final String EQUIPMENT_TRANSFER_DETAIL_URL = "/index.php?m=Api&c=Device&a=saleDetail";

        // 设备求租详情
        public static final String EQUIPMENT_ASKRENT_DETAIL_URL = "/index.php?m=Api&c=Device&a=askRentDetail";

        // 设备求购详情
        public static final String EQUIPMENT_ASKBUY_DETAIL_URL = "/index.php?m=Api&c=Device&a=askSaleDetail";

        // 附近的设备
        public static final String EQUIPMENT_MAP_DATA_URL = "/index.php?m=Api&c=Environs&a=deviceMap";

        // 发布成本论坛
        public static final String PUBLISH_COSTING_THEME_URL = "/index.php?m=Api&c=CostForum&a=publishTheme";

        // 获取交流列表数据
        public static final String COSTING_THEME_LIST_URL = "/index.php?m=Api&c=CostForum&a=forumList";

        // 发布的成本交流论坛详情
        public static final String COSTING_THEME_DETAIL_URL = "/index.php?m=Api&c=CostForum&a=forumInfo";

        // 删除成本交流主题
        public static final String DELETE_COSTING_THEME_URL = "/index.php?m=Api&c=CostForum&a=deleteTopic";

        // 成本交流发表回复
        public static final String REPLY_COSTING_THEME_URL = "/index.php?m=Api&c=CostForum&a=publishReply";

        // 删除成本交流主题评论
        public static final String DELETE_COSTING_REPLAY_THEME_URL = "/index.php?m=Api&c=CostForum&a=deleteReply";

        // 获得更多回复下的回复
        public static final String LOAD_REPLY_COMMENT_URL = "/index.php?m=Api&c=CostForum&a=loadMoreChildReply";

        // 获取我发布的主题列表
        public static final String MY_PUBLISH_COSTING_LIST_URL = "/index.php?m=Api&c=CostForumCenter&a=myJoinList";

        // 加盟的首页
        public static final String LEAGUE_HOME_DATA_URL = "/index.php?m=Api&c=League&a=home";

        // 加盟信息发布
        public static final String PUBLISH_LEAGUE_INFO_URL = "/index.php?m=Api&c=LeagueCenter&a=leaguePublish";

        // 获取个人加盟列表信息
        public static final String LEAGUE_LIST_URL = "/index.php?m=Api&c=League&a=leagueList";

        // 加盟详情信息
        public static final String LEAGUE_DETAIL_URL = "/index.php?m=Api&c=League&a=leagueInfo";

        // 我发布的加盟列表
        public static final String MY_LEAGUE_LIST_URL = "/index.php?m=Api&c=LeagueCenter&a=leagueCenterList";

        // 查看个人及修改加盟信息初始信息
        public static final String SELF_LEAGUE_DETAIL_URL = "/index.php?m=Api&c=LeagueCenter&a=leagueCenterInfo";

        // 操作手招聘发布/编辑提交
        public static final String PUBLISH_MANIPULATOR_RECRUITMENT_URL = "/index.php?m=Api&c=DeviceOpCenter&a=publishOpJob";

        // 我的求职详情@操作手
        public static final String HANDLERS_APPLY_INFO_URL = "/index.php?m=Api&c=DeviceOpCenter&a=selfOpDetail";

        // 操作手简历发布
        public static final String SUBMIT_MANIPULATOR_APPLY_INFOR_URL = "/index.php?m=Api&c=DeviceOpCenter&a=publishOp";

        // 操作手简历保存
        public static final String SAVE_MANIPULATOR_APPLY_INFOR_URL = "/index.php?m=Api&c=DeviceOpCenter&a=saveOp";

        // 操作手招聘列表@我的发布
        public static final String SELF_MANIPULATOR_LIST_URL = "/index.php?m=Api&c=MemberCenter&a=selfOpJobList";

        // 操作手招聘详情@我的发布
        public static final String SELF_MANIPULATOR_RECRUITMENT_DETAIL_URL = "/index.php?m=Api&c=DeviceOpCenter&a=selfOpJobDetail";

        // 操作手求职列表@设备
        public static final String MANIPULATOR_JOB_LIST_URL = "/index.php?m=Api&c=DeviceOp&a=opList";

        // 操作手招聘列表@设备
        public static final String MANIPULATOR_RECRUITMENT_LIST_URL = "/index.php?m=Api&c=DeviceOp&a=opJobList";

        // 操作手求职详情@设备
        public static final String MANIPULATOR_JOB_DETAIL_URL = "/index.php?m=Api&c=DeviceOp&a=opDetail";

        // 操作手招聘详情@设备
        public static final String MANIPULATOR_RECRUITMENT_DETAIL_URL = "/index.php?m=Api&c=DeviceOp&a=opJobDetail";

        // 预支付接口
        public static final String FFU_PREPARE_TOPAY_URL = "/index.php?m=Api&c=V2Payment&a=ffuPrepareToPay";

        // 支付接口
        public static final String FFU_PAYMENT_URL = "/index.php?m=Api&c=V2Payment&a=ffuPay";

        // 用户购买信息记录
        public static final String USER_BUY_INFO_RECORD_URL = "/index.php?m=Api&c=MemberCenter&a=infoTradeRecord";

        // 取消收藏
        public static final String CANCEL_FAVORITES_URL = "/index.php?m=Api&c=Favorite&a=cancelFavorite";

        // 我的收藏列表
        public static final String MY_FAVORITES_URL = "/index.php?m=Api&c=Favorite&a=favoriteList";

        // 删除收藏
        public static final String DELETE_FAVORITES_URL = "/index.php?m=Api&c=Favorite&a=delFavorite";

        // 分享成功回调
        public static final String SHARE_SUCCESS_URL = "/index.php?m=Api&c=MemberTask&a=shareSuccess";

        // 查勘与试工下单probation
        public static final String SEARCH_AND_PROBATION = "/index.php?m=Api&c=V2Payment&a=submitLabourOrder";

        public static final String ADD_FAVORITES_URL = "/index.php?m=Api&c=Favorite&a=addFavorite";

        // 技术添加收藏
        public static final String TECHNOLOGY_ADD_FAVORITES_URL = "/index.php?m=Api&c=Favorite&a=addTechFavorite";

        // 技术取消收藏
        public static final String TECHNOLOGY_CANCEL_FAVORITES_URL = "/index.php?m=Api&c=Favorite&a=cancelTechFavorite";

        // 订单列表
        public static final String MY_AND_BOSS_ORDER_LIST_URL = "/index.php?m=Api&c=LabourOrder&a=orderList";

        // 订单详情
        public static final String ALL_ORDER_DETAIL_URL = "/index.php?m=Api&c=LabourOrder&a=orderDetail";
        // 评价订单
        public static final String ORDER_RATING_URL = "/index.php?m=Api&c=LabourOrder&a=commentOrder";

        // 取消订单
        public static final String CANCEL_ORDER_URL = "/index.php?m=Api&c=LabourOrder&a=cancelOrder";

        // 确认订单
        public static final String COMFIRM_ORDER_URL = "/index.php?m=Api&c=LabourOrder&a=confirmOrder";

        // 完成订单
        public static final String FINISH_ORDER_URL = "/index.php?m=Api&c=LabourOrder&a=finishOrder";

        // 订单求助
        public static final String ORDER_HELP_URL = "/index.php?m=Api&c=WorkOrder&a=postTradeOrder";

        // 意见反馈
        public static final String SUGGES_BACK_URL = "/index.php?m=Api&c=WorkOrder&a=postFeedbackOrder";

        // 浮窗开
        public static final String FLOAT_OPEN_URL = "/index.php?m=Api&c=CommonInfo&a=openInfo";

        // 浮窗关
        public static final String FLOAT_CLOSE_URL = "/index.php?m=Api&c=CommonInfo&a=closeInfo";

        // 我的任务列表
        public static final String MY_TASK_LIST_URL = "/index.php?m=Api&c=MemberTask&a=taskList";

        // 立即领取任务
        public static final String IMMEDIATELY_GET_TASK_URL = "/index.php?m=Api&c=MemberTask&a=reward";

        // 评价列表数据
        public static final String ALL_COMMENT_URL = "/index.php?m=Api&c=LabourOrder&a=commentList";

        // 用户更换电话号码
        public static final String USER_CHANGE_PHONE_URL = "/index.php?m=Api&c=Member&a=changePhone";

        // 用户二维码
        public static final String USER_QRCODE_URL = "/index.php?m=Api&c=Member&a=QRCode";

        // 我的钱包首页
        public static final String MY_WALLET_RUL = "/index.php?m=Api&c=Wallet&a=home";

        // 我的钱包详情
        public static final String MY_WALLET_DETAIL_RUL = "/index.php?m=Api&c=Wallet&a=balanceDetail";

        // 绑定新的卡片
        public static final String BIND_NEW_CARD_RUL = "/index.php?m=Api&c=Wallet&a=addBankCard";
        // 银行卡列表
        public static final String BANK_CARD_LIST_RUL = "/index.php?m=Api&c=Wallet&a=bankCard";
        // 移除银行卡
        public static final String REMOVE_BANK_CARD_RUL = "/index.php?m=Api&c=Wallet&a=removeBankCard";
        // 取现必要信息
        public static final String CASH_OUT_INFO_RUL = "/index.php?m=Api&c=Wallet&a=withdrawView";
        // 取现请求操作
        public static final String CASH_OUT_DEAL_RUL = "/index.php?m=Api&c=Wallet&a=withdraw";
        // 技术频道页
        public static final String TECH_PLATFORM_RUL = "/index.php?m=Api&c=Tech&a=home";









        //-------------------------------------------------------------------------

        // 用户注册协议
        public static final String MEMBER_PROTOCOL_WEB_URL = "http://app.ffu365.com/pages/member_protocol.html";
        // 劳务使用帮助
        public static final String HELP_LABOUR_WEB_URL = "http://app.ffu365.com/pages/help_labour.html";
        // 保险使用帮助
        public static final String HELP_INSURANCE_WEB_URL = "http://app.ffu365.com/pages/help_insurance.html";
        // 技术使用帮助
        public static final String HELP_TECH_WEB_URL = "http://app.ffu365.com/pages/help_tech.html";
        // 设备使用帮助
        public static final String HELP_DEVICE_WEB_URL = "http://app.ffu365.com/pages/help_device.html";
        // 加盟使用帮助
        public static final String HELP_CERT_WEB_URL = "http://app.ffu365.com/pages/help_cert.html";
        // 成本论坛使用帮助
        public static final String HELP_BBS_WEB_URL = "http://app.ffu365.com/pages/help_bbs.html";
        // 保险首页
        public static final String INSURANCE_FEATURES_WEB_URL = "http://app.ffu365.com/pages/insurance_features.html";
        // 保险索赔规则及范围
        public static final String INSURANCE_PROTOCOL_WEB_URL = "http://app.ffu365.com/pages/insurance_protocol.html";
        // 技术服务机构
        public static final String TECH_AGENCY_WEB_URL = "http://app.ffu365.com/pages/tech_agency.html";
        // 联营企业
        public static final String COMPANY_WEB_URL = "http://app.ffu365.com/pages/company.html";
        // 金币说明
        public static final String ABOUT_COIN_WEB_URL = "http://app.ffu365.com/pages/about_coin.html";
        // 工人说明
        public static final String ABOUT_WORKER_WEB_URL = "http://app.ffu365.com/pages/about_worker.html";
        // 团队说明
        public static final String ABOUT_TEAM_WEB_URL = "http://app.ffu365.com/pages/about_team.html";
        // 专家说明
        public static final String ABOUT_EXPERT_WEB_URL = "http://app.ffu365.com/pages/about_expert.html";
        // 工人帮助教程
        public static final String HELP_LESSON_WORKER_WEB_URL = "http://app.ffu365.com/pages/help_lesson_worker.html";
        // 团队帮助教程
        public static final String HELP_LESSON_TEAM_WEB_URL = "http://app.ffu365.com/pages/help_lesson_team.html";
        // 专家帮助教程
        public static final String HELP_LESSON_EXPERT_WEB_URL = "http://app.ffu365.com/pages/help_lesson_expert.html";
        // 常见问题
        public static final String FAQ_WEB_URL = "http://app.ffu365.com/pages/FAQ.html";
        // 联系客服
        public static final String CONTACT_US_WEB_URL = "http://app.ffu365.com/pages/contact_us.html";
        // 关于我们
        public static final String ABOUT_US_WEB_URL = "http://app.ffu365.com/pages/about_us.html";
        // 钱包使用指南
        public static final String HELP_WALLET_WEB_URL = "http://app.ffu365.com/pages/help_wallet.html";
        // 推荐加盟
        public static final String REC_JOIN_WEB_URL = "http://app.ffu365.com/pages/rec_join.html";
        //		个人中心材料推荐
        public static final String MATERIAL_AD_URL = "http://h5.ffu365.com/material/rc.jsp";
        //		个人中心材料求购
        public static final String MATERIAL_AK_URL = "http://h5.ffu365.com/material/ak.jsp";
        //材料联系客服
        public static final String MATERIAL_SV_URL = "http://h5.ffu365.com/material/sv.jsp";
    }

    /**
     * handler的message what
     */
    public final class MessageWhat {
        public static final int MESSAGE_WHAT_ONE = 1;
        public static final int MESSAGE_WHAT_TWO = 2;
        public static final int MESSAGE_WHAT_THREE = 3;
        public static final int MESSAGE_WHAT_FOUR = 4;
        public static final int MESSAGE_WHAT_FIVE = 5;
        public static final int MESSAGE_WHAT_SIX = 6;
        public static final int MESSAGE_WHAT_SEVEN = 7;
        public static final int MESSAGE_WHAT_EGHIT = 8;
        public static final int MESSAGE_WHAT_NINE = 9;
        public static final int MESSAGE_WHAT_TEN = 10;
        public static final int GET_SELECT_TIME = 11;
    }

    public final class TianTianKey {
        // AES 秘钥
        public static final String AES_KEY = "rDh5CMnYX3p7eAoEZovhkIsNv3OJAZ7A";

        // 第一步申请的ID
        public static final String APPLY_ID_KEY = "APPLY_ID_KEY";

        public static final String APP_ID = "wxa8080d15a32e2ff7";

        public static final String APPLY_STATUS_KEY = "APPLY_STATUS_KEY";

        public static final String PHONE_STR = "0731-89702249";

        public static final String TIANTIAN_BEAN_KEY = "TIANTIAN_BEAN_KEY";

    }

	/*
	 * public final class BaseInfo{
	 *//** BaseResult中errcode = 0 */
	/*
	 * public static final int ERROR_CODE0 = 0;
	 *//** BaseResult中errcode = 1 */
	/*
	 * public static final int ERROR_CODE1 = 1;
	 *//** BaseResult中errdialog = 0 */
	/*
	 * public static final int ERROR_DIALOG0 = 0;
	 *//** BaseResult中errdialog = 1 */
	/*
	 * public static final int ERROR_DIALOG1 = 1;
	 *//** BaseResult中errdialog = 2 */
	/*
	 * public static final int ERROR_DIALOG2 = 2; }
	 */
}
