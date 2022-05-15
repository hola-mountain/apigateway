package com.holamountain.apigateway.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JwtProviderTest {

    @Test
    public void jwtTokenValidTest() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOjIwLCJ1c2VyVHlwZSI6IkNVU1RPTUVSIiwiZXhwIjoxNjUyNTY1MzE1fQ.e0IBcXzRf1sJSZGvhdPooQbOHbvR72PIL0qUpgBF0Ww";

        DecodedJWT jwt = JWT.decode(token);

        System.out.println("dasdas");

    }
}