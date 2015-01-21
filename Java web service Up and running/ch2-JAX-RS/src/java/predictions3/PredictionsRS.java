/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predictions3;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.servlet.ServletContext;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author hoangnv
 */
@Path("/")
public class PredictionsRS {

    @Context
    private ServletContext sctx; //dependency injection
    private static PredictionsList plist; //set in populate()

    public PredictionsRS() {

    }

    @GET
    @Path("/xml")
    @Produces({MediaType.APPLICATION_XML})
    public Response getXml() {
        checkContext();
        return Response.ok(plist, "application/xml").build();
    }

    @GET
    @Path("/xml/{id: \\d+}")
    @Produces({MediaType.APPLICATION_XML})
    public Response getXml(@PathParam("id") int id) {
        checkContext();
        return toRequestedType(id, "application/xml");
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/json")
    public Response getJson() {
        checkContext();
        return Response.ok(toJson(plist), "application/json").build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/json/{id:\\d+}")
    public Response getJson(@PathParam("id") int id) {
        checkContext();
        return toRequestedType(id, "application/json");
    }
    
    @GET
    @Path("/plain")
    @Produces({MediaType.TEXT_PLAIN})
    public String getPlain() {
        checkContext();
        return plist.toString();
    }

    @POST
    @Produces({MediaType.TEXT_PLAIN})
    @Path("/create")
    public Response create(@FormParam("who") String who,
            @FormParam("what") String what) {
        checkContext();
        String msg = null;
        //Require both properties to create.
        if (who == null || what == null) {
            msg = "Property 'who' or 'what' is missing.\n";
            return Response.status(Response.Status.BAD_REQUEST).entity(msg).
                    type(MediaType.TEXT_PLAIN).build();
        }
        //Otherwise, create the Prediction and add it to the collection.
        int id = addPrediction(who, what);
        msg = "Prediction " + id + " created: (who = " + who + " what = " + what + ").\n";
        return Response.ok(msg, "text/plain").build();
    }

    @PUT
    @Produces({MediaType.TEXT_PLAIN})
    @Path("/update")
    public Response update(@FormParam("id") int id, @FormParam("who") String who,
            @FormParam("what") String what) {
        checkContext();
        //Check that sufficient data is present to do an edit.
        String msg = null;
        if (who == null && what == null) {
            msg = "Neither who nor what is given: nothing to edit.\n";
        }
        Prediction p = plist.find(id);
        if (p == null) {
            msg = "There is no prediction with ID " + id + "\n";
        }
        if (msg != null) {
            return Response.status(Response.Status.BAD_REQUEST).entity(msg)
                    .type(MediaType.TEXT_PLAIN).build();
        }
        //Update
        if (who != null) {
            p.setWho(who);
        }
        if (what != null) {
            p.setWhat(what);
        }
        msg = "Prediction " + id + " has been updated.\n";
        return Response.ok(msg, "text/plain").build();
    }

    @DELETE
    @Produces({MediaType.TEXT_PLAIN})
    @Path("/delete/{id:\\d+}")
    public Response delete(@PathParam("id") int id) {
        checkContext();
        String msg = null;
        Prediction p = plist.find(id);
        if (p == null) {
            msg = "There is no prediction with ID " + id + ". Cannot delete.\n";
            return Response.status(Response.Status.BAD_REQUEST).entity(msg)
                    .type(MediaType.TEXT_PLAIN).build();
        }
        plist.getPredictions().remove(p);
        msg = "Prediction " + id + " deleted.\n";
        return Response.ok(msg, "text/plain").build();
    }

    private void checkContext() {
        if (plist == null) {
            populate();
        }
    }

    private void populate() {
        plist = new PredictionsList();
        String fileName = "/WEB-INF/data/predictions.db";
        InputStream in = sctx.getResourceAsStream(fileName);
        //Read the data into the array of Predictions.
        if (in != null) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                int i = 0;
                String record = null;
                while ((record = reader.readLine()) != null) {
                    String[] parts = record.split("!");
                    addPrediction(parts[0], parts[1]);
                }
            } catch (Exception e) {
                throw new RuntimeException("I/O failed!");
            }
        }
    }

    private int addPrediction(String who, String what) {
        int id = plist.add(who, what);
        return id;
    }

    //Prediction --> JSON document
    private String toJson(Prediction prediction) {
        String json = "If you see this, there's a problem.";
        try {
            Gson gson = new Gson();
            json = gson.toJson(prediction);
        } catch (Exception e) {

        }
        return json;
    }

    //PredictionsList --> JSON document
    private String toJson(PredictionsList plist) {
        String json = "If you see this, there's a problem.";
        try {
            Gson gson = new Gson();
            json = gson.toJson(plist);
        } catch (Exception e) {
        }
        return json;
    }

    //Generate an HTTP error response or typed OK response.
    private Response toRequestedType(int id, String type) {
        Prediction pred = plist.find(id);
        if (pred == null) {
            String msg = id + " is a bad ID.\n";
            return Response.status(Response.Status.BAD_REQUEST).entity(msg)
                    .type(MediaType.TEXT_PLAIN).build();
        } else if (type.contains("json")) {
            return Response.ok(toJson(pred), type).build();
        } else {
            return Response.ok(pred, type).build();//toXml is automatic
        }
    }
}
