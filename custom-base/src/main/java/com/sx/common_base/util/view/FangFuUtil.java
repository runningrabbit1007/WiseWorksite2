package com.sx.common_base.util.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;

import com.common.base.App;
import com.common.base.config.PreferencesManager;
import com.common.utils.GeneralUtil;
import com.google.gson.JsonObject;
import com.sx.common_base.bean.UploadImageResult;
import com.sx.common_base.callback.BaseSmartCallback;
import com.sx.common_base.callback.BaseSmartMallCallback;
import com.sx.common_base.constant.APIKeys;
import com.sx.common_base.http.RequestMaster;
import com.sx.common_base.modle.bean.publish.DescImageBean;
import com.sx.common_base.modle.request.ImageUploadBean;
import com.sx.common_base.util.DialogUtil;
import com.sx.common_base.util.JSONUtil;
import com.sx.common_base.util.image.BitmapUtil;
import com.sx.common_base.view.proxy.MultipleChoicePhotoAdapter;
import com.sx.common_base.view.proxy.SingleUploadImageProxy;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.builder.PostFormBuilder;
import com.zhy.http.okhttp.request.RequestCall;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import okhttp3.Call;

/**
 * ============================================================
 * <p>
 * project name : TiantianFangFu
 * <p>
 * copyright ZENG HUI (c) 2015
 * <p>
 * author : HUI
 * <p>
 * version : 1.0
 * <p>
 * date created : On July, 2015
 * <p>
 * description : 跟这个项目有关的一些工具类
 * <p>
 * revision history :
 * <p>
 * ============================================================
 */

public class FangFuUtil {
    // 用户类型标识，1为老板，2为团队，3为工人
    public static int tradingUserType = 1;
    // 订单商品类型标识，团队为1，简历为2。
    public static int tradingType = 1;

    public static int jumpPosition = 0;


    public static int orderType = 1;

    public static void initTradingParam(int type, int userType, int position) {
        tradingUserType = userType;
        tradingType = type;
        jumpPosition = position;
    }

    public static String getTradingCacheDataBaseKey(String mOrderType) {
        return FangFuUtil.tradingType + mOrderType + FangFuUtil.tradingUserType;
    }

    /**
     * 得到图片保存的根目录文件夹
     *
     * @return
     */
    public static File getPicturesSaveRootDir() {
        File tempFileDir = new File(Environment.getExternalStorageDirectory()
                + "/ FactoryConnect");
        GeneralUtil.createFile(tempFileDir);
        return tempFileDir;
    }

    /**
     * 上传多选图片部分
     *
     * @param handler
     * @param context
     * @param imageList
     * @param uploadMap
     * @param uploadMsgWhat
     * @param adapter
     */

    public static void dealPhotoResult(Handler handler, Context context, ArrayList<String> imageList,
                                       HashMap<String, DescImageBean> uploadMap, int uploadMsgWhat, MultipleChoicePhotoAdapter adapter) {

        // 临时的list
        ArrayList<String> tmepList = new ArrayList<String>();
        tmepList.addAll(imageList);
        // 去掉重复的，再添加
        imageList.clear();
        imageList.addAll(GeneralUtil.trimArray(tmepList));
        // 移除掉第一个""
        for (String imagePath : imageList) {
            if (TextUtils.isEmpty(imagePath)) {
                imageList.remove(imagePath);
                break;
            }
        }

        // 在最后面加一个""
        imageList.add("");
        adapter.notifyDataSetChanged();
        startUploadImage(handler, imageList, context, uploadMap, uploadMsgWhat);
    }

    //
//	/**
//	 * 创建线程上传
//	 *
//	 * @param handler
//	 * @param imageList
//	 * @param context
//	 * @param uploadMap
//	 * @param uploadMsgWhat
//	 */
    private static void startUploadImage(final Handler handler,
                                         final ArrayList<String> imageList, final Context context,
                                         final HashMap<String, DescImageBean> uploadMap, final int uploadMsgWhat) {


        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Disposition", "form-data;filename=enctype");
        PostFormBuilder builder = OkHttpUtils.post();
        builder.addHeader("Cookie","JSESSIONID="+PreferencesManager.getInstance().getSESSIONID())
                .url(RequestMaster.getInstance().getOriginUrlMall(APIKeys.COMMON.API_UPLOAD_FILES,null));
        for (int i = 0; i < imageList.size(); i++) {

            String tempPhotoName = imageList.get(i).replace("/", "-");
            // 重复路径的不上传
            if (!uploadMap.containsKey(tempPhotoName)
                    && !TextUtils.isEmpty(imageList.get(i))
                    && !imageList.get(i).startsWith("http://") && !imageList.get(i).startsWith("https://")) {
                File file = new File(FangFuUtil.getPicturesSaveRootDir(), tempPhotoName);
                BitmapUtil.compressImageFile(Uri.fromFile(new File(imageList.get(i))),
                        Uri.fromFile(file));
                if (!file.exists()) {

                    App.toast("文件不存在，请修改文件路径");
                    return;
                }
                String filename = file.getName();
                builder.addFile("files", filename, file);
            }

        }

        builder.build().execute(new BaseSmartMallCallback(context) {
            @Override
            public void onGetSuccess(JsonObject result) {
                UploadImageResult imageResult = JSONUtil.parseObject(result.toString(), UploadImageResult.class);
                Message message = new Message();
                message.obj = imageResult;
                message.what = uploadMsgWhat;
                handler.sendMessage(message);
            }

            @Override
            public void onGetFailed(int code) {
            }

            @Override
            public void onGetError(Call call, Exception e, int id) {
            }
        });
    }
//


    /**
     * 得到多选图片上传的列表路径
     *
     * @param images
     * @param maps
     * @return
     */
    public static ArrayList<DescImageBean> getImageList(ArrayList<DescImageBean> images,
                                                        HashMap<String, DescImageBean> maps) {
        ArrayList<DescImageBean> tempImages = getValuesByHashMap(maps);
        for (DescImageBean image : images) {
            tempImages.add(image);
        }
        return tempImages;
    }


    /**
     * 得到HashMap中的值
     *
     * @param hashMap
     * @return
     */
    public static ArrayList<DescImageBean> getValuesByHashMap(
            HashMap<String, DescImageBean> hashMap) {
        ArrayList<DescImageBean> values = new ArrayList<DescImageBean>();
        Iterator<Map.Entry<String, DescImageBean>> iter = hashMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, DescImageBean> entry = iter.next();
            values.add(entry.getValue());
        }
        return values;
    }


    public static String convertIconToString(Bitmap bitmap)
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();// outputstream
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] appicon = baos.toByteArray();// 转为byte数组
        return Base64.encodeToString(appicon, Base64.DEFAULT);

    }
}
