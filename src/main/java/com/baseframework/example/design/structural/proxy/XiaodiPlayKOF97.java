package com.baseframework.example.design.structural.proxy;

public class XiaodiPlayKOF97 implements ARCGame{
	
	private ARCGame ag;
	
	public XiaodiPlayKOF97() {
		ag = new KOF97();
	}

	@Override
	public void buyCoin() {
		ag.buyCoin();
		System.out.println("大哥帮你买币");
	}

	@Override
	public void putCoin() {
		ag.putCoin();
		System.out.println("大哥帮你投币");
		
	}

	@Override
	public void play() {
		ag.play();
		System.out.println("大哥帮你虐他");
		
	}

}
