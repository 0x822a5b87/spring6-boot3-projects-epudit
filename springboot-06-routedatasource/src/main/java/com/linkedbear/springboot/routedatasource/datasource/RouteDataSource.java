package com.linkedbear.springboot.routedatasource.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class RouteDataSource extends AbstractRoutingDataSource {
    
    private static final ThreadLocal<String> DATASOURCE_ACTIVE_HOLDER = new ThreadLocal<>();
    
    @Override
    protected Object determineCurrentLookupKey() {
        return DATASOURCE_ACTIVE_HOLDER.get();
    }
    
    public static void set(String dataSourceActive) {
        DATASOURCE_ACTIVE_HOLDER.set(dataSourceActive);
    }
    
    public static void remove() {
        DATASOURCE_ACTIVE_HOLDER.remove();
    }
}
