package com.baseframework.example.generic;


import com.baseframework.example.pojo.Student;

public class Test<T> {
	
	Class<T> entityClass;
	
	public T create(Class<T> clz) throws Exception {
		T t = clz.newInstance(); 
		return t;
	}
	
	
	
	public T create1() throws Exception {
		return (T) entityClass.newInstance();
	}
	
	
	

	public static void main(String[] args) throws Exception {
		Test<Student> t = new Test<Student>();
		Student s = t.create(Student.class);
		t.create1();
		System.out.println(s==null);
		System.out.println(s);
		
	}

}
