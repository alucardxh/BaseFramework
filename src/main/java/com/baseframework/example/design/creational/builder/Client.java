package com.baseframework.example.design.creational.builder;

public class Client {

	public static void main(String[] args) {
		PlayARCBuilder pa = new PlayARCBuilder(new Tekken());
		pa.playARC();
	}
}
