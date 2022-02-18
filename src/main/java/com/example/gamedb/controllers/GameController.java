package com.example.gamedb.controllers;


import com.example.gamedb.models.Game;
import com.example.gamedb.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/games")
public class GameController {


//    @Autowired
//    GameService gameService;
  GameService gameService;

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

    @PostMapping()
    public Game addGame(@RequestBody Game game) {

        return gameService.createGame(game);
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
