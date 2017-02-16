package com.baseframework.example.design.structural.decorator;

public class Tekken implements ARCGame {
	
	private ARCGame ag;
	
	
	public Tekken(){
		
	}
	
	public Tekken(ARCGame ag){
		this.ag = ag;
		
		
	}
	
	@Override
	public void play() {
		System.out.println("玩铁拳");
		if(ag!=null){
			ag.play();
		}

	}

	@Override
	public void buyCoin() {
		System.out.println("买硬币");
		if(ag!=null){
			ag.buyCoin();
		}
		
	}

	@Override
	public void putCoin() {
		System.out.println("像铁拳街机中投硬币");
		if(ag!=null){
			ag.putCoin();
		}
		
	}

}
