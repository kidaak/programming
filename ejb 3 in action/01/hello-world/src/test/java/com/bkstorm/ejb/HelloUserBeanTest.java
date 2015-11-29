package com.bkstorm.ejb;

import javax.ejb.EJB;

import org.jboss.arquillian.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class HelloUserBeanTest {

	@EJB
	private HelloUser helloUser;

	@Deployment
	public static Archive<?> createDeployment() {
		return ShrinkWrap.create(JavaArchive.class, "ejb-hello-world.jar").addClasses(HelloUserBean.class);
	}

	/**
	 * Tests the hello message
	 */
	@Test
	public void testSayHello() {
		String helloMessage = helloUser.sayHello("Curious George");
		Assert.assertEquals("Message did not match.", "Hello Curious George welcome to EJB 3.1!", helloMessage);
	}
}
