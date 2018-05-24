package com.sx.common_base.modle.request;

/**
 * Created by Undefined on 2017/7/29.
 */

public class HeadImageUploadBean {
    protected String memberId;
    protected String headImageUrl;



    public String getHeadImageUrl() {
        return headImageUrl;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setHeadImageUrl(String headImageUrl) {
        this.headImageUrl = headImageUrl;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
}
