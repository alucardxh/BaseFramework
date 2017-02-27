package com.baseframework.example.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Teacher {

	private String name;

	private String age;
							
	private String src;

	public Teacher(@Value("aaa") String name, @Value("bbb") String age, @Value("ccc") String src) {
		this.name = name;
		this.age = age;
		this.src = src;
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

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

}
