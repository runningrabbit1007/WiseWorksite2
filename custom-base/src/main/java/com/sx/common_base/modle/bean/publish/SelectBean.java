package com.sx.common_base.modle.bean.publish;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Author : Jack
 * Email  : jackzhonglyy@outlook.com
 * Date   : ${date}
 * Desc   :
 * 携参说明：
 * <p>
 * 返回值说明：
 */

public class SelectBean implements Parcelable {
    /**
     * id : 427
     * text : 抹灰工
     */

    private String id;
    private String text;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.text);
    }

    public SelectBean() {
    }

    public SelectBean(String id, String text) {
        this.id = id;
        this.text = text;
    }

    protected SelectBean(Parcel in) {
        this.id = in.readString();
        this.text = in.readString();
    }

    public static final Creator<SelectBean> CREATOR = new Creator<SelectBean>() {
        @Override
        public SelectBean createFromParcel(Parcel source) {
            return new SelectBean(source);
        }

        @Override
        public SelectBean[] newArray(int size) {
            return new SelectBean[size];
        }
    };

    @Override
    public String toString() {
        return "id:" + getId() + ",text:" + getText();
    }

    @Override
    public boolean equals(Object obj) {
        return (obj.toString().equals(toString()));

    }
}
