/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restfully.shop.test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author hoangnv
 */
public class InjactionTest {

    private static final String URL = "http://localhost:8080/services/cars";

    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        String output = client.target(URL).path("/matrix/mercedes/e55;color=black/2006").request().accept(MediaType.TEXT_PLAIN).get(String.class);
        System.out.println(output);
        output = client.target(URL).path("/segments/mercedes/e55/amg/year/2006").request().accept(MediaType.TEXT_PLAIN).get(String.class);
        System.out.println(output);
    }
}
