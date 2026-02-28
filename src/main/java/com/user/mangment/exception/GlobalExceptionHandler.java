package com.user.mangment.exception;

import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Response handleResourceNotFound(final Exception exception,
                                           final HttpServletRequest request) {
        Response error = new Response();
        error.setMessage(exception.getMessage());
        error.setRequestedURL(request.getRequestURI());
        return error;
    }
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    public Response handleUnAuthorisedError(final Exception exception,
                                           final HttpServletRequest request) {
        Response error = new Response();
        error.setMessage(exception.getMessage());
        error.setRequestedURL(request.getRequestURI());
        return error;
    }
    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    public Response badCredentials(final Exception exception,
                                           final HttpServletRequest request) {
        Response error = new Response();
        error.setMessage(exception.getMessage());
        error.setRequestedURL(request.getRequestURI());
        return error;
    }


}
