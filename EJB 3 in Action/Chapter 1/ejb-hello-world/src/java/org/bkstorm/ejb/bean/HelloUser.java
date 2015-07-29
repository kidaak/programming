package org.bkstorm.ejb.bean;

import javax.ejb.Remote;;

@Remote
public interface HelloUser {

	public void sayHello(String name);
}
