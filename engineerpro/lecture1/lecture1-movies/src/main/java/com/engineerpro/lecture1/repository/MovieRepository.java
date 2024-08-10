package com.engineerpro.lecture1.repository;

import com.engineerpro.lecture1.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByUserId(Long userId);
    void deleteByUserIdAndMovieId(Long userId, Long movieId);
}
