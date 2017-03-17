package com.baseframework.example.commons.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class Test2 {

    static Object o = new Object();	
	//private static int a = t.sum;
	public static void main(String[] args) {
       
		for(int i=0;i<10;i++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
//					synchronized (o) {
//						for(int j=0;j<10;j++){
//							a--;
//							System.out.println(a);
//						}
//					}
					test();
				}
			}).start();
		}
	}
	
	
	public static void test(){
	/*	int a = 10;
		//AtomicInteger a = new AtomicInteger(10);
		for(int j=0;j<2;j++){
			System.out.println(Thread.currentThread().getName()+"a = "+a--);
		}*/
		Test t = new Test();
		//for(int j=0;j<5;j++){
		//synchronized (o) {
			
			//t.setSum(t.getSum());
			System.out.println(Thread.currentThread().getName()+" = a = "+Test.add());
		//}
		//}
		
	}
}
