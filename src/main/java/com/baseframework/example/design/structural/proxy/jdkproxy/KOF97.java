package com.baseframework.example.design.structural.proxy.jdkproxy;

public class KOF97 implements ARCGame {

	@Override
	public void play() {
		System.out.println("玩97");

	}

	@Override
	public void buyCoin() {
		System.out.println("买硬币");
		
	}

	@Override
	public void putCoin() {
		System.out.println("像97街机中投硬币");
		
	}

}
