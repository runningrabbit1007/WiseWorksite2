package com.sx.common_base.modle.work;

public class WorkerRecruitmentListFilter {

	public WorkerRecruitmentListFilter() {
		this.type = new TypeBean();
		this.sort = new SortBean();
		this.location = new LocationBean();
	}

	/**
	 * type : {"main":58,"sub":"77"}
	 * sort : {"field":5,"order":0}
	 * certification : 1
	 * home : {"province":255478,"city":46754}
	 * location : {"province":255478,"city":46754}
	 * page : 1
	 * pagesize : 8
	 */

	private TypeBean type;
	private SortBean sort;
	private LocationBean location;
	private int page;
	private int pagesize;

	public TypeBean getType() {
		return type;
	}

	public void setType(TypeBean type) {
		this.type = type;
	}

	public SortBean getSort() {
		return sort;
	}

	public void setSort(SortBean sort) {
		this.sort = sort;
	}

	public LocationBean getLocation() {
		return location;
	}

	public void setLocation(LocationBean location) {
		this.location = location;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}


}
