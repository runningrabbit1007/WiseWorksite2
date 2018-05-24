package com.common.base.bean.pojo;

import java.io.Serializable;

/**
 * Created by Jack on 2016/5/19.
 * 文件存储信息对象
 */
public class BaseSaveFilePojo implements Serializable {
    private static final long serialVersionUID = 1L;
    /**文件地址*/
    public String savePath;
    /**文件名*/
    public String saveName;

}
