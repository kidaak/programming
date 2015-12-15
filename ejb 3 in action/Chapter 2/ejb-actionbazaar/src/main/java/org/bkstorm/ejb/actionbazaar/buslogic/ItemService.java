/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bkstorm.ejb.actionbazaar.buslogic;

import javax.ejb.Local;
import org.bkstorm.ejb.actionbazaar.persistence.Item;

/**
 * Manages items
 */
@Local
public interface ItemService {

    /**
     * Retrieves an item from the database
     *
     * @param itemId - item id
     * @return Item
     */
    Item getItem(long itemId);

    /**
     * Creates an item in the database
     *
     * @param item - item to be created
     */
    public void createItem(Item item);
}
