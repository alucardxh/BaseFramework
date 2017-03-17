package com.baseframework.example.pojo;

import java.io.Serializable;

public class Student implements Serializable{
	private String id;
	
	private String name;
	
	private String age;
	
	private String src;
	
	public String getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", src=" + src + "]";
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
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
}
