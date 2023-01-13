package com.api.filme.service.impl;

import com.api.filme.dto.CategoryDto;
import com.api.filme.dto.MovieDto;
import com.api.filme.entity.Movie;
import com.api.filme.repository.MovieRepository;
import com.api.filme.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepository repository;

    @Override
    public Movie create(Movie movie) {
       return repository.save(movie);
    }


    @Override
    public Movie update(Long movieId, Movie movie) {
        movie.setId(movieId);
        return repository.save(movie);
    }

    @Override
    public void delete(Long movieId) {
         repository.deleteById(movieId);

    }

    @Override
    public MovieDto getById(Long movieId) {
        Movie movie = repository.getReferenceById(movieId);

        MovieDto movieDto = new MovieDto();
        movieDto.setId(movie.getId());
        movieDto.setTitle(movie.getTitle());
        movieDto.setYear(movie.getYear());
        movieDto.setDuration(movie.getDuration());

        List<CategoryDto> categories = new ArrayList<>();
        movie.getCategories().forEach(category -> {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setId(category.getId());
            categoryDto.setTitle(category.getTitle());
            categories.add(categoryDto);
        });
        movieDto.setCategories(categories);

        return movieDto;
    }

    @Override
    public List<MovieDto> getAllMovie() {
        List<Movie> movies = repository.findAll();
        List<MovieDto> movieDtos = new ArrayList<>();

        for (Movie movie : movies) {
            MovieDto movieDto = new MovieDto();
            movieDto.setId(movie.getId());
            movieDto.setTitle(movie.getTitle());
            movieDto.setYear(movie.getYear());
            movieDto.setDuration(movie.getDuration());

            List<CategoryDto> categories = new ArrayList<>();
            movie.getCategories().forEach(category -> {
                CategoryDto categoryDto = new CategoryDto();
                categoryDto.setId(category.getId());
                categoryDto.setTitle(category.getTitle());
                categories.add(categoryDto);
            });
            movieDto.setCategories(categories);

            movieDtos.add(movieDto);
        }
        return movieDtos;
    }

    @Override
    public Movie getByTitle(String title) {
        return repository.findByTitle(title);
    }
}
