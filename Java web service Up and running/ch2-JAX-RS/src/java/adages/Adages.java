/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adages;

import com.google.gson.Gson;
import java.util.Random;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.namespace.QName;

/**
 * REST Web Service
 *
 * @author hoangnv
 */
@Path("/")
public class Adages {

    // Add aphorisms to taste...

    private final String[] aphorisms
            = {"What can be shown cannot be said.",
                "If a lion could talk, we could not understand him.",
                "Philosophy is a battle against the bewitchment of our intelligence by means of language.",
                "Ambition is the death of thought.",
                "The limits of my language mean the limits of my world."};

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Adages
     */
    public Adages() {
    }

    @GET
    @Produces({MediaType.APPLICATION_XML}) // could use "application/xml" instead
    public JAXBElement<Adage> getXml() {
        return toXml(createAdage());
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/json")
    public String getJson() {
        return toJson(createAdage());
    }

    @GET
    @Produces({MediaType.TEXT_PLAIN})
    @Path("/plain")
    public String getPlain() {
        return createAdage().toString() + "\n";
    }

    // Create an Adage and set the words property, which
    // likewise sets the wordCount property. The adage is
    // randomly selected from the array, aphorisms.
    private Adage createAdage() {
        Adage adage = new Adage();
        adage.setWords(aphorisms[new Random().nextInt(aphorisms.length)]);
        return adage;
    }

    // Java Adage --> XML document
    @XmlElementDecl(namespace = "http://aphorism.adage", name = "adage")
    private JAXBElement<Adage> toXml(Adage adage) {
        return new JAXBElement<>(new QName("adage"), Adage.class, adage);
    }

    // Java Adage --> JSON document
    // Jersey provides automatic conversion to JSON using the Jackson
    // libraries. In this example, the conversion is done manually 
    // with the Jackon libraries just to indicate how straightforward it is.
    private String toJson(Adage adage) {
        String json = "If you see this, there's a problem.";
        try {
//            json = new ObjectMapper().writeValueAsString(adage);
            Gson gson = new Gson();
            json = gson.toJson(adage);
        } catch (Exception e) {
        }
        return json;
    }
}
