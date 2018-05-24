package com.sx.common_base.request;

/**
 * Created by Administrator on 2017/12/23.
 */

public class DealerInfoRequest {


    /**
     * username : 15111099235
     * memberRank : {"level":1,"name":"普通会员","id":1}
     * name :
     * email :
     * mobile : 15111099235
     * point : 0
     * balance : 5.8226284E7
     * headImageUrl : http://ad.hnsxtech.com/klm/upload/image/201712/a7d47843-372f-43d2-9dcd-ac0449fadd10.jpg
     * address : 麓谷信息港
     * salesMember : {"id":400,"username":"memberTest"}
     * companyName : Hahhah
     * facebook :
     * fax :
     * invoiceTitle : Houhou
     * taxpayerNumber :
     * openBankName :
     * openBank :
     * bankAccount : 888888888888888
     * area : {"fullName":"浙江省杭州市西湖区","id":930}
     * zipCode : 410000
     * phone : 15115803364
     * taxAddress :
     * taxphone :
     * id :
     */

    private String username;
    private MemberRankBean memberRank;
    private String name;
    private String email;
    private String mobile;
    private int point;
    private double balance;
    private String headImageUrl;
    private String address;
    private SalesMemberBean salesMember;
    private String companyName;
    private String facebook;
    private String fax;
    private String invoiceTitle;
    private String taxpayerNumber;
    private String openBankName;
    private String openBank;
    private String bankAccount;
    private AreaBean area;
    private String zipCode;
    private String phone;
    private String taxAddress;
    private String taxphone;
    private int visitRecordCount;
    private int id;


    public int getVisitRecordCount() {
        return visitRecordCount;
    }

    public void setVisitRecordCount(int visitRecordCount) {
        this.visitRecordCount = visitRecordCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public MemberRankBean getMemberRank() {
        return memberRank;
    }

    public void setMemberRank(MemberRankBean memberRank) {
        this.memberRank = memberRank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getHeadImageUrl() {
        return headImageUrl;
    }

    public void setHeadImageUrl(String headImageUrl) {
        this.headImageUrl = headImageUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public SalesMemberBean getSalesMember() {
        return salesMember;
    }

    public void setSalesMember(SalesMemberBean salesMember) {
        this.salesMember = salesMember;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle;
    }

    public String getTaxpayerNumber() {
        return taxpayerNumber;
    }

    public void setTaxpayerNumber(String taxpayerNumber) {
        this.taxpayerNumber = taxpayerNumber;
    }

    public String getOpenBankName() {
        return openBankName;
    }

    public void setOpenBankName(String openBankName) {
        this.openBankName = openBankName;
    }

    public String getOpenBank() {
        return openBank;
    }

    public void setOpenBank(String openBank) {
        this.openBank = openBank;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public AreaBean getArea() {
        return area;
    }

    public void setArea(AreaBean area) {
        this.area = area;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTaxAddress() {
        return taxAddress;
    }

    public void setTaxAddress(String taxAddress) {
        this.taxAddress = taxAddress;
    }

    public String getTaxphone() {
        return taxphone;
    }

    public void setTaxphone(String taxphone) {
        this.taxphone = taxphone;
    }

    public static class MemberRankBean {
        /**
         * level : 1
         * name : 普通会员
         * id : 1
         */

        private int level;
        private String name;
        private int id;

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    public static class SalesMemberBean {
        /**
         * id : 400
         * username : memberTest
         */

        private int id;
        private String username;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }

    public static class AreaBean {
        /**
         * fullName : 浙江省杭州市西湖区
         * id : 930
         */

        private String fullName;
        private int id;

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
