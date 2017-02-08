package com.baseframework.utils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class CreateTableName {
	
	private static Connection getConn() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://192.168.1.211/cardrights?useUnicode=true&characterEncoding=UTF-8";
		String username = "root";
		String password = "reallove";
		Connection conn = null;
		try {
			Class.forName(driver); // classLoader,加载对应驱动
			conn = (Connection) DriverManager.getConnection(url, username,
					password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void main(String[] args) throws SQLException {
		Connection conn = getConn();

		DatabaseMetaData dbMetaData = conn.getMetaData();

		String[] types = { "TABLE" };

		ResultSet tabs = dbMetaData
				.getTables(null, null, null, types/* 只要表就好了 */);

		List tables = new ArrayList();
		while (tabs.next()) {
			// 只要表名这一列
			tables.add(tabs.getObject("TABLE_NAME"));

		}
		conn.close();
		for (Object object : tables) {
			System.out.println("<table tableName=\""+object.toString()+"\" domainObjectName=\""+StringUtils.capitalize(toCamelCase(object.toString()))+"\" enableCountByExample=\"false\" enableSelectByExample=\"false\" enableDeleteByExample=\"false\" enableUpdateByExample=\"false\" />");
		}
	}
	
	/**
	 * 将字符串转换为驼峰命名法
	 * @param s
	 * @return
	 */
	 public static String toCamelCase(String s) {
			char SEPARATOR = '_';
	        if (s == null) {
	            return null;
	        }
	 
	        s = s.toLowerCase();
	 
	        StringBuilder sb = new StringBuilder(s.length());
	        boolean upperCase = false;
	        for (int i = 0; i < s.length(); i++) {
	            char c = s.charAt(i);
	 
	            if (c == SEPARATOR) {
	                upperCase = true;
	            } else if (upperCase) {
	                sb.append(Character.toUpperCase(c));
	                upperCase = false;
	            } else {
	                sb.append(c);
	            }
	        }
	 
	        return sb.toString();
	    }
}
