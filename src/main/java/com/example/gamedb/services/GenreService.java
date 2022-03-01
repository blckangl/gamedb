package com.example.gamedb.services;

import com.example.gamedb.models.Genre;
import com.example.gamedb.models.Platform;

import java.util.ArrayList;

public interface GenreService {

    ArrayList<Genre> getGenres();
    Genre getById(long id);

    Genre createGenre(Genre genre);

    void deleteGenre(long id);

    Genre updateGenre(long id, Genre genre);
}
