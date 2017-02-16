package com.baseframework.example.design.creational.factory;

public class Client {

	public static void main(String[] args) {
		PS2Factory ps2 = new PS2Factory();
		Xbox360Factory x360  = new Xbox360Factory();
		
		ps2.createTVGame().play();
		x360.createTVGame().play();
		
	}

}
