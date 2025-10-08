package ecommerce_api.ecommerce_api.security.service;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class CustomOAuth2UserService  extends DefaultOAuth2UserService {
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) {
        // 부모 클래스의 메서드를 호출하여 기본 사용자 정보를 가져옵니다.
        OAuth2User oAuth2User = super.loadUser(userRequest);

        // 여기에 사용자 정보를 DB에 저장하거나 업데이트하는 로직을 추가할 수 있습니다.
        // 예: oAuth2User.getAttributes() 등을 활용

        return oAuth2User;
    }
}