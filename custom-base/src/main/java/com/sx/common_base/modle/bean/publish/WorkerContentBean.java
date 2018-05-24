package com.sx.common_base.modle.bean.publish;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Author : Jack
 * Email  : jackzhonglyy@outlook.com
 * Date   : ${date}
 * Desc   :
 * 携参说明：
 * <p>
 * 返回值说明：
 */

public  class WorkerContentBean implements Parcelable {
    /**
     * resume_title : We're
     * worker_name : We're
     * worker_avatar :
     * worker_cell_phone : 18874538201
     * worker_sex : 1
     * worker_birth : 1975-03-03
     * worker_seniority : 2
     * worker_fee_min : 222
     * worker_fee_max : 222
     * worker_experience : [{"p":"123","j":"3333"}]
     * worker_desc : Asdasdasdasda
     * worker_desc_image : ["http://resource.ffu365.com/upload/images/labour_recruitment/2017-07-24/59755f6714ffe4.53389512_low.png","http://resource.ffu365.com/upload/images/labour_recruitment/2017-07-24/59755f67520918.94137900_low.png","http://resource.ffu365.com/upload/images/labour_recruitment/2017-07-24/59755f67782ed3.04915072_low.png"]
     * worker_home_text :
     * worker_work_text :
     * worker_type : [{"id":"308","text":"保冷-保冷外护工"}]
     * worker_industry : [{"id":"328","text":"玻璃钢衬里-衬贴工"}]
     * worker_cert : [{"id":"427","text":"抹灰工"}]
     * worker_home : ["140000000","140400000"]
     * worker_work : ["140000000","140400000"]
     */

    private String resume_title;
    private String worker_name;
    private String worker_avatar;
    private String worker_cell_phone;
    private int worker_sex;
    private String worker_birth;
    private int worker_seniority;
    private int worker_fee_min;
    private int worker_fee_max;
    private String worker_desc;
    private String worker_home_text;
    private String worker_work_text;
    private List<SelectExperienceBean> worker_experience;
    private List<DescImageBean> worker_desc_image;
    private List<SelectBean> worker_type;
    private List<SelectBean> worker_industry;
    private List<SelectBean> worker_cert;
    private List<String> worker_home;
    private List<String> worker_work;

    public String getResume_title() {
        return resume_title;
    }

    public void setResume_title(String resume_title) {
        this.resume_title = resume_title;
    }

    public String getWorker_name() {
        return worker_name;
    }

    public void setWorker_name(String worker_name) {
        this.worker_name = worker_name;
    }

    public String getWorker_avatar() {
        return worker_avatar;
    }

    public void setWorker_avatar(String worker_avatar) {
        this.worker_avatar = worker_avatar;
    }

    public String getWorker_cell_phone() {
        return worker_cell_phone;
    }

    public void setWorker_cell_phone(String worker_cell_phone) {
        this.worker_cell_phone = worker_cell_phone;
    }

    public int getWorker_sex() {
        return worker_sex;
    }

    public void setWorker_sex(int worker_sex) {
        this.worker_sex = worker_sex;
    }

    public String getWorker_birth() {
        return worker_birth;
    }

    public void setWorker_birth(String worker_birth) {
        this.worker_birth = worker_birth;
    }

    public int getWorker_seniority() {
        return worker_seniority;
    }

    public void setWorker_seniority(int worker_seniority) {
        this.worker_seniority = worker_seniority;
    }

    public int getWorker_fee_min() {
        return worker_fee_min;
    }

    public void setWorker_fee_min(int worker_fee_min) {
        this.worker_fee_min = worker_fee_min;
    }

    public int getWorker_fee_max() {
        return worker_fee_max;
    }

    public void setWorker_fee_max(int worker_fee_max) {
        this.worker_fee_max = worker_fee_max;
    }

    public String getWorker_desc() {
        return worker_desc;
    }

    public void setWorker_desc(String worker_desc) {
        this.worker_desc = worker_desc;
    }

