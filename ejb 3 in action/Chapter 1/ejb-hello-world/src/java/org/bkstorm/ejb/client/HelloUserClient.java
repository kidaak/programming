package org.bkstorm.ejb.client;

import javax.ejb.EJB;

import org.bkstorm.ejb.bean.HelloUser;

public class HelloUserClient {
	@EJB
	private static HelloUser helloUser;

	public static void main(String[] args) {
		helloUser.sayHello("bkstorm");
		System.out.println("Invoked EJB successfully .. see server console for output");
	}
}
