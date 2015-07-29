/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bkstorm.javaee.webtier.servlet.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/**
 *
 * @author Nguyen
 */
@WebListener()
public class DemoSessionActivationListener implements HttpSessionActivationListener {

    public void sessionWillPassivate(HttpSessionEvent se) {
        System.out.println("Passivative the session!");
    }

    public void sessionDidActivate(HttpSessionEvent se) {
        System.out.println("Active the session!");
    }

}
