package com.example.gamedb.repositories;

import com.example.gamedb.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Long, Genre> {
}
