package com.example.gamedb.services;

import com.example.gamedb.models.Game;

import java.util.ArrayList;

public interface GameService {

    ArrayList<Game> getGames();

    Game getGameById(int id);

    Game updateGame(int id, Game game);

    Game deleteGame(int id);

    Game createGame(Game game);
}
