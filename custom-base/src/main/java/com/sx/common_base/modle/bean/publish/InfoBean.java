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

public  class InfoBean implements Parcelable {
    /**
     * can_edit : 1       能编辑
     * has_resume : 1     有原始简历
     * resume_id : 47
     * status_text : 信息已上架   信息提示信息
     * has_switch : 1      有开关
     * switch_status : 1   开关的状态
     * has_sub_button : 1   有提交按钮
     */

    private int can_edit;
    private int has_resume;
    private int resume_id;
    private String status_text;
    private int has_switch;
    private int switch_status;
    private int has_sub_button;
    private int type;
    private String edit_notice;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCan_edit() {
        return can_edit;
    }

    public void setCan_edit(int can_edit) {
        this.can_edit = can_edit;
    }

    public int getHas_resume() {
        return has_resume;
    }

    public void setHas_resume(int has_resume) {
        this.has_resume = has_resume;
    }

    public int getResume_id() {
        return resume_id;
    }

    public void setResume_id(int resume_id) {
        this.resume_id = resume_id;
    }

    public String getStatus_text() {
        return status_text;
    }

    public void setStatus_text(String status_text) {
        this.status_text = status_text;
    }

    public int getHas_switch() {
        return has_switch;
    }

    public void setHas_switch(int has_switch) {
        this.has_switch = has_switch;
    }

    public int getSwitch_status() {
        return switch_status;
    }

    public void setSwitch_status(int switch_status) {
        this.switch_status = switch_status;
    }

    public int getHas_sub_button() {
        return has_sub_button;
    }

    public void setHas_sub_button(int has_sub_button) {
        this.has_sub_button = has_sub_button;
    }

    public String getEdit_notice() {
        return edit_notice;
    }

    public void setEdit_notice(String edit_notice) {
        this.edit_notice = edit_notice;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.can_edit);
        dest.writeInt(this.has_resume);
        dest.writeInt(this.resume_id);
    }

    public InfoBean() {
    }

    protected InfoBean(Parcel in) {
        this.can_edit = in.readInt();
        this.has_resume = in.readInt();
        this.resume_id = in.readInt();
    }

    public static final Creator<InfoBean> CREATOR = new Creator<InfoBean>() {
        @Override
        public InfoBean createFromParcel(Parcel source) {
            return new InfoBean(source);
        }

        @Override
        public InfoBean[] newArray(int size) {
            return new InfoBean[size];
        }
    };
}
