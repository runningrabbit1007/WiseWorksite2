package com.common.base.http;

import com.common.base.bean.ServiceBean;
import com.common.base.bean.pojo.BaseSaveFilePojo;
import com.common.base.bean.pojo.BaseUplodFilePojo;
import com.zhy.http.okhttp.callback.Callback;
import com.zhy.http.okhttp.callback.FileCallBack;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import okhttp3.Response;

/**
 * Created by Jack on 2016/5/19.
 */
public abstract class HttpBase {



    /**
     * 异步GET请求方法07
     *  @param targetUrl      目标地址
     * @param params         参数集合
     * @param headers        请求头集合
     * @param tag            请求标志
     * @param readTime       设置读取超时时间
     * @param connTime       设置连接超时时间
     * @param resultCallBack 
     */
    protected abstract void doGetAsyn(String targetUrl, HashMap params, HashMap headers, Object tag, long readTime, long connTime, Callback resultCallBack);

    /**
     * 异步GET请求方法06
     *  @param targetUrl      目标地址
     * @param params         参数集合
     * @param tag            请求标志
     * @param resultCallBack 
     */
    public void doGetAsyn(String targetUrl, HashMap params, HashMap header, Object tag, Callback resultCallBack) {
        this.doGetAsyn(targetUrl, params, header, tag, -1, -1, resultCallBack);
    }

    /**
     * 异步GET请求方法05
     *
     * @param targetUrl      目标地址
     * @param params         参数集合
     * @param resultCallBack 
     */
    public void doGetAsyn(String targetUrl, HashMap params, HashMap header, Callback resultCallBack) {
        this.doGetAsyn(targetUrl, params, header, null, -1, -1, resultCallBack);
    }

    /**
     * 异步GET请求方法04
     *  @param targetUrl      目标地址
     * @param params         参数集合
     * @param tag            请求标志
     * @param resultCallBack 
     */
    public void doGetAsyn(String targetUrl, HashMap params, Object tag, Callback resultCallBack) {
        this.doGetAsyn(targetUrl, params, null, tag, -1, -1, resultCallBack);
    }

    /**
     * 异步GET请求方法03
     *
     * @param targetUrl      目标地址
     * @param params         参数集合
     * @param resultCallBack 
     */
    public void doGetAsyn(String targetUrl, HashMap params, Callback resultCallBack) {
        this.doGetAsyn(targetUrl, params, null, null, -1, -1, resultCallBack);
    }

    /**
     * 异步GET请求方法02
     *
     * @param targetUrl      目标地址
     * @param tag            请求标志
     * @param resultCallBack 
     */
    public void doGetAsyn(String targetUrl, Object tag, Callback resultCallBack) {
        this.doGetAsyn(targetUrl, null, null, tag, -1, -1, resultCallBack);
    }

    /**
     * 异步GET请求方法01
     *
     * @param targetUrl      目标地址
     * @param resultCallBack 
     */
    public void doGetAsyn(String targetUrl, Callback resultCallBack) {
        doGetAsyn(targetUrl, resultCallBack);
    }










    //************************************************//


    /**
     * 同步GET请求方法07
     *  @param targetUrl      目标地址
     * @param params         参数集合
     * @param headers        请求头集合
     * @param tag            请求标志
     * @param readTime       设置读取超时时间
     * @param connTime       设置连接超时时间
     */
    protected abstract Response doGetSync(String targetUrl, HashMap params, HashMap headers, Object tag, long readTime, long connTime);

    /**
     * 同步GET请求方法06
     *
     * @param targetUrl      目标地址
     * @param params         参数集合
     * @param tag            请求标志
     */
    public Response doGetSync(String targetUrl, HashMap params, HashMap header, Object tag) {
       return this.doGetSync(targetUrl, params, header, tag, -1, -1);
    }

    /**
     * 同步GET请求方法05
     *
     * @param targetUrl      目标地址
     * @param params         参数集合
     */
    public Response doGetSync(String targetUrl, HashMap params, HashMap header) {
       return this.doGetSync(targetUrl, params, header, null, -1, -1);
    }

