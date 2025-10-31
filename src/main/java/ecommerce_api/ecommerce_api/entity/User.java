package ecommerce_api.ecommerce_api.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity //jpa가 이 클래스 테이블로 관리
@Setter
@Getter
@NoArgsConstructor
@ToString // ToString 추가
//db 모델
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //기본키, 값 자동 생성
    @Column(nullable = false, unique = true)
    //비어있을 수 없고 중복될 수 없음
    private String email;
    private String password;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String provider; //local로 회원가입 했는지 google로 회원가입 했는지

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Wishlist> wishlist = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecentlyViewed> recentlyViewed = new ArrayList<>();

    @Builder
    public User(String email, String password, String name, String provider) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.provider = provider;
    }
}
