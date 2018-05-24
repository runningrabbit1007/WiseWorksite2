package com.sx.common_base.result;

import com.sx.common_base.bean.CityItemBean;
import com.sx.common_base.bean.MallCityItemBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/15.
 */

public class AreaListResult {

    ArrayList<MallCityItemBean> areaList;

    public ArrayList<MallCityItemBean> getAreaList() {
        return areaList;
    }

    public void setAreaList(ArrayList<MallCityItemBean> areaList) {
        this.areaList = areaList;
    }
}
