/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adages2;

import org.restlet.Application;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.data.MediaType;
import org.restlet.data.Status;
import org.restlet.routing.Router;

/**
 *
 * @author hoangnv
 */
public class AdagesApplication extends Application {

    @Override
    public Restlet createInboundRoot() {
        /*
         To illustrate the different API possibilities, implement the DELETE operation
         as an anomyous Restlet class. For the remaining operations, follow Restlet best practices
         and implement each as a Java class.
         */
        Restlet janitor = new Restlet(getContext()) {

            @Override
            public void handle(Request request, Response response) {
                super.handle(request, response);
                String msg = null;
                String sid = (String) request.getAttributes().get("id");
                if (sid == null) {
                    msg = badRequest("No ID given.\n");
                }
                Integer id = null;
                try {
                    id = Integer.parseInt(sid.trim());
                } catch (Exception e) {
                    msg = badRequest("Ill-formed ID.\n");
                }
                Adage adage = Adages.find(id);
                if (adage == null) {
                    msg = badRequest("No adage with ID " + id + "\n");
                } else {
                    Adages.getList().remove(adage);
                    msg = "Adage " + id + " removed.\n";
                }
                // Generate HTTP response
                response.setEntity(msg, MediaType.TEXT_PLAIN);
            }
        };
        //Create the routing table.
        Router router = new Router(getContext());
        router.attach("/", PlainResource.class);
        router.attach("/xml", XmlAllResource.class);
        router.attach("/xml/{id}", XmlOneResource.class);
        router.attach("/json", JsonOneResource.class);
        router.attach("/create", CreateResource.class);
        router.attach("/update", UpdateResource.class);
        router.attach("delete/{id}", janitor); //instance of anonymous class
        return router;
    }
    
    private String badRequest(String msg){
        Status error = new Status(Status.CLIENT_ERROR_BAD_REQUEST, msg);
        return error.toString();
    }

}
