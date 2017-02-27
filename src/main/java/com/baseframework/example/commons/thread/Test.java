package com.baseframework.example.commons.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {
	
	public static AtomicInteger count = new AtomicInteger();
	
	public static int count1=0;
	
	
	
	public static StringBuffer sb = new StringBuffer();
	public static StringBuilder sb1 = new StringBuilder();
	 
    public  static void sb() {
 
    	sb.append("A");
 
       
    }
    public  static void sb1() {
    	 
    	sb1.append("A");
 
       
    }
 
    public static void main(String[] args) {
    	
 
        //同时启动1000个线程，去进行i++计算，看看实际结果
    	ExecutorService s = Executors.newCachedThreadPool();

        for (int i = 0; i < 1000; i++) {
        	s.execute(new Runnable(){
				@Override
				public void run() {
					 System.out.println(Thread.currentThread().getName());
					Test.sb();
				}
        	});
        }
        s.shutdown();
        System.out.println("*"+Thread.currentThread().getName());
    }
    
    


}
