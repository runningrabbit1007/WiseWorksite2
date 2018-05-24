package com.sx.common_base.bean;

import java.io.Serializable;

/**
 * Created by yonggege on 2017/11/28.
 */

public class MallCityItemBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int value;
//    private String full_text;


    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
