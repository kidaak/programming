/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkstorm.ejb.buslogic;

import com.bkstorm.ejb.persistence.Bid;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Nguyen
 * Manages bids
 */
public class BidServiceBean implements BidService {

    /**
     * Persistence Context
     */
    @PersistenceContext
    private EntityManager entityManager;
    
    /**
     * Adds a bid to the database
     * @param bid
     */
    @Override
    public void addBid(Bid bid) {
        entityManager.persist(bid);
    }

}
