package com.bkstorm.ejb;

import javax.ejb.Stateless;

/**
 * Created by Nguyen on 11/28/2015.
 */
@Stateless
public class HelloUserBean implements HelloUser{

    public String sayHello(String name) {
        return "Hello " + name + " welcome to EJB 3.2";
    }
}
