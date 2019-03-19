package com.netease.salessystem.service.Impl;

import com.netease.salessystem.dao.SaleContentDao;
import com.netease.salessystem.dao.UserDao;
import com.netease.salessystem.domain.SaleContent;
import com.netease.salessystem.domain.User;
import com.netease.salessystem.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:626hp
 * @date:2019/3/8
 * @description:
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SaleContentDao saleContentDao;

    @Autowired
    private UserDao userDao;

    @Override
    public List<SaleContent> list() {
        List<SaleContent> saleContents = saleContentDao.list();
        return saleContents;
    }

    @Override
    public void insert(String userName, SaleContent saleContent) {
        User query = new User();
        query.setUserName(userName);
        User onlineUser = userDao.find(query);
        saleContent.setSellerId(onlineUser.getId());
        saleContentDao.insert(saleContent);
    }

    @Override
    public SaleContent select(Integer id) {
        return saleContentDao.select(id);
    }

    @Override
    public void edit(SaleContent saleContent) {
        saleContentDao.edit(saleContent);
    }


}
