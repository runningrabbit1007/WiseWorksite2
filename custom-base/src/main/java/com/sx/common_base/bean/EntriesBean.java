package com.sx.common_base.bean;

/**
 * Created by Administrator on 2018/4/9.
 */

public class EntriesBean {

    /**
     * name : 屏幕尺寸
     * value : 50英寸
     */

    private String name;
    private String value;
    private int id;
    private String parentname;

    public String getParentname() {
        return parentname;
    }

    public void setParentname(String parentname) {
        this.parentname = parentname;
    }

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
