package com.netease.salessystem.dao;

import com.netease.salessystem.domain.BuyContent;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author:626hp
 * @date:2019/3/11
 * @description:
 */
@Repository
public interface BuyContentDao {

    /**
    *@description:已购买商品ID
    *@Param:[buyerId]
    *@return:java.util.List<com.netease.salessystem.domain.BuyContent>
    */
    List<BuyContent> list(Integer buyerId);
    /**
    *@description:已购买商品
    *@Param:[buyId]
    *@return:java.util.List<java.lang.Integer>
    */
    List<Integer> listContentIds(Integer buyId);

}
