package net.javaci.rest.jaxrs.client;

import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.StatusType;

import net.javaci.rest.common.SalutationRequest;
import net.javaci.rest.common.SalutationResponse;

public class JaxRsClientApplication {

    public static void main(String[] args) {
        
        Client client = ClientBuilder.newClient();
        
        SalutationRequest request = new SalutationRequest();
        request.setName("Ali");
        request.setSurname("Veli");
        request.setSalutation("Selam");
        
        Response response = client
            .target("http://localhost:8080/JaxRsServer/javaciapi/salutation/sayhello")
            .request(MediaType.APPLICATION_JSON)
            .post(Entity.entity(request, MediaType.APPLICATION_JSON));
        
        StatusType statusInfo = response.getStatusInfo();
        
        // Istek basarizsa
        if (200 != statusInfo.getStatusCode()) {
            Logger.getAnonymousLogger().warning("Response error " +statusInfo.getReasonPhrase() );
            return;
        }
        
        SalutationResponse responseObject = response.readEntity(SalutationResponse.class);
        Logger.getAnonymousLogger().info(responseObject.getSalutation());
        
    }

}
