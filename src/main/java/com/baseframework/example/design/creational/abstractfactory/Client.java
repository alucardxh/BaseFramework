package com.baseframework.example.design.creational.abstractfactory;

import com.baseframework.example.design.creational.abstractfactory.arcgame.ARCGame;
import com.baseframework.example.design.creational.abstractfactory.tvgame.TVGame;

public class Client {

	public static void main(String[] args) {
		Factory1 f1 = new Factory1();
		TVGame tg = f1.createTVGame();
		ARCGame ac = f1.createARCGame();
		tg.play();
		ac.play();
	}

}
