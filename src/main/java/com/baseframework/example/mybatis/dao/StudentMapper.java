package com.baseframework.example.mybatis.dao;

import com.baseframework.example.pojo.Student;

public interface StudentMapper {
	
	Student selectStudentById(String id);

}
