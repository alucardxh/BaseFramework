package com.baseframework.example.design.structural.proxy.cglibproxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {

	@Override
	public Object intercept(Object object, Method method, Object[] objectArray, MethodProxy methodProxy) throws Throwable {
		System.out.println("before-------------");  
		
		methodProxy.invokeSuper(object, objectArray);  
		
        System.out.println("after--------------");  
        return null;  
	}

}
