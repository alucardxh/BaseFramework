package com.baseframework.example.design.creational.abstractfactory;

import com.baseframework.example.design.creational.abstractfactory.arcgame.ARCGame;
import com.baseframework.example.design.creational.abstractfactory.tvgame.TVGame;

public interface GameFactory {

	public TVGame createTVGame();
	
	public ARCGame createARCGame();
	
}
