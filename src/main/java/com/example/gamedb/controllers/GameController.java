package com.example.gamedb.controllers;


import com.example.gamedb.models.Category;
import com.example.gamedb.models.Game;
import com.example.gamedb.models.Genre;
import com.example.gamedb.models.Platform;
import com.example.gamedb.requests.GameBody;
import com.example.gamedb.services.CategoryService;
import com.example.gamedb.services.GameService;
import com.example.gamedb.services.GenreService;
import com.example.gamedb.services.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/games")
@CrossOrigin("*")
public class GameController {


    //    @Autowired
//    GameService gameService;
    GameService gameService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    PlatformService platformService;
    @Autowired
    GenreService genreService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping()
    public ArrayList<Game> Index() {
        return gameService.getGames();
    }

    @GetMapping("/{id}")
    public Game getGameById(@PathVariable int id) {
        return gameService.getGameById(id);
    }

    @GetMapping("/title/{title}")
    public Game getGameByTitle(@PathVariable String title) {
        return gameService.getGameByTitle(title);

    }


    @PostMapping()
    public GameBody addGame(@RequestBody GameBody game) {

        ArrayList<Platform> platforms = new ArrayList<Platform>();
        ArrayList<Genre> genres = new ArrayList<Genre>();
        ArrayList<Category> categories = new ArrayList<Category>();

        for (int i = 0; i < game.getCategories().size(); i++) {
            Long cat = game.getCategories().get(i);
            Category category = categoryService.getById(cat);
            if (category != null) {
                categories.add(category);
            }
        }
        for (int i = 0; i < game.getCategories().size(); i++) {
            Long plat = game.getPlatforms().get(i);
            Platform platform = platformService.getById(plat);
            if (platform != null) {
                platforms.add(platform);
            }
        }
        for (int i = 0; i < game.getCategories().size(); i++) {
            Long gen = game.getGenres().get(i);
            Genre genre = genreService.getById(gen);
            if (genre != null) {
                genres.add(genre);
            }
        }


//        gameService.createGame(game)
        return game;
    }


    @PutMapping("{id}")
    public Game updateGame(@RequestBody Game game, @PathVariable int id) {

        return gameService.updateGame(id, game);
    }


    @DeleteMapping("{id}")
    public Game deleteGame(@PathVariable int id) {
        return gameService.deleteGame(id);

    }
}
