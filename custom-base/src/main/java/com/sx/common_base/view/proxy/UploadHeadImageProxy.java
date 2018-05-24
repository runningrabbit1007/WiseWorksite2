package com.sx.common_base.view.proxy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.widget.ImageView;


import com.sx.common_base.util.image.BitmapUtil;
import com.sx.common_base.util.image.ImageUtil;
import com.sx.common_base.util.view.FangFuUtil;

import java.io.File;

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
public class UploadHeadImageProxy extends SingleUploadImageProxy {
    public static final int PHOTO_ZOOM_REQUEST_COED = 3;
    public static final int PHOTO_ZOOM_REQUEST_CAMER_COED = 4;

    private String mUploadAddress;
    private int msgWhat = -1;
    private Handler handler = null;
    private File tempFile;

    public UploadHeadImageProxy(ImageView proxyIv, String uploadAddress) {
        super(proxyIv);
        this.mUploadAddress = uploadAddress;
        tempFile = new File(FangFuUtil.getPicturesSaveRootDir(), "temp.jpg");
    }

    public UploadHeadImageProxy(ImageView proxyIv, String uploadAddress, boolean isCrop) {
        super(proxyIv);
        this.mUploadAddress = uploadAddress;
        tempFile = new File(FangFuUtil.getPicturesSaveRootDir(), "temp.jpg");
        this.isCrop = isCrop;
    }

    public UploadHeadImageProxy(ImageView proxyIv, String uploadAddress,
                                int msgWhat, Handler handler) {
        super(proxyIv);
        this.mUploadAddress = uploadAddress;
        this.msgWhat = msgWhat;
        this.handler = handler;
        tempFile = new File(FangFuUtil.getPicturesSaveRootDir(), "temp.jpg");
    }

    public UploadHeadImageProxy(ImageView proxyIv, String uploadAddress, boolean isCrop, Context context) {
        super(proxyIv,context);
        this.mUploadAddress = uploadAddress;
        tempFile = new File(FangFuUtil.getPicturesSaveRootDir(), "temp.jpg");
        this.isCrop = isCrop;
    }

    public UploadHeadImageProxy(ImageView proxyIv, String uploadAddress,
                                int msgWhat, Handler handler, Context context) {
        super(proxyIv,context);
        this.mUploadAddress = uploadAddress;
        this.msgWhat = msgWhat;
        this.handler = handler;
        tempFile = new File(FangFuUtil.getPicturesSaveRootDir(), "temp.jpg");
    }
    /**
     * 处理activity返回的结果
     */
    public void dealActivityResult(int requestCode, int resultCode, Intent data) {
        super.dealActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case PHOTO_ZOOM_REQUEST_COED:
                    // 处理结果
                    BitmapUtil.compressImageFile(Uri.fromFile(tempFile),
                            Uri.fromFile(mSelectTempImageFile));
                    Bitmap bmp = BitmapFactory.decodeFile(mSelectTempImageFile
                            .getAbsolutePath());
                    mProxyIv.setImageBitmap(bmp);
                    uplodImage(mSelectTempImageFile.getAbsolutePath());
                    break;
                case PHOTO_ZOOM_REQUEST_CAMER_COED:
                    BitmapUtil.compressImageFile(Uri.fromFile(tempFile),
                            Uri.fromFile(mSelectTempImageFile));
                    Bitmap bmp2 = BitmapFactory.decodeFile(mSelectTempImageFile
                            .getAbsolutePath());
                    mProxyIv.setImageBitmap(bmp2);
                    uplodImage(mSelectTempImageFile.getAbsolutePath());
                    break;
            }
        }
    }


    @Override
    protected void photoActivityResult(Intent data) {
        // 相册
        if (isCrop) {
            ImageUtil.startPhotoZoomSafe(mContext,
                    data.getData(), PHOTO_ZOOM_REQUEST_COED,
                    -1, -1, Uri.fromFile(tempFile));
        } else {
            super.photoActivityResult(data);
        }

    }

    @Override
    protected void camareActivityResult() {
        // 相机
        if(isCrop){
            ImageUtil.startPhotoZoomSafe(mContext,
                    Uri.fromFile(mSelectTempImageFile), PHOTO_ZOOM_REQUEST_COED,
                    -1, -1, Uri.fromFile(tempFile));
        }else{
            super.camareActivityResult();
        }

    }

}