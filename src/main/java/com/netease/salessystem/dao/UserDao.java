package com.netease.salessystem.dao;

import com.netease.salessystem.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    /**
     * @param user
     * @return the user
     */
    User find(User user);
}
