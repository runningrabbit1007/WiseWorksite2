package com.common.base.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 后台服务记录Bean
 */
public class ServiceBean implements Parcelable{
	private int id;
	private String serviceKey;
	private String serviceValues;
	private String serviceUnique;
	private String serviceId;
	private int serviceStatus;

	public String getServiceKey() {
		return serviceKey;
	}


	public void setServiceKey(String serviceKey) {
		this.serviceKey = serviceKey;
	}

	public String getServiceValues() {
		return serviceValues;
	}

	public void setServiceValues(String serviceValues) {
		this.serviceValues = serviceValues;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getServiceStatus() {
		return serviceStatus;
	}

	public void setServiceStatus(int serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceUnique() {
		return serviceUnique;
	}

	public void setServiceUnique(String serviceUnique) {
		this.serviceUnique = serviceUnique;
	}

	/**
	 * Service的构造方法
	 * @param serviceKey 某一个请求任务key，一个key下有多个Service
	 * @param serviceValues 对应的文件路径
	 * @param serviceUnique 对应的文件路径替换“/”为“-”
	 * @param serviceId 该service上传时对应的KEY，用于处理Service的数据更新
	 * @param serviceStatus 该service的上传状态
	 */
	public ServiceBean(String serviceKey, String serviceValues, String serviceUnique, String serviceId, int serviceStatus) {
		this.serviceKey = serviceKey;
		this.serviceValues = serviceValues;
		this.serviceUnique = serviceUnique;
		this.serviceId = serviceId;
		this.serviceStatus = serviceStatus;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(this.id);
		dest.writeString(this.serviceKey);
		dest.writeString(this.serviceValues);
		dest.writeString(this.serviceUnique);
		dest.writeString(this.serviceId);
		dest.writeInt(this.serviceStatus);
	}

	protected ServiceBean(Parcel in) {
		this.id = in.readInt();
		this.serviceKey = in.readString();
		this.serviceValues = in.readString();
		this.serviceUnique = in.readString();
		this.serviceId = in.readString();
		this.serviceStatus = in.readInt();
	}

	public static final Creator<ServiceBean> CREATOR = new Creator<ServiceBean>() {
		@Override
		public ServiceBean createFromParcel(Parcel source) {
			return new ServiceBean(source);
		}

		@Override
		public ServiceBean[] newArray(int size) {
			return new ServiceBean[size];
		}
	};
}
