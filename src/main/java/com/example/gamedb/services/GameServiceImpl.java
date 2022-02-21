package com.example.gamedb.services;

import com.example.gamedb.models.Game;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GameServiceImpl implements GameService {

    ArrayList<Game> gameList = new ArrayList<>();

    public GameServiceImpl() {
        gameList.add(new Game(1, "wow", "World of Warcraft is a MMORPG based in the Warcraft universe. The player creates a character choosing from 8 races and 9 classes. Most races start in their own part of the vast world. As the races move out from their starting locations, they can meet the other races if they choose to move out through the world. Both races and classes have unique abilities, skills, and spells to help them survive in the world.", "https://www.mobygames.com/images/shots/l/91184-world-of-warcraft-windows-screenshot-creating-your-character.png", "https://www.mobygames.com/images/covers/l/38593-world-of-warcraft-macintosh-front-cover.jpg"));
        gameList.add(new Game(2, "fallout", "After World War II, rapid technology development carried humans towards a supposedly bright future, fulfilling their eternal dream. But eventually war raged again and in the year 2077, the dream suddenly came to a halt and mushroom clouds dominated the sky. A few communities survived in their underground bunkers called \"Vaults\"; others mutated heavily. Overall, what was left of the world was nothing more than a nuclear wasteland filled with ruins of a once great civilization. Two hundred years later, the human kind slowly but surely leaves the vaults and reclaims the lands of Earth.\n", "https://www.mobygames.com/images/shots/l/505310-fallout-3-playstation-3-screenshot-main-menu.jpg", "https://www.mobygames.com/images/covers/l/136938-fallout-3-windows-front-cover.jpg"));
        gameList.add(new Game(3, "god of war", "God of War is a soft reboot of Sony's long-running series of action games. While the originals were set within Greek mythology, the new title takes place after the original games within the world of Norse mythology. Kratos now resides in Midgard along with his son Atreus. After encountering a mysterious stranger covered in tattoos, Kratos and Atreus set out on a long and dangerous journey through the Nine Realms to scatter his dead wife's ashes from atop the highest mountain peak in Midgard.\n" +
                "\n" +
                "Unlike the original games, God of War utilizes a freely controllable third-person camera. Kratos now makes use of the Leviathan Axe, which has frost-damaging capabilities to freeze enemies in place, and can be thrown and summoned back to Kratos' hand at will. Kratos also has a shield that can be used to block and parry incoming attacks. Kratos can also use his fists to attack enemies, this can stun enemies and allows Kratos to execute finishing moves. In addition, his son Atreus can fire arrows at enemies and summon animals. Attacking enemies and collecting certain items raises Kratos' rage meter. After it is full, Kratos can use Spartan Rage, which greatly increases his attack power and speed, making him virtually unstoppable for a short time.", "https://www.mobygames.com/images/shots/l/944058-god-of-war-playstation-4-screenshot-splash-screen.jpg", "https://www.mobygames.com/images/covers/l/474565-god-of-war-playstation-4-front-cover.png"));
        gameList.add(new Game(4, "Dota2", "Dota 2 is the official sequel to Defense of the Ancients, a fan-made map of Warcraft III: Reign of Chaos, introducing an extensive selection of new heroes and items. Primarily meant for online multiplayer, the game also offers offline play for matches against bots.\n" +
                "\n" +
                "Similar to its predecessor, this game offers the same type of gameplay: consisting of two teams that has to destroy all opposing structures. Each team consists of a party of heroes and supporting non-player characters (NPCs) known as creepers. The player controls one these heroes, together with other heroes and creepers, attempt to push forward into enemy territory while also coordinating defense against enemy intrusions. Creepers on both sides continually respawn and will gradually increase in numbers and strength as the game progresses. Fallen heroes will suffer a timeout and will eventually respawn at the starting location.\n" +
                "\n" +
                "Heroes acquire experience during combat, simply by being in the area when an adjacent enemy falls. Slightly more experience is awarded if the hero deals the killing blow. Sufficient experience allows the player's hero to level up and choose new skills, consisting of three basic skills and one unique expert skill after the hero has reached level 6. Each skill may also be increased in its level as the hero gains more levels. Some skills may require specific items before it can be upgraded. Unlike its predecessor, leveling up stats (strength, agility, intelligence) is now automatic.\n" +
                "\n" +
                "Gold is steadily received at a rate of one per second once combat start is announced, however greater gold rewards are obtained by delivering killing blows to enemies; the most rewarding being a killing blow to another hero. Gold may then be used to purchase items at stores. A combination of certain items may be used as a recipe to upgrade the items into a single more powerful item. A hero may only carry six items, additional items will be deposited in a stash inventory at the base and may be retrieved manually or via an animal courier.", "https://www.mobygames.com/images/promo/original/1471162549-3475988976.jpg", "https://www.mobygames.com/images/covers/l/274887-dota-2-linux-front-cover.jpg"));
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
