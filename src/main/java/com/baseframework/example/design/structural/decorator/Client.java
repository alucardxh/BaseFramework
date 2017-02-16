package com.baseframework.example.design.structural.decorator;


public class Client {

	public static void main(String[] args) {
		
		ARCGame ag= new KOF97(new Tekken(new SanGuo()));
		
		PlayARCBuilder pab = new PlayARCBuilder(ag);
		pab.playARC();
		
	}
}
