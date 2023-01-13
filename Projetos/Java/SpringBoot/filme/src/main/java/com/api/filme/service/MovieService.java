package com.api.filme.service;

import com.api.filme.dto.MovieDto;
import com.api.filme.entity.Movie;

import java.util.List;

public interface MovieService {
    public Movie create(Movie movie);
    public Movie update(Long movieId, Movie movie);
    public void delete(Long movieId);
    public MovieDto getById(Long movieId);
    public List<MovieDto> getAllMovie();
    public Movie getByTitle(String title);
}
