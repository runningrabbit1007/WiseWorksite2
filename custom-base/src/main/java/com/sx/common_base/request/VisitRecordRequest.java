package com.sx.common_base.request;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2018/1/3.
 */

public class VisitRecordRequest {

    private Long id;

    private String memberName;

    private String address;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private int memberId;

    private String currentUserId;

    private List<DemandRequest.ImagesBean> images;

    private String memo;

    public int getMemberId() {
        return memberId;
    }

    public String getCurrentUserId() {
        return currentUserId;
    }

    public void setCurrentUserId(String currentUserId) {
        this.currentUserId = currentUserId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public List<DemandRequest.ImagesBean> getImages() {
        return images;
    }

    public void setImages(List<DemandRequest.ImagesBean> images) {
        this.images = images;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
