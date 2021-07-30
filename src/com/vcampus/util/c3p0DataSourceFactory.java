package com.vcampus.util;

import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * c3p0数据库连接池
 *
 * @author Franklin Yang
 * @date 2021/7/12
 */

public class c3p0DataSourceFactory extends UnpooledDataSourceFactory{
    public c3p0DataSourceFactory() {this.dataSource=new ComboPooledDataSource();}
}
