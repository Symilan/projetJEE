package objectManager;

import model.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Register {
    private final HashMap<Integer, Game> GamesList;
    private final HashMap<Integer, Player> PlayersList;
    private final HashMap<Integer, GameSession> GameSessionsList;

    private Register() {
        GamesList = new HashMap<>();
        GameSessionsList = new HashMap<>();
        PlayersList = new HashMap<>();
    }

    private static class RegisterHolder {
        private final static Register MAIN_REGISTER_FACADE = new Register();
    }

    private static Register getRegister() {
        return Register.RegisterHolder.MAIN_REGISTER_FACADE;
    }

    public static HashMap<Integer, Game> getGameMap() {
        return getRegister().GamesList;
    }

    public static HashMap<Integer, GameSession> getGameSessionMap() {
        return getRegister().GameSessionsList;
    }

    public static HashMap<Integer, Player> getPlayerMap() {
        return getRegister().PlayersList;
    }

    public static ArrayList<Game> getActivatedGamesList()
    {
        ArrayList<Game> gameList = new ArrayList<>(Register.getGameMap().values());
        ArrayList<Game> activatedGameList = new ArrayList<>();
        for (Game game : gameList)
        {
            if (game.getActivated())
            {
                activatedGameList.add(game);
            }
        }
        return activatedGameList;
    }

    public static void addPlayer(Player player) throws Exception {
        if (!(getPlayerMap().containsKey(player.getId()))) {
            getPlayerMap().put(player.getId(), player);
        } else {
            throw new Exception("Le joueur est déjà dans le Register");
        }
    }

    public static void addGame(Game game) throws Exception {
        if (!(getPlayerMap().containsKey(game.getId()))) {
            getGameMap().put(game.getId(), game);
        } else {
            throw new Exception("Le jeu est déjà dans le Register");
        }
    }

    public static void addGameSession(GameSession gameSession) throws Exception {
        if (!(getPlayerMap().containsKey(gameSession.getId()))) {
            getGameSessionMap().put(gameSession.getId(), gameSession);
        } else {
            throw new Exception("La session de jeu est déjà dans le Register");
        }
    }

}
