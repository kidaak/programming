/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bkstorm.ejb.actionbazaar.buslogic;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.bkstorm.ejb.actionbazaar.persistence.Item;

/**
 * Item service - retrieves items from the database.
 */
@Stateless
public class ItemServiceBean implements ItemService {

    /**
     * Persistence Context
     */
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Item getItem(long itemId) {
        return entityManager.find(Item.class, itemId);
    }

    /**
     * Creates an item in the database
     *
     * @param item
     */
    @Override
    public void createItem(Item item) {
        entityManager.persist(item);
    }

}
