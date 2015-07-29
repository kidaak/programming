/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bkstorm.javaee.webtier.servlet.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author Nguyen
 */
@WebListener()
public class DemoRequestListener implements ServletRequestListener{

    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("Destroyed the request!");
    }

    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("Init a new request!");
    }
    
}
