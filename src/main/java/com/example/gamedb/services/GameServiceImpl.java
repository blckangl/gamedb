package com.example.gamedb.services;

import com.example.gamedb.models.Game;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GameServiceImpl implements GameService {

    ArrayList<Game> gameList = new ArrayList<>();

    public GameServiceImpl() {
        gameList.add(new Game(1, "wow", "mmorpg game", "", ""));
        gameList.add(new Game(2, "fallout", "rpg game", "", ""));
        gameList.add(new Game(3, "god of war", "action game", "", ""));
    }

    @Override
    public ArrayList<Game> getGames() {
        return gameList;
    }

    @Override
    public Game getGameById(int id) {
        return gameList.stream().filter(x -> x.getUuid() == id).findFirst().orElse(null);
    }

    @Override
    public Game updateGame(int id, Game game) {
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

            return gameToUpdate;
        }

        return null;
    }

    @Override
    public Game deleteGame(int id) {
        Game gameToDelete = gameList.stream().filter(x -> x.getUuid() == id).findFirst().orElse(null);
        gameList.removeIf(x -> x.getUuid() == id);
        return gameToDelete;
    }

    @Override
    public Game createGame(Game game) {
        this.gameList.add(game);

        return game;
    }
}
