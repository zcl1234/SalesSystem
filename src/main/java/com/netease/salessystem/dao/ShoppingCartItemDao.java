package com.netease.salessystem.dao;

import com.netease.salessystem.domain.ShoppingCartItem;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author:626hp
 * @date:2019/3/18
 * @description:购物车
 */
@Repository
public interface ShoppingCartItemDao {
    
    /**
    *@description:加入购物车
    *@Param:[shoppingCart]
    *@return:void
    */
    void insert(ShoppingCartItem shoppingCartItem);

    /**
    *@description:根据商品ID查找
    *@Param:[productId]
    *@return:com.netease.salessystem.domain.ShoppingCart
    */
    ShoppingCartItem select(Integer productId);

    /**
    *@description:购物车列表
    *@Param:[buyerId]
    *@return:java.util.List<com.netease.salessystem.domain.ShoppingCartItem>
    */
    List<ShoppingCartItem> list(Integer buyerId);
}
