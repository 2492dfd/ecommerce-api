package ecommerce_api.ecommerce_api.repository;

import ecommerce_api.ecommerce_api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
