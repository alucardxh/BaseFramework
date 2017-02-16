package com.baseframework.example.design.creational.abstractfactory;

import com.baseframework.example.design.creational.abstractfactory.arcgame.ARCGame;
import com.baseframework.example.design.creational.abstractfactory.arcgame.Tekken;
import com.baseframework.example.design.creational.abstractfactory.tvgame.PS2;
import com.baseframework.example.design.creational.abstractfactory.tvgame.TVGame;

public class Factory1 implements GameFactory{

	@Override
	public TVGame createTVGame() {
		return new PS2();
	}

	@Override
	public ARCGame createARCGame() {
		return new Tekken();
	}

}
