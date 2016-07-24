package com.test.dynamicDataSource.dao.impl;

import com.test.dynamicDataSource.common.router.DbRouteResultHolder;
import com.test.dynamicDataSource.common.router.annotation.RouteDbSource;
import com.test.dynamicDataSource.dao.UserDao;
import com.test.dynamicDataSource.po.User;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.List;

/**
 * Created by jd on 2016/7/17.
 */
public class UserDaoImpl extends SqlMapClientTemplate implements UserDao {

    @Override
    @RouteDbSource
    public void insert(User user) {
        try {
            String tableIndex = DbRouteResultHolder.getTableIndex();
            System.out.println(tableIndex + "***********************************");
            user.setTableIndex(tableIndex);
            insert("User.insert", user);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    @RouteDbSource
    public List<User> select(User user) {
        return queryForList("User.select", user);
    }
}
