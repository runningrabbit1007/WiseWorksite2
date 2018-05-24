package com.sx.common_base.request;

import java.util.List;

/**
 * Created by Administrator on 2018/3/1.
 */

public class ReturnApplyRequest {

    private String type;

    private  String reason;

    private String remark;

    private List<String> images;

    private int orderShippingId;

    private List<ReturnsApplyOrderItemModel> returnsApplyOrderItemModel;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public int getOrderShippingId() {
        return orderShippingId;
    }

    public void setOrderShippingId(int orderShippingId) {
        this.orderShippingId = orderShippingId;
    }

    public List<ReturnsApplyOrderItemModel> getReturnsApplyOrderItemModel() {
        return returnsApplyOrderItemModel;
    }

    public void setReturnsApplyOrderItemModel(List<ReturnsApplyOrderItemModel> returnsApplyOrderItemModel) {
        this.returnsApplyOrderItemModel = returnsApplyOrderItemModel;
    }

    public static class ReturnsApplyOrderItemModel{
        private int applyReturnedQuantity;
        private int id;

        public ReturnsApplyOrderItemModel() {
        }

        public int getApplyReturnedQuantity() {
            return applyReturnedQuantity;
        }

        public int getId() {
            return id;
        }

        public void setApplyReturnedQuantity(int applyReturnedQuantity) {
            this.applyReturnedQuantity = applyReturnedQuantity;
        }

        public void setId(int id) {
            this.id = id;
        }
    }


}
