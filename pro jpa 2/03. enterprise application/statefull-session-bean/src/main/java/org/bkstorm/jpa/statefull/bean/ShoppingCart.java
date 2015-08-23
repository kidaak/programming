/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bkstorm.jpa.statefull.bean;

import java.util.Map;

/**
 *
 * @author Nguyen
 */
public interface ShoppingCart {

    void addItem(String id, int quantity);

    void removeItem(String id, int quantity);

    Map<String, Integer> getItems();

    void checkout(int paymentId);

    void cancel();
}
