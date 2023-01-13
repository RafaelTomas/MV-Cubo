package com.api.filme.controller;

import com.api.filme.dto.CategoryDto;
import com.api.filme.entity.Category;
import com.api.filme.entity.Movie;
import com.api.filme.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryServiceImpl service;

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody CategoryDto categoryDto)
    {
        Category category = new Category();
        category.setTitle(categoryDto.getTitle());

        service.create(category);
        return ResponseEntity.ok().body(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long categoryId)
    {
        service.delete(categoryId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable(value = "id")  Long id, @RequestBody Category category)
    {
        service.update(id, category);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> list = service.getAllCategory();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id){
        Category list = service.getCategoryById(id);

        return ResponseEntity.ok().body(list);
    }

}
