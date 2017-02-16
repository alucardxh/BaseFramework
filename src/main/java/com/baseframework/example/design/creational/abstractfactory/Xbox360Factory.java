package com.baseframework.example.design.creational.abstractfactory;

import com.baseframework.example.design.creational.abstractfactory.arcgame.ARCGame;
import com.baseframework.example.design.creational.abstractfactory.tvgame.TVGame;
import com.baseframework.example.design.creational.abstractfactory.tvgame.Xbox360;

public class Xbox360Factory implements GameFactory {

	@Override
	public TVGame createTVGame() {
		return new Xbox360();
	}

	@Override
	public ARCGame createARCGame() {
		// TODO Auto-generated method stub
		return null;
	}

}
