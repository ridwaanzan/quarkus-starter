package com.codecipta.controller.starter;

import com.codecipta.helper.response.ResponseTemplate;
import com.codecipta.service.StarterService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/v1/starter")
public class StarterController {

    @Inject
    StarterService starterService;

    @GET
    public ResponseTemplate<?> StarterControllerMethod() {
        return starterService.starterServiceMethod();
    }
}
