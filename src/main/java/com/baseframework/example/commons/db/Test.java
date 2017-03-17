package com.baseframework.example.commons.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {

	public static void main(String[] args) throws SQLException {
		Connection conn = new MyDataSource().getConnection();
		
		
		
		
		PreparedStatement  ps = conn.prepareStatement("select * from student where id=1");
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			rs.getString(1);
			rs.getString(2);
			rs.getString(3);
			
		}

	}

}
