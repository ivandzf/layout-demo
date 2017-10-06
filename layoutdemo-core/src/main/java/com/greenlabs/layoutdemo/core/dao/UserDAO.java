package com.greenlabs.layoutdemo.core.dao;

import com.greenlabs.layoutdemo.core.entity.User;

/**
 * Created by Ivan on 10/6/17
 */
public interface UserDAO extends BaseDAO<User> {

    User getUsername(String username);

    String getPassword(User user);

}
