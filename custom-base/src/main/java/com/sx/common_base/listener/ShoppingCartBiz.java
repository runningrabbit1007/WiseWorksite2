package com.sx.common_base.listener;

import android.widget.ImageView;
import android.widget.TextView;


import com.sx.common_base.R;
import com.sx.common_base.result.ShopCartResult;
import com.sx.common_base.util.DecimalUtil;

import java.util.List;

public class ShoppingCartBiz {





   /* * =====================上面是界面改动部分，下面是数据变化部分=========================

    *
     * 获取结算信息，肯定需要获取总价和数量，但是数据结构改变了，这里处理也要变；
     *
     * @return 0=选中的商品数量；1=选中的商品总价*/

    public static String[] getShoppingCount(List<ShopCartResult.CartItemModelListBean> listGoods) {
        String[] infos = new String[2];
        String selectedCount = "0";
        String selectedMoney = "0";
        for (int i = 0; i < listGoods.size(); i++) {
            String price = String.valueOf(listGoods.get(i).getPrice());
            String num = String.valueOf(listGoods.get(i).getQuantity());
            String countMoney = DecimalUtil.multiply(price, num);
            selectedMoney = DecimalUtil.add(selectedMoney, countMoney);
            selectedCount = DecimalUtil.add(selectedCount, num);
        }
        infos[0] = selectedCount;
        infos[1] = selectedMoney;
        return infos;
    }

    public static boolean hasSelectedGoods(List<ShopCartResult.CartItemModelListBean> listGoods) {
        String count = getShoppingCount(listGoods)[0];
        return !"0".equals(count);
    }

   /* *
     * 增减数量，操作通用，数据不通用*/

    public static void addOrReduceGoodsNum(boolean isPlus, ShopCartResult.CartItemModelListBean goods,
                                           TextView tvNum) {
        String currentNum = String.valueOf(goods.getQuantity());
        String num = "1";
        if (isPlus) {
            if (Integer.valueOf(currentNum) < 10000) {
                num = String.valueOf(Integer.parseInt(currentNum) + 1);
            }
        } else {
            int i = Integer.parseInt(currentNum);
            if (i > 1) {
                num = String.valueOf(i - 1);
            } else {
                num = "1";
            }
        }
        tvNum.setText(num);
        goods.setQuantity(Integer.valueOf(num));
    }

//    *
//     * 增减数量，操作通用，数据不通用

    public static void addOrReduceGoodsNum(boolean isPlus, TextView tvNum) {
        String currentNum = String.valueOf(tvNum.getText().toString());
        String num = "1";
        if (isPlus) {
            if (Integer.valueOf(currentNum) < 10000) {
                num = String.valueOf(Integer.parseInt(currentNum) + 1);
            }
        } else {
            int i = Integer.parseInt(currentNum);
            if (i > 1) {
                num = String.valueOf(i - 1);
            } else {
                num = "1";
            }
        }
        tvNum.setText(num);
    }


}
