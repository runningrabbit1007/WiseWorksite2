package com.sx.common_base.modle.bean.publish;


/**
 * Author : Jack
 * Email  : jackzhonglyy@outlook.com
 * Date   : 2016/10/10
 * Desc   : 跳转类型的bean
 */

public class JumpBean {


//    /**
//     * type : 2
//     * link : app_home
//     */
//
//    private int type;
//    private String link;
//    private JsonObject param;
//    private int bind;
//
//    public int getType() {
//        return type;
//    }
//
//    public void setType(int type) {
//        this.type = type;
//    }
//
//    public String getLink() {
//        return link;
//    }
//
//    public void setLink(String link) {
//        this.link = link;
//    }
//
//    public JsonObject getParam() {
//        return param;
//    }
//
//    public void setParam(JsonObject param) {
//        this.param = param;
//    }
//
//    public int getBind() {
//        return bind;
//    }
//
//    public void setBind(int bind) {
//        this.bind = bind;
//    }

    /**
     * type : 2
     * bind : 1
     * link : labour
     * param : {"type":{"main":32,"sub":38},"page":1,"pagesize":5}
     * param : {"id":2}
     */

    private int type;
    private int bind;
    private String link;
    private Object param;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getBind() {
        return bind;
    }

    public void setBind(int bind) {
        this.bind = bind;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Object getParam() {
        return param;
    }

    public void setParam(Object param) {
        this.param = param;
    }
}
