package com.baseframework.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.baseframework.example.pojo.Student;
import com.baseframework.utils.XStreamPlus;
import com.thoughtworks.xstream.XStream;

@Controller
public class DataConvert {
	
	
	/**
	 * json字符串对象互转
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/json")
	public String getJSON(){
		Student student = new Student();
		student.setAge("1");
		student.setName("success");
		
		//对象------>json字符串
		String jsonStudent = JSON.toJSONString(student);
		System.out.println(jsonStudent);
		
		//json字符串------>对象
		Student student1 = JSON.parseObject(jsonStudent, Student.class);
		System.out.println(student1);
		return null;
	}
	
	/**
	 * xml字符串对象互转
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getXml")
	public String getJson(HttpServletRequest request, Model model) {
		Student student = new Student();
		student.setAge("1");
		student.setName("success");
		
		//设置XStream对象
		XStream xStream = new XStream();
		xStream.ignoreUnknownElements();
		xStream.alias("xml", Student.class);
		
		//对象------>xml字符串
		String xmlStudent = xStream.toXML(student);
		System.out.println(xmlStudent);
		//xml字符串------>对象
		Student student1 = (Student) xStream.fromXML(xmlStudent);
		System.out.println(student1);
		
		
		//增强版
		XStreamPlus<Student> xp = new XStreamPlus<Student>();
		xp.alias("xml", Student.class);
		//对象------>xml字符串
		String s1 = xp.toXML(student);
		//xml字符串------>对象
		Student s = xp.fromXML(s1);
		return null;
	}

}
