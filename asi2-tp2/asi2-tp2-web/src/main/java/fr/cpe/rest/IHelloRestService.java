package fr.cpe.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by ubuntu on 9/11/16.
 */
@Path("/hello")
public interface IHelloRestService {

    @GET
    @Produces("text/plain")
    @Path("/")
    String hello();

    @GET
    @Produces("text/plain")
    @Path("/jms")
    String helloJms();
}
