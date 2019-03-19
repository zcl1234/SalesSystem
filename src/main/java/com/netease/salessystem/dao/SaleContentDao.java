package com.netease.salessystem.dao;

import com.netease.salessystem.domain.SaleContent;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author:626hp
 * @date:2019/3/7
 * @description:
 */
@Repository
public interface SaleContentDao {

    /**
    *@description:insert
    *@Param:[saleContent]
    *@return:void
    */
    void insert(SaleContent saleContent);

    /**
    *@description:
    *@Param:[]
    *@return:java.util.List<com.netease.salessystem.domain.SaleContent>
    */
    List<SaleContent> list();
    /**
    *@description:
    *@Param:[id]
    *@return:com.netease.salessystem.domain.SaleContent
    */
    SaleContent select(Integer id);
    
    /**
    *@description:编辑内容
    *@Param:[saleContent]
    *@return:void
    */
    void edit(SaleContent saleContent);
}
