package com.sx.common_base.view.proxy;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.GridView;

import com.common.utils.GeneralUtil;
import com.common.utils.LogUtils;
import com.sx.common_base.bean.UploadImageResult;
import com.sx.common_base.modle.bean.publish.DescImageBean;
import com.sx.common_base.util.view.FangFuUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * ============================================================
 * <p>
 * project name :
 * <p>
 * copyright ZENG HUI (c) 2015
 * <p>
 * author : HUI
 * <p>
 * version : 1.0
 * <p>
 * date created : On October, 2015
 * <p>
 * description : 多图上传的代理
 * <p>
 * revision history :
 * <p>
 * =============================================================
 */
@SuppressLint("HandlerLeak")
public class MultipleUploadImageProxy implements MultipleChoicePhotoAdapter.MultipleChoiceClickLisenter {
    // 代理多图的GridView
    private GridView mProxyGv;
    private Handler mHandler;
    private HashMap<String, DescImageBean> mUploadPhotoMap;
    private ArrayList<String> mStringImages;
    private Context mContext;
    private int albumRequestCode=0;
    private int camearRequestCode=0;
    private ArrayList<DescImageBean> mDescImages;


    private MultipleChoicePhotoAdapter mPhotoDescAdapter;
    private ArrayList<String> mPhotoDescImages;
    //    private final int SELECT_PHOTO_DESC_RESULTCODE = 0x00102;
    private static final int MULTIPLE_SINGLE_UPLOAD_IMAGE_MSGWHAT = 0x00103;
    public static final int PHOTO_ZOOM_REQUEST_COED = 0x00104;
    private Activity activity;

    /************************ 图片上传请求码 ***********************/
    // 选择图片
//    public static final int SELECT_PHOTO_REQUEST_CODE = 0x00100;
    // 图像 （拍照）
    public static final int CAMRE_REQUEST_CODE = 0x00101;

    // 选择项目经验临时图片文件
    private static String mTempImageAbsolutePath;

    public MultipleUploadImageProxy(GridView proxyGv,boolean isShowCamera) {
        this.mProxyGv = proxyGv;
        this.mContext = this.mProxyGv.getContext();
        initMultiplePhotoView(isShowCamera);
        initHandler();
    }

    public MultipleUploadImageProxy(Activity activity,GridView proxyGv,boolean isShowCamera) {
        this.activity = activity;
        this.mProxyGv = proxyGv;
        this.mContext = this.mProxyGv.getContext();
        initHandler();
        initMultiplePhotoView(isShowCamera);
    }

    public MultipleUploadImageProxy(GridView proxyGv,int albumRequestCode,int camearRequestCode,boolean isShowCamera) {
        this.mProxyGv = proxyGv;
        this.mContext = this.mProxyGv.getContext();
        this.albumRequestCode = albumRequestCode;
        this.camearRequestCode = camearRequestCode;
        initMultiplePhotoView(isShowCamera);
        initHandler();
    }



    public void setmDescImages(ArrayList<DescImageBean> mDescImages) {
        this.mDescImages = mDescImages;
    }

    public void setmStringImages(ArrayList<String> mStringImages) {
        this.mStringImages = mStringImages;
    }

    /**
     * TODO 自定义"添加图片按钮"
     *
     * @param proxyGv  被监听的GridView
     * @param resource 自定义图片添加器
     */
    public MultipleUploadImageProxy(GridView proxyGv, int resource) {
        this.mProxyGv = proxyGv;
        this.mContext = this.mProxyGv.getContext();
        initMultiplePhotoView(resource);
        initHandler();
    }

