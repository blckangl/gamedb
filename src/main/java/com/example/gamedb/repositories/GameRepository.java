package com.example.gamedb.repositories;

import com.example.gamedb.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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


    @Query("select g from Game g join g.categories c join g.platforms p join g.genres ge where (:catId is null or c.id =:catId) and (:platId is null or p.id = :platId) and (:genreId is null or ge.id = :genreId) and (:term is null or g.title like %:term%) order by g.releaseDate desc")
    ArrayList<Game> filter(@Param("catId") Long categoryId,@Param("platId") Long platformId,@Param("genreId") Long genreId,@Param("term") String term);

}
