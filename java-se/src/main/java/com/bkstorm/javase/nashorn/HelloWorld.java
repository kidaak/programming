package com.bkstorm.javase.nashorn;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class HelloWorld {
	public static void main(String[] args) {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		try {
			engine.eval("print('Hello World!');");
		} catch (ScriptException e) {
			e.printStackTrace();
		}
	}
}
