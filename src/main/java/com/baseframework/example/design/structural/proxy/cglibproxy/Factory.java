package com.baseframework.example.design.structural.proxy.cglibproxy;

import org.springframework.cglib.proxy.Enhancer;

public class Factory {
	
	  public static KOF97 getInstance(CglibProxy proxy) {  
	        Enhancer enhancer = new Enhancer();  
	        enhancer.setSuperclass(KOF97.class);  
	        //回调方法的参数为代理类对象CglibProxy，最后增强目标类调用的是代理类对象CglibProxy中的intercept方法  
	        enhancer.setCallback(proxy);  
	        // 此刻，base不是单纯的目标类，而是增强过的目标类  
	        KOF97 kof97 = (KOF97) enhancer.create();
	        return kof97;
	    }  
	  
	  
	  
	  
	  public static <T> T getInstanceT(CglibProxy proxy,Class<T> clazz) {  
	        Enhancer enhancer = new Enhancer();  
	        enhancer.setSuperclass(clazz);
	        //回调方法的参数为代理类对象CglibProxy，最后增强目标类调用的是代理类对象CglibProxy中的intercept方法  
	        enhancer.setCallback(proxy);
	        // 此刻，base不是单纯的目标类，而是增强过的目标类  
	        T kof97 = (T) enhancer.create();
	        return kof97;
	    }  

}
