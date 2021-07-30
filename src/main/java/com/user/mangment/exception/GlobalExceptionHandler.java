package com.user.mangment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
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


}
