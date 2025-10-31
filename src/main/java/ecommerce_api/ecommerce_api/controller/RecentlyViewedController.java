package ecommerce_api.ecommerce_api.controller;

import ecommerce_api.ecommerce_api.entity.RecentlyViewed;
import ecommerce_api.ecommerce_api.service.RecentlyViewedService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recently-viewed")
@RequiredArgsConstructor
public class RecentlyViewedController {

    private final RecentlyViewedService recentlyViewedService;

    @GetMapping("/{userId}")
    public List<RecentlyViewed> getRecentlyViewedProducts(@PathVariable Long userId) {
        return recentlyViewedService.getRecentlyViewedProducts(userId);
    }
}
