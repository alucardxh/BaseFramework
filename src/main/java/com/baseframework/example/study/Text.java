package com.baseframework.example.study;

//http://www.cnblogs.com/greatfish/p/5771548.html
//http://www.cnblogs.com/guodefu909/p/4991612.html
//http://blog.csdn.net/rabbit_in_android/article/details/50382739
public class AliQuestion {
	public static int k = 0;
	public static AliQuestion t1 = new AliQuestion("t1");
	public static AliQuestion t2 = new AliQuestion("t2");
	public static int i = print("i");
	public static int n = 99;
	public int j = print("j");

	{
		print("构造块");
	}

	static {
		print("静态块");
	}

	public AliQuestion(String str) {

		System.out.println((++k) + ":" + str + "   i=" + i + "    n=" + n);
		++i;
		++n;
	}

	public static int print(String str) {
		System.out.println((++k) + ":" + str + "   i=" + i + "    n=" + n);
		++n;
		return ++i;
	}

	public static void main(String args[]) {
		AliQuestion t = new AliQuestion("init");
	}
}