    public String getWorker_home_text() {
        return worker_home_text;
    }

    public void setWorker_home_text(String worker_home_text) {
        this.worker_home_text = worker_home_text;
    }

    public String getWorker_work_text() {
        return worker_work_text;
    }

    public void setWorker_work_text(String worker_work_text) {
        this.worker_work_text = worker_work_text;
    }

    public List<SelectExperienceBean> getWorker_experience() {
        return worker_experience;
    }

    public void setWorker_experience(List<SelectExperienceBean> worker_experience) {
        this.worker_experience = worker_experience;
    }

    public List<DescImageBean> getWorker_desc_image() {
        return worker_desc_image;
    }

    public void setWorker_desc_image(List<DescImageBean> worker_desc_image) {
        this.worker_desc_image = worker_desc_image;
    }

    public List<SelectBean> getWorker_type() {
        return worker_type;
    }

    public void setWorker_type(List<SelectBean> worker_type) {
        this.worker_type = worker_type;
    }

    public List<SelectBean> getWorker_industry() {
        return worker_industry;
    }

    public void setWorker_industry(List<SelectBean> worker_industry) {
        this.worker_industry = worker_industry;
    }

    public List<SelectBean> getWorker_cert() {
        return worker_cert;
    }

    public void setWorker_cert(List<SelectBean> worker_cert) {
        this.worker_cert = worker_cert;
    }

    public List<String> getWorker_home() {
        return worker_home;
    }

    public void setWorker_home(List<String> worker_home) {
        this.worker_home = worker_home;
    }

    public List<String> getWorker_work() {
        return worker_work;
    }

    public void setWorker_work(List<String> worker_work) {
        this.worker_work = worker_work;
    }


    public WorkerContentBean() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.resume_title);
        dest.writeString(this.worker_name);
        dest.writeString(this.worker_avatar);
        dest.writeString(this.worker_cell_phone);
        dest.writeInt(this.worker_sex);
        dest.writeString(this.worker_birth);
        dest.writeInt(this.worker_seniority);
        dest.writeInt(this.worker_fee_min);
        dest.writeInt(this.worker_fee_max);
        dest.writeString(this.worker_desc);
        dest.writeString(this.worker_home_text);
        dest.writeString(this.worker_work_text);
        dest.writeTypedList(this.worker_experience);
        dest.writeTypedList(this.worker_desc_image);
        dest.writeTypedList(this.worker_type);
        dest.writeTypedList(this.worker_industry);
        dest.writeTypedList(this.worker_cert);
        dest.writeStringList(this.worker_home);
        dest.writeStringList(this.worker_work);
    }

    protected WorkerContentBean(Parcel in) {
        this.resume_title = in.readString();
        this.worker_name = in.readString();
        this.worker_avatar = in.readString();
        this.worker_cell_phone = in.readString();
        this.worker_sex = in.readInt();
        this.worker_birth = in.readString();
        this.worker_seniority = in.readInt();
        this.worker_fee_min = in.readInt();
        this.worker_fee_max = in.readInt();
        this.worker_desc = in.readString();
        this.worker_home_text = in.readString();
        this.worker_work_text = in.readString();
        this.worker_experience = in.createTypedArrayList(SelectExperienceBean.CREATOR);
        this.worker_desc_image = in.createTypedArrayList(DescImageBean.CREATOR);
        this.worker_type = in.createTypedArrayList(SelectBean.CREATOR);
        this.worker_industry = in.createTypedArrayList(SelectBean.CREATOR);
        this.worker_cert = in.createTypedArrayList(SelectBean.CREATOR);
        this.worker_home = in.createStringArrayList();
        this.worker_work = in.createStringArrayList();
    }

    public static final Creator<WorkerContentBean> CREATOR = new Creator<WorkerContentBean>() {
        @Override
        public WorkerContentBean createFromParcel(Parcel source) {
            return new WorkerContentBean(source);
        }

        @Override
        public WorkerContentBean[] newArray(int size) {
            return new WorkerContentBean[size];
        }
    };
}