package net.javaci.rest.jaxrs.server;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

@ApplicationPath("/javaciapi")
public class JaxRsServerApplication extends Application {

    @Path("/health")
    public static class Healthcheck {
        
        /** 
         * GET http://localhost:8080/../javaciapi/health/check
         * 
         * @return
         */
        @GET
        @Path("/check")
        public Response check() {
            return Response
                    .ok()
                    .entity("Service online")
                    .build();
        }
        
        @GET
        @Path("/ping")
        public Response ping() {
            return Response.ok().entity("Pong").build();
        }
        
    }
    
}
