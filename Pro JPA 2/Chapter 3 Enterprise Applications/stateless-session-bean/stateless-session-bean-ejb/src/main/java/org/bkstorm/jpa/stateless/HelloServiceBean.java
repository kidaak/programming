/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bkstorm.jpa.stateless;

import javax.ejb.Stateless;

/**
 *
 * @author martin
 */
@Stateless
public class HelloServiceBean implements HelloService {

    @Override
    public String sayHello(String name) {
        return "Hello, " + name;
    }
}
