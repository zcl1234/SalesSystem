package com.netease.salessystem.domain;

/**
 * @author:626hp
 * @date:2019/3/18
 * @description:购物车
 */
public class ShoppingCartItem {

    Integer id;

    Integer buyerId;

    SaleContent saleContent;

    Integer num;

    Double perPrice;

    public Double getPerPrice() {
        return perPrice;
    }

    public void setPerPrice(Double perPrice) {
        this.perPrice = perPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    public SaleContent getSaleContent() {
        return saleContent;
    }

    public void setSaleContent(SaleContent saleContent) {
        this.saleContent = saleContent;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
