package com.sx.common_base.view.proxy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.common.base.App;
import com.common.base.config.BaseConfig;
import com.common.base.image.ImageDisplayManager;
import com.common.utils.LogUtils;
import com.common.utils.ToastUtil;
import com.common.utils.dialog.DialogViewHolder;
import com.sx.common_base.ConfigureApplication;
import com.sx.common_base.R;
import com.sx.common_base.activity.PhotoViewActivity;
import com.sx.common_base.listScreen.adapter.CommonAdapter;
import com.sx.common_base.listScreen.adapter.ViewHolder;
import com.sx.common_base.modle.bean.publish.DescImageBean;
import com.sx.common_base.util.ApplicationUtil;
import com.sx.common_base.util.DialogUtil;
import com.sx.common_base.util.view.FangFuUtil;
import com.sx.common_base.view.ImplantGridView;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.finalteam.galleryfinal.FunctionConfig;
import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.model.PhotoInfo;
import cn.finalteam.rxgalleryfinal.RxGalleryFinal;
import cn.finalteam.rxgalleryfinal.bean.MediaBean;
import cn.finalteam.rxgalleryfinal.imageloader.ImageLoaderType;
import cn.finalteam.rxgalleryfinal.rxbus.RxBusResultDisposable;
import cn.finalteam.rxgalleryfinal.rxbus.event.ImageMultipleResultEvent;
import cn.finalteam.rxgalleryfinal.ui.RxGalleryListener;
import cn.finalteam.rxgalleryfinal.ui.base.IMultiImageCheckedListener;
import cn.finalteam.rxgalleryfinal.ui.widget.SquareImageView;

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
 * description : 多张图片选择的
 * <p>
 * revision history :
 * <p>
 * ============================================================
 */
public class MultipleChoicePhotoAdapter extends CommonAdapter<String> {
    private GridView mGridView;
    /**
     * 相册
     */
    private int mAlbumResultCode;
    private boolean mIsAbleEdit = true;
    /**
     * 相机
     */
    private int mCamearResultCode;
    private NextActivityIntentCallBack mIntentCallBack;
    // 用户选择照片或是拍照的dialog
    private DialogUtil mSelectPhotoOrCameraDialog;
    // 可选择的张数
    private int mCanChooseNumber = 5;

    // 记录一下过去的
    private ArrayList<String> mOldImages;

    private FunctionConfig mFunctionConfig;

    private static int uploadIconLayout = R.layout.grid_upload_chid_item;
    private Activity activity;
    private Handler mHandler;
    private static final int MULTIPLE_SINGLE_UPLOAD_IMAGE_MSGWHAT = 0x00103;
    private HashMap<String, DescImageBean> mUploadPhotoMap;
    private ArrayList<String> mPhotoDescImages;
    private MultipleChoicePhotoAdapter adapter;
    private boolean isShowCamera;
    public MultipleChoicePhotoAdapter(HashMap<String, DescImageBean> mUploadPhotoMap, ArrayList<String> mPhotoDescImages, Handler mHandler, Activity activity, Context context, List<String> mDatas,
                                      GridView gridView, int mAlbumResultCode, int mCamearResultCode,boolean isShowCamera) {
        super(context, mDatas, uploadIconLayout, false);
        this.mGridView = gridView;
        this.mAlbumResultCode = mAlbumResultCode;
        this.mCamearResultCode = mCamearResultCode;
        this.activity = activity;
        this.mHandler = mHandler;
        this.mUploadPhotoMap = mUploadPhotoMap;
        this.mPhotoDescImages = mPhotoDescImages;
        this.isShowCamera = isShowCamera;
    }

    public MultipleChoicePhotoAdapter(Context context, List<String> mDatas,
                                      ImplantGridView gridView, int mAlbumResultCode,
                                      int mCamearResultCode, NextActivityIntentCallBack callBack) {
        super(context, mDatas, uploadIconLayout, false);
        this.mGridView = gridView;
        this.mAlbumResultCode = mAlbumResultCode;
        this.mCamearResultCode = mCamearResultCode;
        this.mIntentCallBack = callBack;
    }

    /**
     * TODO 使用一个自定义的ImageLoadIcon布局的适配器，使得底部图片能自定义
     *
     * @param context
     * @param mDatas
     * @param gridView
     * @param reousrce 自定义的布局
     */
    public MultipleChoicePhotoAdapter(Context context, List<String> mDatas,
                                      ImplantGridView gridView, int mAlbumResultCode,
                                      int mCamearResultCode, int reousrce) {
        super(context, mDatas, reousrce, false);
        this.mGridView = gridView;
        this.mAlbumResultCode = mAlbumResultCode;
        this.mCamearResultCode = mCamearResultCode;
    }

