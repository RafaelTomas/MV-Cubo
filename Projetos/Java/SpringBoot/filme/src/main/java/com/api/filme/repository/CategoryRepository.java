package com.api.filme.repository;

import com.api.filme.entity.Category;
import com.api.filme.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
