package com.baseframework.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baseframework.example.commons.pool.StuentFactory;
import com.baseframework.example.commons.pool.PoolUtils;
import com.baseframework.example.pojo.Student;


@Controller
public class PoolController {
	
	/**
	 * 封装了一个对象池
	 */
	private PoolUtils<Student> studentPool = new PoolUtils<Student>(new StuentFactory());
	
	
	
	
	/**
	 * 临时存放从对象池取出来的对象
	 */
	private List<Student> cache  = new ArrayList<Student>();
	
	@RequestMapping(value = "/getPoolPage")
	public String getPoolPage() {
		return "example/pool";
	}
	
	@ResponseBody
	@RequestMapping(value = "/borrowObject")
	public String borrowObject() {
		String returnMessage;
		try {
			if(studentPool.getNumActive()<8){
				Student s = studentPool.borrowObject();
				cache.add(s);
				returnMessage="已从线程池中取出"+s;
			}else{
				returnMessage="借了都不换，对象池中没有对象了";
			}
		} catch (Exception e) {
			e.printStackTrace();
			returnMessage="异常";
		}
		return returnMessage;
	}
	
	@ResponseBody
	@RequestMapping(value = "/returnObject")
	public String returnObject() {
		String returnMessage;
		if(cache.size()>0){
			Student s = cache.remove(0);
			studentPool.returnObject(s);
			returnMessage="将使用的对象"+s+"返还到了对象池";
		}else{
			returnMessage="借都没借，你拿什么还呢";
		}
		return returnMessage;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/clearPool")
	public String clearPool() {
		System.out.println("清空");
		studentPool.clear();
		return "清空池子喽";
	}
	
	
	
	@ResponseBody
	@RequestMapping(value = "/getIdel")
	public String getIdel() {
		return String.valueOf(studentPool.getNumIdle());
	}
	


}
