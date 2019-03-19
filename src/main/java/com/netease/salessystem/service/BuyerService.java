package com.netease.salessystem.service;

import com.netease.salessystem.domain.BuyContent;
import com.netease.salessystem.domain.ShoppingCartItem;

import java.util.List;

/**
 * @author:626hp
 * @date:2019/3/11
 * @description:
 */
public interface BuyerService {

    /**
     * @description:返回所有内容
     * @Param:[buyerId]
     * @return:java.util.List<com.netease.salessystem.domain.BuyContent>
     */
    List<BuyContent> list(Integer buyerId);

    /**
     * @description:返回未购买内容
     * @Param:[buyerId]
     * @return:java.util.List<com.netease.salessystem.domain.BuyContent>
     */
    List<BuyContent> listUnbought(Integer buyerId);

    /**
    *@description:插入购物车
    *@Param:[shoppingCart]
    *@return:void
    */
    void addShoppingCartItem(ShoppingCartItem shoppingCartItem);

    /**
    *@description:根据商品ID查找
    *@Param:[productId]
    *@return:com.netease.salessystem.domain.ShoppingCart
    */
    ShoppingCartItem select(Integer productId);
    
    /**
    *@description:购物车列表
    *@Param:[]
    *@return:java.util.List<com.netease.salessystem.domain.ShoppingCartItem>
    */
    List<ShoppingCartItem> listShoppingCartItem(Integer buyerId);
}
