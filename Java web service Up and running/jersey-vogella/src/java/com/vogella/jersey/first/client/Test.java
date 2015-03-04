/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vogella.jersey.first.client;

import java.net.URI;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.jersey.client.ClientConfig;

/**
 *
 * @author hoangnv
 */
public class Test {

    public static void main(String[] args) {
        ClientConfig config = new ClientConfig();

        Client client = ClientBuilder.newClient(config);

        WebTarget target = client.target(getBaseURI());

        System.out.println(target.path("rest").path("hello").request()
                .accept(MediaType.TEXT_PLAIN).get(Response.class)
                .toString());

        System.out.println(target.path("rest").path("hello").request()
                .accept(MediaType.TEXT_PLAIN).get(String.class));

        System.out.println(target.path("rest").path("hello").request()
                .accept(MediaType.TEXT_XML).get(String.class));

        System.out.println(target.path("rest").path("hello").request()
                .accept(MediaType.TEXT_HTML).get(String.class));

    }

    private static URI getBaseURI() {

        return UriBuilder.fromUri("http://localhost:8080/").build();

    }
}
