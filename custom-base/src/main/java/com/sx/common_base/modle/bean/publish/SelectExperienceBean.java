package com.sx.common_base.modle.bean.publish;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Author : Jack
 * Email  : jackzhonglyy@outlook.com
 * Date   : 2017/7/25
 * Desc   : 工作经历bean
 */
public class SelectExperienceBean implements Parcelable {
    /**
     * p : 工程名
     * j : 岗位
     */

    private String p;
    private String j;

    private String experience_text;

    public String getExperience_text() {
        if (experience_text == null || experience_text.isEmpty()) {
            return p + ":" + j;
        }
        return experience_text;
    }

    public void setExperience_text(String experience_text) {
        this.experience_text = experience_text;
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }

    public String getJ() {
        return j;
    }

    public void setJ(String j) {
        this.j = j;
    }

    public SelectExperienceBean() {
    }


    public void assemblyDesc() {
        experience_text = p + ":" + j;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.p);
        dest.writeString(this.j);
        dest.writeString(this.experience_text);
    }

    protected SelectExperienceBean(Parcel in) {
        this.p = in.readString();
        this.j = in.readString();
        this.experience_text = in.readString();
    }

    public static final Creator<SelectExperienceBean> CREATOR = new Creator<SelectExperienceBean>() {
        @Override
        public SelectExperienceBean createFromParcel(Parcel source) {
            return new SelectExperienceBean(source);
        }

        @Override
        public SelectExperienceBean[] newArray(int size) {
            return new SelectExperienceBean[size];
        }
    };
}
