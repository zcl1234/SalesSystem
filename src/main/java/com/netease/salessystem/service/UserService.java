package com.netease.salessystem.service;

import com.netease.salessystem.domain.User;

/**
 * @author:626hp
 * @date:2019/3/2
 * @description:
 */
public interface UserService {
    /**
     * @param userName
     * @return user
     */
    User find(String userName,String password);
}
