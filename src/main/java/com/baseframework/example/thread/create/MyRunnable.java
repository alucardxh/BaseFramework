package com.baseframework.example.thread.create;

public class MyRunnable implements Runnable {

	private ThreadDemo threadDemo;

	public MyRunnable(ThreadDemo threadDemo) {
		this.threadDemo = threadDemo;
	}

	@Override
	public void run() {
		Thread thread = Thread.currentThread();
		System.out.println(thread.getId() + "**" + thread.getName());
		for (int j = 0; j < 1000; j++)
			threadDemo.increase();
	};

}
