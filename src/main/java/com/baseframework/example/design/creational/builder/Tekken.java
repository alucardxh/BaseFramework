package com.baseframework.example.design.creational.builder;

public class Tekken implements ARCGame {

	@Override
	public void play() {
		System.out.println("玩铁拳");

	}

	@Override
	public void buyCoin() {
		System.out.println("买硬币");
		
	}

	@Override
	public void putCoin() {
		System.out.println("像铁拳街机中投硬币");
		
	}

}
