package com.codecipta.config.exception;

import com.codecipta.helper.response.ResponseTemplate;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable exception) {
        ResponseTemplate<Object> responseTemplate = new ResponseTemplate<>(
                Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),
                false,
                "Internal Server Error! Please call the admin.",
                null
        );

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(responseTemplate)
                .build();
    }
}
