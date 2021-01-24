package net.javaci.rest.jaxrs.server.api;

import java.util.concurrent.TimeUnit;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import net.javaci.rest.common.SalutationRequest;
import net.javaci.rest.common.SalutationResponse;

@Path("/salutation")
public class SalutationApi {

    @GET
    @Path("/{name}/sayhello")
    @Produces(MediaType.APPLICATION_JSON)
    public SalutationResponse saluteGET( @PathParam("name") String name ) {
        return new SalutationResponse(name, "Merhaba");
    }
    
    @GET
    @Path("/{name}/sayhello2")
    public Response salute2GET(@PathParam("name") String name ) {
        return Response
                .ok()
                .entity(new SalutationResponse(name, "Merhaba"))
                .build();
    }
    
    @POST
    @Path("/sayhello")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public SalutationResponse salutePOST( SalutationRequest request ) {
        
        addArtificialDelay();
        
        String fullName = request.getName() + " " + request.getSurname();
        return new SalutationResponse(request.getSalutation() , fullName);
    }

    private void addArtificialDelay() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            
        }
    }
}
