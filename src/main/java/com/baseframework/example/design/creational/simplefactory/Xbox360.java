package com.baseframework.example.design.creational.simplefactory;

public class Xbox360 implements TVGame {

	@Override
	public void open() {
		System.out.println("Xbox360开机");

	}

	@Override
	public void close() {
		System.out.println("Xbox360关机");

	}

	@Override
	public void play() {
		System.out.println("玩Xbox360");

	}

}
