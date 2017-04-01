package com.baseframework.example.reflect.proxy;

import java.lang.reflect.Proxy;

public class Client {

	public static void main(String[] args) {
		//创建对象
		RealSubject rs = new RealSubject();
		//实现InvocationHandler接口
		MyInvocationHandler myInvocationHandler	 = new MyInvocationHandler(rs);
		//将对象的类加载器
		//对象的接口
		//及实现的InvocationHandler实现类的实例传入
		Subject obj  = (Subject)Proxy.newProxyInstance(rs.getClass().getClassLoader(), rs.getClass().getInterfaces(), myInvocationHandler);
		System.out.println(obj.say("haha", 10));
	}

}
