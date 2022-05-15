package com.holamountain.apigateway.filter;//package com.holamountain.apigateway.filter;

import com.holamountain.apigateway.common.UserEnums.UserType;
import com.holamountain.apigateway.common.message.ExceptionMessage;
import com.holamountain.apigateway.exception.AuthorizationException;
import com.holamountain.apigateway.jwt.JwtTokenProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserFilter extends AbstractGatewayFilterFactory<UserFilter.Config> {
    private Environment env;
    private JwtTokenProvider jwtTokenProvider;

    public UserFilter(Environment env, JwtTokenProvider jwtTokenProvider) {
        super(Config.class);
        this.env = env;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public static class Config {
    }

    @Override
    public GatewayFilter apply(UserFilter.Config config) {
        return ((exchange, chain) -> {
            String token = jwtTokenProvider.resolveToken((ServerHttpRequest) exchange.getRequest());

            if (token != null && jwtTokenProvider.isValidToken(token) &&
                    jwtTokenProvider.getUserTypeFromToken(token).equals(UserType.CUSTOMER)) {
                return chain.filter(exchange);
            } else {
                throw new AuthorizationException(ExceptionMessage.AuthorizationException.getMessage());
            }
        });
    }
}
