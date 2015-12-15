/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkstorm.ejb.buslogic;

import com.bkstorm.ejb.persistence.Bid;

/**
 *
 * @author Nguyen
 * Manages a bid
 */
public interface BidService {

    /**
     * Adds a bid to the system
     * @param bid - bid to be added
     */
    public void addBid(Bid bid);
}
