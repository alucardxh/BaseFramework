package com.baseframework.example.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Client {

	public static void main(String[] args) throws Exception {
				// 获取Class对象的三种方法
				Class<?> clazz1 = Class.forName("com.baseframework.example.reflect.ReflectExample");
				Class<?> clazz2 = ReflectExample.class;
				Class<?> clazz3 = new ReflectExample().getClass();
				
				// 获取父类
				Class<?> superClass = clazz1.getSuperclass();

				// 获取实现的接口
				Class<?>[] intes = clazz2.getInterfaces();

					// 获取指定参数的构造方法
					Constructor<?> cons = clazz2.getConstructor(String.class);
			
					// 获取全部的构造函数
					Constructor<?>[] constructor = clazz2.getConstructors();
			
					// 获取某个构造器的参数类型
					Class<?>[] cla = constructor[0].getParameterTypes();
					
					ReflectExample rd;
					// 通过构造器创建对象
					rd = (ReflectExample) cons.newInstance("helloreflect");
					// 通过无参构造器创建对象
					rd = (ReflectExample) clazz1.newInstance();
					
						/**
						 * 获取属性
						 */
						//取得实现的接口或者父类的属性
				        Field[] field1 = clazz1.getFields();
						//取得本类的全部属性
						Field[] field = clazz1.getDeclaredFields();
				        System.out.println(field.length+"*****"+field1.length);
				        	/**
				        	 * 查看属性的各个参数
				        	 */
				        	//获取属性修饰符
					        String modifierField = Modifier.toString(field[0].getModifiers());
					        //获取属性名
					        String fieldName = field[0].getName();
					        //获取属性的类型
					        Class fieldType = field[0].getType();
					        
					        /**
					         * 设置属性的参数
					         */
					        
					        Field nameField = clazz1.getDeclaredField("name");
					        nameField.setAccessible(true);
					        nameField.set(rd, "Java反射机制");
					        
					        
					    
					    /**
					     * 获取类中的方法
					     */
					    //访问类中声明为公有的方法,私有的方法它无法访问,能访问从其它类继承来的公有方法.
					    Method[] method = clazz1.getMethods();
					    //能访问类中所有的字段,与修饰符无关,不能访问从其它类继承来的方法  
					    Method[] method1 = clazz1.getDeclaredMethods();
					    	/**
					    	 * 查看方法的各个参数
					    	 */
					    	//获取方法的属性修饰符
					    	String modifierMethod = Modifier.toString(method1[0].getModifiers());
					    	//获取方法的名称
					    	String MethodName = method1[0].getName();
					    	//获取方法的参数值
					    	Class<?>[] parameterType = 	method1[0].getParameterTypes();
					    	//获取方法的返回值
					    	Class<?> returnType = method1[0].getReturnType();
					    	//获取方法异常类型
					    	Class<?>[] exceptionType = method1[0].getExceptionTypes();
					    	
					  
						    /**
						     * 调用某个类的方法
						     */
					    	// 调用setAge方法
					        Method setAge = clazz1.getMethod("setAge",String.class);
					        setAge.invoke(rd, "26");
					        // 调用getAge方法
					        Method getAge = clazz1.getMethod("getAge");
					        String age = (String)getAge.invoke(rd);
					        
					        Method getName = clazz1.getMethod("getName");
					        String name = (String)getName.invoke(rd);
					        
					        System.out.println(name);
					    	

	}

}
