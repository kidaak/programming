/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkstorm.ejb.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents a bidder
 * @author Nguyen
 */
@Entity
@Table(name="BIDDERS")
public class Bidder extends User implements Serializable {

    /**
     * Unique identifier for the bidder
     */
    @Id
    @GeneratedValue
    @Column(name="USER_ID")
    private Long bidderId;

    /**
     * credit rating
     */
    private Long creditRating;

    /**
     * Creates a bidder
     */
    public Bidder() {
        // Constructs a new bidder
    }

    /**
     * Creates a new bidder with the initial credit rating provided
     * @param firstName - first name
     * @param lastName - last name
     * @param creditRating - credit rating
     */
    public Bidder(String firstName, String lastName, Long creditRating) {
        super(firstName,lastName);
        this.creditRating = creditRating;
    }

    /**
     * Creates a new bidder object
     * @param creditRating - credit rating
     */
    public Bidder(Long creditRating) {
        this.creditRating = creditRating;
    }

    /**
     * Returns the id of the bidder
     * @return bidder id
     */
    public Long getBidderId() {
        return bidderId;
    }

    /**
     * Creates a new credit rating
     * @return credit rating
     */
    public Long getCreditRating() {
        return creditRating;
    }

    /**
     * Sets the credit rating
     * @param creditRating - credit rating
     */
    public void setCreditRating(Long creditRating) {
        this.creditRating = creditRating;
    }
}
