package com.test.dynamicDataSource.common.router.RouteRule;

import java.util.List;

/**
 * Created by jd on 2016/7/17.
 * 数据源、数据库个数、表个数
 */
public class RouteRuleSet {
    private List<String>  dbKeyArray;       // 数据源的key
    private int           dbNumber;          // 数据库个数
    private int           tableNumber;      // 每个库，表的数量
    private String        tableIndexStyle; // 表后缀格式

    public List<String> getDbKeyArray() {
        return dbKeyArray;
    }

    public void setDbKeyArray(List<String> dbKeyArray) {
        this.dbKeyArray = dbKeyArray;
    }

    public int getDbNumber() {
        return dbNumber;
    }

    public void setDbNumber(int dbNumber) {
        this.dbNumber = dbNumber;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public String getTableIndexStyle() {
        return tableIndexStyle;
    }

    public void setTableIndexStyle(String tableIndexStyle) {
        this.tableIndexStyle = tableIndexStyle;
    }
}
