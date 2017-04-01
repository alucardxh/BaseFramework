package com.baseframework.example.thread.create;

public class MyThread extends Thread {

	private ThreadDemo threadDemo;


	public MyThread(ThreadDemo threadDemo) {
		this.threadDemo = threadDemo;
	}

	@Override
	public void run() {
		threadDemo.exe();
	}

}
