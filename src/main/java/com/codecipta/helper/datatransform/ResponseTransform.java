package com.codecipta.helper.datatransform;

import com.codecipta.helper.response.ResponseTemplate;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.awt.*;

@Path("/v1/starter")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ResponseTransform {

    @Path("/do")
    @GET
    public ResponseTemplate<?> getDoing() {
        return ResponseTemplate.builder()
                .responseCode(Response.Status.OK.getStatusCode())
                .isSuccess(Boolean.TRUE)
                .responseMessage(null)
                .responseData(null)
                .build();
    }

}
