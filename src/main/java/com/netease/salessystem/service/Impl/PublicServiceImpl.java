package com.netease.salessystem.service.Impl;

import com.netease.salessystem.dao.SaleContentDao;
import com.netease.salessystem.dao.UserDao;
import com.netease.salessystem.domain.SaleContent;
import com.netease.salessystem.domain.User;
import com.netease.salessystem.service.PublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author:626hp
 * @date:2019/3/6
 * @description:
 */
@Service
public class PublicServiceImpl implements PublicService {

    @Autowired
    private SaleContentDao saleContentDao;

    @Autowired
    private UserDao userDao;

    @Override
    public void insert(String userName, SaleContent saleContent) {
//        User query = new User();
//        query.setUserName(userName);
//        User onlineUser = userDao.find(query);
//        saleContent.setSellerId(onlineUser.getId());
//        saleContentDao.insert(saleContent);
    }
}
