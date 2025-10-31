package ecommerce_api.ecommerce_api.repository;

import ecommerce_api.ecommerce_api.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