    /**
     * 同步GET请求方法04
     *
     * @param targetUrl      目标地址
     * @param params         参数集合
     * @param tag            请求标志
     *  
     */
    public Response doGetSync(String targetUrl, HashMap params, Object tag) {
       return this.doGetSync(targetUrl, params, null, tag, -1, -1);
    }

    /**
     * 同步GET请求方法03
     *
     * @param targetUrl      目标地址
     * @param params         参数集合
     *  
     */
    public Response doGetSync(String targetUrl, HashMap params) {
        return this.doGetSync(targetUrl, params, null, null, -1, -1);
    }

    /**
     * 同步GET请求方法02
     *
     * @param targetUrl      目标地址
     * @param tag            请求标志
     *  
     */
    public Response doGetSync(String targetUrl, Object tag) {
       return this.doGetSync(targetUrl, null, null, tag, -1, -1);
    }

    /**
     * 同步GET请求方法01
     *
     * @param targetUrl      目标地址
     *  
     */
    public Response doGetSync(String targetUrl) {
       return this.doGetSync(targetUrl, null, null, null, -1, -1);
    }

    //***************************************************


    /**
     * 异步POST请求方法07
     *
     * @param targetUrl      目标地址
     * @param params         参数集合
     * @param headers        请求头集合
     * @param tag            请求标志
     * @param readTime       设置读取超时时间
     * @param connTime       设置连接超时时间
     *  
     */
    protected abstract void doPostAsyn(String targetUrl, HashMap params, HashMap headers, Object tag, long readTime, long connTime, Callback resultCallBack);

    /**
     * 异步POST请求方法06
     *
     * @param targetUrl      目标地址
     * @param params         参数集合
     * @param tag            请求标志
     *  
     */
    public void doPostAsyn(String targetUrl, HashMap params, HashMap header, Object tag, Callback resultCallBack) {
        this.doPostAsyn(targetUrl, params, header, tag, -1, -1, resultCallBack);
    }

    /**
     * 异步POST请求方法05
     *
     * @param targetUrl      目标地址
     * @param params         参数集合
     *  
     */
    public void doPostAsyn(String targetUrl, HashMap params, HashMap header, Callback resultCallBack) {
        this.doPostAsyn(targetUrl, params, header, null, -1, -1, resultCallBack);
    }

    /**
     * 异步POST请求方法04
     *
     * @param targetUrl      目标地址
     * @param params         参数集合
     * @param tag            请求标志
     *  
     */
    public void doPostAsyn(String targetUrl, HashMap params, Object tag, Callback resultCallBack) {
        this.doPostAsyn(targetUrl, params, null, tag, -1, -1, resultCallBack);
    }

    /**
     * 异步POST请求方法03
     *
     * @param targetUrl      目标地址
     * @param params         参数集合
     *  
     */
    public void doPostAsyn(String targetUrl, HashMap params, Callback resultCallBack) {
        this.doPostAsyn(targetUrl, params, null, null, -1, -1, resultCallBack);
    }

    /**
     * 异步POST请求方法02
     *
     * @param targetUrl      目标地址
     * @param tag            请求标志
     *  
     */
    public void doPostAsyn(String targetUrl, Object tag, Callback resultCallBack) {
        this.doPostAsyn(targetUrl, null, null, tag, -1, -1, resultCallBack);
    }

    /**
     * 异步POST请求方法01
     *
     * @param targetUrl      目标地址
     *  
     */
    public void doPostAsyn(String targetUrl, Callback resultCallBack) {
        this.doPostAsyn(targetUrl, null, null, null, -1, -1, resultCallBack);
    }

    //**************************************************************


    /**
     * 同步POST请求方法07
     *
     * @param targetUrl      目标地址
     * @param params         参数集合
     * @param headers        请求头集合
     * @param tag            请求标志
     * @param readTime       设置读取超时时间
     * @param connTime       设置连接超时时间
     */
    protected abstract Response doPostSync(String targetUrl, HashMap params, HashMap headers, Object tag, long readTime, long connTime);

