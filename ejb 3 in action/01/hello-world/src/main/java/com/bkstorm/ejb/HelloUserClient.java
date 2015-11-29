package com.bkstorm.ejb;

import javax.ejb.EJB;

/**
 * Created by Nguyen on 11/28/2015.
 */
public class HelloUserClient {
    @EJB
    private static HelloUser helloUser;

    public static void main(String[] args) {
        helloUser.sayHello("bkstorm");
        System.out.println("Invoked EJB successfully .. see server console for output");
    }
}
