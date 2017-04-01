package com.baseframework.example.thread;

import com.baseframework.example.thread.create.MyRunnable;
import com.baseframework.example.thread.create.ThreadDemo;

public class Client {

	public static void main(String[] args) {
		
		ThreadDemo object = new ThreadDemo();
		for (int i = 0; i < 10; i++) {
			new Thread(new MyRunnable(object)).start();
		}
		
		
		
		 while(Thread.activeCount()>1)  //保证前面的线程都执行完
	            Thread.yield();
	        System.out.println(object.i);
		
		
	}

}
