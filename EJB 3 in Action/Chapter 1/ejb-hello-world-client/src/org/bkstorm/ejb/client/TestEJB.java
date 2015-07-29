/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bkstorm.ejb.client;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.bkstorm.ejb.bean.HelloUser;

/**
 *
 * @author Nguyen
 */
public class TestEJB {

    public static void main(String[] args) {
        try {
            InitialContext context = new InitialContext();
            HelloUser helloUser = (HelloUser) context.lookup("org.bkstorm.ejb.bean.HelloUser");
            helloUser.sayHello("bkstorm");
        } catch (NamingException ex) {
            Logger.getLogger(TestEJB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
