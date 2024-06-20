package com.codecipta.config.exception;

import com.codecipta.helper.response.ResponseTemplate;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class TimeoutExceptionMapper implements ExceptionMapper<WebApplicationException> {

    @Override
    public Response toResponse(WebApplicationException exception) {
        ResponseTemplate<Object> responseTemplate = new ResponseTemplate<>(
                Response.Status.REQUEST_TIMEOUT.getStatusCode(),
                false,
                "Request Timeout!",
                null
        );

        return Response.status(Response.Status.REQUEST_TIMEOUT)
                .entity(responseTemplate)
                .build();
    }
}
