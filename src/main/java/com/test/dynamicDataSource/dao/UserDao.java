package com.test.dynamicDataSource.dao;

import com.test.dynamicDataSource.po.User;

import java.util.List;

/**
 * Created by jd on 2016/7/17.
 */
public interface UserDao {
    public void insert(User user);

    public List<User> select(User user);
}
