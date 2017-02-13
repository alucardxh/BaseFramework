package com.baseframework.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;



public class SpringContextUtils implements ApplicationContextAware {
	private static ApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		SpringContextUtils.context = context;
	}

	public static Object getBean(String beanName) {
		checkApplicationContext();
		return context.getBean(beanName);
	}

	public static <T> T getBean(String beanName, Class<T> requiredType) {
		checkApplicationContext();
		return context.getBean(beanName, requiredType);
	}
	
	public static <T> T getBean(Class<T> clazz) {
		checkApplicationContext();
		return context.getBean(clazz);
	}
	
	private static void checkApplicationContext() {
		if (context == null) {
			throw new RuntimeException("applicaitonContext未注入,请在spring配置文件中定义SpringContextUtils");
		}
	}
}
