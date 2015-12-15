package com.bkstorm.javase.nashorn;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.Date;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.bkstorm.javase.Person;

public class CallJSFromJava {
	public static void main(String[] args) throws FileNotFoundException, ScriptException, NoSuchMethodException {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		engine.eval(new FileReader("C:\\script.js"));

		Invocable invocable = (Invocable) engine;

		Object result = invocable.invokeFunction("fun1", "Peter Parker");
		System.out.println(result);
		System.out.println(result.getClass());

		invocable.invokeFunction("fun2", new Date());
		// [object java.util.Date]

		invocable.invokeFunction("fun2", LocalDateTime.now());
		// [object java.time.LocalDateTime]

		invocable.invokeFunction("fun2", new Person());
		// [object com.winterbe.java8.Person]
	}
}
