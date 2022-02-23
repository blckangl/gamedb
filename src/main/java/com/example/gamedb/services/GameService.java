package com.example.gamedb.services;

import com.example.gamedb.models.Game;

import java.util.ArrayList;

public interface GameService {

    ArrayList<Game> getGames();

    Game getGameById(long id);
    Game getGameByTitle(String title);

    Game updateGame(int id, Game game);

    Game deleteGame(int id);

    Game createGame(Game game);
}
