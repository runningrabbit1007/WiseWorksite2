package com.sx.common_base.result;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/24.
 */

public class SiteListResult {


    private ArrayList<SiteBean> list;

    public ArrayList<SiteBean> getList() {
        return list;
    }

    public void setList(ArrayList<SiteBean> list) {
        this.list = list;
    }

    public static class SiteBean {
        /**
         * id : 453
         * name : 肯尼亚
         * areaCode : 0086
         */

        private int id;
        private String name;
        private String areaCode;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAreaCode() {
            return areaCode;
        }

        public void setAreaCode(String areaCode) {
            this.areaCode = areaCode;
        }
    }
}
