package com.thoughtworks.ketsu.web.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ConflictExceptionMapperA implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable exception) {
        exception.printStackTrace();
        return Response.status(400).build();
    }
}
