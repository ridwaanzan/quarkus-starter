package com.codecipta.config.exception;

import com.codecipta.helper.response.ResponseTemplate;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.Set;
import java.util.stream.Collectors;

@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException exception) {
        Set<ConstraintViolation<?>> violations = exception.getConstraintViolations();
        String errorMessage = violations.stream()
                .map(violation -> violation.getPropertyPath() + " " + violation.getMessage())
                .collect(Collectors.joining(", "));

        ResponseTemplate<Object> responseTemplate = new ResponseTemplate<>(
                Response.Status.BAD_REQUEST.getStatusCode(),
                false,
                "Validation Error: " + errorMessage,
                null
        );

        return Response.status(Response.Status.BAD_REQUEST)
                .entity(responseTemplate)
                .build();
    }
}
