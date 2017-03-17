package com.baseframework.example.commons.db;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.DataSourceFactory;

public class MyDataSourceFactory implements DataSourceFactory{

	@Override
	public void setProperties(Properties props) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DataSource getDataSource() {
		return new MyDataSource();
	}

}
