package com.test.dynamicDataSource.common.router.impl;

import com.test.dynamicDataSource.common.router.DbRouteResultHolder;
import com.test.dynamicDataSource.common.router.RouteRule.RouteRuleSet;
import com.test.dynamicDataSource.common.router.RouteService;
import org.apache.commons.lang.StringUtils;

import java.text.DecimalFormat;

/**
 * Created by jd on 2016/7/17.
 */
class RouteServiceImpl implements RouteService {
    private RouteRuleSet routeRuleSet;

    @Override
    public String doRouteByResource(String resourceCode) {
        if(StringUtils.isEmpty(resourceCode)) {
            throw new IllegalArgumentException("the code which is used to route can't be null!!!");
        } else {
            int routeFieldInt = Integer.valueOf(resourceCode).intValue();
            String dbKey = getDbKey(this.routeRuleSet, routeFieldInt);
            return dbKey;
        }
    }

    public static String getDbKey(RouteRuleSet ruleSets, int routeFieldInt) {
        Object dbRuleSet = null;
        if(ruleSets != null) {
            String dbKey = null;
            if(ruleSets.getDbKeyArray() != null && ruleSets.getDbNumber() != 0) {
                long dbIndex = 0L;
                long tbIndex = 0L;
                long mode    = (long)ruleSets.getDbNumber();

                mode         =  (long)(ruleSets.getDbNumber() * ruleSets.getTableNumber());
                dbIndex      =  (long)routeFieldInt % mode / (long)ruleSets.getTableNumber();
                tbIndex      =  (long)(routeFieldInt % ruleSets.getTableNumber());

                String tableIndex  =  getFormateTableIndex(ruleSets.getTableIndexStyle(), tbIndex);
                DbRouteResultHolder.setTableIndex(tableIndex);

                dbKey = (String)ruleSets.getDbKeyArray().get(Long.valueOf(dbIndex).intValue());
                DbRouteResultHolder.setDbIndex(dbKey);
            }
            return dbKey;
        } else {
            throw new IllegalArgumentException("rule used to route can not be null.");
        }
    }

    private static String getFormateTableIndex(String style, long tbIndex) {
        String tableIndex = null;
        DecimalFormat df = new DecimalFormat();
        if(StringUtils.isEmpty(style)) {
            style = "_0000";
        }

        df.applyPattern(style);
        tableIndex = df.format(tbIndex);
        return tableIndex;
    }

    public RouteRuleSet getRouteRuleSet() {
        return routeRuleSet;
    }

    public void setRouteRuleSet(RouteRuleSet routeRuleSet) {
        this.routeRuleSet = routeRuleSet;
    }
}
