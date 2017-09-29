package fr.cpe.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.List;

/**
 * Created by ubuntu on 9/11/16.
 */
@Path("/addition")
public interface IAdditionRestService {
    @GET
    @Produces("application/json")
    @Path("/")
    Number add(@QueryParam("a") List<Double> a);

    @GET
    @Produces("application/json")
    @Path("/jms")
    void addJms(@QueryParam("a") List<Double> a);
}
