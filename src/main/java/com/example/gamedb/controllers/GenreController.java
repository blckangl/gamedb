package com.example.gamedb.controllers;


import com.example.gamedb.models.Category;
import com.example.gamedb.models.Genre;
import com.example.gamedb.services.CategoryService;
import com.example.gamedb.services.GenreService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/genres")
@CrossOrigin("*")
public class GenreController {

    GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping()
    public ArrayList<Genre> Index() {
        return genreService.getGenres();
    }

    @DeleteMapping("{id}")
    public ArrayList<Genre> delete(@PathVariable long id) {
        genreService.deleteGenre(id);
        return genreService.getGenres();
    }

    @PostMapping
    public Genre create(@RequestBody Genre genre) {
        return genreService.createGenre(genre);
    }

    @PutMapping("{id}")
    public Genre create(@RequestBody Genre genre, @PathVariable long id) {
        return genreService.updateGenre(id, genre);
    }
}
