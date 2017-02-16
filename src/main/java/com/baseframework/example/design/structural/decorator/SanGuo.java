package com.baseframework.example.design.structural.decorator;

public class SanGuo implements ARCGame{
	
	private ARCGame ag;
	
	public SanGuo() {

	}
	
	public SanGuo(ARCGame ag) {
		this.ag = ag;
	}

	@Override
	public void buyCoin() {
		System.out.println("买币");
		if(ag!=null){
			ag.buyCoin();
		}
	}

	@Override
	public void putCoin() {
		System.out.println("像三国街机投币");
		if(ag!=null){
			ag.putCoin();
		}
		
	}

	@Override
	public void play() {
		System.out.println("玩三国吞食天地");
		if(ag!=null){
			ag.play();
		}
		
	}

}
