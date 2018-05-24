package com.sx.common_base.modle.bean.publish;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Author: Created by Jacklyy
 * Email:  jackzhonglyy@outlook.com
 * Date:   ${date}
 * Desc:
 * Params:
 * CallBack:
 */

public class DescImageBean implements Parcelable {
    /**
     * url : http://a.b.c/1.jpg
     * width : 22
     * height : 222
     */

    private String url;
    private String width;
    private String height;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.url);
        dest.writeString(this.width);
        dest.writeString(this.height);
    }

    public DescImageBean() {
    }

    protected DescImageBean(Parcel in) {
        this.url = in.readString();
        this.width = in.readString();
        this.height = in.readString();
    }

    public static final Creator<DescImageBean> CREATOR = new Creator<DescImageBean>() {
        @Override
        public DescImageBean createFromParcel(Parcel source) {
            return new DescImageBean(source);
        }

        @Override
        public DescImageBean[] newArray(int size) {
            return new DescImageBean[size];
        }
    };

    @Override
    public String toString() {
        return "url:" + url+"-width:" + width +"-height:" + height;
    }
}
