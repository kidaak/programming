package com.example.model;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Dog implements HttpSessionBindingListener{
	private String breed;
	
	public Dog(String breed) {
		this.breed = breed;
	}

	public String getBreed() {
		return breed;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
