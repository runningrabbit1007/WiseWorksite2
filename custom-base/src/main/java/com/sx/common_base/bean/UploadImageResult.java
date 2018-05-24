package com.sx.common_base.bean;


import com.sx.common_base.modle.bean.publish.DescImageBean;

import java.util.ArrayList;

/**
 * Author: Created by Jacklyy
 * Email:  jackzhonglyy@outlook.com
 * Date:   ${date}
 * Desc:
 * Params:
 * CallBack:
 */

public class UploadImageResult {
    /**
     * info : {"url":"http://api.ffu365.com/v4/image/output/p/upload%255C20170806%255C_zeb59868f381d9ba.jpg","width":254,"height":254}
     * unique : /storage/emulated/0/ffu365/image.jpg
     */

    private DescImageBean info;
    private ArrayList<UrlBean> urls;
    private String unique;
    private  String url;

    public DescImageBean getInfo() {
        return info;
    }

    public void setInfo(DescImageBean info) {
        this.info = info;
    }

    public String getUnique() {
        return unique;
    }

    public void setUnique(String unique) {
        this.unique = unique;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ArrayList<UrlBean> getUrls() {
        return urls;
    }

    public void setUrls(ArrayList<UrlBean> urls) {
        this.urls = urls;
    }

   public class UrlBean {
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