    /**
     * 同步POST请求方法06
     *
     * @param targetUrl      目标地址
     * @param params         参数集合
     * @param tag            请求标志
     */
    public Response doPostSync(String targetUrl, HashMap params, HashMap header, Object tag) {
        return this.doPostSync(targetUrl, params, header, tag, -1, -1);
    }

    /**
     * 同步POST请求方法05
     *
     * @param targetUrl      目标地址
     * @param params         参数集合
     */
    public Response doPostSync(String targetUrl, HashMap params, HashMap header) {
        return this.doPostSync(targetUrl, params, header, null, -1, -1);
    }

    /**
     * 同步POST请求方法04
     *
     * @param targetUrl      目标地址
     * @param params         参数集合
     * @param tag            请求标志
     */
    public Response doPostSync(String targetUrl, HashMap params, Object tag) {
        return this.doPostSync(targetUrl, params, null, tag, -1, -1);
    }

    /**
     * 同步POST请求方法03
     *
     * @param targetUrl      目标地址
     * @param params         参数集合
     */
    public Response doPostSync(String targetUrl, HashMap params ) {
        return this.doPostSync(targetUrl, params, null, null, -1, -1);
    }

    /**
     * 同步POST请求方法02
     *
     * @param targetUrl      目标地址
     * @param tag            请求标志
     */
    public Response doPostSync(String targetUrl, Object tag) {
        return this.doPostSync(targetUrl, null, null, tag, -1, -1);
    }

    /**
     * 同步POST请求方法01
     *
     * @param targetUrl      目标地址
     */
    public Response doPostSync(String targetUrl) {
        return this.doPostSync(targetUrl, null, null, null, -1, -1);
    }

    //************************************************************

    /**
     * POST请求方法提交String数据
     */
    public abstract void doPostStringAsyn(String url, String content, Callback callback);
    /**
     * POST请求方法提交String数据
     */
    public abstract Response doPsotStringSync(String url, String content) throws IOException;







    public void doPostFileAsyn() {

    }


    /**
     * 多文件上传方法07
     *
     * @param targetUrl        目标地址
     * @param params           参数集合
     * @param headers          请求头集合
     * @param tag              请求标志
     * @param readTime         设置读取超时时间
     * @param connTime         设置连接超时时间
     * @param list             目标文件列表
     * @param progressCallback 进度回调
     */
    protected abstract void doMultiUploadFiles(String targetUrl, HashMap params, HashMap headers, Object tag, long readTime, long connTime, List<? extends BaseUplodFilePojo> list, Callback progressCallback);

    /**
     * 多文件上传方法06
     *
     * @param targetUrl        目标地址
     * @param params           参数集合
     * @param tag              请求标志
     * @param list             目标文件列表
     * @param progressCallback 进度回调
     */
    public void doMultiUploadFiles(String targetUrl, HashMap params, HashMap header, Object tag, List<? extends BaseUplodFilePojo> list,Callback progressCallback) {
        this.doMultiUploadFiles(targetUrl, params, header, tag, -1, -1, list, progressCallback);
    }

    /**
     * 多文件上传方法05
     *
     * @param targetUrl        目标地址
     * @param params           参数集合
     * @param list             目标文件列表
     * @param progressCallback 进度回调
     */
    public void doMultiUploadFiles(String targetUrl, HashMap params, HashMap header, List<? extends BaseUplodFilePojo> list,Callback progressCallback) {
        this.doMultiUploadFiles(targetUrl, params, header, null, -1, -1, list, progressCallback);
    }

    /**
     * 多文件上传方法04
     *
     * @param targetUrl        目标地址
     * @param params           参数集合
     * @param tag              请求标志
     * @param list             目标文件列表
     * @param progressCallback 进度回调
     */
    public void doMultiUploadFiles(String targetUrl, HashMap params, Object tag, List<? extends BaseUplodFilePojo> list,Callback progressCallback) {
        this.doMultiUploadFiles(targetUrl, params, null, tag, -1, -1, list, progressCallback);
    }

    /**
     * 多文件上传方法03
     *
     * @param targetUrl        目标地址
     * @param params           参数集合
     * @param list             目标文件列表
     * @param progressCallback 进度回调
     */
    public void doMultiUploadFiles(String targetUrl, HashMap params, List<? extends BaseUplodFilePojo> list,Callback progressCallback) {
        this.doMultiUploadFiles(targetUrl, params, null, null, -1, -1, list, progressCallback);
    }

