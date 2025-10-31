package ecommerce_api.ecommerce_api.controller;

import ecommerce_api.ecommerce_api.entity.Article;
import ecommerce_api.ecommerce_api.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    @GetMapping("/{articleId}")
    public Article getArticleById(@PathVariable Long articleId) {
        return articleService.getArticleById(articleId);
    }

    @PostMapping
    public Article createArticle(@RequestBody Article article) {
        return articleService.createArticle(article);
    }
}
