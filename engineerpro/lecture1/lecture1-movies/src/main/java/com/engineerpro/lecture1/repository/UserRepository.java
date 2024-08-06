package com.engineerpro.lecture1.repository;

import com.engineerpro.lecture1.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
