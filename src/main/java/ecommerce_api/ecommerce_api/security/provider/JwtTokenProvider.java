package ecommerce_api.ecommerce_api.security.provider;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Component
public class JwtTokenProvider {
    private final Key key;

    // JWT 키 생성
    public JwtTokenProvider() {
        this.key = Keys.secretKeyFor(SignatureAlgorithm.HS256); // 안전한 키 생성
    }

    // 인자 1개 버전: 일반 로그인용 (subject만 포함)
    public String createToken(String subject) {
        // 토큰 유효 시간 설정 (예: 30분)
        Date now = new Date();
        Date validity = new Date(now.getTime() + 1800000); // 30분 = 30 * 60 * 1000ms

        return Jwts.builder()
                .setSubject(subject) // 토큰 주체 (예: 이메일)
                .setIssuedAt(now) // 발행 시간
                .setExpiration(validity) // 만료 시간
                .signWith(key, SignatureAlgorithm.HS256) // 서명에 사용할 키와 알고리즘
                .compact();
    }

    // 인자 2개 버전: OAuth2 로그인용 (subject와 권한 정보 포함)
    public String createToken(String subject, Collection<? extends GrantedAuthority> authorities) {
        Date now = new Date();
        Date validity = new Date(now.getTime() + 1800000);

        String authoritiesString = authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        return Jwts.builder()
                .setSubject(subject)
                .claim("roles", authoritiesString) // 권한 정보 추가
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // 토큰 유효성 검증
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
