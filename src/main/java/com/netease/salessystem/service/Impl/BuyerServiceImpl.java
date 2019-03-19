package com.netease.salessystem.service.Impl;

import com.google.common.collect.Lists;
import com.netease.salessystem.dao.BuyContentDao;
import com.netease.salessystem.dao.SaleContentDao;
import com.netease.salessystem.dao.ShoppingCartItemDao;
import com.netease.salessystem.domain.BuyContent;
import com.netease.salessystem.domain.SaleContent;
import com.netease.salessystem.domain.ShoppingCartItem;
import com.netease.salessystem.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:626hp
 * @date:2019/3/11
 * @description:
 */
@Service
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private BuyContentDao buyContentDao;

    @Autowired
    private SaleContentDao saleContentDao;

    @Autowired
    private ShoppingCartItemDao shoppingCartItemDao;

    @Override
    public List<BuyContent> list(Integer buyerId) {
        List<BuyContent> buyContents = getUnbought(buyerId);
        buyContents.addAll(buyContentDao.list(buyerId));
        return buyContents;
    }

    @Override
    public List<BuyContent> listUnbought(Integer buyerId) {
        return getUnbought(buyerId);
    }

    @Override
    public void addShoppingCartItem(ShoppingCartItem shoppingCartItem) {
        shoppingCartItemDao.insert(shoppingCartItem);
    }

    @Override
    public ShoppingCartItem select(Integer productId) {
        return shoppingCartItemDao.select(productId);
    }

    @Override
    public List<ShoppingCartItem> listShoppingCartItem(Integer buyerId) {
        return shoppingCartItemDao.list(buyerId);
    }


    private List<BuyContent> getUnbought(Integer buyerId) {
        List<SaleContent> saleContents = saleContentDao.list();
        List<Integer> contentIds = buyContentDao.listContentIds(buyerId);
        List<BuyContent> buyContents = Lists.newArrayList();
        for (SaleContent saleContent : saleContents) {
            if (!contentIds.contains(saleContent.getId())) {
                BuyContent buyContent = new BuyContent();
                buyContent.setBuyerId(buyerId);
                buyContent.setSaleContent(saleContent);
                buyContent.setBuyNum(0);
                buyContents.add(buyContent);
            }
        }
        return buyContents;
    }


}
