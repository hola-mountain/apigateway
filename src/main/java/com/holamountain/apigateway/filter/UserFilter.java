package com.holamountain.apigateway.filter;

import com.holamountain.apigateway.type.AuthType;
import com.holamountain.apigateway.util.FilterUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserFilter extends AbstractGatewayFilterFactory<UserFilter.Config> {
    private Environment env;

    public UserFilter(Environment env) {
        super(Config.class);
        this.env = env;
    }

    public static class Config {}

    @Override
    public GatewayFilter apply(UserFilter.Config config) {
        return FilterUtil.getFilter(env.getProperty("token.secret"), AuthType.USER);
    }
}