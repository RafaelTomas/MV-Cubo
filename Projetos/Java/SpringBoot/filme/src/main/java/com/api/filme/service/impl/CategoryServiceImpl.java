package com.api.filme.service.impl;

import com.api.filme.entity.Category;
import com.api.filme.repository.CategoryRepository;
import com.api.filme.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Override
    public List<Category> getAllCategory() {
        return repository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }

    @Override
    public Category update(Long id, Category category) {
        category.setId(id);
        return repository.save(category);
    }

    @Override
    public Category create(Category category) {
        return repository.save(category);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