    /**
     * 多文件上传方法02
     *
     * @param targetUrl        目标地址
     * @param tag              请求标志
     * @param list             目标文件列表
     * @param progressCallback 进度回调
     */
    public void doMultiUploadFiles(String targetUrl, Object tag, List<? extends BaseUplodFilePojo> list,Callback progressCallback) {
        this.doMultiUploadFiles(targetUrl, null, null, tag, -1, -1, list, progressCallback);
    }

    /**
     * 多文件上传方法01
     *
     * @param targetUrl        目标地址
     * @param list             目标文件列表
     * @param progressCallback 进度回调
     */
    public void doMultiUploadFiles(String targetUrl, List<? extends BaseUplodFilePojo> list,Callback progressCallback) {
        this.doMultiUploadFiles(targetUrl, null, null, null, -1, -1, list, progressCallback);
    }



    /**
     * 多文件上传方法07
     *  @param targetUrl        目标地址
     * @param params           参数集合
     * @param headers          请求头集合
     * @param tag              请求标志
     * @param readTime         设置读取超时时间
     * @param connTime         设置连接超时时间
     * @param pojo
     * @param progressCallback 进度回调
     */
    protected abstract void doSimpleUploadFile(String targetUrl, HashMap params, HashMap headers, Object tag, long readTime, long connTime, ServiceBean pojo, Callback progressCallback);

    /**
     * 多文件上传方法06
     *
     * @param targetUrl        目标地址
     * @param params           参数集合
     * @param header
     * @param tag              请求标志
     * @param pojo
     * @param progressCallback 进度回调
     */
    public void doSimpleUploadFile(String targetUrl, HashMap params, HashMap header, Object tag, ServiceBean pojo,Callback progressCallback) {
        this.doSimpleUploadFile(targetUrl, params, header, tag, -1, -1, pojo, progressCallback);
    }

    /**
     * 多文件上传方法05
     *
     * @param targetUrl        目标地址
     * @param params           参数集合
     * @param header
     * @param pojo
     * @param progressCallback 进度回调
     */
    public void doSimpleUploadFile(String targetUrl, HashMap params, HashMap header, ServiceBean pojo,Callback progressCallback) {
        this.doSimpleUploadFile(targetUrl, params, header, null, -1, -1, pojo, progressCallback);
    }

    /**
     * 多文件上传方法04
     *
     * @param targetUrl        目标地址
     * @param params           参数集合
     * @param tag              请求标志
     * @param pojo
     * @param progressCallback 进度回调
     */
    public void doSimpleUploadFile(String targetUrl, HashMap params, Object tag, ServiceBean pojo,Callback progressCallback) {
        this.doSimpleUploadFile(targetUrl, params, null, tag, -1, -1, pojo, progressCallback);
    }

    /**
     * 多文件上传方法03
     *
     * @param targetUrl        目标地址
     * @param params           参数集合
     * @param pojo
     * @param progressCallback 进度回调
     */
    public void doSimpleUploadFile(String targetUrl, HashMap params, ServiceBean pojo,Callback progressCallback) {
        this.doSimpleUploadFile(targetUrl, params, null, null, -1, -1, pojo, progressCallback);
    }

    /**
     * 多文件上传方法02
     *
     * @param targetUrl        目标地址
     * @param tag              请求标志
     * @param pojo
     * @param progressCallback 进度回调
     */
    public void doSimpleUploadFile(String targetUrl, Object tag, ServiceBean pojo,Callback progressCallback) {
        this.doSimpleUploadFile(targetUrl, null, null, tag, -1, -1, pojo, progressCallback);
    }


    /**
     * 多文件上传方法01
     *  @param targetUrl        目标地址
     * @param pojo
     * @param progressCallback 进度回调
     */
    public void doSimpleUploadFile(String targetUrl, ServiceBean pojo,Callback progressCallback) {
        this.doSimpleUploadFile(targetUrl, null, null, null, -1, -1, pojo, progressCallback);
    }



