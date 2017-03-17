package com.baseframework.example.commons.db;


import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.JDBC4PreparedStatement;
import com.mysql.jdbc.MySQLConnection;

public class MyPreparedStatement extends JDBC4PreparedStatement{

	public MyPreparedStatement(MySQLConnection conn, String catalog) throws SQLException {
		super(conn, catalog);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultSet executeQuery() throws SQLException {
		// TODO Auto-generated method stub
		return super.executeQuery();
	}
	
	

}
