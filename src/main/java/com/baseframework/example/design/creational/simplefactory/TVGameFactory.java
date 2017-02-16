package com.baseframework.example.design.creational.simplefactory;

public class TVGameFactory {
	
	public static TVGame createTVGame(String s){
		TVGame tg =null;
		
		switch (s) {
		case "PS2":
			tg =  new PS2();
			break;
		case "Xbox360":
			tg = new Xbox360();
			break;
		default:
			
		}
		return tg;
	}

}
