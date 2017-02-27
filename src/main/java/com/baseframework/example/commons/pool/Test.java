package com.baseframework.example.commons.pool;

import com.baseframework.example.pojo.Student;

public class Test {
	public static void main(String[] args) throws Exception {
		
		
		
		PoolUtils<Student> s = new PoolUtils<Student>(Student.class);
		
		
//		PoolUtils<DBHelper> ss = new PoolUtils<>(new ConnectionFactory());
//		
		
//		
//		
//		DBHelper db = ss.borrowObject();
//		
//		Connection conn = db.getConnection();
//		boolean b  = conn.isClosed();
//		
//		System.out.println(b);
//		
//		conn.close();
		
		Student  ss =  s.borrowObject();
		
		System.out.println(ss);
		
		Student  ss1 =  s.borrowObject();
		
		System.out.println(ss1);
		
		
//		
//		Student s1 = s.borrowObject();
//		
//		System.out.println(s1);
//		System.out.println("wait"+s.getNumWaiters());
//		System.out.println("active"+s.getNumActive());
//		System.out.println("Idle"+s.getNumIdle());
//
//		Student s2 = s.borrowObject();
//		System.out.println(s2);
//
//		Student s3 = s.borrowObject();
//		System.out.println(s3);
//		
//		Student s4 = s.borrowObject();
//		System.out.println(s4);
//		
//		Student s5 = s.borrowObject();
//		System.out.println(s5);
//		
//		
//		Student s6 = s.borrowObject();
//		System.out.println(s6);
//		
//		Student s7 = s.borrowObject();
//		System.out.println(s7);
//		
//		Student s8 = s.borrowObject();
//		System.out.println(s8);
//		System.out.println("wait"+s.getNumWaiters());
//		System.out.println("active"+s.getNumActive());
//		System.out.println("Idle"+s.getNumIdle());
//		
//		
//		
////		s.returnObject(s1);
////		
////		s.returnObject(s2);
//		
//		
//		
////		
////		System.out.println(s.borrowObject());
////		
////		
////		System.out.println("wait"+s.getNumWaiters());
////		System.out.println("active"+s.getNumActive());
////		System.out.println("Idle"+s.getNumIdle());
//		System.out.println("wait"+s.getNumWaiters());
//		s.returnObject(s8);
//		System.out.println(" =  "+s.borrowObject());
////		System.out.println(s.borrowObject());
////		System.out.println(s.borrowObject());
////		System.out.println(s.borrowObject());
////		System.out.println(s.borrowObject());
////		System.out.println(s.borrowObject());
////		System.out.println(s.borrowObject());
////		System.out.println(s.borrowObject());
////		System.out.println(s.borrowObject());
////		
////		
////		
//		System.out.println("active"+s.getNumActive());
//		System.out.println("Idle"+s.getNumIdle());
		
		
	}
	
	
	


}
