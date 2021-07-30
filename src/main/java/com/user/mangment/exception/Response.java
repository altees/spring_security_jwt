package com.user.mangment.exception;

import lombok.Data;

@Data
public class Response {
    private String message;
    private String requestedURL;
}
