/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bkstorm.javaee.webtier.servlet.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author Nguyen
 */
@WebListener()
public class DemoServletContextAtrributeListener implements ServletContextAttributeListener{

    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("Added attribute into servlet context!");
    }

    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("Removed attribute from servlet context!");
    }

    public void attributeReplaced(ServletContextAttributeEvent arg0) {
        System.out.println("Replaced attribute in servlet context!");
    }
    
}
