package com.example.gamedb.repositories;

import com.example.gamedb.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    Game findByTitle(String title);

    //    ArrayList<Game> findTop5ByOrderByCreated_at();
    ArrayList<Game> findTop4ByOrderByCreatedAtDesc();

    @Query(value = "select * from game ORDER BY release_date DESC LIMIT 4", nativeQuery = true)
    ArrayList<Game> getRecenlyReleased();

    ArrayList<Game> findAllByCategoriesIdOrderByReleaseDateDesc(long id);

}
