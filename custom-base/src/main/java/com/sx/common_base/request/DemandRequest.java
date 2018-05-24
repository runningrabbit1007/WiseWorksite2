package com.sx.common_base.request;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Administrator on 2018/1/2.
 */

public class DemandRequest {


    /**
     * description : string
     * id : 0
     * images : [{"order":0,"url":"string"}]
     * member : 0
     * name : string
     * number : 0
     * price : 0
     * productCategory : 0
     * salesMember : 0
     * type : 0
     */

    private String description;
    private String id;
    private String member;
    private String name;
    private String number;
    private String price;
    private String productCategory;
    private String salesMember;
    private String type;
    private List<ImagesBean> images;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getSalesMember() {
        return salesMember;
    }

    public void setSalesMember(String salesMember) {
        this.salesMember = salesMember;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ImagesBean> getImages() {
        return images;
    }

    public void setImages(List<ImagesBean> images) {
        this.images = images;
    }

    public static class ImagesBean  implements Parcelable{
        /**
         * order : 0
         * url : string
         */

        private String order;
        private String url;

        protected ImagesBean(Parcel in) {
            order = in.readString();
            url = in.readString();
        }

        public static final Creator<ImagesBean> CREATOR = new Creator<ImagesBean>() {
            @Override
            public ImagesBean createFromParcel(Parcel in) {
                return new ImagesBean(in);
            }

            @Override
            public ImagesBean[] newArray(int size) {
                return new ImagesBean[size];
            }
        };

        public ImagesBean() {
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(order);
            dest.writeString(url);
        }
    }
}
