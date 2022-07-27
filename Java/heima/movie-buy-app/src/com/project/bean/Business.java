package com.project.bean;

/**
 * 商家
 */
public class Business extends User {
    // 店铺名
    private String shopName;
    // 店铺地址
    private String shopAddress;

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }
}
