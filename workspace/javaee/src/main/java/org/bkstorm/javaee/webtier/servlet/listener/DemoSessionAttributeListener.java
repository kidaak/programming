/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bkstorm.javaee.webtier.servlet.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 *
 * @author Nguyen
 */
@WebListener()
public class DemoSessionAttributeListener implements HttpSessionAttributeListener {

    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("Added a new attribute into the session!");
    }

    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("Removed attribute from the session!");
    }

    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("Replaced attribute in the session!");
    }
    
}
