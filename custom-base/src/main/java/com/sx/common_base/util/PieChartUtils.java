package com.sx.common_base.util;

import android.graphics.Color;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/10.
 */

public class PieChartUtils {

    public static PieChart initChart(PieChart mChart) {

        mChart.setUsePercentValues(false);//设置value是否用显示百分数,默认为false
        mChart.getDescription().setEnabled(false);//设置描述
        mChart.setExtraOffsets(5, 10, 5, 5);
//        mChart.setDrawSliceText(false);//设置隐藏饼图上文字，只显示百分比
        mChart.setDragDecelerationFrictionCoef(0.95f);//设置阻尼系数,范围在[0,1]之间,越小饼状图转动越困难


        mChart.setDrawHoleEnabled(true);//是否绘制饼图中间的圆
        mChart.setHoleColor(Color.WHITE);//中间饼图圆颜色

        mChart.setTransparentCircleColor(Color.BLACK);//设置圆环颜色
        mChart.setTransparentCircleAlpha(0);//设置透明度

        mChart.setHoleRadius(58f);
        mChart.setTransparentCircleRadius(61f);//设置圆环半径值

        mChart.setDrawCenterText(false);//绘制中间问题

        mChart.setRotationAngle(0);//旋转角度
        // enable rotation of the chart by touch
        mChart.setRotationEnabled(false);//是否能够旋转
        mChart.setHighlightPerTapEnabled(true);//选中tab是否高亮


        //设置比例图（说明的次奥方块）
        Legend l = mChart.getLegend();
        l.setForm(Legend.LegendForm.CIRCLE);
        l.setPosition(Legend.LegendPosition.RIGHT_OF_CHART_CENTER);//设置每个tab的显示位置
        l.setXEntrySpace(0f);
        l.setYEntrySpace(0f);//设置tab之间Y轴方向上的空白间距值
        l.setYOffset(0f);


        // entry label styling
        mChart.setDrawEntryLabels(false);//设置是否绘制Label
        mChart.setEntryLabelColor(Color.BLACK);//设置绘制Label的颜色
        mChart.setEntryLabelTextSize(10f);//设置绘制Label的字体大小

        return mChart;

    }


    /**
     * 设置图表数据
     *
     * @param mChart  图表
     * @param entries 数据
     */
    public static void setChartData(PieChart mChart, ArrayList<PieEntry> entries) {
        PieDataSet dataSet = new PieDataSet(entries, "");

        dataSet.setDrawIcons(false);

        dataSet.setSliceSpace(3f);
        dataSet.setIconsOffset(new MPPointF(0, 40));
        dataSet.setSelectionShift(5f);

        // add a lot of colors

        ArrayList<Integer> colors = new ArrayList<Integer>();

       /* for (int c : ColorTemplate.VORDIPLOM_COLORS)
            colors.add(c);
*/
       /* for (int c : ColorTemplate.JOYFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.PASTEL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);*/

        /*for (int c : ColorTemplate.LIBERTY_COLORS)
            colors.add(c);*/
        colors.add(ColorTemplate.rgb("#FF741D"));
        colors.add(ColorTemplate.getHoloBlue());
        colors.add(ColorTemplate.rgb("#8C609F"));
        colors.add(ColorTemplate.rgb("#0AED8A"));
        colors.add(ColorTemplate.rgb("#F550A8"));
        colors.add(ColorTemplate.rgb("#CC0000"));


        dataSet.setColors(colors);

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(12f);//百分数
        data.setValueTextColor(Color.WHITE);
        mChart.setData(data);

        // undo all highlights
        mChart.highlightValues(null);

        mChart.invalidate();

        mChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);
    }

    /**
     * 更新图表
     *
     * @param chart     图表
     * @param entries    数据
     */
    public static void notifyDataSetChanged(PieChart chart, ArrayList<PieEntry> entries) {

        chart.invalidate();
        setChartData(chart, entries);
    }

}
