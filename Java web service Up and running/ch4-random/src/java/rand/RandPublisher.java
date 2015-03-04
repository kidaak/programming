/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rand;

import javax.xml.ws.Endpoint;

/**
 *
 * @author hoangnv
 */
public class RandPublisher {

    public static void main(String[] args) {
        final String url = "http://localhost:8888/rs";
        System.out.println("Publishing RandService at endpoint: " + url);
        Endpoint.publish(url, new RandService());
    }
}
