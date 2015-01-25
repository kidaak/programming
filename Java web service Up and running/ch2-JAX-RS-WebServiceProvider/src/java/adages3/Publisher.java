/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adages3;

import javax.xml.ws.Endpoint;

/**
 *
 * @author hoangnv
 */
public class Publisher {

    public static void main(String[] args) {
        int port = 8888;
        String url = "http://localhost:" + port + "/";
        System.out.println("Restfully publishing on port " + port);
        Endpoint.publish(url, new AdagesProvider());
    }
}
