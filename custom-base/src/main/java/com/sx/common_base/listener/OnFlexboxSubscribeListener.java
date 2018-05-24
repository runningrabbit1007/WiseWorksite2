package com.sx.common_base.listener;

import java.util.List;

/**
 */
public interface OnFlexboxSubscribeListener<T> {

    /**
     * @param selectedItem 已选中的标签
     */
    void onSubscribe(List<T> selectedItem);
}
