package com.api.filme.controller;

import com.api.filme.dto.MovieDto;
import com.api.filme.entity.Category;
import com.api.filme.entity.Movie;
import com.api.filme.service.impl.CategoryServiceImpl;
import com.api.filme.service.impl.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    MovieServiceImpl service;

    @Autowired
    CategoryServiceImpl CategoryService;

    @PostMapping
    public ResponseEntity<Movie> create(@RequestBody MovieDto movieDto)
    {
        Movie movie = new Movie();
        movie.setTitle(movieDto.getTitle());
        movie.setDuration(movieDto.getDuration());
        movie.setYear(movieDto.getYear());
        movieDto.getCategories().forEach(g -> {
            Category categories = CategoryService.getCategoryById(g.getId());
            movie.addCategory(categories);
        });
         service.create(movie);
        return ResponseEntity.ok().body(movie);
    }

    @GetMapping
    public List<MovieDto> getAllMovie()
    {
        return  service.getAllMovie();
    }

    @GetMapping("/{id}")
    public MovieDto getMovieById(@PathVariable(value = "id") Long movieId) {
        return service.getById(movieId);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Movie> update(@PathVariable(value = "id")  Long movieId, @RequestBody Movie movie)
    {
        service.update(movieId, movie);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long movieId)
    {
        service.delete(movieId);
        return ResponseEntity.noContent().build();
    }


}
