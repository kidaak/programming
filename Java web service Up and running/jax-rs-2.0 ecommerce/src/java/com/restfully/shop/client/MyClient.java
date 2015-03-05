/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restfully.shop.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

/**
 *
 * @author hoangnv
 */
public class MyClient {

    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        try {
            System.out.println("*** Create a new Customer ***");
            String xml = "<customer>"
                    + "<first-name>Bill</first-name>"
                    + "<last-name>Burke</last-name>"
                    + "<street>256 Clarendon Street</street>"
                    + "<city>Boston</city>"
                    + "<state>MA</state>"
                    + "<zip>02115</zip>"
                    + "<country>USA</country>"
                    + "</customer>";
            Response response = client.target("http://localhost:8080/services/customers")
                    .request().post(Entity.xml(xml));
            if (response.getStatus() != Response.Status.CREATED.getStatusCode()) {
                throw new RuntimeException("Failed to create");
            }
            String location = (String) response.getMetadata().get("location").get(0);
            System.out.println("Location:" + location);

            System.out.println("*** GET Created Customer ***");
            String customer = client.target(location).request().get(String.class);
            System.out.println(customer);

            String updateCustomer = "<customer>"
                    + "<first-name>William</first-name>"
                    + "<last-name>Burke</last-name>"
                    + "<street>256 Clarendon Street</street>"
                    + "<city>Boston</city>"
                    + "<state>MA</state>"
                    + "<zip>02115</zip>"
                    + "<country>USA</country>"
                    + "</customer>";
            response = client.target(location)
                    .request()
                    .put(Entity.xml(updateCustomer));
            if (response.getStatus() != 204) {
                throw new RuntimeException("Failed to update");
            }

            System.out.println("**** After Update ***");
            customer = client.target(location).request().get(String.class);
            System.out.println(customer);
        } finally {
            client.close();
        }
    }
}
