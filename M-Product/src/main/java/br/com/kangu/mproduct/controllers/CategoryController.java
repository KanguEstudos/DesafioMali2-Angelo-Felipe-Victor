package br.com.kangu.mproduct.controllers;

import br.com.kangu.mproduct.entities.Category;
import br.com.kangu.mproduct.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {
    @Autowired
    private CategoryRepository repository;

    @GetMapping
    public List<Category> findAll() {
        return repository.findAll();
    }

    @PostMapping()
    public Category insertCategory(@RequestBody Category category){
        return repository.save(category);
    }


}
