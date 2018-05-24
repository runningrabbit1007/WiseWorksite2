package com.sx.common_base.result;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2017/12/14.
 */

public class ShopCartResult {
    /**
     * tag : 9893cec3c553a2340352e1416c9633bd
     * skuQuantity : 1
     * effectivePrice : 6100.0
     * cartItemModelList : [{"cartItemId":804,"productId":2,"skuId":10,"skuName":"苹果 iPhone 6","skuPath":"/product/detail/2","skuThumbnail":"http://image.demo.shopxx.net/b2b2c/5.0/201601/d7f59d79-1958-4059-852c-0d6531788b48-thumbnail.jpg","price":6100,"quantity":1,"subtotal":null,"specificationList":["银色","64GB"],"marketable":true,"lowStock":false}]
     */

    private String tag;
    private int skuQuantity;
    private double effectivePrice;
    private List<CartItemModelListBean> cartItemModelList;

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

    public double getEffectivePrice() {
        return effectivePrice;
    }

    public void setEffectivePrice(double effectivePrice) {
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
         * cartItemId : 804
         * productId : 2
         * skuId : 10
         * skuName : 苹果 iPhone 6
         * skuPath : /product/detail/2
         * skuThumbnail : http://image.demo.shopxx.net/b2b2c/5.0/201601/d7f59d79-1958-4059-852c-0d6531788b48-thumbnail.jpg
         * price : 6100.0
         * quantity : 1
         * subtotal : null
         * specificationList : ["银色","64GB"]
         * marketable : true
         * lowStock : false
         */

        private int cartItemId;
        private int productId;
        private int skuId;
        private String skuName;
        private String skuPath;
        private String skuThumbnail;
        private BigDecimal price;
        private int quantity;
        private double subtotal;
        private boolean marketable;
        private boolean lowStock;
        private List<String> specificationList;

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

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getSubtotal() {
            return subtotal;
        }

        public void setSubtotal(double subtotal) {
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

        public List<String> getSpecificationList() {
            return specificationList;
        }

        public void setSpecificationList(List<String> specificationList) {
            this.specificationList = specificationList;
        }
    }


    /**
     * list : [{"goods_amount":24,"cover_image":"http://img3.imgtn.bdimg.com/it/u=1734947412,488870121&fm=21&gp=0.jpg","goods_id":1057,"title":"想自杀的骨架已经说胡话了","sub_title":"哈！精确的原野","exact_price":"7005.66/个","calc_price":"7005.66"},{"goods_amount":233,"cover_image":"http://img3.imgtn.bdimg.com/it/u=1734947412,488870121&fm=21&gp=0.jpg","goods_id":456,"title":"转动吧！","sub_title":"大钟在递送英雄","exact_price":"7005.66/个","calc_price":"7005.66"},{"goods_amount":45,"cover_image":"http://img3.imgtn.bdimg.com/it/u=1734947412,488870121&fm=21&gp=0.jpg","goods_id":333,"title":"水牛，山丘和手，在一起拍手着","sub_title":"看，逻辑是多么纤细！","exact_price":"7005.66/个","calc_price":"7005.66"}]
     * page : 1
     * pagesize : 3
     * webview_url : http://www.baidu.com
     *//*

    private DataBean data;


    private boolean isSelect = false;

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean isSelect) {
        this.isSelect = isSelect;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private int page;
        private int pagesize;
        private String webview_url;
        *//**
         * goods_amount : 24
         * cover_image : http://img3.imgtn.bdimg.com/it/u=1734947412,488870121&fm=21&gp=0.jpg
         * goods_id : 1057
         * title : 想自杀的骨架已经说胡话了
         * sub_title : 哈！精确的原野
         * exact_price : 7005.66/个
         * calc_price : 7005.66
         *//*

        private ArrayList<ShopCart> list;

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getPagesize() {
            return pagesize;
        }

        public void setPagesize(int pagesize) {
            this.pagesize = pagesize;
        }

        public String getWebview_url() {
            return webview_url;
        }

        public void setWebview_url(String webview_url) {
            this.webview_url = webview_url;
        }

        public ArrayList<ShopCart> getList() {
            return list;
        }

        public void setList(ArrayList<ShopCart> list) {
            this.list = list;
        }

        public static class ShopCart {
            private int goods_amount;
            private String cover_image;
            private int goods_id;
            private String title;
            private String sub_title;
            private String exact_price;
            private String calc_price;
            private boolean isSelect = false;
            private boolean isEdit = false;

            public boolean isEdit() {
                return isEdit;
            }

            public void setEdit(boolean isEdit) {
                this.isEdit = isEdit;
            }

            public boolean isSelect() {
                return isSelect;
            }

            public void setSelect(boolean isSelect) {
                this.isSelect = isSelect;
            }

            public int getGoods_amount() {
                return goods_amount;
            }

            public void setGoods_amount(int goods_amount) {
                this.goods_amount = goods_amount;
            }

            public String getCover_image() {
                return cover_image;
            }

            public void setCover_image(String cover_image) {
                this.cover_image = cover_image;
            }

            public int getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(int goods_id) {
                this.goods_id = goods_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getSub_title() {
                return sub_title;
            }

            public void setSub_title(String sub_title) {
                this.sub_title = sub_title;
            }

            public String getExact_price() {
                return exact_price;
            }

            public void setExact_price(String exact_price) {
                this.exact_price = exact_price;
            }

            public String getCalc_price() {
                return calc_price;
            }

            public void setCalc_price(String calc_price) {
                this.calc_price = calc_price;
            }
        }
    }*/

}
