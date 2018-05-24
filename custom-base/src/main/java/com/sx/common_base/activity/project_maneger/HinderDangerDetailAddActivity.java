package com.sx.common_base.activity.project_maneger;

import android.content.DialogInterface;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.configure.PickerOptions;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.common.base.widget.titlebar.TitleModule;
import com.common.base.widget.titlebar.TitleModuleBuilder;
import com.common.base.widget.titlebar.ViewBean;
import com.sx.common_base.R;
import com.sx.common_base.R2;
import com.sx.common_base.base.BaseRequestUrlActivity;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;

import static cn.finalteam.toolsfinal.DateUtils.calendar;
import static cn.finalteam.toolsfinal.DateUtils.format;
import static cn.finalteam.toolsfinal.DateUtils.getTime;

/**
 *
 * 隐患管理-add
 *
 */


public class HinderDangerDetailAddActivity extends BaseRequestUrlActivity{


    @BindView(R2.id.modify_time_select)
    TextView modify_time_select;


    @Override
    public int getContentViewId() {
        return R.layout.activity_hinder_danger_detail_add;
    }

    @Override
    public void initTitle() {

        TitleModule module = TitleModuleBuilder.builder
                .setTitleVB(new ViewBean(R.string.app_name))
                .setLeftImgVB1(new ViewBean(R.drawable.common_back))
                .createTitleModule();
        mTitleBar.setModel(module);
        mTitleBar.setTitle("隐患管理");
        mTitleBar.setBackgroundResource(R.color.c1884FF);
        mTitleBar.setTitleColor(Color.WHITE);
        mTitleBar.hiddenGrayLine();//隐藏灰线

    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @OnClick(R2.id.modify_time_select)
    public void selectTime(){

        Calendar startDate = Calendar.getInstance();
//        startDate.set(2013,1,1);
        Calendar endDate = Calendar.getInstance();
        endDate.set(startDate.get(Calendar.YEAR)+10,1,1);

        TimePickerView pvTime = new TimePickerBuilder(mContext, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                modify_time_select.setText(format(date, "yyyy/MM/dd"));
            }
        })
                .setCancelText("取消")//取消按钮文字
                .setSubmitText("确认")//确认按钮文字
                .setTitleSize(20)//标题文字大小
                .setTitleText("选择时间")//标题文字
                .isCyclic(true)//是否循环滚动
                .setOutSideCancelable(false)//点击屏幕，点在控件外部范围时，是否取消显示
                .setRangDate(startDate,endDate)//起始终止年月日设定
                .isDialog(false)//是否显示为对话框样式
                .build();

        pvTime.setDate(Calendar.getInstance());//注：根据需求来决定是否使用该方法（一般是精确到秒的情况），此项可以在弹出选择器的时候重新设置当前时间，避免在初始化之后由于时间已经设定，导致选中时间与当前时间不匹配的问题。
        pvTime.show();


    }


}
