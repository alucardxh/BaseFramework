package com.baseframework.example.thread.create;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo {
	
	
	public  volatile  int i=0;
	
	private Lock lock = new ReentrantLock();
	
	public void exe(){
		synchronized (this) {
			try {
				String t = Thread.currentThread().getName();
				i++;
				System.out.println(t+i);
				System.out.println(t+"睡");
				Thread.currentThread().sleep(1000);
				System.out.println(t+"醒");
				i++;
				System.out.println(t+i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	
	public synchronized static void insertStatic(){
		
		System.out.println("insertStatic");
		System.out.println("insertStatic完毕");
		
	}
	
	public synchronized  void insert(){
		System.out.println("insert");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("insert完毕");
	}
	
	
	public void increase() {
		
		
		
		lock.lock();
        i++;
        lock.unlock();
    }
	
}
