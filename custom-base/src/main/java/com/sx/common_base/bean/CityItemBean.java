package com.sx.common_base.bean;

import java.io.Serializable;

public class CityItemBean implements Serializable{
	/**
	 * 然而在Android上这个技巧就不再是那么的受推崇了，
	 * 因为字段搜寻要比方法调用效率高得多，
	 * 我们直接访问某个字段可能要比通过getters方法来去访问这个字段快3到7倍。
	 * 不过我们肯定不能仅仅因为效率的原因就将封装这个技巧给抛弃了，
	 * 编写代码还是要按照面向对象思维的，但是我们可以在能优化的地方进行优化，
	 * 比如说避免在内部调用getters/setters方法
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int id;
	private String cityCode;
	
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	
	public String getName(){
		return name;
	}
	public int getId(){
		return id;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setId(int id){
		this.id=id;
	}
	
	public boolean isEqualsAll(){
		return "全部".equals(getName());
	}
}
