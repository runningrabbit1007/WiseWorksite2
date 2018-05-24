package com.sx.common_base.modle;

import java.util.List;

/**
 * Created by jack on 2017/6/5.
 */

public class Container {
    private List<ApiEntity> Node;

    public List<ApiEntity> getNode() {
        return Node;
    }

    public Container setNode(List<ApiEntity> Node) {
        this.Node = Node;
        return this;
    }
}
