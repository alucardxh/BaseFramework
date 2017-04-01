package com.baseframework.example.reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler{
	
	private Object obj;
	
	public MyInvocationHandler(Object obj){
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object  returnValue = method.invoke(obj, args);
		return returnValue+"我被代理了";
	}
	

}
