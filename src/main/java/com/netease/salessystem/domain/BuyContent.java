package com.netease.salessystem.domain;

/**
 * @author:626hp
 * @date:2019/3/11
 * @description:
 */
public class BuyContent {

    int id;

    int buyerId;

    SaleContent saleContent;

    int buyNum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public SaleContent getSaleContent() {
        return saleContent;
    }

    public void setSaleContent(SaleContent saleContent) {
        this.saleContent = saleContent;
    }

    public int getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(int buyNum) {
        this.buyNum = buyNum;
    }
}