    /**
     * TODO
     *
     * @param mContext
     * @param mDatas
     * @param gridView
     * @param camreaResultCode
     * @param photoResultCode
     * @param resource
     */
    public MultipleChoicePhotoAdapter(Context mContext,
                                      ArrayList<String> mDatas, GridView gridView, int camreaResultCode,
                                      int photoResultCode, int resource) {
        // TODO Auto-generated constructor stub
        super(mContext, mDatas, resource, false);
        this.mGridView = gridView;
        this.mAlbumResultCode = camreaResultCode;
        this.mCamearResultCode = photoResultCode;
    }

    public void setAdapter(MultipleChoicePhotoAdapter adapter){
        this.adapter = adapter;
    }
    /**
     * TODO
     *
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }

    @Override
    public void convert(ViewHolder holder, final String bean, final int position) {
        // 得到自定的image view
        SquareImageView myImageView = holder.getView(R.id.id_item_image);
        if (!TextUtils.isEmpty(bean)) {
//			ImageUtil.getInstance(mContext).display(myImageView, bean);
            ImageDisplayManager.getInstance().loadImage(myImageView, bean);
        } else {
            ImageDisplayManager.getInstance().loadImage(myImageView, R.drawable.default_upload_icon);
//			ImageUtil.getInstance(mContext).display(myImageView,
//					R.drawable.default_upload_icon + "");
        }
        // 点击
        holder.setOnClickListener(R.id.id_item_image, new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(bean)) {
                    if (!mIsAbleEdit) {
                        ToastUtil.showToast(mContext,mContext.getString(R.string.activity_pic_setting_edit));
                        return;
                    }

                    if (mDatas.size() > mCanChooseNumber) {
                        // 可选择的照片不是0,并且选择的照片超过了可选择的数量
                        ToastUtil.showToast(mContext,mContext.getString(R.string.activity_pic_setting_one) + mCanChooseNumber + mContext.getString(R.string.activity_pic_setting_two)
                        );

                        return;
                    }
                    // 选择照片或者拍照
                    showSelectPhotoOrCameraDialog(mCanChooseNumber);
                    /*RxGalleryFinal rxGalleryFinal = RxGalleryFinal.with(activity)
                            .image()
                            .multiple();
                    if (mDatas != null && !mDatas.isEmpty()) {
                        List<MediaBean> list = new ArrayList<MediaBean>();
                        for(int i=0;i<mDatas.size();i++){
                            if(!mDatas.get(i).isEmpty()){
                                MediaBean mediaBean = new MediaBean();
                                mediaBean.setOriginalPath(mDatas.get(i));
                                list.add(mediaBean);
                            }
                        }
                        rxGalleryFinal
                                .selected(list);
                    }
                    rxGalleryFinal.maxSize(mCanChooseNumber)
                            .imageLoader(ImageLoaderType.GLIDE)
                            .subscribe(new RxBusResultDisposable<ImageMultipleResultEvent>() {
                                @Override
                                protected void onEvent(ImageMultipleResultEvent imageMultipleResultEvent) throws Exception {
                                    List<MediaBean> list = imageMultipleResultEvent.getResult();
                                    mDatas.clear();
                                    for (int i=0;i<list.size();i++){
                                        mDatas.add(list.get(i).getOriginalPath());
                                    }

                                    FangFuUtil.dealPhotoResult(mHandler, mContext, (ArrayList<String>)mDatas, mUploadPhotoMap,
                                            MULTIPLE_SINGLE_UPLOAD_IMAGE_MSGWHAT,adapter);
                                }

                            }).openGallery();

                    RxGalleryListener.getInstance().setMultiImageCheckedListener(new IMultiImageCheckedListener() {
                        @Override
                        public void selectedImg(Object t, boolean isChecked) {

                        }

                        @Override
                        public void selectedImgMax(Object t, boolean isChecked, int maxSize) {
                            ToastUtil.showToast(mContext,mContext.getString(R.string.activity_pic_setting_one)+ maxSize + mContext.getString(R.string.activity_pic_setting_two));
                        }
                    });*/

                } else {
                    // 打开照片详情;
                    // ArrayList<String> images = (ArrayList<String>) mDatas;
                    // 这种赋值方式导致的后果是，images删掉某个数据，会影响到mDatas.images只是指向了mDatas的数据地址
                    ArrayList<String> images = new ArrayList<>(mDatas);
                    images.remove("");
                    Intent intent = new Intent(mContext,
                            PhotoViewActivity.class);
                    intent.putStringArrayListExtra(
                            PhotoViewActivity.IMAGE_URL_LIST_KEY, images);
                    intent.putExtra(PhotoViewActivity.CURRENT_POINT_KEY,
                            position);
                    mContext.startActivity(intent);
                }
            }
        });
        // 长按
        final ImageView deleteIv = holder.getView(R.id.delete_image);
        if (mIsAbleEdit && !TextUtils.isEmpty(bean)) {
            deleteIv.setVisibility(View.VISIBLE);
        } else {
            deleteIv.setVisibility(View.GONE);
        }
