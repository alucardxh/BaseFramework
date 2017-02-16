package com.baseframework.example.design.creational.factory;

public class PS2Factory implements TVGameFactory{

	@Override
	public TVGame createTVGame() {
		return new PS2();
	}

}
