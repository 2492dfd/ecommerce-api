package ecommerce_api.ecommerce_api.repository;

import ecommerce_api.ecommerce_api.entity.RecentlyViewed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecentlyViewedRepository extends JpaRepository<RecentlyViewed, Long> {
    List<RecentlyViewed> findByUserIdOrderByViewedAtDesc(Long userId);
}
