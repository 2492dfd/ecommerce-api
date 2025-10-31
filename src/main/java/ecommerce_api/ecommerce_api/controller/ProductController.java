package ecommerce_api.ecommerce_api.controller;

import ecommerce_api.ecommerce_api.entity.Product;
import ecommerce_api.ecommerce_api.service.ProductService;
import ecommerce_api.ecommerce_api.service.RecentlyViewedService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final RecentlyViewedService recentlyViewedService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable Long productId, @RequestParam Long userId) {
        recentlyViewedService.addRecentlyViewedProduct(userId, productId);
        return productService.getProductById(productId);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }
}
