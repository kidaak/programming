/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bkstorm.jpa.statefull.bean;

import java.util.Collection;
import org.bkstorm.jpa.statefull.model.Order;

/**
 *
 * @author Nguyen
 */
public interface OrderBrowser {

    Collection<Order> orders();
}
