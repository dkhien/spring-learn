package com.engineerpro.lecture1.controllers;

import com.engineerpro.lecture1.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/like")
    public void likeMovie(@RequestParam Long userId, @RequestParam Long movieId) {
        // Like a movie
        movieService.likeMovie(userId, movieId);
    }

    @GetMapping("/favorites")
    public void getFavoriteMovies(@RequestParam Long userId) {
        movieService.getFavoriteMovies(userId);

    }

    @PostMapping
    public void removeFavoriteMovie(@RequestParam Long userId, @RequestParam Long movieId) {
        // Remove a movie from favorite movies
        movieService.removeFavoriteMovie(userId, movieId);
    }
}
