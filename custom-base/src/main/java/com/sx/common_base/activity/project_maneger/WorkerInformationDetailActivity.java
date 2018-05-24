package com.sx.common_base.activity.project_maneger;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.common.base.widget.titlebar.TitleModule;
import com.common.base.widget.titlebar.TitleModuleBuilder;
import com.common.base.widget.titlebar.ViewBean;
import com.sx.common_base.R;
import com.sx.common_base.R2;
import com.sx.common_base.adapter.SortAdapter;
import com.sx.common_base.base.BaseRequestUrlActivity;
import com.sx.common_base.request.DealerInfoRequest;
import com.sx.common_base.view.pinyin.ContactSortModel;
import com.sx.common_base.view.pinyin.EditTextWithDel;
import com.sx.common_base.view.pinyin.PinyinComparator;
import com.sx.common_base.view.pinyin.PinyinUtils;
import com.sx.common_base.view.pinyin.SideBar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;

public class WorkerInformationDetailActivity extends BaseRequestUrlActivity {


    public static int SELECT_CLIENT_RESULT_CODE = 119;

    @BindView(R2.id.lv_contact)
    ListView sortListView;

    @BindView(R2.id.sidebar)
    SideBar sideBar;

    @BindView(R2.id.dialog)
    TextView dialog;

    @BindView(R2.id.et_search)
    EditText mEtSearchName;

    private List<ContactSortModel> SourceDateList;

    private SortAdapter adapter;


    @Override
    public int getContentViewId() {
        return R.layout.activity_worker_information_detail;
    }

    @Override
    public void initTitle() {

        TitleModule module = TitleModuleBuilder.builder
                .setTitleVB(new ViewBean(R.string.app_name))
                .setLeftImgVB1(new ViewBean(R.drawable.common_back))
                .setRightImgVB1(new ViewBean(R.drawable.common_back))
                .createTitleModule();
        mTitleBar.setModel(module);
        mTitleBar.setTitle("工人信息");
        mTitleBar.setBackgroundResource(R.color.c1884FF);
        mTitleBar.setTitleColor(Color.WHITE);
        mTitleBar.hiddenGrayLine();//隐藏灰线

        mTitleBar.setRightImageClick1(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,WorkerInformationAddActivity.class);
                mContext.startActivity(intent);
            }
        });


    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

        requestData();
        sideBar.setTextView(dialog);
        initEvent();

    }

    private void requestData(){
        List<String> list = new ArrayList<>();
        list.add("李大钊");
        list.add("毛泽东");
        list.add("周恩来");
        list.add("邓小平");
        SourceDateList = filledData(list);
        Collections.sort(SourceDateList, new PinyinComparator());
        adapter = new SortAdapter(mContext, SourceDateList);
        sortListView.setAdapter(adapter);
    }

    private void initEvent(){
        //设置右侧触摸监听
        sideBar.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {
            @Override
            public void onTouchingLetterChanged(String s) {
                //该字母首次出现的位置
                int position = adapter.getPositionForSection(s.charAt(0));
                if (position != -1) {
                    sortListView.setSelection(position + 1);
                }
            }
        });

        //ListView的点击事件
        sortListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent = new Intent();
//                intent.putExtra("memberId", ((ContactSortModel) adapter.getItem(position)).getMember().getId());
                intent.putExtra("memberName", ((ContactSortModel) adapter.getItem(position)).getMember());
                setResult(SELECT_CLIENT_RESULT_CODE, intent);
                localFinish();
            }
        });

        //根据输入框输入值的改变来过滤搜索
        mEtSearchName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //当输入框里面的值为空，更新为原来的列表，否则为过滤数据列表
                filterData(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private List<ContactSortModel> filledData(List<String> members) {
        List<ContactSortModel> mSortList = new ArrayList<>();
        ArrayList<String> indexString = new ArrayList<>();

        for (int i = 0; i < members.size(); i++) {
            ContactSortModel sortModel = new ContactSortModel();
            sortModel.setMember(members.get(i));
            String pinyin = PinyinUtils.getPingYin(members.get(i));
            String sortString = pinyin.substring(0, 1).toUpperCase();
            if (sortString.matches("[A-Z]")) {
                sortModel.setSortLetters(sortString.toUpperCase());
                if (!indexString.contains(sortString)) {
                    indexString.add(sortString);
                }
            }else{
                sortModel.setSortLetters("#");
                if (!indexString.contains("#")) {
                    indexString.add("#");
                }
            }
            mSortList.add(sortModel);
        }
        Collections.sort(indexString);
        sideBar.setIndexText(indexString);
        return mSortList;
    }

    /**
     * 根据输入框中的值来过滤数据并更新ListView
     *
     * @param filterStr
     */
    private void filterData(String filterStr) {
        List<ContactSortModel> mSortList = new ArrayList<>();
        if (TextUtils.isEmpty(filterStr)) {
            mSortList = SourceDateList;
        } else {
            mSortList.clear();
            if(SourceDateList!=null) {
                for (ContactSortModel sortModel : SourceDateList) {
                    String name = sortModel.getMember();
                    if (name.toUpperCase().indexOf(filterStr.toString().toUpperCase()) != -1 || PinyinUtils.getPingYin(name).toUpperCase().startsWith(filterStr.toString().toUpperCase())) {
                        mSortList.add(sortModel);
                    }
                }
            }
        }
        // 根据a-z进行排序
        Collections.sort(mSortList, new PinyinComparator());
        adapter.updateListView(mSortList);
    }


}
