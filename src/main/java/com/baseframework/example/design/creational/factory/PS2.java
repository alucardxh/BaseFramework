package com.baseframework.example.design.creational.factory;

public class PS2 implements TVGame {

	@Override
	public void open() {
		System.out.println("ps2开机");

	}

	@Override
	public void close() {
		System.out.println("ps2关机");

	}

	@Override
	public void play() {
		System.out.println("玩ps2");

	}

}
