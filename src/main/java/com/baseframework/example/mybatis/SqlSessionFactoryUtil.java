package com.baseframework.example.mybatis;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryUtil {

	private static SqlSessionFactory sqlSessionFactory = null;

	private static final Class CLASS_LOCK = SqlSessionFactoryUtil.class;

	private SqlSessionFactoryUtil() {

	}
	public static SqlSessionFactory initSqlSessionFactory() {
		String resource = "com/baseframework/example/mybatis/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = 	Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			
		}
		synchronized (CLASS_LOCK) {
			if (sqlSessionFactory==null) {
					sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			}
		}
		return sqlSessionFactory;
	}
	
	public static SqlSession openSqlSession(){
		if(sqlSessionFactory==null){
			initSqlSessionFactory();
		}
		return sqlSessionFactory.openSession();
	}

}
