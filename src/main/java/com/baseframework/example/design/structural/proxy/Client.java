package com.baseframework.example.design.structural.proxy;


/**
 * 代理模式（Proxy）：为其他对象提供一种代理以控制对这个对象的访问。
 * @author Administrator
 *
 */
public class Client {

	public static void main(String[] args) {
		
		ProxyPlayARCGame ppa = new ProxyPlayARCGame(new KOF97());
		
		PlayARCBuilder pab = new PlayARCBuilder(ppa);
		
		pab.playARC();
	}
}
