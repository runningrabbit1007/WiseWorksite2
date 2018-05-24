package com.sx.common_base.view.proxy;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.common.base.bean.ServiceBean;
import com.common.base.config.PreferencesManager;
import com.common.base.image.ImageDisplayManager;
import com.google.gson.JsonObject;
import com.sx.common_base.bean.UploadImageResult;
import com.sx.common_base.callback.BaseSmartCallback;
import com.sx.common_base.callback.BaseSmartMallCallback;
import com.sx.common_base.constant.APIKeys;
import com.sx.common_base.constant.ConstantValue;
import com.sx.common_base.http.RequestMaster;
import com.sx.common_base.listener.SingleImageCureentListener;
import com.sx.common_base.modle.request.HeadImageUploadBean;
import com.sx.common_base.modle.request.ImageUploadBean;
import com.sx.common_base.util.DialogUtil;
import com.sx.common_base.util.ImageUtil;
import com.sx.common_base.util.JSONUtil;
import com.sx.common_base.util.image.BitmapUtil;
import com.sx.common_base.util.view.FangFuUtil;
import com.yalantis.ucrop.model.AspectRatio;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import cn.finalteam.rxgalleryfinal.RxGalleryFinal;
import cn.finalteam.rxgalleryfinal.RxGalleryFinalApi;
import cn.finalteam.rxgalleryfinal.imageloader.ImageLoaderType;
import cn.finalteam.rxgalleryfinal.rxbus.event.ImageRadioResultEvent;
import cn.finalteam.rxgalleryfinal.ui.base.IRadioImageCheckedListener;
import okhttp3.Call;
import cn.finalteam.rxgalleryfinal.rxbus.RxBusResultDisposable;


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
 * description : 单图上传的代理
 * <p>
 * revision history :
 * <p>
 * =============================================================
 */
public class SingleUploadImageProxy implements OnClickListener {

    private final String TAG = "SingleUploadImageProxy";
    public static final int PHOTO_ZOOM_REQUEST_COED = 3;
    // 代理多图的GridView
    protected ImageView mProxyIv;
    private Handler mHandler;
    protected Context mContext;
    private String mCurrentUploadImageUrl = "";
    private int mUploadType = 4;

    protected File tempFile;

    // 图像 （相册）
    public static final int HEAD_PHOTO_REQUEST_CODE = 1;
    // 图像 （拍照）
    public static final int CAMRE_REQUEST_CODE = 0x00101;
    private static final int MULTIPLE_SINGLE_UPLOAD_IMAGE_MSGWHAT = ConstantValue.MessageWhat.MESSAGE_WHAT_TEN;


    private SingleImageCureentListener mListener;

    // 选择项目经验临时图片文件
    protected File mSelectTempImageFile;
    // 图片是否上传成功
    private boolean mIsUploadComplete = false;
    public boolean isCrop = true;  //默认剪切
    private Context context;

    public SingleUploadImageProxy(ImageView proxyIv) {
        this.mProxyIv = proxyIv;
        this.mContext = getActivityFromView(this.mProxyIv);
        this.mSelectTempImageFile = new File(
                FangFuUtil.getPicturesSaveRootDir(), "image.jpg");

        tempFile = new File(FangFuUtil.getPicturesSaveRootDir(), "temp.jpg");
        initHandler();
        this.mProxyIv.setOnClickListener(this);
    }

    public SingleUploadImageProxy(ImageView proxyIv, Context context) {
        this.mProxyIv = proxyIv;
        this.mContext = getActivityFromView(this.mProxyIv);
        this.mSelectTempImageFile = new File(
                FangFuUtil.getPicturesSaveRootDir(), "image.jpg");

        tempFile = new File(FangFuUtil.getPicturesSaveRootDir(), "temp.jpg");
        initHandler();
        this.mProxyIv.setOnClickListener(this);
        this.context = context;
    }

    public SingleUploadImageProxy(ImageView proxyIv, int uploaType) {
        this.mProxyIv = proxyIv;
        this.mContext = this.mProxyIv.getContext();
        this.mSelectTempImageFile = new File(
                FangFuUtil.getPicturesSaveRootDir(), "image.jpg");
        tempFile = new File(FangFuUtil.getPicturesSaveRootDir(), "temp.jpg");
        initHandler();
        this.mProxyIv.setOnClickListener(this);
        this.mUploadType = uploaType;
    }

