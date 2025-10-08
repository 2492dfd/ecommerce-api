package ecommerce_api.ecommerce_api.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String email;
    private String password;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String provider;
    @Builder
    public User(String email, String password, String name, String provider) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.provider = provider;
    }
}
