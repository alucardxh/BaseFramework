package com.baseframework.example.controller;

import java.util.Properties;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baseframework.example.pojo.Student;
import com.baseframework.example.service.properties.PropService;
import com.baseframework.utils.SpringContextUtils;
import com.baseframework.utils.SpringPropertiesUtils;




/**
 * 问题：@value在controller中无法取到值
 * 
 * 解决问题：
 * 这里spring mvc中使用了两个spring container， 
 * 一个是web root context(简称rc，在context-parm中创建).
 * 另外一个是servlet context(简称sc，在DispatchServlet中创建).
 * rc是sc的父类，子类的bean可以访问父类，反之则不行。
 * 
 * @Value由BeanPostProcessor处理，
 * BeanPostProcessor的scope是per-container, 
 * 也就是在处理@Value过程中只取当前servlet容器的值
 * 
 */


@Controller
public class PropertiesController {
	
	
	@Resource
	private Properties propTest;
	
	@Resource
	private SpringPropertiesUtils vipList;
	
	@Autowired
	private PropService propService;
	
	
	@ResponseBody
	@RequestMapping(value = "/prop1")
	public Object getProp1(HttpServletRequest request, Model model) {
		Set<Object> set = propTest.keySet();
		return set;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/prop2")
	public Object getProp2(HttpServletRequest request, Model model) {
		Properties  prop = vipList.getProperty();
		Set<Object> set1 = prop.keySet();
		return set1;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/prop3")
	public Object getProp3(HttpServletRequest request, Model model) {
		return propService.s();
	}
	
	
	/**
	 * 获取spring容器中的bean对象
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/bean")
	public Object getBean(HttpServletRequest request, Model model) {
		Student student = SpringContextUtils.getBean(Student.class);
		return student;
	}

}
