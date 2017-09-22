package com.baseframework.example.design.structural.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;



/**
 * 代理模式（Proxy）：为其他对象提供一种代理以控制对这个对象的访问。
 * @author Administrator
 *
 */
public class Client {

	public static void main(String[] args) {
		
		/*ARCGame kof97 = new KOF97();  
        InvocationHandler handler = new MyInvocationHandler(kof97);  
        // Proxy为InvocationHandler实现类动态创建一个符合某一接口的代理实例  
        ARCGame kof97daili = (ARCGame) Proxy.newProxyInstance(kof97  
                .getClass().getClassLoader(), kof97.getClass().getInterfaces(), handler);  
        // 由动态生成的代理对象来aServiceProxy 代理执行程序，其中aServiceProxy 符合Service接口  
        kof97daili.buyCoin(); 
        kof97daili.putCoin();
        kof97daili.play();*/
		
		
		ARCGame a= (ARCGame)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{ARCGame.class},new InvocationHandler(){
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println(proxy.getClass());
				if(method.getName().equals("buyCoin")){
					System.out.println("投币");
				}
				if("play".equals(method.getName())){
					System.out.println("玩");
				}
				return null;
			}
			
		});
		
		a.buyCoin();
		a.play();
		
	}
}
