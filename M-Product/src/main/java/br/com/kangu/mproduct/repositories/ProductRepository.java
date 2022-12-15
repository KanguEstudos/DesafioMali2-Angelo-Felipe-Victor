package br.com.kangu.mproduct.repositories;


import br.com.kangu.mproduct.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByCategoryName(String category_name);

}
