package com.sx.common_base.request;

/**
 * Created by Administrator on 2017/12/28.
 */

public class AddShippingRequest {

    private String deliveryCorp;
    private int deliveryCorpId;

    private String trackingNo;

    private String returnsApplyId;

    public int getDeliveryCorpId() {
        return deliveryCorpId;
    }

    public void setDeliveryCorpId(int deliveryCorpId) {
        this.deliveryCorpId = deliveryCorpId;
    }

    public String getDeliveryCorp() {
        return deliveryCorp;
    }

    public void setDeliveryCorp(String deliveryCorp) {
        this.deliveryCorp = deliveryCorp;
    }

    public String getTrackingNo() {
        return trackingNo;
    }

    public void setTrackingNo(String trackingNo) {
        this.trackingNo = trackingNo;
    }

    public String getReturnsApplyId() {
        return returnsApplyId;
    }

    public void setReturnsApplyId(String returnsApplyId) {
        this.returnsApplyId = returnsApplyId;
    }
}
