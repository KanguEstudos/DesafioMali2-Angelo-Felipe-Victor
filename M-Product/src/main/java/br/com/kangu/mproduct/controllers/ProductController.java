package br.com.kangu.mproduct.controllers;

import br.com.kangu.mproduct.entities.Category;
import br.com.kangu.mproduct.entities.Product;
import br.com.kangu.mproduct.repositories.CategoryRepository;
import br.com.kangu.mproduct.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public List<Product> findAllProducts() {
        List<Product> result = productRepository.findAll();
        return result;
    }

    @GetMapping(value="/{id}")
    public Product findById(@PathVariable Long id) {
        Product result = productRepository.findById(id).get();
        return result;
    }

    @GetMapping(value="/categories")
    public List<Category> findAllCategories() {
        List<Category> result = categoryRepository.findAll();
        return result;
    }

    @GetMapping(value="/category/{name}")
    public List<Product> findAllProductsInCategory(@PathVariable String name) {
        List<Product> result = productRepository.findAllByCategoryName(name);
        return result;
    }

}
