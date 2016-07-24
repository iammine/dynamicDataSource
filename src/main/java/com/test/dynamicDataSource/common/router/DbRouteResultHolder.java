package com.test.dynamicDataSource.common.router;

/**
 * Created by jd on 2016/7/17.
 * 将路由结果保存在当前线程的局部变量中
 */
public class DbRouteResultHolder {
    private static final ThreadLocal<String> dbIndexHolder = new ThreadLocal<String>();      // 保存库的路由结果线程变量
    private static final ThreadLocal<String> tableIndexHolder = new ThreadLocal<String>();   // 保存表的路由结果的线程变量

    /**
     * 保存库的路由结果
     * @param dbIndex
     */
    public static void setDbIndex(String dbIndex){
        dbIndexHolder.set(dbIndex);
    }

    /**
     * 获取库的路由结果
     * @return
     */
    public static String getDbIndex(){
        return dbIndexHolder.get();
    }

    /**
     * 保存表的路由结果
     * @param tableIndex
     */
    public static void setTableIndex(String tableIndex){
        tableIndexHolder.set(tableIndex);
    }

    /**
     * 获取表的路由结果
     * @return
     */
    public static String getTableIndex() {
        return tableIndexHolder.get();
    }
}
