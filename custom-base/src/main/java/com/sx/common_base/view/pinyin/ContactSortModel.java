package com.sx.common_base.view.pinyin;

import com.sx.common_base.request.DealerInfoRequest;

public class ContactSortModel {

    private String member;//显示的数据
    private String sortLetters;//显示数据拼音的首字母

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getSortLetters() {
        return sortLetters;
    }

    public void setSortLetters(String sortLetters) {
        this.sortLetters = sortLetters;
    }
}
