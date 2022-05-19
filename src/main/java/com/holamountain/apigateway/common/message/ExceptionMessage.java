
package com.holamountain.apigateway.common.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum ExceptionMessage {
    AuthorizationException("AuthorizationException", "접근 권한이 없습니다."),
    MalformedJwtException("MalformedJwtTokenException", "잘못된 형식의 jwt토큰입니다."),
    ExpiredJwtTokenException("ExpiredJwtTokenException", "재로그인해주세요."),
    UnsupportedJwtTokenException("UnsupportedJwtTokenException", "지원되지 않는 형식입니다.");

    private String type;
    private String message;
}
