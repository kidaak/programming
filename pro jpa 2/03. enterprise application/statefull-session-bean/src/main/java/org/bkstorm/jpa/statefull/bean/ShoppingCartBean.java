/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bkstorm.jpa.statefull.bean;

import java.util.HashMap;
import java.util.Map;
import javax.ejb.Remove;

/**
 *
 * @author Nguyen
 */
public class ShoppingCartBean implements ShoppingCart {

    private final Map<String, Integer> items = new HashMap<>();

    @Override
    public void addItem(String item, int quantity) {
        Integer orderQuantity = items.get(item);
        if (orderQuantity == null) {
            orderQuantity = 0;
        }
        orderQuantity += quantity;
        items.put(item, orderQuantity);
    }

    @Override
    public void removeItem(String item, int quantity) {
        Integer orderQuantity = items.get(item);
        if (orderQuantity == null) {
            return;
        }
        orderQuantity -= quantity;
        if (orderQuantity > 0) {
            items.put(item, orderQuantity);
        } else {
            items.remove(item);
        }
    }

    @Override
    public Map<String, Integer> getItems() {
        return items;
    }

    @Remove
    @Override
    public void checkout(int paymentId) {
        // store items to database
        // ...
    }

    @Remove
    @Override
    public void cancel() {
    }
}
