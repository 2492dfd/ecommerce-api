package ecommerce_api.ecommerce_api.service;

import ecommerce_api.ecommerce_api.entity.Article;
import ecommerce_api.ecommerce_api.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Article getArticleById(Long articleId) {
        return articleRepository.findById(articleId).orElse(null);
    }

    public Article createArticle(Article article) {
        return articleRepository.save(article);
    }
}
