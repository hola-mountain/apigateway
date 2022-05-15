package com.holamountain.apigateway.exception;

import org.springframework.http.HttpStatus;

public class MalformedJwtException extends ApiGateWayException {
    public MalformedJwtException() {
        super(HttpStatus.UNAUTHORIZED);
    }

    public MalformedJwtException(String reason) {
        super(HttpStatus.UNAUTHORIZED, reason);
    }

    public MalformedJwtException(String reason, Throwable cause) {
        super(HttpStatus.UNAUTHORIZED, reason, cause);
    }

    public MalformedJwtException(int rawStatusCode, String reason, Throwable cause) {
        super(rawStatusCode, reason, cause);
    }
}
