package com.holamountain.apigateway.exception;

import org.springframework.http.HttpStatus;

public class ExpiredJwtTokenException extends ApiGateWayException {
    public ExpiredJwtTokenException() {
        super(HttpStatus.UNAUTHORIZED);
    }

    public ExpiredJwtTokenException(String reason) {
        super(HttpStatus.UNAUTHORIZED, reason);
    }

    public ExpiredJwtTokenException(String reason, Throwable cause) {
        super(HttpStatus.UNAUTHORIZED, reason, cause);
    }

    public ExpiredJwtTokenException(int rawStatusCode, String reason, Throwable cause) {
        super(rawStatusCode, reason, cause);
    }
}
