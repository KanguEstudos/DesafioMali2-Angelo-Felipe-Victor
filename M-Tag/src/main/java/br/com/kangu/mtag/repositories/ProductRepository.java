package br.com.kangu.mtag.repositories;

import br.com.kangu.mtag.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
