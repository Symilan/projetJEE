package objectManager;

import model.*;

import java.util.ArrayList;
import java.util.Date;

public class Factory {
    private Factory() { }

    private static class FactoryHolder {
        private static final Factory factory = new Factory();
    }

    public static Factory getFactory() {
        return FactoryHolder.factory;
    }

    public Game createGame(Integer id, String name, Integer nbPlayedSessions, Boolean activated)
    {
        Game game=new Game(id,name,nbPlayedSessions,activated);
        try {
            Register.addGame(game);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return game;
    }

    public Player createPlayer(Integer id, String pseudo, String mail, Date birthDate, ArrayList<String> preferedGames, Integer nbPlayedSessions, Date signInDate, Boolean banned)
    {
        Player player = new Player(id,pseudo, mail, birthDate, preferedGames, nbPlayedSessions, signInDate, banned);
        try {
            Register.addPlayer(player);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return player;
    }
}
