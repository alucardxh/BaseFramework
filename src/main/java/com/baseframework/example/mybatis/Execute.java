package com.baseframework.example.mybatis;

import org.apache.ibatis.session.SqlSession;
import com.baseframework.example.mybatis.dao.StudentMapper;
import com.baseframework.example.pojo.Student;

public class Execute {

	public static void main(String[] args) {

		SqlSession sqlSession = null;

		try {
			sqlSession = SqlSessionFactoryUtil.openSqlSession();
			StudentMapper sm = sqlSession.getMapper(StudentMapper.class);
			Student s = sm.selectStudentById("3");
			System.out.println(s);
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}

		}
	}

}
