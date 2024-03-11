package dev.rpmhub;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.Response;
import jakarta.json.Json;

/**
 * This class represents a conversion service that provides methods for
 * converting units of measurement.
 */
@Path("/Conversion")
public class ConversionService {

    /**
     * Converts kilometers per hour to miles per hour.
     *
     * @param kmph the value in kilometers per hour to be converted
     * @return the converted value in miles per hour as a string
    */
    @POST
    @Path("/km-to-miles")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String kmphToMph(double kmph) {
        double mph = kmph * 0.621371;
        // Truncate to 5 decimal places
        mph = Math.floor(mph * 100000) / 100000;
        return Double.toString(mph);
    }

    /**
     * Converts knots to kilometers per hour (km/h).
     *
     * @param knots the value in knots to be converted
     * @return a Response object containing the converted value in kilometers
     * per hour (km/h)
    */
    @GET
    @Path("/knots-to-km/{knots}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response knotsToKmph(@PathParam("knots") double knots) {
        double kmph = knots * 1.852;
        return Response.ok(Json
            .createObjectBuilder()
            .add("value", kmph)
            .build()).build();
    }
}