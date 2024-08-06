package com.engineerpro.lecture1.services;

import com.engineerpro.lecture1.models.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {
    void likeMovie(Long userId, Long movieId);
    List<Movie> getFavoriteMovies(Long userId);
    void removeFavoriteMovie(Long userId, Long movieId);
}
