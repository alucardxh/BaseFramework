package com.baseframework.example.design.creational.abstractfactory;

import com.baseframework.example.design.creational.abstractfactory.arcgame.ARCGame;
import com.baseframework.example.design.creational.abstractfactory.arcgame.KOF97;
import com.baseframework.example.design.creational.abstractfactory.tvgame.TVGame;
import com.baseframework.example.design.creational.abstractfactory.tvgame.Xbox360;

public class Factory2 implements GameFactory {

	@Override
	public TVGame createTVGame() {
		return new Xbox360();
	}

	@Override
	public ARCGame createARCGame() {
		return new KOF97();
	}

}
