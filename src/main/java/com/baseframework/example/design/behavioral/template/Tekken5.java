package com.baseframework.example.design.behavioral.template;

public class Tekken5 extends  ARCGame{

	@Override
	public void buyCoin() {
		System.out.println("买币");
		
	}

	@Override
	public void putCoin() {
		System.out.println("投");
		
	}

	@Override
	public void play() {
		System.out.println("玩");
		
	}

	@Override
	public boolean Continue() {
		return false;
	}

}
