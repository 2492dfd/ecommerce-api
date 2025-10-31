package ecommerce_api.ecommerce_api.service;

import ecommerce_api.ecommerce_api.entity.Product;
import ecommerce_api.ecommerce_api.entity.RecentlyViewed;
import ecommerce_api.ecommerce_api.entity.User;
import ecommerce_api.ecommerce_api.repository.ProductRepository;
import ecommerce_api.ecommerce_api.repository.RecentlyViewedRepository;
import ecommerce_api.ecommerce_api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecentlyViewedService {

    private final RecentlyViewedRepository recentlyViewedRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public void addRecentlyViewedProduct(Long userId, Long productId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));

        RecentlyViewed recentlyViewed = new RecentlyViewed();
        recentlyViewed.setUser(user);
        recentlyViewed.setProduct(product);
        recentlyViewed.setViewedAt(LocalDateTime.now());

        recentlyViewedRepository.save(recentlyViewed);
    }

    public List<RecentlyViewed> getRecentlyViewedProducts(Long userId) {
        return recentlyViewedRepository.findByUserIdOrderByViewedAtDesc(userId);
    }
}
