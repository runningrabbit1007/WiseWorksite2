package com.common.base.bean.pojo;

import java.io.File;
import java.io.Serializable;

/**
 * Created by Jack on 2016/5/19.
 * 上传文件基本对象
 */
public class BaseUplodFilePojo implements Serializable {
    private static final long serialVersionUID = 1L;
    /**key值*/
    public String key;
    /**文件名*/
    public String filename;
    /**文件对象*/
    public File file;

    public BaseUplodFilePojo(String key, String filename, File file) {
        this.key = key;
        this.filename = filename;
        this.file = file;
    }
}
