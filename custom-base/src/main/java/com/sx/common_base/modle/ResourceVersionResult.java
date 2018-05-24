package com.sx.common_base.modle;

/**
 * Created by edz on 2016/12/9.
 */

public class ResourceVersionResult {
    /**
     * activex1Url : http://img.liker365.com/lianke-dev/20161208/LK-64b073f8094741c48f77541fde166578.png
     * activeUrl : http://img.liker365.com/lianke-dev/20161208/LK-ae59733e7de84fd58f392769aae208d9.png
     * activex3Url : http://img.liker365.com/lianke-dev/20161208/LK-4f106e048c8b40f28c81e817faf1c31a.png
     * afterTitleColour : #611515
     * beforeTitleColour : #0c1c13
     * channelId : 44888660374009864
     * iconx1Url : http://img.liker365.com/lianke-dev/20161208/LK-04857837fafc4521969d6c289fd53f3f.png
     * iconUrl : http://img.liker365.com/lianke-dev/20161208/LK-e6904dfb933446b3948964e0074efbd7.png
     * iconx3Url : http://img.liker365.com/lianke-dev/20161208/LK-2391d27fe4694ee3bccc87056466cf75.png
     * title : 活动1
     */

    private String activeUrl;
    private String afterTitleColour;
    private String beforeTitleColour;
    private Long channelId;
    private String iconUrl;
    private String title;


    public String getActiveUrl() {
        return activeUrl;
    }

    public void setActiveUrl(String activeUrl) {
        this.activeUrl = activeUrl;
    }


    public String getAfterTitleColour() {
        return afterTitleColour;
    }

    public void setAfterTitleColour(String afterTitleColour) {
        this.afterTitleColour = afterTitleColour;
    }

    public String getBeforeTitleColour() {
        return beforeTitleColour;
    }

    public void setBeforeTitleColour(String beforeTitleColour) {
        this.beforeTitleColour = beforeTitleColour;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }


    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}