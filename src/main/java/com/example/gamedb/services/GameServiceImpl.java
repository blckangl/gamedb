package com.example.gamedb.services;

import com.example.gamedb.models.Game;
import com.example.gamedb.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GameServiceImpl implements GameService {

    ArrayList<Game> gameList = new ArrayList<>();

    @Autowired
    GameRepository gameRepository;

    public GameServiceImpl() {
    }

    @Override
    public ArrayList<Game> getGames() {

        return new ArrayList<>(gameRepository.findAll());

    }

    @Override
    public Game getGameById(long id) {
        return gameRepository.findById(id).orElse(null);
    }

    @Override
    public Game getGameByTitle(String title) {
        Game game = gameRepository.findByTitle(title);
        if(game != null){
            return game;
        }
        return null;
    }

    @Override
    public Game updateGame(int id, Game game) {
        return null;
    }

    @Override
    public Game deleteGame(int id) {
        return null;
    }

    @Override
    public Game createGame(Game game) {
        return null;
    }
//
//    @Override
//    public Game getGameById(int id) {
//        return gameList.stream().filter(x -> x.getUuid() == id).findFirst().orElse(null);
//    }
//
//    @Override
//    public Game updateGame(int id, Game game) {
//        Game gameToUpdate = gameList.stream().filter(x -> x.getUuid() == id).findFirst().orElse(null);
//        if (gameToUpdate != null) {
//            int index = gameList.indexOf(gameToUpdate);
//
//            if (game.getTitle() != null) {
//                gameToUpdate.setTitle(game.getTitle());
//            }
//            if (game.getPicture() != null) {
//                gameToUpdate.setPicture(game.getPicture());
//            }
//            if (game.getCover_picture() != null) {
//                gameToUpdate.setCover_picture(game.getCover_picture());
//            }
//            if (game.getDescription() != null) {
//                gameToUpdate.setDescription(game.getDescription());
//            }
//
//            gameList.set(index, gameToUpdate);
//
//            return gameToUpdate;
//        }
//
//        return null;
//    }
//
//    @Override
//    public Game deleteGame(int id) {
////        Game gameToDelete = gameList.stream().filter(x -> x.getUuid() == id).findFirst().orElse(null);
////        gameList.removeIf(x -> x.getUuid() == id);
////        return gameToDelete;
//    }
//
//    @Override
//    public Game createGame(Game game) {
////        this.gameList.add(game);
////
////        return game;
//    }
}
