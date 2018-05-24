package com.sx.common_base.listScreen.bean;


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
 * description : 专家列表
 * 
 * revision history :
 * 
 * ============================================================
 * 
 */
public class ExpertListResult extends BaseResult {
	private static final long serialVersionUID = 1L;
	public ExpertListData data;

	public class ExpertListData {
		public ArrayList<Expert> list;
	}

	public class Expert implements Serializable {
		private static final long serialVersionUID = 1L;
		public String outside_symbol;
		public String profile_id;
		public String expert_industry;
		public String expert_skill;
		public String profile_name;
		public String profile_avatar;
		public String expert_area;
		public String expert_form;
	}
}
