package ecommerce_api.ecommerce_api.service;

import ecommerce_api.ecommerce_api.entity.Product;
import ecommerce_api.ecommerce_api.entity.User;
import ecommerce_api.ecommerce_api.entity.Wishlist;
import ecommerce_api.ecommerce_api.repository.ProductRepository;
import ecommerce_api.ecommerce_api.repository.UserRepository;
import ecommerce_api.ecommerce_api.repository.WishlistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WishlistService {

    private final WishlistRepository wishlistRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public void addProductToWishlist(Long userId, Long productId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));

        Wishlist wishlist = new Wishlist();
        wishlist.setUser(user);
        wishlist.setProduct(product);

        wishlistRepository.save(wishlist);
    }

    public List<Wishlist> getWishlistByUserId(Long userId) {
        return wishlistRepository.findByUserId(userId);
    }
}
