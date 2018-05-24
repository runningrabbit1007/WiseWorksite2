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

public class TechDemandBean implements Parcelable {
    /**
     * req_title : 大跳冲锋冲锋火箭鞋
     * contact_name : 二手冰箱
     * contact_cell_phone : 18874538201
     * req_option : 2
     * req_option_text : 电话咨询服务
     * req_type : 8
     * req_type_text : 技术领域文本
     * req_industry : 22
     * req_industry_text : 需求的行业
     * desc : 阿尔萨斯，萨尔萨斯，我回来了！
     * desc_image : [{"url":"http://a.2.com","width":555,"height":999},{"url":"http://a.2.com","width":555,"height":999}]
     */

    private String req_title;
    private String contact_name;
    private String contact_cell_phone;
    private String req_option;
    private String req_option_text;
    private int req_type;
    private String req_type_text;
    private int req_industry;
    private String req_industry_text;
    private String desc;
    private List<DescImageBean> desc_image;

    public String getReq_title() {
        return req_title;
    }

    public void setReq_title(String req_title) {
        this.req_title = req_title;
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public String getContact_cell_phone() {
        return contact_cell_phone;
    }

    public void setContact_cell_phone(String contact_cell_phone) {
        this.contact_cell_phone = contact_cell_phone;
    }

    public String getReq_option() {
        return req_option;
    }

    public void setReq_option(String req_option) {
        this.req_option = req_option;
    }

    public String getReq_option_text() {
        return req_option_text;
    }

    public void setReq_option_text(String req_option_text) {
        this.req_option_text = req_option_text;
    }

    public int getReq_type() {
        return req_type;
    }

    public void setReq_type(int req_type) {
        this.req_type = req_type;
    }

    public String getReq_type_text() {
        return req_type_text;
    }

    public void setReq_type_text(String req_type_text) {
        this.req_type_text = req_type_text;
    }

    public int getReq_industry() {
        return req_industry;
    }

    public void setReq_industry(int req_industry) {
        this.req_industry = req_industry;
    }

    public String getReq_industry_text() {
        return req_industry_text;
    }

    public void setReq_industry_text(String req_industry_text) {
        this.req_industry_text = req_industry_text;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<DescImageBean> getDesc_image() {
        return desc_image;
    }

    public void setDesc_image(List<DescImageBean> desc_image) {
        this.desc_image = desc_image;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.req_title);
        dest.writeString(this.contact_name);
        dest.writeString(this.contact_cell_phone);
        dest.writeString(this.req_option);
        dest.writeString(this.req_option_text);
        dest.writeInt(this.req_type);
        dest.writeString(this.req_type_text);
        dest.writeInt(this.req_industry);
        dest.writeString(this.req_industry_text);
        dest.writeString(this.desc);
        dest.writeTypedList(this.desc_image);
    }

    public TechDemandBean() {
    }

    protected TechDemandBean(Parcel in) {
        this.req_title = in.readString();
        this.contact_name = in.readString();
        this.contact_cell_phone = in.readString();
        this.req_option = in.readString();
        this.req_option_text = in.readString();
        this.req_type = in.readInt();
        this.req_type_text = in.readString();
        this.req_industry = in.readInt();
        this.req_industry_text = in.readString();
        this.desc = in.readString();
        this.desc_image = in.createTypedArrayList(DescImageBean.CREATOR);
    }

    public static final Creator<TechDemandBean> CREATOR = new Creator<TechDemandBean>() {
        @Override
        public TechDemandBean createFromParcel(Parcel source) {
            return new TechDemandBean(source);
        }

        @Override
        public TechDemandBean[] newArray(int size) {
            return new TechDemandBean[size];
        }
    };
}
