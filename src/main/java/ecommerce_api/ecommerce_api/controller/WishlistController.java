package ecommerce_api.ecommerce_api.controller;

import ecommerce_api.ecommerce_api.entity.Wishlist;
import ecommerce_api.ecommerce_api.service.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wishlist")
@RequiredArgsConstructor
public class WishlistController {

    private final WishlistService wishlistService;

    @PostMapping("/{userId}/{productId}")
    public void addProductToWishlist(@PathVariable Long userId, @PathVariable Long productId) {
        wishlistService.addProductToWishlist(userId, productId);
    }

    @GetMapping("/{userId}")
    public List<Wishlist> getWishlistByUserId(@PathVariable Long userId) {
        return wishlistService.getWishlistByUserId(userId);
    }
}
