package com.engineerpro.lecture1.services;

import com.engineerpro.lecture1.models.Movie;
import com.engineerpro.lecture1.models.User;
import com.engineerpro.lecture1.repository.MovieRepository;
import com.engineerpro.lecture1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final UserRepository userRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository, UserRepository userRepository) {
        this.movieRepository = movieRepository;
        this.userRepository = userRepository;

    }

    @Override
    public void likeMovie(Long userId, Long movieId) {
        // Add movie to user's favorite movies
        Optional<Movie> movie = movieRepository.findById(movieId);
        Optional<User> user = userRepository.findById(userId);

        if (movie.isPresent() && user.isPresent()) {
            user.get().getFavoriteMovies().add(movie.get());
            userRepository.save(user.get());
        }
    }

    @Override
    public List<Movie> getFavoriteMovies(Long userId) {
        // Get user's favorite movies
        Optional<User> user = userRepository.findById(userId);
        return user.map(User::getFavoriteMovies).orElse(null);
    }

    @Override
    public void removeFavoriteMovie(Long userId, Long movieId) {
        // Remove movie from user's favorite movies
        Optional<User> user = userRepository.findById(userId);
        Optional<Movie> movie = movieRepository.findById(movieId);
        if (user.isPresent() && movie.isPresent()) {
            user.get().getFavoriteMovies().remove(movie.get());
            userRepository.save(user.get());
        }
    }
}
