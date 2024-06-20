package com.codecipta.config.exception;

import com.codecipta.helper.response.ResponseTemplate;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

    @Override
    public Response toResponse(NotFoundException exception) {
        ResponseTemplate<Object> responseTemplate = new ResponseTemplate<>(
                Response.Status.NOT_FOUND.getStatusCode(),
                false,
                "Resource Not Found!",
                null
        );

        return Response.status(Response.Status.NOT_FOUND)
                .entity(responseTemplate)
                .build();
    }
}
