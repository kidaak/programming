/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bkstorm.javaee.webtier.servlet.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author Nguyen
 */
@WebListener()
public class DemoServletContextListener implements ServletContextListener{

    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Init context!");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Destroy context!");
    }
    
}
