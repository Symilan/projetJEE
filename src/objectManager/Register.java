package objectManager;

import model.*;

import java.util.HashMap;

public class Register {

    private final HashMap<Integer, Game> GamesList;
    private final HashMap<Integer, Player> PlayersList;
    private final HashMap<Integer, GameSession> GameSessionsList;

    private Register(){
        GamesList = new HashMap<>();
        GameSessionsList = new HashMap<>();
        PlayersList = new HashMap<>();
    }

    private static class RegisterHolder {
        private final static Register MAIN_REGISTER_FACADE = new Register() ;
    }

    private static Register getRegister(){
        return Register.RegisterHolder.MAIN_REGISTER_FACADE;
    }

    public static HashMap<Integer, Game> getGamesList()
    {
        return getRegister().GamesList;
    }

    public static HashMap<Integer, GameSession> getGameSessionsList()
    {
        return getRegister().GameSessionsList;
    }

    public static HashMap<Integer, Player> getPlayersList()
    {
        return getRegister().PlayersList;
    }

    public static void addPlayer(Player player) throws Exception {
        if (!(getPlayersList().containsKey(player.getId())))
        {
            getPlayersList().put(player.getId(), player);
        }
        else
        {
            throw new Exception("Le joueur est déjà dans le Register");
        }
    }

    public static void addGame(Game game) throws Exception {
        if (!(getPlayersList().containsKey(game.getId())))
        {
            getGamesList().put(game.getId(), game);
        }
        else
        {
            throw new Exception("Le jeu est déjà dans le Register");
        }
    }

    public static void addGameSession(GameSession gameSession) throws Exception {
        if (!(getPlayersList().containsKey(gameSession.getId())))
        {
            getGameSessionsList().put(gameSession.getId(), gameSession);
        }
        else
        {
            throw new Exception("La session de jeu est déjà dans le Register");
        }
    }
}
