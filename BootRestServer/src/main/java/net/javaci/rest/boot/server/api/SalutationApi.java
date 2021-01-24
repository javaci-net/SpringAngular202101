package net.javaci.rest.boot.server.api;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaci.rest.common.SalutationRequest;
import net.javaci.rest.common.SalutationResponse;

@RestController
@RequestMapping("/javaciapi/salutation/")
public class SalutationApi {

    @GetMapping("/{name}/sayhello")
    public SalutationResponse saluteGET( @PathVariable("name") String name ) {
        return new SalutationResponse(name, "Merhaba");
    }
    
    @PostMapping("/sayhello")
    public SalutationResponse salutePOST( @RequestBody SalutationRequest request ) {
        if (!StringUtils.hasLength(request.getName())) {
            throw new RuntimeException("Name cannot be empty");
        }
        String fullName = request.getName() + " " + request.getSurname();
        return new SalutationResponse(request.getSalutation() , fullName);
    }
}
