package com.baseframework.example.commons.db;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.DataSourceFactory;

public class MyDataSource implements DataSource,DataSourceFactory{
	
	

	/*public MyDataSource(String username,String password,String url,String driver) {
		
		
		
	}
*/
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Connection getConnection() throws SQLException {
		return new MyConnection();
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		return new MyConnection();
	}

	@Override
	public void setProperties(Properties props) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DataSource getDataSource() {
		return new MyDataSource();
	}

}
