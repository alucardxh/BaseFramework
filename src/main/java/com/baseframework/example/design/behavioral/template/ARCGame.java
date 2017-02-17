package com.baseframework.example.design.behavioral.template;

public abstract class ARCGame {
	
	abstract void buyCoin();
	abstract void putCoin();
	abstract void play();
	void run(){
		buyCoin();
		putCoin();
		play();
		if(Continue()){
			System.out.println("又投了一个币续命");
		}
		
	}
	
	abstract boolean Continue();
}
