package com.test.dynamicDataSource.po;

import com.test.dynamicDataSource.common.router.DbRouteResultHolder;

/**
 * Created by jd on 2016/7/17.
 */
public class User {
    private int    id;
    private String name;
    private String remark;

    private String tableIndex; // 表路由结果

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTableIndex() {
        tableIndex = DbRouteResultHolder.getTableIndex();
        return tableIndex;
    }

    public void setTableIndex(String tableIndex) {
        this.tableIndex = DbRouteResultHolder.getTableIndex();
    }
}
