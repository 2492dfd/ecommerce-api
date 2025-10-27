package ecommerce_api.ecommerce_api.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//자체 로그인
public class LoginRequest {
    private String email;
    private String password;
}
