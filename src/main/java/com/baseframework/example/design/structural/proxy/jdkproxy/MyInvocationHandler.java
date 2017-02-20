package com.baseframework.example.design.structural.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
	
		private Object target;  
	  
	    public MyInvocationHandler() {  
	        super();  
	    }  
	  
	    public MyInvocationHandler(Object target) {  
	        super();  
	        this.target = target;  
	    }  

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("before-----------------------------");  
        // 程序执行  
        Object result = method.invoke(target, args);  
        // 程序执行后加入逻辑，MethodAfterAdviceInterceptor  
        System.out.println("after------------------------------");  
        
        return result; 
	}

}
