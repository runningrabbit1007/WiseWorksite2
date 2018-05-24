package com.sx.common_base.modle.request;

/**
 * Created by jacklyy on 2017/6/4.
 */

public class RequestModel {

    /**
     * data : {}
     * report : {"appid":2,"version":114,"location":"29.42,111.11","uid":"10568","cookie":"hgfyeuiow","push_id":"cbe7cabb4033d","debug":0}
     */

    private Object data;
    private ReportBean report;

    public RequestModel() {

    }


    public RequestModel(Object data) {
        this.data = data;
        this.report = new ReportBean();
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ReportBean getReport() {
        return report;
    }

    public void setReport(ReportBean report) {
        this.report = report;
    }



}
