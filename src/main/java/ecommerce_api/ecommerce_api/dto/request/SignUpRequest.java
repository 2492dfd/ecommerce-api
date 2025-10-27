package ecommerce_api.ecommerce_api.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//자체 회원가입
public class SignUpRequest {
    private String email;
    private String password;
    private String name;
}
