package com.holamountain.apigateway.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ApiGateWayException extends ResponseStatusException {
    public ApiGateWayException(HttpStatus status) {
        super(status);
    }

    public ApiGateWayException(HttpStatus status, String reason) {
        super(status, reason);
    }

    public ApiGateWayException(HttpStatus status, String reason, Throwable cause) {
        super(status, reason, cause);
    }

    public ApiGateWayException(int rawStatusCode, String reason, Throwable cause) {
        super(rawStatusCode, reason, cause);
    }
}
