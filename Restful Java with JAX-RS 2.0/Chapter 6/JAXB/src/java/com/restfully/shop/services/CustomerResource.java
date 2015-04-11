/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restfully.shop.services;

import com.restfully.shop.domain.Customer;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 *
 * @author hoangnv
 */
@Path("/customers")
public class CustomerResource {

    private final Map<Integer, Customer> customerDB = new ConcurrentHashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger();

    public CustomerResource() {

    }

    @POST
    @Consumes("application/xml")
    public Response createCustomer(Customer customer) {
        customer.setId(idCounter.incrementAndGet());
        customerDB.put(customer.getId(), customer);
        System.out.println("Created customer " + customer.getId());
        return Response.created(URI.create("/customers/" + customer.getId())).build();
    }

    @POST
    @Consumes("application/example-java")
    public Response createCustomer2(Customer customer) {
        customer.setId(idCounter.incrementAndGet());
        customerDB.put(customer.getId(), customer);
        System.out.println("Created customer " + customer.getId());
        return Response.created(URI.create("/customers/" + customer.getId())).build();
    }

    @GET
    @Path("{id}")
    @Produces("application/xml")
    public Customer getCustomer(@PathParam("id") int id) {
        Customer customer = customerDB.get(id);
        if (customer == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return customer;
    }

    @PUT
    @Path("{id}")
    @Consumes("application/xml")
    public void updateCustomer(@PathParam("id") int id, Customer update) {
        Customer current = customerDB.get(id);
        if (current == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        current.setFirstName(update.getFirstName());
        current.setLastName(update.getLastName());
        current.setStreet(update.getStreet());
        current.setZip(update.getZip());
        current.setCountry(update.getCountry());
    }
}