    /**
     * 初始化handler
     */
    private void initHandler() {
        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                MultipleSingleUploadImageResult uploadImageResult = (MultipleSingleUploadImageResult) msg.obj;
                if (uploadImageResult.errcode == 1) {
                    mIsUploadComplete = true;
                    mCurrentUploadImageUrl = uploadImageResult.data.img_path;

                    uploadSuccess(mCurrentUploadImageUrl);
                }
            }
        };
    }

    /**
     * 上传成功
     *
     * @param uploadUrl
     */
    protected void uploadSuccess(String uploadUrl) {

    }

    /**
     * 处理activity返回的结果
     */
    public void dealActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case HEAD_PHOTO_REQUEST_CODE:
                    photoActivityResult(data);
                    break;
                case CAMRE_REQUEST_CODE:
                    camareActivityResult();
                    break;
            }
        }
    }

    /**
     * 相机
     */
    protected void camareActivityResult() {
        // 先要清除缓存，要不然会有缓存只会显示一次
        ImageUtil.getInstance(mContext).clearAllCache(
                mSelectTempImageFile.getAbsolutePath());
        ImageDisplayManager.getInstance().loadImage(mProxyIv, mSelectTempImageFile.getAbsolutePath());
        BitmapUtil.compressImageFile(Uri.fromFile(mSelectTempImageFile),
                Uri.fromFile(tempFile));

        uplodImage(tempFile.getAbsolutePath());
    }

    /**
     * 相册
     */
    protected void photoActivityResult(Intent data) {
        String imagePath = ImageUtil.getImageAbsolutePathByUri(
                (Activity) mContext, data.getData());
        ImageDisplayManager.getInstance().loadImage(mProxyIv, imagePath);

        BitmapUtil.compressImageFile(Uri.fromFile(new File(imagePath)),
                Uri.fromFile(tempFile));

        uplodImage(tempFile.getAbsolutePath());
    }

    /**
     * 上传图片
     */
    protected void uplodImage(String imagePath) {

        mCurrentUploadImageUrl = imagePath;

        ImageUploadBean imageUploadBean = new ImageUploadBean();
        imageUploadBean.setUnique(imagePath);
        imageUploadBean.setFile(JSONUtil.FileToBase64(imagePath));

        RequestMaster.getInstance().callPostRequest(APIKeys.COMMON.API_UPLOAD_FILE, imageUploadBean, new BaseSmartCallback(mContext) {
            @Override
            public void onGetSuccess(JsonObject result) {
//				Log.e(TAG, "onGetSuccess: upload is success, info == " + JSONUtil.toJSON(result));

                try {
                    UploadImageResult imageResult = JSONUtil.parseObject(result.toString(), UploadImageResult.class);
                    mCurrentUploadImageUrl = imageResult.getInfo().getUrl();
                    mIsUploadComplete = true;
                    mListener.uploadSuccess(mProxyIv, SingleUploadImageProxy.this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onGetFailed(int code) {

            }

            @Override
            public void onGetError(Call call, Exception e, int id) {

            }
        }, "");
    }



    protected void uplodImage(File file) {

        mCurrentUploadImageUrl = file.getAbsolutePath();
        HashMap<String, String> params = new HashMap<>();
        OkHttpUtils.post()
                .addFile("file",file.getPath(),file)
                .addHeader("Cookie","JSESSIONID="+PreferencesManager.getInstance().getSESSIONID())
                .url(RequestMaster.getInstance().getOriginUrlMall(APIKeys.COMMON.API_UPLOAD_FILE,null))
                .build()
                .execute(new BaseSmartCallback(context){

                    @Override
                    public void onGetSuccess(JsonObject result) {
                        UploadImageResult imageResult = JSONUtil.parseObject(result.toString(), UploadImageResult.class);
                        mCurrentUploadImageUrl = imageResult.getUrl();
                        mIsUploadComplete = true;
                        mListener.uploadSuccess(mProxyIv, SingleUploadImageProxy.this);
                    }

                    @Override
                    public void onGetFailed(int code) {

                    }

                    @Override
                    public void onGetError(Call call, Exception e, int id) {

                    }
            });



        /*OkHttpUtils.postFile()
                .tag(this)
                .file(file)
                .url(RequestMaster.getInstance().getOriginUrlMall(APIKeys.COMMON.API_UPLOAD_FILE,null))
                .build().execute(new BaseSmartCallback(context){

            @Override
            public void onGetSuccess(JsonObject result) {
                UploadImageResult imageResult = JSONUtil.parseObject(result.toString(), UploadImageResult.class);
                mCurrentUploadImageUrl = imageResult.getUrl();
                mIsUploadComplete = true;
                mListener.uploadSuccess(mProxyIv, SingleUploadImageProxy.this);
            }

            @Override
            public void onGetFailed(int code) {

            }

            @Override
            public void onGetError(Call call, Exception e, int id) {

            }
        });*/


        /*RequestMaster.getInstance().callPostRequestMall(APIKeys.COMMON.API_UPLOAD_FILE, params, new File(mContext) {
            @Override
            public void onGetSuccess(JsonObject result) {
//				Log.e(TAG, "onGetSuccess: upload is success, info == " + JSONUtil.toJSON(result));

                try {
                    UploadImageResult imageResult = JSONUtil.parseObject(result.toString(), UploadImageResult.class);
                    mCurrentUploadImageUrl = imageResult.getUrl();
                    mIsUploadComplete = true;
                    mListener.uploadSuccess(mProxyIv, SingleUploadImageProxy.this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onGetFailed(int code) {

            }

            @Override
            public void onGetError(Call call, Exception e, int id) {

            }
        }, "");*/
    }




    @Override
    public void onClick(View v) {
        // 选择图片，从相册中还是拍照
        if (context == null) {
            DialogUtil.showCameraOrPhotoDialog(mContext,
                    mSelectTempImageFile, HEAD_PHOTO_REQUEST_CODE,
                    CAMRE_REQUEST_CODE);
            return;
        }else{
            //自定义方法的单选
            if (isCrop) {
                RxGalleryFinalApi.getInstance((Activity) context)
                        .onCrop(true)//是否裁剪
                        .openGalleryRadioImgDefault(new RxBusResultDisposable() {
                            @Override
                            protected void onEvent(Object o) throws Exception {
                            }
                        }).onCropImageResult(new IRadioImageCheckedListener() {
                    @Override
                    public void cropAfter(Object t) {
                        photoResult(t.toString());
                    }

                    @Override
                    public boolean isActivityFinish() {
                        return true;
                    }
                });
            } else {
                RxGalleryFinal
                        .with(context)
                        .image()
                        .radio()
                        .cropAspectRatioOptions(0, new AspectRatio("3:3",30, 10))
                        .imageLoader(ImageLoaderType.GLIDE)
                        .subscribe(new RxBusResultDisposable<ImageRadioResultEvent>() {           //图片选择后的回调方法（单选要为ImageRadioResultEvent）
                            @Override
                            protected void onEvent(ImageRadioResultEvent imageRadioResultEvent) throws Exception {
                                //图片选择结果
                                String filePath = imageRadioResultEvent.getResult().getOriginalPath();//获取照片的储存路径
                                photoResult(filePath);
                            }
                        })
                        .openGallery();
            }
        }
        if (mListener != null) {
            mListener.current(this);
        }
    }

    /**
     * 单图选择
     */
    protected void photoResult(String path) {
        ImageDisplayManager.getInstance().loadImage(mProxyIv, path);
        String tempPhotoName = path.replace("/", "-");
        File file = new File(FangFuUtil.getPicturesSaveRootDir(), tempPhotoName);
        BitmapUtil.compressImageFile(Uri.fromFile(new File(path)),
                Uri.fromFile(file));

        uplodImage(file);
    }

    /**
     * 获取图片上传后的路径
     */
    public String getCurrentUploadImageUrl() {
        return mCurrentUploadImageUrl;
    }

    /**
     * 设置图片上传的路径
     */
    public void setCurrentUploadImageUrl(String currentUploadImageUrl) {
        this.mCurrentUploadImageUrl = currentUploadImageUrl;
        ImageDisplayManager.getInstance().loadImage(mProxyIv, currentUploadImageUrl);
        this.mIsUploadComplete = true;
    }

    /**
     * 图片是否上传成功
     *
     * @return
     */
    public boolean isUploadImageSucess() {
        return mIsUploadComplete;
    }

    public void setOnSingleImageCureentListener(
            SingleImageCureentListener listener) {
        this.mListener = listener;
    }

    public static Activity getActivityFromView(View view) {
        Context context = view.getContext();
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

}