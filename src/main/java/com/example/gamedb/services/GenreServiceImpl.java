package com.example.gamedb.services;

import com.example.gamedb.models.Category;
import com.example.gamedb.models.Genre;
import com.example.gamedb.models.Platform;
import com.example.gamedb.repositories.GameRepository;
import com.example.gamedb.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    GenreRepository genreRepository;

    @Override
    public ArrayList<Genre> getGenres() {
        return new ArrayList<>(genreRepository.findAll());
    }

    @Override
    public Genre getById(long id) {
        return genreRepository.findById(id).orElse(null);
    }

    @Override
    public Genre createGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public void deleteGenre(long id) {
        genreRepository.deleteById(id);

        return;
    }

    @Override
    public Genre updateGenre(long id, Genre genre) {
        Genre genretoUpdate = genreRepository.findById(id).orElse(null);

        if (genretoUpdate != null) {

            if (genre.getTitle() != null)
                genretoUpdate.setTitle(genre.getTitle());

            return genreRepository.save(genretoUpdate);
        } else {
            return null;

        }
    }
}