//        holder.setOnLongClickListener(R.id.id_item_image,
//                new OnLongClickListener() {
//                    @Override
//                    public boolean onLongClick(View v) {
//                        if (!mIsAbleEdit || TextUtils.isEmpty(bean)) {
//                            return true;
//                        }
//                        deleteIv.setVisibility(View.VISIBLE);
//                        return true;
//                    }
//                });
        // 删除
        holder.setOnClickListener(R.id.delete_image, new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mIsAbleEdit || TextUtils.isEmpty(bean)) {
                    return;
                }

                LogUtils.d("bean == " + bean);
                //
                mDatas.remove(bean);

                notifyDataSetChanged();

                if (mLisenter != null) {
                    mLisenter.deletePhotoClick(bean, mGridView, position);
                }
            }
        });
    }

    /**
     * TODO 显示用户选择相片或是拍照的dialog
     */
    private void showSelectPhotoOrCameraDialog(final int mCanChooseNumber) {

         FunctionConfig.Builder functionConfigBuilder  = new FunctionConfig.Builder();
        functionConfigBuilder/*.setEnableCamera(true)*/
                .setEnablePreview(true).setMutiSelectMaxSize(mCanChooseNumber);

        if (mDatas != null && !mDatas.isEmpty()) {
            List<PhotoInfo> list = new ArrayList<PhotoInfo>();
            for (int i = 0; i < mDatas.size(); i++) {
                if (!mDatas.get(i).isEmpty()) {
                    PhotoInfo mediaBean = new PhotoInfo();
                    mediaBean.setPhotoPath(mDatas.get(i));
                    list.add(mediaBean);
                }
            }
            functionConfigBuilder
                    .setSelected(list);//添加过滤集合
        }



       mFunctionConfig = functionConfigBuilder.build();


    if (mSelectPhotoOrCameraDialog == null) {
        mSelectPhotoOrCameraDialog = new DialogUtil(mContext,
                R.layout.photo_choose_dialog) {
            @Override
            public void convert(DialogViewHolder view) {

                if(!isShowCamera){
                    view.setViewGone(R.id.image_depot);
                }

                view.getView(R.id.image_depot).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mSelectPhotoOrCameraDialog.cancelDialog();


                        FunctionConfig.Builder functionConfigBuilder  = new FunctionConfig.Builder();
                        functionConfigBuilder/*.setEnableCamera(true)*/
                                .setEnablePreview(true).setMutiSelectMaxSize(mCanChooseNumber);

                        if (mDatas != null && !mDatas.isEmpty()) {
                            List<PhotoInfo> list = new ArrayList<PhotoInfo>();
                            for (int i = 0; i < mDatas.size(); i++) {
                                if (!mDatas.get(i).isEmpty()) {
                                    PhotoInfo mediaBean = new PhotoInfo();
                                    mediaBean.setPhotoPath(mDatas.get(i));
                                    list.add(mediaBean);
                                }
                            }
                            functionConfigBuilder
                                    .setSelected(list);//添加过滤集合
                        }


                        //从相册中选择
                        GalleryFinal.openGalleryMuti(BaseConfig.REQUEST_CODE_GALLERY, mFunctionConfig,  new GalleryFinal.OnHanlderResultCallback() {
                            @Override
                            public void onHanlderSuccess(int reqeustCode, List<PhotoInfo> resultList) {
                                List<PhotoInfo> list = resultList;
//                                mDatas.clear();
                                for (int i = 0; i < list.size(); i++) {
                                    mDatas.add(list.get(i).getPhotoPath());

                                }


                                FangFuUtil.dealPhotoResult(mHandler, mContext, (ArrayList<String>) mDatas, mUploadPhotoMap,
                                        MULTIPLE_SINGLE_UPLOAD_IMAGE_MSGWHAT, adapter);
                            }

                            @Override
                            public void onHanlderFailure(int requestCode, String errorMsg) {
                                Toast.makeText(mContext, errorMsg, Toast.LENGTH_SHORT).show();
                            }
                        });




                        /*RxGalleryFinal rxGalleryFinal = RxGalleryFinal.with(activity)
                                .image()
                                .hideCamera()
                                .multiple();
                        if (mDatas != null && !mDatas.isEmpty()) {
                            List<MediaBean> list = new ArrayList<MediaBean>();
                            for(int i=0;i<mDatas.size();i++){
                                if(!mDatas.get(i).isEmpty()){
                                    MediaBean mediaBean = new MediaBean();
                                    mediaBean.setOriginalPath(mDatas.get(i));
                                    list.add(mediaBean);
                                }
                            }
                            rxGalleryFinal
                                    .selected(list);
                        }
                        rxGalleryFinal.maxSize(mCanChooseNumber)
                                .imageLoader(ImageLoaderType.GLIDE)
                                .subscribe(new RxBusResultDisposable<ImageMultipleResultEvent>() {
                                    @Override
                                    protected void onEvent(ImageMultipleResultEvent imageMultipleResultEvent) throws Exception {
                                        List<MediaBean> list = imageMultipleResultEvent.getResult();
                                        mDatas.clear();
                                        for (int i=0;i<list.size();i++){
                                            mDatas.add(list.get(i).getOriginalPath());
                                        }

                                        FangFuUtil.dealPhotoResult(mHandler, mContext, (ArrayList<String>)mDatas, mUploadPhotoMap,
                                                MULTIPLE_SINGLE_UPLOAD_IMAGE_MSGWHAT,adapter);
                                    }

                                }).openGallery();

                        RxGalleryListener.getInstance().setMultiImageCheckedListener(new IMultiImageCheckedListener() {
                            @Override
                            public void selectedImg(Object t, boolean isChecked) {

                            }

                            @Override
                            public void selectedImgMax(Object t, boolean isChecked, int maxSize) {
                                ToastUtil.showToast(mContext,mContext.getString(R.string.activity_pic_setting_one)+ maxSize + mContext.getString(R.string.activity_pic_setting_two));
                            }
                        });*/



                    }
                });

                view.getView(R.id.photo_camre).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        mSelectPhotoOrCameraDialog.cancelDialog();

                        GalleryFinal.openCamera(BaseConfig.REQUEST_CODE_CAMERA, mFunctionConfig, new GalleryFinal.OnHanlderResultCallback() {
                            @Override
                            public void onHanlderSuccess(int reqeustCode, List<PhotoInfo> resultList) {
                                List<PhotoInfo> list = resultList;
//                                mDatas.clear();  拍照不需要清除
                                for (int i = 0; i < list.size(); i++) {
                                    mDatas.add(list.get(i).getPhotoPath());

                                }


                                FangFuUtil.dealPhotoResult(mHandler, mContext, (ArrayList<String>) mDatas, mUploadPhotoMap,
                                        MULTIPLE_SINGLE_UPLOAD_IMAGE_MSGWHAT, adapter);
                            }

                            @Override
                            public void onHanlderFailure(int requestCode, String errorMsg) {
                                Toast.makeText(mContext, errorMsg, Toast.LENGTH_SHORT).show();
                            }
                        });


                        /*File imageTempFile = new File(
                                FangFuUtil.getPicturesSaveRootDir(),
                                System.currentTimeMillis() + ".jpg");
                        Intent getImageByCamera = new Intent(
                                "android.media.action.IMAGE_CAPTURE");
                        getImageByCamera.putExtra(MediaStore.EXTRA_OUTPUT,
                                Uri.fromFile(imageTempFile));
                        if (mLisenter != null) {
                            mLisenter.openCamreClick(imageTempFile, mGridView);
                        }

                        if (mIntentCallBack != null) {
                            mIntentCallBack.backIntent(getImageByCamera,
                                    mCamearResultCode);
                            return;
                        }
                        ((Activity) mContext).startActivityForResult(
                                getImageByCamera, mCamearResultCode);
                    }*/
                    }
                });

                view.getView(R.id.user_cancle).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mSelectPhotoOrCameraDialog.cancelDialog();
                    }
                });
            }

        };
        mSelectPhotoOrCameraDialog
                .setWidthAndHeight(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        ApplicationUtil.getScreenWidthHeight(mContext).y * 65/ 100);
        mSelectPhotoOrCameraDialog.fromBottom();
        mSelectPhotoOrCameraDialog.bindClick();
    }
    mSelectPhotoOrCameraDialog.showDialog();
}

    /**
     * 设置是否可编辑
     *
     * @param isEdit
     */
    public void setIsAbleEdit(boolean isEdit) {
        this.mIsAbleEdit = isEdit;
    }

    public interface MultipleChoiceClickLisenter {
        void deletePhotoClick(String imagePath, View currentGv, int position);

        void openCamreClick(File tempFile, View currentGv);
    }

    private MultipleChoiceClickLisenter mLisenter;

    public void setOnMultipleChoiceClickLisenter(
            MultipleChoiceClickLisenter lisenter) {
        this.mLisenter = lisenter;
    }

    public interface NextActivityIntentCallBack {
        void backIntent(Intent intent, int requestCode);
    }

    /**
     * 设置能够选择的张数
     */
    public void setCanChooseNumber(int chooseNumber) {
        this.mCanChooseNumber = chooseNumber;
    }

    public ArrayList<String> getOldImages() {
        return mOldImages;
    }
}
