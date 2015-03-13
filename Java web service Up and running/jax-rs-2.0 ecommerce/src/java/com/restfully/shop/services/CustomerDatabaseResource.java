/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restfully.shop.services;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author hoangnv
 */
@Path("/customers")
public class CustomerDatabaseResource {

    protected CustomerResource europe = new CustomerResource();
    protected FirstLastCustomerResource northamerica = new FirstLastCustomerResource();

    @Path("{database}-db")
    public Object getDatabase(@PathParam("database") String db) {
        if (null != db) {
            switch (db) {
                case "europe":
                    return europe;
                case "northamerica":
                    return northamerica;
                default:
                    return null;
            }
        }
        return null;
    }
}
