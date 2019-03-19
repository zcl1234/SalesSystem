package com.netease.salessystem.service;

import com.netease.salessystem.domain.SaleContent;

import java.util.List;

/**
 * @author:626hp
 * @date:2019/3/8
 * @description:
 */
public interface SellerService {

    /**
     * @description:list
     * @Param:[]
     * @return:java.util.List<com.netease.salessystem.domain.SaleContent>
     */
    List<SaleContent> list();

    /**
     * @description:发布内容
     * @Param:[userName, saleContent]
     * @return:void
     */
    void insert(String userName, SaleContent saleContent);

    /**
     * @description:查找
     * @Param:[id]
     * @return:com.netease.salessystem.domain.SaleContent
     */
    SaleContent select(Integer id);
    /**
    *@description:编辑内容
    *@Param:[saleContent]
    *@return:void
    */
    void edit(SaleContent saleContent);

}