    /**
     * 文件下载请求方法07
     *
     * @param targetUrl                  目标地址
     * @param params                     参数集合
     * @param headers                    请求头集合
     * @param tag                        请求标志
     * @param readTime                   设置读取超时时间
     * @param connTime                   设置连接超时时间
     * @param saveFileBean               文件存储信息对象
     * @param baseFileProgressCallback 文件下载进度回调
     */
    protected abstract void doSimpleDownloadFiles(String targetUrl, HashMap params, HashMap headers, Object tag, long readTime, long connTime, BaseSaveFilePojo saveFileBean, FileCallBack baseFileProgressCallback);

    /**
     * 文件下载请求方法06
     *
     * @param targetUrl                  目标地址
     * @param params                     参数集合
     * @param tag                        请求标志
     * @param saveFileBean               文件存储信息对象
     * @param baseFileProgressCallback 文件下载进度回调
     */
    public void doSimpleDownloadFiles(String targetUrl, HashMap params, HashMap header, Object tag, BaseSaveFilePojo saveFileBean, FileCallBack baseFileProgressCallback) {
        this.doSimpleDownloadFiles(targetUrl, params, header, tag, -1, -1, saveFileBean, baseFileProgressCallback);
    }

    /**
     * 文件下载最终请求方法05
     *
     * @param targetUrl                  目标地址
     * @param params                     参数集合
     * @param saveFileBean               文件存储信息对象
     * @param baseFileProgressCallback 文件下载进度回调
     */
    public void doSimpleDownloadFiles(String targetUrl, HashMap params, HashMap header, BaseSaveFilePojo saveFileBean, FileCallBack baseFileProgressCallback) {
        this.doSimpleDownloadFiles(targetUrl, params, header, null, -1, -1, saveFileBean, baseFileProgressCallback);
    }

    /**
     * 文件下载最终请求方法04
     *
     * @param targetUrl                  目标地址
     * @param params                     参数集合
     * @param tag                        请求标志
     * @param saveFileBean               文件存储信息对象
     * @param baseFileProgressCallback 文件下载进度回调
     */
    public void doSimpleDownloadFiles(String targetUrl, HashMap params, Object tag, BaseSaveFilePojo saveFileBean, FileCallBack baseFileProgressCallback) {
        this.doSimpleDownloadFiles(targetUrl, params, null, tag, -1, -1, saveFileBean, baseFileProgressCallback);
    }

    /**
     * 文件下载最终请求方法03
     *
     * @param targetUrl                  目标地址
     * @param params                     参数集合
     * @param saveFileBean               文件存储信息对象
     * @param baierFileProgressCallback 文件下载进度回调
     */
    public void doSimpleDownloadFiles(String targetUrl, HashMap params, BaseSaveFilePojo saveFileBean, FileCallBack baierFileProgressCallback) {
        this.doSimpleDownloadFiles(targetUrl, params, null, null, -1, -1, saveFileBean, baierFileProgressCallback);
    }

    /**
     * 文件下载最终请求方法02
     *
     * @param targetUrl                  目标地址
     * @param tag                        请求标志
     * @param saveFileBean               文件存储信息对象
     * @param baseFileProgressCallback 文件下载进度回调
     */
    public void doSimpleDownloadFiles(String targetUrl, Object tag, BaseSaveFilePojo saveFileBean, FileCallBack baseFileProgressCallback) {
        this.doSimpleDownloadFiles(targetUrl, null, null, tag, -1, -1, saveFileBean, baseFileProgressCallback);
    }

    /**
     * 文件下载请求方法01
     *
     * @param targetUrl                  目标地址
     * @param saveFileBean               文件存储信息对象
     * @param baseFileProgressCallback 文件下载进度回调
     */
    public void doSimpleDownloadFiles(String targetUrl, BaseSaveFilePojo saveFileBean, FileCallBack baseFileProgressCallback) {
        this.doSimpleDownloadFiles(targetUrl, null, null, null, -1, -1, saveFileBean, baseFileProgressCallback);
    }


    /**
     * 取消目标tag的请求
     *
     * @param tag
     */
    protected abstract void doCancel(Object tag);
}
