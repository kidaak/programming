/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkstorm.javase;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Nguyen
 */
public class PersonTest {

	@Test
	public void testGreeting() {
		Person person = new Person("hoangnv");
		Assert.assertTrue("Hi bill gate, my name is hoangnv".equals(person.greet("bill gate")));
	}

	@Test
	public void testFinalPerson() {
		final Person person = new Person("hoangnv");
		person.setName("bill gate");
		Assert.assertTrue("bill gate".equals(person.getName()));
	}
}
