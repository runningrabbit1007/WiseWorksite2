package com.sx.common_base.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.sx.common_base.R;
import com.sx.common_base.R2;

import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/4/17.
 */

public class TeamWorkManagerAdapter extends BaseExpandableListAdapter {

    private List<String> groups;
    private Map<String, List<String>> children;
    private Context context;

    public TeamWorkManagerAdapter(List<String> groups, Map<String, List<String>> children, Context context) {
        this.groups = groups;
        this.children = children;
        this.context = context;
    }



    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        String groupName = groups.get(groupPosition);
        return children.get(groupName).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groups.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {

        List<String> childs = children.get(groups.get(groupPosition));
        return childs.get(childPosition);

    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        final GroupViewHolder gholder;

        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_teamwork_manager_group, null);
            gholder = new GroupViewHolder(convertView);
            convertView.setTag(gholder);
        } else {
            gholder = (GroupViewHolder) convertView.getTag();
        }

        final String group = groups.get(groupPosition);

        gholder.item_group_name.setText(group);


        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        final ChildViewHolder cholder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_teamwork_manager_child, null);


            cholder = new ChildViewHolder(convertView);
            convertView.setTag(cholder);
        } else {
            cholder = (ChildViewHolder) convertView.getTag();
        }

        Object child = getChild(groupPosition,childPosition);

        cholder.itemChildName.setText((String)child);
        cholder.itemChildDesc.setText("工程部");

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    /**
     * 组元素绑定器
     */
    static class GroupViewHolder {
        @BindView(R2.id.item_group_name)
        TextView item_group_name;
        @BindView(R2.id.item_group_count)
        TextView item_group_count;

        GroupViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }


    /**
     * 子元素绑定器
     */
    static class ChildViewHolder {

        @BindView(R2.id.item_child_image)
        ImageView itemChildImage;
        @BindView(R2.id.item_child_name)
        TextView itemChildName;
        @BindView(R2.id.item_child_desc)
        TextView itemChildDesc;

        ChildViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

    }



}