    /**
     * 初始化handler
     */
    private void initHandler() {
        mHandler = new Handler() {// 处理上传完成之后返回的图片数据
            @Override
            public void handleMessage(Message msg) {
                try {
                    UploadImageResult uploadImageResult = (UploadImageResult) msg.obj;

                    //把之前上传的图片清空，避免产生重复数据
                    mStringImages.clear();

                    if(uploadImageResult.getUrl()!=null) {
                        if (!mStringImages.contains(uploadImageResult.getUrl())) {
                            mStringImages.add(uploadImageResult.getUrl());
                        }
                    }
                    if(uploadImageResult.getUrls().size()>0){
                        for(UploadImageResult.UrlBean item:uploadImageResult.getUrls()){
                            if(!mStringImages.contains(item.getUrl())){
                                mStringImages.add(item.getUrl());
                            }
                        }
                    }

                    /*if (!mDescImages.contains(uploadImageResult.getInfo())){
                        mDescImages.add(uploadImageResult.getInfo());
                    }*/

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }

    /**
     * 初始化项目经验的图片选择控件
     */
    private void initMultiplePhotoView(boolean isShowCamera) {
        mPhotoDescImages = new ArrayList<String>();
        mPhotoDescImages.add("");
        mUploadPhotoMap = new HashMap<String, DescImageBean>();
        mPhotoDescAdapter = new MultipleChoicePhotoAdapter(mUploadPhotoMap,mPhotoDescImages,mHandler,activity,mContext,
                mPhotoDescImages, mProxyGv, albumRequestCode,
                camearRequestCode,isShowCamera);
        mPhotoDescAdapter.setAdapter(mPhotoDescAdapter);
        mProxyGv.setAdapter(mPhotoDescAdapter);
        mPhotoDescAdapter.setOnMultipleChoiceClickLisenter(this);
    }

    /**
     * TODO
     *
     * @param resource void
     */
    private void initMultiplePhotoView(int resource) {
        // TODO Auto-generated method stub
        mPhotoDescImages = new ArrayList<String>();
        mPhotoDescImages.add("");
        mUploadPhotoMap = new HashMap<String, DescImageBean>();
        mPhotoDescAdapter = new MultipleChoicePhotoAdapter(mContext,
                mPhotoDescImages, mProxyGv, albumRequestCode,
                camearRequestCode, resource);
        mProxyGv.setAdapter(mPhotoDescAdapter);
        mPhotoDescAdapter.setOnMultipleChoiceClickLisenter(this);
    }

    /**
     * 删除照片
     */
    @Override
    public void deletePhotoClick(String imagePath, View currentGv, int position) {
        /*String key = imagePath.replace("/", "-");
        Set<HashMap.Entry<String, DescImageBean>> entry = mUploadPhotoMap.entrySet();
        for (HashMap.Entry<String, DescImageBean> e : entry) {
            LogUtils.d("key:" + e.getKey() + "-value:" + e.getValue());
        }*/
//        mUploadPhotoMap.remove(key);

        try {
//            mDescImages.remove(position);
            mStringImages.remove(position);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 打开相机拍照的回调
     */
    @Override
    public void openCamreClick(File tempFile, View currentGv) {
        System.gc();
        mTempImageAbsolutePath = tempFile.getAbsolutePath();
    }

    /**
     * 处理activity返回的结果
     */
    public void dealActivityResult(int requestCode, int resultCode, Intent data) {
//        if(data == null || data.getStringArrayListExtra(SelectPhotoActivity.SELECT_IMAGEPATH_KEY) == null){
//            return;
//        }
//        if(resultCode == albumRequestCode){
//            // 照片
//            try{
//                FangFuUtil.dealPhotoResult(mHandler, mContext, data,
//                    mPhotoDescImages, mUploadPhotoMap,
//                    MULTIPLE_SINGLE_UPLOAD_IMAGE_MSGWHAT, mPhotoDescAdapter);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//        if(requestCode == camearRequestCode){
//            if (resultCode == Activity.RESULT_OK) {
//                // 相机 (不剪切)
//                try {
//                    mPhotoDescImages.add(mTempImageAbsolutePath);
//                    FangFuUtil.dealPhotoResult(mHandler, mContext, data,
//                            mPhotoDescImages, mUploadPhotoMap,
//                            MULTIPLE_SINGLE_UPLOAD_IMAGE_MSGWHAT,
//                            mPhotoDescAdapter);
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//
//            }
//        }
    }

    /**
     * 得到图片上传的集合
     */
    public ArrayList<DescImageBean> getUploadImageUrls() {
        ArrayList<DescImageBean> images = FangFuUtil.getImageList(mDescImages,
                mUploadPhotoMap);
        return GeneralUtil.trimArray(images);
    }

    /**
     * 得到图片上传的String集合
     */
    public ArrayList<String> getUploadImageStringUrls() {
        return GeneralUtil.trimArray(mStringImages);
    }



    public void setOldImageUrls(ArrayList<String> images) {
        if (images == null || images.size() <= 0) {
            return;
        }
        mPhotoDescImages.clear();
        images.add("");
        mPhotoDescImages.addAll(images);
        mPhotoDescAdapter.notifyDataSetChanged();
    }

    /**
     * 设置能够选择的张数
     */
    public void setCanChooseNumber(int chooseNumber) {
        mPhotoDescAdapter.setCanChooseNumber(chooseNumber);
    }

    public void setEnable(boolean canItEdit) {
        mPhotoDescAdapter.setIsAbleEdit(canItEdit);
    }

}