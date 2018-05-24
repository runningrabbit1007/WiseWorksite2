package com.sx.common_base.request;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by yonggege on 2017/11/21.
 */

public class AccountRequest implements Parcelable {
//        params.put("receiverId","501");  //收货地址
//        params.put("ticketId","501");    //收票地址
//        params.put("roleType","1");  //订单的角色类型  (1.个人 2采购经理)
////        params.put("parentId",);   //用户的父ID（采购经理的ID）
//        params.put("taxTicketId","202");  //税收发票ID
////        params.put("mobile",);   //推荐人电话
//        params.put("cartIds","1001");
////        params.put("skuIds",);
////        params.put("quantitys",);  //数量拼接的字符串


    public AccountRequest() {
        this.cartTag = "";
        this.receiverId = "";
        this.memberId = "";
        this.cartId = "";
        this.memo = "";
        this.invoiceTitle = "";
        this.balance = "";
    }

    private String cartTag;
    private String receiverId;
    private String memberId;
    private String cartId;
    private String memo;
    private String invoiceTitle;
    private String balance;

    protected AccountRequest(Parcel in) {
        receiverId = in.readString();
        cartTag = in.readString();
        memberId = in.readString();
        cartId = in.readString();
        memo = in.readString();
        invoiceTitle = in.readString();
        balance = in.readString();
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(receiverId);
        dest.writeString(cartTag);
        dest.writeString(memberId);
        dest.writeString(cartId);
        dest.writeString(memo);
        dest.writeString(invoiceTitle);
        dest.writeString(balance);
    }



    public static final Creator<AccountRequest> CREATOR = new Creator<AccountRequest>() {
        @Override
        public AccountRequest createFromParcel(Parcel in) {
            return new AccountRequest(in);
        }

        @Override
        public AccountRequest[] newArray(int size) {
            return new AccountRequest[size];
        }
    };

    public String getCartTag() {
        return cartTag;
    }

    public void setCartTag(String cartTag) {
        this.cartTag = cartTag;
    }

    public String getBalance() {
        return balance;
    }

    public String getCartId() {
        return cartId;
    }

    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getMemo() {
        return memo;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    @Override
    public int describeContents() {
        return 0;
    }


}
