package com.codecipta.config.logging;

import jakarta.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.PreMatching;
import jakarta.ws.rs.ext.Provider;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.jboss.logging.Logger;

@Provider
@PreMatching
@Priority(Priorities.AUTHENTICATION)
@ApplicationScoped
public class RequestLoggingFilter implements ContainerRequestFilter {
    private static final Logger log = Logger.getLogger(RequestLoggingFilter.class);

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String method = requestContext.getMethod();
        String path = requestContext.getUriInfo().getRequestUri().toString();
        String host = requestContext.getUriInfo().getBaseUri().getHost();
        int port = requestContext.getUriInfo().getBaseUri().getPort();

        // Read the entity stream (body) to log the payload
        InputStream inputStream = requestContext.getEntityStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            baos.write(buffer, 0, bytesRead);
        }
        byte[] requestBodyBytes = baos.toByteArray();
        String requestBody = new String(requestBodyBytes, "UTF-8");

        log.infof("Request received: %s:%d%s [Method: %s] [Payload: %s]",
                host, port, path, method, requestBody);

        // Reset the input stream to the beginning with the copied bytes
        requestContext.setEntityStream(new ByteArrayInputStream(requestBodyBytes));
    }
}
