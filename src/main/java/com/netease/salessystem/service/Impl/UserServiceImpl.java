package com.netease.salessystem.service.Impl;

import com.netease.salessystem.dao.UserDao;
import com.netease.salessystem.domain.User;
import com.netease.salessystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author:626hp
 * @date:2019/3/2
 * @description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User find(String userName, String password) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        User res = userDao.find(user);
        return res;
    }
}
