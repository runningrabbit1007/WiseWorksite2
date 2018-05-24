package com.sx.common_base.util;

import com.common.base.App;
import com.common.utils.CheckUtil;
import com.common.utils.data.DataContainerConvert;
import com.common.utils.resource.AssetsUtils;
import com.common.utils.xml.GsonXml;
import com.common.utils.xml.GsonXmlBuilder;
import com.common.utils.xml.XmlParserCreator;
import com.sx.common_base.modle.ApiEntity;
import com.sx.common_base.modle.Container;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.util.Map;


/**
 * Author : Jack
 * Email  : jackzhonglyy@outlook.com
 * Date   : 2017/6/5
 * Desc   : API管理者
 * 1. 负责从assets中将xml的数据读取到内存中
 * 2. 负责通过APIKey读取APIEntity并返回
 */
public class ApiMaster {
//    public static List<ApiEntity> apiList;
    private static Map<String, ApiEntity> apiMap;
    private static Map<String, ApiEntity> urlMap;
    public static ApiEntity findApiByKey(String apiKey){
        if (CheckUtil.isEmpty(apiKey)){
            return null;
        }
        if (CheckUtil.isEmpty(apiMap)){
            loadApi();
        }
       return apiMap.get(apiKey);
    }

    public static ApiEntity findApiByUrl(String apiUrl){
        if (CheckUtil.isEmpty(apiUrl)){
            return null;
        }
        if (CheckUtil.isEmpty(urlMap)){
            loadApi();
        }
        return urlMap.get(apiUrl);
    }

    public static void loadApi(){
        XmlParserCreator parserCreator = new XmlParserCreator() {
            @Override
            public XmlPullParser createParser() {
                try {
                    return XmlPullParserFactory.newInstance().newPullParser();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };

        GsonXml gsonXml = new GsonXmlBuilder()
                .setXmlParserCreator(parserCreator).setSameNameLists(true)
                .create();

        String xmlData = AssetsUtils.getFileString(App.INSTANCE, "API.xml");
        Container container = gsonXml.fromXml(xmlData, Container.class);
        if (!CheckUtil.isEmpty(container.getNode())) {
            apiMap =  DataContainerConvert.listToMap(container.getNode(),"key");
            urlMap = DataContainerConvert.listToMap(container.getNode(),"url");
        }
    }


}
