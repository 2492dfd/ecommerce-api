package ecommerce_api.ecommerce_api.security.handler;

import ecommerce_api.ecommerce_api.security.provider.JwtTokenProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component // 스프링 빈으로 등록
public class OAuth2SuccessHandler implements AuthenticationSuccessHandler {
    private final JwtTokenProvider jwtTokenProvider;
    public OAuth2SuccessHandler(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {

        // 여기에 로그인 성공 후 처리할 로직을 작성합니다.
        // 예: JWT 토큰 발급, 특정 페이지로 리다이렉트 등

        // 예시: 로그인 성공 시 메인 페이지로 리다이렉트
        response.sendRedirect("/");
    }

}
