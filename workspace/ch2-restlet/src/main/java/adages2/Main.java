/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adages2;

import org.restlet.Component;
import org.restlet.data.Protocol;

/**
 *
 * @author hoangnv
 */
public class Main {

    public static void main(String[] args) throws Exception {
        //Create a new Component
        Component component = new Component();
        //Add a new HTTP server listening on port 8182.
        component.getServers().add(Protocol.HTTP, 8182);
        //Attach the application.
        component.getDefaultHost().attach("/", new AdagesApplication());
        //Start the web server
        component.start();
    }
}
