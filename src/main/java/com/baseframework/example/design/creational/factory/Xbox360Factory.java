package com.baseframework.example.design.creational.factory;

public class Xbox360Factory implements TVGameFactory {

	@Override
	public TVGame createTVGame() {
		return new Xbox360();
	}

}
