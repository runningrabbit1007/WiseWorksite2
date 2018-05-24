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

public class TeamContentBean implements Parcelable {

    /**
     * resume_title : We're
     * team_contact_name : We're
     * team_avatar :
     * team_contact_cell_phone : 18874538201
     * team_size : 11
     * team_avg_age : 55
     * team_avg_seniority : 4
     * team_fee_min : 222
     * team_fee_max : 222
     * team_experience : [{"p":"123","j":"3333"}]
     * team_desc : Asdasdasdasda
     * team_desc_image : ["http://resource.ffu365.com/upload/images/labour_recruitment/2017-07-24/59755f6714ffe4.53389512_low.png","http://resource.ffu365.com/upload/images/labour_recruitment/2017-07-24/59755f67520918.94137900_low.png","http://resource.ffu365.com/upload/images/labour_recruitment/2017-07-24/59755f67782ed3.04915072_low.png"]
     * team_home_text : 华南-长沙
     * team_work_text : 华南-长陵
     * team_type : [{"id":"308","text":"保冷-保冷外护工"}]
     * team_industry : [{"id":"328","text":"玻璃钢衬里-衬贴工"}]
     * team_cert : [{"id":"427","text":"抹灰工"}]
     * team_home : ["140000000","140400000"]
     * team_work : ["140000000","140400000"]
     */

    private String resume_title;
    private String team_contact_name;
    private String team_avatar;
    private String team_contact_cell_phone;
    private int team_size;
    private String team_avg_age;
    private int team_avg_seniority;
    private int team_fee_min;
    private int team_fee_max;
    private String team_desc;
    private String team_home_text;
    private String team_work_text;
    private List<SelectExperienceBean> team_experience;
    private List<DescImageBean> team_desc_image;
    private List<SelectBean> team_type;
    private List<SelectBean> team_industry;
    private List<SelectBean> team_cert;
    private List<String> team_home;
    private List<String> team_work;

    public String getResume_title() {
        return resume_title;
    }

    public void setResume_title(String resume_title) {
        this.resume_title = resume_title;
    }

    public String getTeam_contact_name() {
        return team_contact_name;
    }

    public void setTeam_contact_name(String team_contact_name) {
        this.team_contact_name = team_contact_name;
    }

    public String getTeam_avatar() {
        return team_avatar;
    }

    public void setTeam_avatar(String team_avatar) {
        this.team_avatar = team_avatar;
    }

    public String getTeam_contact_cell_phone() {
        return team_contact_cell_phone;
    }

    public void setTeam_contact_cell_phone(String team_contact_cell_phone) {
        this.team_contact_cell_phone = team_contact_cell_phone;
    }

    public int getTeam_size() {
        return team_size;
    }

    public void setTeam_size(int team_size) {
        this.team_size = team_size;
    }

    public String getTeam_avg_age() {
        return team_avg_age;
    }

    public void setTeam_avg_age(String team_avg_age) {
        this.team_avg_age = team_avg_age;
    }

    public int getTeam_avg_seniority() {
        return team_avg_seniority;
    }

    public void setTeam_avg_seniority(int team_avg_seniority) {
        this.team_avg_seniority = team_avg_seniority;
    }

    public int getTeam_fee_min() {
        return team_fee_min;
    }

    public void setTeam_fee_min(int team_fee_min) {
        this.team_fee_min = team_fee_min;
    }

    public int getTeam_fee_max() {
        return team_fee_max;
    }

    public void setTeam_fee_max(int team_fee_max) {
        this.team_fee_max = team_fee_max;
    }

    public String getTeam_desc() {
        return team_desc;
    }

    public void setTeam_desc(String team_desc) {
        this.team_desc = team_desc;
    }

    public String getTeam_home_text() {
        return team_home_text;
    }

    public void setTeam_home_text(String team_home_text) {
        this.team_home_text = team_home_text;
    }

    public String getTeam_work_text() {
        return team_work_text;
    }

    public void setTeam_work_text(String team_work_text) {
        this.team_work_text = team_work_text;
    }

    public List<SelectExperienceBean> getTeam_experience() {
        return team_experience;
    }

    public void setTeam_experience(List<SelectExperienceBean> team_experience) {
        this.team_experience = team_experience;
    }

    public List<DescImageBean> getTeam_desc_image() {
        return team_desc_image;
    }

    public void setTeam_desc_image(List<DescImageBean> team_desc_image) {
        this.team_desc_image = team_desc_image;
    }

    public List<SelectBean> getTeam_type() {
        return team_type;
    }

    public void setTeam_type(List<SelectBean> team_type) {
        this.team_type = team_type;
    }

    public List<SelectBean> getTeam_industry() {
        return team_industry;
    }

    public void setTeam_industry(List<SelectBean> team_industry) {
        this.team_industry = team_industry;
    }

    public List<SelectBean> getTeam_cert() {
        return team_cert;
    }

    public void setTeam_cert(List<SelectBean> team_cert) {
        this.team_cert = team_cert;
    }

    public List<String> getTeam_home() {
        return team_home;
    }

    public void setTeam_home(List<String> team_home) {
        this.team_home = team_home;
    }

    public List<String> getTeam_work() {
        return team_work;
    }

    public void setTeam_work(List<String> team_work) {
        this.team_work = team_work;
    }


    public TeamContentBean() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.resume_title);
        dest.writeString(this.team_contact_name);
        dest.writeString(this.team_avatar);
        dest.writeString(this.team_contact_cell_phone);
        dest.writeInt(this.team_size);
        dest.writeString(this.team_avg_age);
        dest.writeInt(this.team_avg_seniority);
        dest.writeInt(this.team_fee_min);
        dest.writeInt(this.team_fee_max);
        dest.writeString(this.team_desc);
        dest.writeString(this.team_home_text);
        dest.writeString(this.team_work_text);
        dest.writeTypedList(this.team_experience);
        dest.writeTypedList(this.team_desc_image);
        dest.writeTypedList(this.team_type);
        dest.writeTypedList(this.team_industry);
        dest.writeTypedList(this.team_cert);
        dest.writeStringList(this.team_home);
        dest.writeStringList(this.team_work);
    }

    protected TeamContentBean(Parcel in) {
        this.resume_title = in.readString();
        this.team_contact_name = in.readString();
        this.team_avatar = in.readString();
        this.team_contact_cell_phone = in.readString();
        this.team_size = in.readInt();
        this.team_avg_age = in.readString();
        this.team_avg_seniority = in.readInt();
        this.team_fee_min = in.readInt();
        this.team_fee_max = in.readInt();
        this.team_desc = in.readString();
        this.team_home_text = in.readString();
        this.team_work_text = in.readString();
        this.team_experience = in.createTypedArrayList(SelectExperienceBean.CREATOR);
        this.team_desc_image = in.createTypedArrayList(DescImageBean.CREATOR);
        this.team_type = in.createTypedArrayList(SelectBean.CREATOR);
        this.team_industry = in.createTypedArrayList(SelectBean.CREATOR);
        this.team_cert = in.createTypedArrayList(SelectBean.CREATOR);
        this.team_home = in.createStringArrayList();
        this.team_work = in.createStringArrayList();
    }

    public static final Creator<TeamContentBean> CREATOR = new Creator<TeamContentBean>() {
        @Override
        public TeamContentBean createFromParcel(Parcel source) {
            return new TeamContentBean(source);
        }

        @Override
        public TeamContentBean[] newArray(int size) {
            return new TeamContentBean[size];
        }
    };
}
