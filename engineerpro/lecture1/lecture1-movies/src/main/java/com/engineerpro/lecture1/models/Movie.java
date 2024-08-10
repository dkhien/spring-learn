package com.engineerpro.lecture1.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String type; // "movie" or "series"
    private int rating;  // star rating from 1 to 5

    @ManyToMany(mappedBy = "favoriteMovies")
    private List<User> users = new CopyOnWriteArrayList<>();
}
