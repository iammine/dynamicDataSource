package com.test.dynamicDataSource.common;

import com.test.dynamicDataSource.common.router.DbRouteResultHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by jd on 2016/7/17.
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DbRouteResultHolder.getDbIndex();
    }
}
