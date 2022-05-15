package com.holamountain.apigateway.jwt;

import com.holamountain.apigateway.common.message.ExceptionMessage;
import com.holamountain.apigateway.exception.AuthorizationException;
import com.holamountain.apigateway.exception.ExpiredJwtTokenException;
import com.holamountain.apigateway.exception.UnsupportedJwtTokenException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component
@Slf4j
public class JwtTokenProvider {

    @Value("${jwt.secret-key}")
    private String secret;

    public boolean isValidToken(String jwtToken){
        try {
            Jws<Claims> claims = Jwts.parserBuilder().setSigningKey(secret).build().parseClaimsJws(jwtToken);
            return true;
        } catch (SecurityException | MalformedJwtException e) {
            throw new MalformedJwtException(ExceptionMessage.MalformedJwtException.getMessage());
        } catch (ExpiredJwtException e) {
            throw new ExpiredJwtTokenException(ExceptionMessage.ExpiredJwtTokenException.getMessage());
        } catch (UnsupportedJwtException e) {
            throw new UnsupportedJwtTokenException(ExceptionMessage.UnsupportedJwtTokenException.getMessage());
        }
    }

    public String resolveToken(ServerHttpRequest serverHttpRequest) {
        if (serverHttpRequest.getHeaders().containsKey("AUTHORIZATION")) {
            throw new AuthorizationException(ExceptionMessage.AuthorizationException.getMessage());
        }

        return serverHttpRequest.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
    }

    public String getUserTypeFromToken(String jwtToken) {
        try {
            SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwtToken).getBody().get("userType").toString();
        } catch (SecurityException | MalformedJwtException e) {
            throw new MalformedJwtException(ExceptionMessage.MalformedJwtException.getMessage());
        } catch (ExpiredJwtException e) {
            throw new ExpiredJwtTokenException(ExceptionMessage.ExpiredJwtTokenException.getMessage());
        } catch (UnsupportedJwtException e) {
            throw new UnsupportedJwtTokenException(ExceptionMessage.UnsupportedJwtTokenException.getMessage());
        }
    }
}
