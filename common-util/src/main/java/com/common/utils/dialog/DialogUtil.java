package com.common.utils.dialog;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PixelFormat;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.common.utils.system.AppUtil;
import com.common.utils.R;
import com.common.utils.dialog.loading.LodingDataView;

/**
 * Created by Jack on 2016/5/27.
 * DialogUtil  Dialog工具类，主要功能：实现加载框
 */
public class DialogUtil{

    public static ProgressDialog mProgressDialog;
    public static CustomProgressDialog customProgressDialog;

    /**
     * WindowManager下的LayoutParams实例
     */
    private static WindowManager.LayoutParams mlodingParams;

    /**
     * 正在加载数据的页面
     */
    private static View mLoadingView;

    /**
     * 与服务器后台约定好的提示框
     */
    private static DialogFactory msgDialog;

    /**
     * Show a progress prompt dialog
     *
     * @param context          当前上下文，这里不能传入getApplicationContext。
     * @param msg              : show message text content
     * @param onCancelListener 监听器，使用场景，当用户取消进度条时，认为其想取消当前请求，取消操作在监听中设置
     */
    public static void showProgressDialog(final Context context, final String msg, final DialogInterface.OnCancelListener onCancelListener){
        if(context == null){
            return;
        }
//        new Thread(new Runnable(){
//            @Override
//            public void run(){
//                Looper.prepare();
//                if(mProgressDialog != null && mProgressDialog.isShowing()){
//                    mProgressDialog.cancel();
//                }
//                mProgressDialog = null;
//                mProgressDialog = new ProgressDialog(context,ProgressDialog.THEME_DEVICE_DEFAULT_DARK);
//                mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);//圆环风格
//                mProgressDialog.setCanceledOnTouchOutside(false);
//                if(onCancelListener != null){
//                    mProgressDialog.setOnCancelListener(onCancelListener);
//                }
//                mProgressDialog.setMessage(msg);
//                try {
//                    mProgressDialog.show();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                Looper.loop();
//            }
//        }).start();

        new Thread(new Runnable(){
            @Override
            public void run(){
                Looper.prepare();
                if(customProgressDialog != null && customProgressDialog.isShowing()){
                    customProgressDialog.cancel();
                }
                customProgressDialog = null;
                customProgressDialog = new CustomProgressDialog(context,R.style.CustomDialog);
                customProgressDialog.setCanceledOnTouchOutside(false);
                if(onCancelListener != null){
                    customProgressDialog.setOnCancelListener(onCancelListener);
                }
                if(msg!=null) {
                    customProgressDialog.setMessage(msg);
                }
                try {
                    customProgressDialog.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Looper.loop();
            }
        }).start();
    }

    public static void showProgressDialog(final Context context, final String msg){
        if(context == null){
            return;
        }
        showProgressDialog(context, msg, null);
    }

    /**
     * Dismiss a progress prompt dialog box
     */
    public static void dismissProgressDialog(){
        if(customProgressDialog != null){
            customProgressDialog.dismiss();
        }
    }

    /**
     * TODO 添加一个正在加载数据的界面
     */
    public static final void addLoadingView(Context context){
        if(mLoadingView != null || context == null){
            return;
        }
        final WindowManager mWM = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        mlodingParams = new WindowManager.LayoutParams();
        int resourceId = context.getResources().getIdentifier("status_bar_height",
                "dimen", "android");
        final int statusBarHeight = resourceId > 0 ? context.getResources()
                .getDimensionPixelSize(resourceId) : 50;
        final int titleBarHeight = (int) context.getResources().getDimension(
                R.dimen.title_bar_height);
        mlodingParams.height = AppUtil.getScreenWidthHeight().y
                - statusBarHeight - titleBarHeight;
        mlodingParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        mlodingParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        // 效果为背景透明
        mlodingParams.format = PixelFormat.RGBA_8888;
        // 在底部显示
        mlodingParams.gravity = Gravity.BOTTOM;
        mLoadingView = new LodingDataView(context);
        mWM.addView(mLoadingView, mlodingParams);
    }

    /**
     * TODO 添加一个空视图
     */
    public static final void addEmptyView(Context context, View emptyView){
        if(context == null){
            return;
        }
        final WindowManager mWM = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        mlodingParams = new WindowManager.LayoutParams();
        int resourceId = context.getResources().getIdentifier("status_bar_height",
                "dimen", "android");
        final int statusBarHeight = resourceId > 0 ? context.getResources()
                .getDimensionPixelSize(resourceId) : 50;
        final int titleBarHeight = (int) context.getResources().getDimension(
                R.dimen.title_bar_height);
        mlodingParams.height = AppUtil.getScreenWidthHeight().y
                - statusBarHeight - titleBarHeight;
        mlodingParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        mlodingParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        // 效果为背景透明
        mlodingParams.format = PixelFormat.RGBA_8888;
        // 在底部显示
        mlodingParams.gravity = Gravity.BOTTOM;
        mWM.addView(emptyView, mlodingParams);
    }

    /**
     * TODO 删除空视图
     */
    public static final void dissmissEmptyView(Context context, View emptyView){
        if(context == null){
            return;
        }
        final WindowManager mWM = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        try{
            mWM.removeView(emptyView);
        }catch(Exception e){
            e.printStackTrace();
        }
        mLoadingView = null;
        mlodingParams = null;
    }

    /**
     * TODO 如果有缓存或是数据获取成功了，就把正在加载数据的界面干掉
     */
    public static final void dissmissLodingView(Context context){
        if(mLoadingView == null || context == null){
            return;
        }
        final WindowManager mWM = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        mWM.removeView(mLoadingView);
        mLoadingView = null;
        mlodingParams = null;
    }

    public static void dismissMsgDialog(){
        if(msgDialog != null){
            msgDialog.cancelDialog();
            msgDialog = null;
        }
    }

    /**
     * 双按钮操作 Dialog (取消 or 确定)
     *
     * @param context
     * @param msg
     * @param isAnimation
     * @param onClickListener
     */
    public static final void showMsgDialog(Context context, final String msg, boolean isAnimation, final View.OnClickListener onClickListener){
        if(context == null){
            return;
        }
        //        if(msgDialog == null){
        msgDialog = new DialogFactory(context, R.layout.dialog_style_one){
            @Override
            public void convert(DialogViewHolder view){
                view.setText(R.id.content, msg);
                view.setOnClick(R.id.sure, onClickListener);
                view.setOnClick(R.id.cancle, new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        msgDialog.cancelDialog();
                    }
                });
            }
        };
        //        }else{
        //            msgDialog.getDilaogVh().setText(R.id.content, msg);
        //        }
        if(msgDialog != null){
            msgDialog.showDialog(isAnimation);
        }
    }


    /**
     * 双按钮操作 提现按钮 Dialog (取消 or 确定)
     *
     * @param context
     * @param msg
     * @param isAnimation
     * @param onClickListener
     */
    public static final void showWithdrawMsgDialog(Context context, final String title, final String msg, boolean isAnimation, final View.OnClickListener onClickListener){
        if(context == null){
            return;
        }
        msgDialog = new DialogFactory(context, R.layout.dialog_style_one){
            @Override
            public void convert(DialogViewHolder view){
                view.setText(R.id.content, msg);
                view.setText(R.id.title,title);
                view.setOnClick(R.id.sure, onClickListener);
                view.setOnClick(R.id.cancle, new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        msgDialog.cancelDialog();
                    }
                });
            }
        };
        if(msgDialog != null){
            msgDialog.showDialog(isAnimation);
        }
    }







    /**
     * 双按钮操作 Dialog  (自定义按钮文字    默认取消 or 确定)
     *
     * @param context
     * @param msg
     * @param isAnimation
     */
    public static final void showMsgDialog(Context context, final String msg, boolean isAnimation,final String srtSure,final String strCancel, final View.OnClickListener onSureClickListener,final View.OnClickListener onCancelClickListener){
        if(context == null){
            return;
        }
        //        if(msgDialog == null){
        msgDialog = new DialogFactory(context, R.layout.dialog_style_one){
            @Override
            public void convert(DialogViewHolder view){
                view.setText(R.id.content, msg);
                if(!srtSure.isEmpty()){
                    view.setText(R.id.sure,srtSure);
                }
                if(!strCancel.isEmpty()){
                    view.setText(R.id.cancle,strCancel);
                }
                view.setOnClick(R.id.sure, onSureClickListener);
                view.setOnClick(R.id.cancle, onCancelClickListener);
//                view.setOnClick(R.id.cancle, new View.OnClickListener(){
//                    @Override
//                    public void onClick(View view){
//                        msgDialog.cancelDialog();
//                    }
//                });
            }
        };
        if(msgDialog != null){
            msgDialog.showDialog(isAnimation);
        }
    }

    /**
     * 单按钮操作 Dialog  ( 确定 )
     *
     * @param context
     * @param msg
     * @param isAnimation
     * @param onClickListener
     */
    public static final void showMsgDialogForSure(Context context, final String msg, boolean isAnimation, final View.OnClickListener onClickListener){
        if(context == null){
            return;
        }
        //        if(msgDialog == null){
        msgDialog = new DialogFactory(context, R.layout.dialog_style_one){
            @Override
            public void convert(DialogViewHolder view){
                view.setText(R.id.content, msg);
                view.setOnClick(R.id.sure, onClickListener);
                view.setViewGone(R.id.cancle);
                view.setViewGone(R.id.middle_line);
            }
        };
        //        }else{
        //            msgDialog.getDilaogVh().setText(R.id.content, msg);
        //        }
        if(msgDialog != null){
            msgDialog.showDialog(isAnimation);
        }
    }

    /**
     * 单按钮操作 Dialog  ( 确定 ) 点击其他位置弹框不消失
     *
     * @param context
     * @param msg
     * @param isAnimation
     * @param onClickListener
     */
    public static final void showMsgDialogForSure(Context context, final String msg, boolean isAnimation,boolean isCancelable, final View.OnClickListener onClickListener){
        if(context == null){
            return;
        }
        //        if(msgDialog == null){
        msgDialog = new DialogFactory(context, R.layout.dialog_style_one){
            @Override
            public void convert(DialogViewHolder view){
                view.setText(R.id.content, msg);
                view.setOnClick(R.id.sure, onClickListener);
                view.setViewGone(R.id.cancle);
                view.setViewGone(R.id.middle_line);
            }
        };
        msgDialog.setCancelable(isCancelable);
        if(msgDialog != null){
            msgDialog.showDialog(isAnimation);
        }
    }

    /**
     * 纯文本 dialog 手动延迟关闭
     *
     * @param context
     * @param msg
     * @param isAnimation
     */
    public static final void showMsgDialog(Context context, final String msg, boolean isAnimation){
        if(context == null){
            return;
        }
        msgDialog = new DialogFactory(context, R.layout.dialog_message_only){
            @Override
            public void convert(DialogViewHolder view){
                view.setText(R.id.tv_dialog_content, msg);
            }
        };
        if(msgDialog != null){
            msgDialog.showDialog(isAnimation);
        }
    }

    /**
     * 纯文本 dialog 自带1000毫秒延迟
     *
     * @param context
     * @param msg
     */
    public static final void showMsgDialog(Context context, final String msg) {
        showMsgDialog(context, msg, true, true);
    }

    /**
     * 纯文本 dialog 自带1000毫秒延迟
     *
     * @param context
     * @param msg
     * @param isAnimation
     * @param isDelay
     */
    public static final void showMsgDialog(Context context, final String msg, boolean isAnimation, boolean isDelay){
        if(context == null){
            return;
        }
        msgDialog = new DialogFactory(context, R.layout.dialog_message_only){
            @Override
            public void convert(DialogViewHolder view){
                view.setText(R.id.tv_dialog_content, msg);
            }
        };
        if(msgDialog != null){
            msgDialog.showDialog(isAnimation);
        }
        if(isDelay){
            new Handler().postDelayed(new Runnable(){
                public void run(){
                    msgDialog.cancelDialog();
                }
            }, 1500);
        }
    }

    public static final void showMsgDialog(Context context, int type, final String msg, boolean isAnimation){
        if(context == null){
            return;
        }
        switch(type){
            case 1://显示土司
                Toast.makeText(context, msg,Toast.LENGTH_SHORT).show();
                break;
            case 2://显示一个按钮的msg提示框
                if(msgDialog != null){
                    msgDialog.cancelDialog();
                    msgDialog = null;
                }
                msgDialog = new DialogFactory(context, R.layout.dialog_style_one){
                    @Override
                    public void convert(DialogViewHolder view){
                        view.setText(R.id.content, msg);
                        view.setViewGone(R.id.cancle);
                        view.setViewGone(R.id.middle_line);
                        view.setOnClick(R.id.sure, new View.OnClickListener(){

                            @Override
                            public void onClick(View v){
                                hideMsgDialog();
                            }
                        });
                    }
                };
                msgDialog.getDilaogVh().setText(R.id.content, msg);
                break;
            default:
                break;
        }
        if(msgDialog != null){
            msgDialog.showDialog(isAnimation);
        }
    }

    /**
     * 底部弹窗 dialog (内置取消功能)
     *
     * @param mcontent
     * @param title
     * @param sureClick
     */
    public static final void showDialogFromBottomMsg(Context mcontent, final String title, final View.OnClickListener sureClick){
        if(mcontent == null){
            return;
        }
        msgDialog = new DialogFactory(mcontent, R.layout.dialog_message_from_bottom){
            @Override
            public void convert(DialogViewHolder view){
                view.setOnClick(R.id.tv_dialog_sure, sureClick);
                view.setText(R.id.tv_dialog_title, title);
                view.setOnClick(R.id.tv_dialog_cancel, new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        msgDialog.cancelDialog();
                    }
                });
            }
        };
        msgDialog.fullWidth().fromBottom().showDialog();
    }

    /**
     * 底部弹窗 dialog
     *
     * @param mcontent
     * @param title
     * @param sure
     * @param cancel
     * @param sureClick
     * @param cancelClick
     */
    public static final void showDialogFromBottomMsg(Context mcontent, final String title, final String sure, final String cancel, final View.OnClickListener sureClick, final View.OnClickListener cancelClick){
        if(mcontent == null){
            return;
        }
        msgDialog = new DialogFactory(mcontent, R.layout.dialog_message_from_bottom){
            @Override
            public void convert(DialogViewHolder view){
                view.setOnClick(R.id.tv_dialog_sure, sureClick);
                view.setOnClick(R.id.tv_dialog_cancel, cancelClick);
                view.setText(R.id.tv_dialog_title, title);
                view.setText(R.id.tv_dialog_sure, sure);
                view.setText(R.id.tv_dialog_cancel, cancel);
            }
        };
        msgDialog.fullWidth().fromBottom().showDialog();
    }

    /**
     * 双按钮加图片 Dialog
     *
     * @param mcontent
     * @param sureClick
     * @param cancelClick
     */
    public static final void showDoubleBottonImageDialog(Context mcontent, final View.OnClickListener sureClick, final View.OnClickListener cancelClick){
        if(mcontent == null){
            return;
        }
        msgDialog = new DialogFactory(mcontent, R.layout.dialog_message_image_double_button){
            @Override
            public void convert(DialogViewHolder view){
                view.setOnClick(R.id.img_dialog_cancel, new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        msgDialog.cancelDialog();
                    }
                });
                view.setOnClick(R.id.sure, sureClick);
                view.setOnClick(R.id.cancle, cancelClick);
            }
        };
        msgDialog.setPercentWidthAndHeight(80, 0).showDialog(true);
    }

    /**
     * 双按钮加图片 Dialog
     *
     * @param mcontent
     * @param title
     * @param sure
     * @param cancel
     * @param sureClick
     * @param cancelClick
     */
    public static final void showDoubleBottonImageDialog(Context mcontent, final String title, final String sure, final String cancel, final View.OnClickListener sureClick, final View.OnClickListener cancelClick){
        if(mcontent == null){
            return;
        }
        msgDialog = new DialogFactory(mcontent, R.layout.dialog_message_image_double_button){
            @Override
            public void convert(DialogViewHolder view){
                view.setOnClick(R.id.img_dialog_cancel, new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        msgDialog.cancelDialog();
                    }
                });
                view.setOnClick(R.id.tv_dialog_sure, sureClick);
                view.setOnClick(R.id.tv_dialog_cancel, cancelClick);
                view.setText(R.id.tv_dialog_cancel, cancel);
                view.setText(R.id.tv_dialog_sure, sure);
                view.setText(R.id.tv_dialog_sure, title);
            }
        };
        msgDialog.setPercentWidthAndHeight(80, 0).showDialog(true);
    }

    public static final void showDoubleBottonImageDialog(Context mcontent, final boolean showButton){
        msgDialog = new DialogFactory(mcontent, R.layout.dialog_message_image_double_button){

            @Override
            public void convert(DialogViewHolder view){
                if(showButton){
                    view.setViewGone(R.id.ll_double_button);
                    view.setViewInViSible(R.id.img_dialog_cancel);
                    new Handler().postDelayed(new Runnable(){
                        public void run(){
                            msgDialog.cancelDialog();
                        }
                    }, 1500);
                }
            }
        };
        msgDialog.setPercentWidthAndHeight(80, 0).showDialog(true);
    }

    //扫描二维码dialog
    public static final void showHintDialog(Context mcontent, final String showContent, final View.OnClickListener listener, final View.OnClickListener cancelListener){
        if(mcontent == null){
            return;
        }
        msgDialog = new DialogFactory(mcontent, R.layout.dialog_scan_show_info){

            @Override
            public void convert(DialogViewHolder view){
                view.setOnClick(R.id.tv_dialog_sure, listener);
                view.setText(R.id.tv_content, showContent);
                view.setOnClick(R.id.tv_dialog_cancel, cancelListener);
            }
        };
        msgDialog.setCanceledOnTouchOutside(false);
        msgDialog.setPercentWidthAndHeight(70, 0).showDialog(true);
    }

    public static final void showHintDialog(Context mcontent, final String showContent, final String sureContent, final View.OnClickListener listener){
        showHintDialog(mcontent, showContent, sureContent, false, listener);
    }

    public static final void showHintDialog(Context mcontent, final String showContent, final String sureContent, final boolean onlySure, final View.OnClickListener listener){
        showHintDialog(mcontent, showContent, sureContent, "提示", onlySure, listener);
    }

    public static final void showHintDialog(Context mcontent, final String showContent, final String sureContent, final String titleContent, final boolean onlySure, final View.OnClickListener listener){
        if(mcontent == null){
            return;
        }
        msgDialog = new DialogFactory(mcontent, R.layout.dialog_scan_show_info){

            @Override
            public void convert(DialogViewHolder view){
                view.setOnClick(R.id.tv_dialog_sure, listener);
                view.setText(R.id.tv_content, showContent);
                view.setOnClick(R.id.tv_dialog_cancel, new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        msgDialog.dismissDialog();
                    }
                });
                view.setText(R.id.tv_dialog_sure, sureContent);
                view.setText(R.id.tv_dialog_title, titleContent);
                if(onlySure){
                    view.setViewGone(R.id.tv_dialog_cancel);
                    view.setViewGone(R.id.view_line_v);
                }
            }
        };
        msgDialog.setCanceledOnTouchOutside(false);
        msgDialog.setPercentWidthAndHeight(70, 0).showDialog(true);
    }

    public static final void hideMsgDialog(){
        if(msgDialog != null){
            msgDialog.cancelDialog();
        }
    }

    public static final void clearMsgDialog(){
        if(msgDialog != null){
            msgDialog = null;
        }
    }
}
