package com.sx.common_base.listScreen.entity;


import com.sx.common_base.listScreen.bean.CategoryBean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * ============================================================
 * 
 * project name : TiantianFangFu
 * 
 * copyright ZENG HUI (c) 2015
 * 
 * author : HUI
 * 
 * version : 1.0
 * 
 * date created : On July, 2015
 * 
 * description : 列表用于筛选和选择的实体
 * 
 * revision history :
 * 
 * ============================================================
 * 
 */
public class ListScreeningEntity extends CategoryBean implements Serializable {
	private static final long serialVersionUID = 1L;

	public ListScreeningEntity() {

	}

	public ListScreeningEntity(String domain_desc, String domain_value) {
		this.domain_desc = domain_desc;
		this.domain_value = domain_value;
	}

	public String domain_unit;
	public ArrayList<String> domain_salary;
	public String type;
	public String domain_desc;
	public ArrayList<String> domain_ability;
	public String domain_value;
	public ArrayList<ListScreeningEntity> children = new ArrayList<>();

	@Override
	public boolean equals(Object o) {

		if (o == null) {
			return false;
		}

		if (!(o instanceof ListScreeningEntity)) {
			return false;
		}

		ListScreeningEntity compareObj = (ListScreeningEntity) o;
		return domain_value.equals(compareObj.domain_value)
				&& domain_desc.equals(compareObj.domain_desc);
	}
}
