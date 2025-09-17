package com.linkedbear.springboot.routedatasource.config;

import com.linkedbear.springboot.routedatasource.datasource.RouteDataSource;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.BeanFactoryDataSourceLookup;

import javax.sql.DataSource;
import java.util.Map;

@Configuration(proxyBeanMethods = false)
public class RouteDataSourceConfiguration {
    
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource masterDataSource() {
        return DataSourceBuilder.create().build();
    }
    
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    public DataSource slaveDataSource() {
        return DataSourceBuilder.create().build();
    }
    
    @Bean
    @Primary
    public RouteDataSource routeDataSource(BeanFactory beanFactory, DataSource masterDataSource) {
        RouteDataSource dataSource = new RouteDataSource();
        dataSource.setTargetDataSources(Map.of("master", "masterDataSource", "slave", "slaveDataSource"));
        dataSource.setDataSourceLookup(new BeanFactoryDataSourceLookup(beanFactory));
        dataSource.setDefaultTargetDataSource(masterDataSource);
        return dataSource;
    }
}
