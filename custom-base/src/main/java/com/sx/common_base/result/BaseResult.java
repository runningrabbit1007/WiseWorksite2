package com.sx.common_base.result;
import com.google.gson.JsonObject;

import java.util.List;

/**
 * Created by jacklyy on 2017/6/4.
 */

public class BaseResult {
    /**
     * msg : sucess
     * code : 200
     * data : {"areaList":[{"name":"北京市","value":1},{"name":"天津市","value":18},{"name":"河北省","value":35},{"name":"山西省","value":219},{"name":"内蒙古自治区","value":350},{"name":"辽宁省","value":465},{"name":"吉林省","value":580},{"name":"黑龙江省","value":650},{"name":"上海市","value":792},{"name":"江苏省","value":810},{"name":"浙江省","value":924},{"name":"安徽省","value":1026},{"name":"福建省","value":1148},{"name":"江西省","value":1243},{"name":"山东省","value":1355},{"name":"河南省","value":1511},{"name":"湖北省","value":1688},{"name":"湖南省","value":1805},{"name":"广东省","value":1942},{"name":"广西壮族自治区","value":2085},{"name":"海南省","value":2210},{"name":"重庆市","value":2237},{"name":"四川省","value":2276},{"name":"贵州省","value":2481},{"name":"云南省","value":2579},{"name":"西藏自治区","value":2725},{"name":"陕西省","value":2807},{"name":"甘肃省","value":2925},{"name":"青海省","value":3026},{"name":"宁夏回族自治区","value":3078},{"name":"新疆维吾尔自治区","value":3106},{"name":"台湾省","value":3220},{"name":"香港特别行政区","value":3221},{"name":"澳门特别行政区","value":3222}]}
     */

    private String msg;
    private int code;
    private JsonObject data;
    public Object pageModel;
    /**
     * tag : 2daa588c808213055057682a7c56a025
     * skuQuantity : 1
     * effectivePrice : 0
     * cartItemModelList : [{"cartItemId":818,"productId":40,"skuId":57,"skuName":"索尼 KDL-50W700B","skuPath":"/product/detail/40","skuThumbnail":"http://image.demo.shopxx.net/b2b2c/5.0/201601/eee0bfc5-d5f6-48c4-aa75-73fb709d824b-thumbnail.jpg","price":0,"quantity":1,"subtotal":"{}","specificationList":[],"marketable":true,"lowStock":false}]
     */

    private String tag;
    private int skuQuantity;
    private int effectivePrice;
    private List<CartItemModelListBean> cartItemModelList;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getSkuQuantity() {
        return skuQuantity;
    }

    public void setSkuQuantity(int skuQuantity) {
        this.skuQuantity = skuQuantity;
    }

    public int getEffectivePrice() {
        return effectivePrice;
    }

    public void setEffectivePrice(int effectivePrice) {
        this.effectivePrice = effectivePrice;
    }

    public List<CartItemModelListBean> getCartItemModelList() {
        return cartItemModelList;
    }

    public void setCartItemModelList(List<CartItemModelListBean> cartItemModelList) {
        this.cartItemModelList = cartItemModelList;
    }

    public static class CartItemModelListBean {
        /**
         * cartItemId : 818
         * productId : 40
         * skuId : 57
         * skuName : 索尼 KDL-50W700B
         * skuPath : /product/detail/40
         * skuThumbnail : http://image.demo.shopxx.net/b2b2c/5.0/201601/eee0bfc5-d5f6-48c4-aa75-73fb709d824b-thumbnail.jpg
         * price : 0
         * quantity : 1
         * subtotal : {}
         * specificationList : []
         * marketable : true
         * lowStock : false
         */

        private int cartItemId;
        private int productId;
        private int skuId;
        private String skuName;
        private String skuPath;
        private String skuThumbnail;
        private int price;
        private int quantity;
        private String subtotal;
        private boolean marketable;
        private boolean lowStock;
        private List<?> specificationList;

        public int getCartItemId() {
            return cartItemId;
        }

        public void setCartItemId(int cartItemId) {
            this.cartItemId = cartItemId;
        }

        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }

        public int getSkuId() {
            return skuId;
        }

        public void setSkuId(int skuId) {
            this.skuId = skuId;
        }

        public String getSkuName() {
            return skuName;
        }

        public void setSkuName(String skuName) {
            this.skuName = skuName;
        }

        public String getSkuPath() {
            return skuPath;
        }

        public void setSkuPath(String skuPath) {
            this.skuPath = skuPath;
        }

        public String getSkuThumbnail() {
            return skuThumbnail;
        }

        public void setSkuThumbnail(String skuThumbnail) {
            this.skuThumbnail = skuThumbnail;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public String getSubtotal() {
            return subtotal;
        }

        public void setSubtotal(String subtotal) {
            this.subtotal = subtotal;
        }

        public boolean isMarketable() {
            return marketable;
        }

        public void setMarketable(boolean marketable) {
            this.marketable = marketable;
        }

        public boolean isLowStock() {
            return lowStock;
        }

        public void setLowStock(boolean lowStock) {
            this.lowStock = lowStock;
        }

        public List<?> getSpecificationList() {
            return specificationList;
        }

        public void setSpecificationList(List<?> specificationList) {
            this.specificationList = specificationList;
        }
    }
}
