/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restfully.shop.services;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author hoangnv
 */
@Path("/cars")
public class CarResource {

    public static enum Color {

        red, white, blue, black
    }

    @GET
    @Path("/matrix/{make}/{model}/{year}")
    @Produces("text/plain")
    public String getFromMatrixParam(@PathParam("make") String make,
            @PathParam("model") PathSegment car,
            @MatrixParam("color") Color color,
            @PathParam("year") String year) {
        return "A" + color + " " + year + " " + make + " " + car.getPath();
    }

    @GET
    @Path("/segment/{make}/{model}/{year}")
    @Produces("text/plain")
    public String getFromPathSegment(@PathParam("make") String make,
            @PathParam("model") PathSegment car,
            @PathParam("year") String year) {
        String carColor = car.getMatrixParameters().getFirst("color");
        return "A" + carColor + " " + year + " " + make + " " + car.getPath();
    }

    @GET
    @Path("/segments/{make}/{model: .+}/year/{year}")
    @Produces("text/plain")
    public String getFromMultipleSegments(@PathParam("make") String make,
            @PathParam("model") List<PathSegment> car,
            @PathParam("year") String year) {
        StringBuilder output = new StringBuilder("A ").append(year).append(" ").append(make);
        car.stream().forEach((segment) -> {
            output.append(" ").append(segment.getPath());
        });
        return output.toString();
    }

    @GET
    @Path("/uriinfo/{make}/{model}/{year}")
    @Produces("text/plain")
    public String getFromUriInfo(@Context UriInfo info) {
        String make = info.getPathParameters().getFirst("make");
        String year = info.getPathParameters().getFirst("year");
        PathSegment model = info.getPathSegments().get(3);
        String color = model.getMatrixParameters().getFirst("color");
        return "A " + color + " " + year + " " + make + " " + model.getPath();
    }
}
