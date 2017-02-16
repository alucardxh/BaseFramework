package com.baseframework.example.design.structural.decorator;

public class KOF97 implements ARCGame {
	
	private ARCGame ag;
	
	public KOF97(){
		
	}
	public KOF97(ARCGame ag){
		this.ag= ag;
	}

	@Override
	public void play() {
		System.out.println("玩97");
		
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
		System.out.println("像97街机中投硬币");
		if(ag!=null){
			ag.putCoin();
		}
		
	}

}
