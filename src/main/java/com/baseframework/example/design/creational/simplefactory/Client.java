package com.baseframework.example.design.creational.simplefactory;

public class Client {

	public static void main(String[] args) {
		TVGame ps2 = TVGameFactory.createTVGame("PS2");
		TVGame x360 = TVGameFactory.createTVGame("Xbox360");
		ps2.play();
		x360.play();
	}

}
