package com.sx.common_base.modle.bean.publish;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Author: Created by Jacklyy
 * Email:  jackzhonglyy@outlook.com
 * Date:   ${date}
 * Desc:
 * Params:
 * CallBack:
 */

public class ExpertContentBean implements Parcelable {
    /**
     * resume_title : We're
     * expert_name : We're
     * expert_avatar : http://a.b.c/1.jpg
     * expert_cell_phone : 18874538201
     * expert_sex : 1
     * expert_birth : 1975-03-03
     * expert_seniority : 2
     * expert_edu : 1
     * expert_edu_text : 高中
     * expert_desc : Asdasdasdasda
     * expert_desc_image : [{"url":"http://a.b.c/1.jpg","width":"22","height":"222"}]
     * expert_home_text : xx-xx
     * expert_work_text : xx-xxx
     * expert_type : [{"id":"308","text":"xx-xx"}]
     * expert_industry : [{"id":"328","text":"xx-xxx"}]
     * expert_home : ["140000000","140400000"]
     * expert_work : ["140000000","140400000"]
     */

    private String resume_title;
    private String expert_name;
    private String expert_avatar;
    private String expert_cell_phone;
    private int expert_sex;
    private String expert_birth;
    private int expert_seniority;
    private int expert_edu;
    private String expert_edu_text;
    private String expert_desc;
    private String expert_home_text;
    private String expert_work_text;
    private List<DescImageBean> expert_desc_image;
    private List<SelectBean> expert_type;
    private List<SelectBean> expert_industry;
    private List<String> expert_home;
    private List<String> expert_work;

    public String getResume_title() {
        return resume_title;
    }

    public void setResume_title(String resume_title) {
        this.resume_title = resume_title;
    }

    public String getExpert_name() {
        return expert_name;
    }

    public void setExpert_name(String expert_name) {
        this.expert_name = expert_name;
    }

    public String getExpert_avatar() {
        return expert_avatar;
    }

    public void setExpert_avatar(String expert_avatar) {
        this.expert_avatar = expert_avatar;
    }

    public String getExpert_cell_phone() {
        return expert_cell_phone;
    }

    public void setExpert_cell_phone(String expert_cell_phone) {
        this.expert_cell_phone = expert_cell_phone;
    }

    public int getExpert_sex() {
        return expert_sex;
    }

    public void setExpert_sex(int expert_sex) {
        this.expert_sex = expert_sex;
    }

    public String getExpert_birth() {
        return expert_birth;
    }

    public void setExpert_birth(String expert_birth) {
        this.expert_birth = expert_birth;
    }

    public int getExpert_seniority() {
        return expert_seniority;
    }

    public void setExpert_seniority(int expert_seniority) {
        this.expert_seniority = expert_seniority;
    }

    public int getExpert_edu() {
        return expert_edu;
    }

    public void setExpert_edu(int expert_edu) {
        this.expert_edu = expert_edu;
    }

    public String getExpert_edu_text() {
        return expert_edu_text;
    }

    public void setExpert_edu_text(String expert_edu_text) {
        this.expert_edu_text = expert_edu_text;
    }

    public String getExpert_desc() {
        return expert_desc;
    }

    public void setExpert_desc(String expert_desc) {
        this.expert_desc = expert_desc;
    }

    public String getExpert_home_text() {
        return expert_home_text;
    }

    public void setExpert_home_text(String expert_home_text) {
        this.expert_home_text = expert_home_text;
    }

    public String getExpert_work_text() {
        return expert_work_text;
    }

    public void setExpert_work_text(String expert_work_text) {
        this.expert_work_text = expert_work_text;
    }

    public List<DescImageBean> getExpert_desc_image() {
        return expert_desc_image;
    }

    public void setExpert_desc_image(List<DescImageBean> expert_desc_image) {
        this.expert_desc_image = expert_desc_image;
    }

    public List<SelectBean> getExpert_type() {
        return expert_type;
    }

    public void setExpert_type(List<SelectBean> expert_type) {
        this.expert_type = expert_type;
    }

    public List<SelectBean> getExpert_industry() {
        return expert_industry;
    }

    public void setExpert_industry(List<SelectBean> expert_industry) {
        this.expert_industry = expert_industry;
    }

    public List<String> getExpert_home() {
        return expert_home;
    }

    public void setExpert_home(List<String> expert_home) {
        this.expert_home = expert_home;
    }

    public List<String> getExpert_work() {
        return expert_work;
    }

    public void setExpert_work(List<String> expert_work) {
        this.expert_work = expert_work;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.resume_title);
        dest.writeString(this.expert_name);
        dest.writeString(this.expert_avatar);
        dest.writeString(this.expert_cell_phone);
        dest.writeInt(this.expert_sex);
        dest.writeString(this.expert_birth);
        dest.writeInt(this.expert_seniority);
        dest.writeInt(this.expert_edu);
        dest.writeString(this.expert_edu_text);
        dest.writeString(this.expert_desc);
        dest.writeString(this.expert_home_text);
        dest.writeString(this.expert_work_text);
        dest.writeTypedList(this.expert_desc_image);
        dest.writeTypedList(this.expert_type);
        dest.writeTypedList(this.expert_industry);
        dest.writeStringList(this.expert_home);
        dest.writeStringList(this.expert_work);
    }

    public ExpertContentBean() {
    }

    protected ExpertContentBean(Parcel in) {
        this.resume_title = in.readString();
        this.expert_name = in.readString();
        this.expert_avatar = in.readString();
        this.expert_cell_phone = in.readString();
        this.expert_sex = in.readInt();
        this.expert_birth = in.readString();
        this.expert_seniority = in.readInt();
        this.expert_edu = in.readInt();
        this.expert_edu_text = in.readString();
        this.expert_desc = in.readString();
        this.expert_home_text = in.readString();
        this.expert_work_text = in.readString();
        this.expert_desc_image = in.createTypedArrayList(DescImageBean.CREATOR);
        this.expert_type = in.createTypedArrayList(SelectBean.CREATOR);
        this.expert_industry = in.createTypedArrayList(SelectBean.CREATOR);
        this.expert_home = in.createStringArrayList();
        this.expert_work = in.createStringArrayList();
    }

    public static final Creator<ExpertContentBean> CREATOR = new Creator<ExpertContentBean>() {
        @Override
        public ExpertContentBean createFromParcel(Parcel source) {
            return new ExpertContentBean(source);
        }

        @Override
        public ExpertContentBean[] newArray(int size) {
            return new ExpertContentBean[size];
        }
    };
}
