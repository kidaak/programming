/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restfully.shop.client;

import com.restfully.shop.domain.Customer;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

/**
 *
 * @author hoangnv
 */
public class ContentHandlerTest {
    
    private static final String URI = "http://localhost:8080/services/customers";
    
    public static void main(String[] args) {
        System.out.println("*** Create a new Customer ***");
        Customer newCustomer = new Customer();
        newCustomer.setFirstName("Bill");
        newCustomer.setLastName("Burke");
        newCustomer.setStreet("256 Clarendon Street");
        newCustomer.setCity("Boston");
        newCustomer.setState("MA");
        newCustomer.setZip("02115");
        newCustomer.setCountry("USA");
        
        Client client = ClientBuilder.newClient();
        Response response = client.target(URI).request().post(Entity.entity(newCustomer, "application/example-java"));
        if (response.getStatus() != 201) {
            throw new RuntimeException("Failed to create");
        }
    }
}
