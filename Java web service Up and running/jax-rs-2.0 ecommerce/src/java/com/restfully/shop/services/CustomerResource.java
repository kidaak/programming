/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restfully.shop.services;

import com.restfully.shop.domain.Customer;
import com.restfully.shop.utils.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * REST Web Service
 *
 * @author hoangnv
 */
public class CustomerResource {

    private final Map<Integer, Customer> customerDB;
    private final AtomicInteger idCounter = new AtomicInteger();

    public CustomerResource() {
        customerDB = new ConcurrentHashMap();
        customerDB.put(1, new Customer(1, "Bill", "Gates"));
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response createCustomer(InputStream is) {
        Customer customer = readCustomer(is);
        customer.setId(idCounter.incrementAndGet());
        customerDB.put(customer.getId(), customer);
        return Response.created(URI.create("/customers" + customer.getId())).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public StreamingOutput getCustomer(@PathParam("id") int id) {
        final Customer customer = customerDB.get(id);
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

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_XML)
    public void updateCustomer(@PathParam("id") int id, InputStream is) {
        Customer update = readCustomer(is);
        Customer current = customerDB.get(id);
        if (current == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        current.setFirstName(update.getFirstName());
        current.setLastName(update.getLastName());
        current.setStreet(update.getStreet());
        current.setCity(update.getCity());
        current.setState(update.getState());
        current.setZip(update.getZip());
        current.setCountry(update.getCountry());
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

    protected Customer readCustomer(InputStream is) {
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(is);
            Element root = doc.getDocumentElement();
            Customer cust = new Customer();
            if (root.getAttribute("id") != null
                    && !root.getAttribute("id").trim().equals("")) {
                cust.setId(Integer.valueOf(root.getAttribute("id")));
            }
            NodeList nodes = root.getChildNodes();
            for (int i = 0; i < nodes.getLength(); i++) {
                Element element = (Element) nodes.item(i);
                switch (element.getTagName()) {
                    case Constants.FIRST_NAME_TAG:
                        cust.setFirstName(element.getTextContent());
                        break;
                    case Constants.LAST_NAME_TAG:
                        cust.setLastName(element.getTextContent());
                        break;
                    case Constants.STREET:
                        cust.setStreet(element.getTextContent());
                        break;
                    case Constants.CITY:
                        cust.setCity(element.getTextContent());
                        break;
                    case Constants.STATE:
                        cust.setState(element.getTextContent());
                        break;
                    case Constants.ZIP:
                        cust.setZip(element.getTextContent());
                        break;
                    case Constants.COUNTRY:
                        cust.setCountry(element.getTextContent());
                        break;
                }
            }
            return cust;
        } catch (SAXException | IOException | ParserConfigurationException ex) {
            throw new WebApplicationException(ex, Response.Status.BAD_REQUEST);
        }
    }
}
