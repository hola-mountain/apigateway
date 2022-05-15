package com.holamountain.apigateway.exception;

import org.springframework.http.HttpStatus;

public class AuthorizationException extends ApiGateWayException {
    public AuthorizationException() {
        super(HttpStatus.UNAUTHORIZED);
    }

    public AuthorizationException(String reason) {
        super(HttpStatus.UNAUTHORIZED, reason);
    }

    public AuthorizationException(String reason, Throwable cause) {
        super(HttpStatus.UNAUTHORIZED, reason, cause);
    }

    public AuthorizationException(int rawStatusCode, String reason, Throwable cause) {
        super(rawStatusCode, reason, cause);
    }
}
