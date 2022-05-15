package com.holamountain.apigateway.exception;

import com.holamountain.apigateway.jwt.JwtTokenProvider;
import org.springframework.http.HttpStatus;

public class UnsupportedJwtTokenException extends ApiGateWayException {
    public UnsupportedJwtTokenException() {
        super(HttpStatus.UNAUTHORIZED);
    }

    public UnsupportedJwtTokenException(String reason) {
        super(HttpStatus.UNAUTHORIZED, reason);
    }

    public UnsupportedJwtTokenException(String reason, Throwable cause) {
        super(HttpStatus.UNAUTHORIZED, reason, cause);
    }

    public UnsupportedJwtTokenException(int rawStatusCode, String reason, Throwable cause) {
        super(rawStatusCode, reason, cause);
    }
}
