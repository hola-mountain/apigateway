package com.holamountain.apigateway.exception;

import org.springframework.http.HttpStatus;

public class MalformedJwtTokenException extends ApiGateWayException {
    public MalformedJwtTokenException() {
        super(HttpStatus.UNAUTHORIZED);
    }

    public MalformedJwtTokenException(String reason) {
        super(HttpStatus.UNAUTHORIZED, reason);
    }

    public MalformedJwtTokenException(String reason, Throwable cause) {
        super(HttpStatus.UNAUTHORIZED, reason, cause);
    }

    public MalformedJwtTokenException(int rawStatusCode, String reason, Throwable cause) {
        super(rawStatusCode, reason, cause);
    }
}
