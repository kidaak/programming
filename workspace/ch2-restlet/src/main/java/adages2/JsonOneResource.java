/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adages2;

import java.util.List;
import org.restlet.data.Status;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 *
 * @author hoangnv
 */
public class JsonOneResource extends ServerResource {

    public JsonOneResource() {

    }

    @Get
    public Representation toJson() {
        // Extract the adage's id.
        String sid = (String) getRequest().getAttributes().get("id");
        if (sid == null) {
            return badRequest("No ID provided\n");
        }

        int id;
        try {
            id = Integer.parseInt(sid.trim());
        } catch (Exception e) {
            return badRequest("No such ID\n");
        }

        // Search for the Adage.
        List<Adage> list = Adages.getList();
        Adage adage = Adages.find(id);
        if (adage == null) {
            return badRequest("No adage with ID " + id + "\n");
        }

        // Generate the JSON representation.
        JsonRepresentation json = null;
        try {
            json = new JsonRepresentation(new StringRepresentation(adage.toString()));
        } catch (Exception e) {
        }
        return json;
    }

    private StringRepresentation badRequest(String msg) {
        Status error = new Status(Status.CLIENT_ERROR_BAD_REQUEST, msg);
        return new StringRepresentation(error.toString());
    }
}
