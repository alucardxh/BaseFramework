package com.baseframework.example.reflect;

import com.baseframework.example.pojo.Student;

public class ReflectExample extends Student implements Runnable {
	
	private String id;
	
	private String name;
	
	private String age;
	
	
	public ReflectExample() {
		System.out.println("我是无参构造器");
	}

	public ReflectExample(String s) {
		System.out.println(s);
	}

	public ReflectExample(int a, String s) {
		System.out.println(String.valueOf(a) + s);
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
}
