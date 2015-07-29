/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bkstorm.javaee.webtier.servlet.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author Nguyen
 */
@WebListener()
public class DemoSessionListener implements HttpSessionListener{

    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Created a new session!");
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Destroyed the session!");
    }
    
}
