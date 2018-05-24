package com.sx.common_base.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yonggege on 2017/11/28.
 */

public class MallCityListBean implements Serializable {
    private ArrayList<MallCityItemBean> cityItemBeanList;

    public ArrayList<MallCityItemBean> getCityItemBeanList() {
        return cityItemBeanList;
    }

    public void setCityItemBeanList(ArrayList<MallCityItemBean> cityItemBeanList) {
        this.cityItemBeanList = cityItemBeanList;
    }

    public MallCityListBean(ArrayList<MallCityItemBean> cityItemBeanList) {
        this.cityItemBeanList = cityItemBeanList;
    }
}
