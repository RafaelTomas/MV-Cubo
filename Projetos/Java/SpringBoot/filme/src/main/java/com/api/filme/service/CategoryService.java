package com.api.filme.service;


import com.api.filme.entity.Category;
import com.api.filme.entity.Movie;

import java.util.List;

public interface CategoryService {
    public List<Category> getAllCategory();
    public Category getCategoryById(Long id);
    public Category update(Long id, Category category);
    public Category create(Category category);
    public void delete(Long id);
}
