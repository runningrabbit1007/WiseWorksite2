package com.sx.common_base.bean;

/**
 * Created by Administrator on 2017/12/20.
 */

public class SpecBean {
    private  int availableStock;
    private String quantity;
    private int SkuId;
    private boolean isPreSale;

    public boolean isPreSale() {
        return isPreSale;
    }

    public void setPreSale(boolean preSale) {
        isPreSale = preSale;
    }

    public int getAvailableStock() {
        return availableStock;
    }

    public void setAvailableStock(int availableStock) {
        this.availableStock = availableStock;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public int getSkuId() {
        return SkuId;
    }

    public void setSkuId(int skuId) {
        SkuId = skuId;
    }

    public SpecBean(int availableStock, String quantity, int skuId, boolean isPreSale) {
        this.availableStock = availableStock;
        this.quantity = quantity;
        SkuId = skuId;
        this.isPreSale = isPreSale;
    }
}
