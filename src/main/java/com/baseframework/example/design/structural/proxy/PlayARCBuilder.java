package com.baseframework.example.design.structural.proxy;

public class PlayARCBuilder {
	
	private ARCGame ag;
	
	
	public PlayARCBuilder(ARCGame ag) {
		this.ag = ag;
	}
	
	public void playARC(){
		ag.buyCoin();
		ag.putCoin();
		ag.play();
		
	}

}
