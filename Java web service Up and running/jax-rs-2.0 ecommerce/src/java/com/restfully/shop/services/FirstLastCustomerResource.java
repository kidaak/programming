/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restfully.shop.services;

import com.restfully.shop.domain.Customer;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

/**
 *
 * @author hoangnv
 */
public class FirstLastCustomerResource {

    private final Map<String, Customer> customerDB;

    public FirstLastCustomerResource() {
        customerDB = new ConcurrentHashMap();
        customerDB.put("Hoang", new Customer(1, "Nguyen", "Hoang"));
    }

    @GET
    @Path("{first}-{last}")
    @Produces("application/xml")
    public StreamingOutput getCustomer(@PathParam("first") String firstName,
            @PathParam("last") String lastName) {
        final Customer customer = customerDB.get(lastName);
        if (customer == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return new StreamingOutput() {
            @Override
            public void write(OutputStream out) throws IOException, WebApplicationException {
                outputCustomer(out, customer);
            }
        };
    }

    protected void outputCustomer(OutputStream os, Customer cust) {
        PrintStream writer = new PrintStream(os);
        writer.println("<customer id=\"" + cust.getId() + "\">");;
        writer.println("<first-name>" + cust.getFirstName() + "</first-name>");
        writer.println("<last-name>" + cust.getLastName() + "</last-name>");
        writer.println("<street>" + cust.getStreet() + "</street>");
        writer.println("<city>" + cust.getCity() + "</city>");
        writer.println("<state>" + cust.getLastName() + "</state>");
        writer.println("<zip>" + cust.getLastName() + "</zip>");
        writer.println("<country>" + cust.getLastName() + "</country>");
        writer.println("</customer>");
    }
}
