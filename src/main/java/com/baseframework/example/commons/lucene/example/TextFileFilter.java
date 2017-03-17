package com.baseframework.example.commons.lucene.example;

import java.io.File;
import java.io.FileFilter;

public class TextFileFilter implements FileFilter{
	
	private String s;

	public TextFileFilter(String s) {
		this.s =s;
	}
	@Override
	public boolean accept(File pathname) {
		return pathname.getName().toLowerCase().endsWith("."+s);
	}

}
