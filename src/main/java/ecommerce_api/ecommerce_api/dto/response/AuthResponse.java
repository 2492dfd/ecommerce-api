package ecommerce_api.ecommerce_api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
//로그인 성공시 클라이언트에게 반환할 accessToken 담음
public class AuthResponse {
    private String accessToken;
}
