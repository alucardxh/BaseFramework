package com.baseframework.example.commons.script;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Test {

	public static void main(String[] args) throws ScriptException {
		
		ScriptEngineManager factory= new ScriptEngineManager();
		
		
		ScriptEngine se = factory.getEngineByName("Java");
		
		se.eval("System.out.println(\"aaa\");");
		
	}

}
