package com.sx.common_base.modle;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jack on 2017/6/5.
 */

public class ApiEntity {
    @SerializedName("@Url")
    public String url;
    @SerializedName("@Key")
    public String key;
    @SerializedName("@Expires")
    public String expires;
    @SerializedName("@NetType")
    public String netType;
    @SerializedName("@Token")
    public boolean needLogin;
    @SerializedName("@CacheMaxCount")
    public int maxCount;
    @SerializedName("@MockHandler")
    public String mockhandler;
    @SerializedName("@Scope")
    public String scope;

}
