package com.baseframework.utils;

public class StringFilter {
	
	/**
	 * 过滤windows系统文件名不允许的字符
	 * @param srcPath
	 * @return
	 */
	public static String winFileName(String srcPath){
		
		String s = "(\\\\)|(\\/)|(\\:)|(\\*)|(\\?)|(\\\")|(\\<)|(\\>)|(\\|)";
		
		return srcPath.replaceAll(s, "");
	}

}
