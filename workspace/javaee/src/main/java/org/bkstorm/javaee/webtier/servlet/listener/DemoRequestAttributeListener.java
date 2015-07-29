/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bkstorm.javaee.webtier.servlet.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author Nguyen
 */
@WebListener()
public class DemoRequestAttributeListener implements ServletRequestAttributeListener {

    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println("Added a new attribute into request!");
    }

    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        System.out.println("Removed attribute from request!");
    }

    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        System.out.println("Replaced attribute in request!");
    }

}
