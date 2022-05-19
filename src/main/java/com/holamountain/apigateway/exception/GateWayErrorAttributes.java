package com.holamountain.apigateway.exception;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.util.Map;

// DefaultErrorAttributes는 스프링이 자동으로 만들어내는 에러를 담고 있다.
@Component
public class GateWayErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(ServerRequest request, ErrorAttributeOptions options) {

        Map<String, Object> map = super.getErrorAttributes(request, options);

        Throwable throwable = getError(request);
        if (throwable instanceof ApiGateWayException) {
            ApiGateWayException ex = (ApiGateWayException) getError(request);
            map.put("errorCode", ex.getStatus().value());
            map.remove("status");
            map.put("errorMessage", ex.getReason());
        }

        return map;
    }
}