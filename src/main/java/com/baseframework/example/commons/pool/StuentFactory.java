package com.baseframework.example.commons.pool;


import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import com.baseframework.example.pojo.Student;

public class StuentFactory extends  BasePooledObjectFactory<Student> {

	@Override
	public Student create() throws Exception {
		return new Student();
	}

	@Override
	public PooledObject<Student> wrap(Student obj) {
		 return new DefaultPooledObject<Student>(obj);
	}

	

}
