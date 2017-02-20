package com.baseframework.example.design.structural.proxy.cglibproxy;


public class Client {

	public static void main(String[] args) {
		
		CglibProxy proxy = new CglibProxy();  
        // base为生成的增强过的目标类  
        Tekken kof97 = Factory.getInstanceT(proxy,Tekken.class);  
        kof97.buyCoin();
        kof97.putCoin();
        kof97.play();
	}
}
