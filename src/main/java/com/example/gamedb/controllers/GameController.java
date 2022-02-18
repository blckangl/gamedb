package com.example.gamedb.controllers;


import com.example.gamedb.models.Game;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/games")
public class GameController {

    ArrayList<Game> gameList = new ArrayList<>();

    public GameController() {
        gameList.add(new Game(1, "wow", "mmorpg game", "", ""));
        gameList.add(new Game(2, "fallout", "rpg game", "", ""));
        gameList.add(new Game(3, "god of war", "action game", "", ""));
    }

    @GetMapping()
    public ArrayList<Game> Index() {
        return this.gameList;
    }

    @GetMapping("/{id}")
    public Game getGameById(@PathVariable String id) {
        Game tempGame = null;
        for (Game game : gameList
        ) {
            if (game.getUuid() == Integer.parseInt(id)) {
                tempGame = game;

                return game;
            }
        }
        return tempGame;
    }

    @PostMapping()
    public ArrayList<Game> addGame(@RequestBody Game game) {
        this.gameList.add(game);
        return gameList;
    }


    @PutMapping("{id}")
    public ArrayList<Game> updateGame(@RequestBody Game game, @PathVariable int id) {
        Game gameToUpdate = gameList.stream().filter(x -> x.getUuid() == id).findFirst().orElse(null);
        if (gameToUpdate != null) {
            int index = gameList.indexOf(gameToUpdate);

            if (game.getTitle() != null) {
                gameToUpdate.setTitle(game.getTitle());
            }
            if (game.getPicture() != null) {
                gameToUpdate.setPicture(game.getPicture());
            }
            if (game.getCover_picture() != null) {
                gameToUpdate.setCover_picture(game.getCover_picture());
            }
            if (game.getDescription() != null) {
                gameToUpdate.setDescription(game.getDescription());
            }

            gameList.set(index, gameToUpdate);

            return gameList;

        } else {
            return null;
        }
    }
}
