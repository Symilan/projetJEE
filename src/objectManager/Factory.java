package objectManager;

import model.*;

import java.util.Date;

public class Factory {
    private Factory() {
    }

    private static class FactoryHolder {
        private static final Factory factory = new Factory();
    }

    /**
     * Used to get the factory singleton
     * @return singleton factory
     */
    public static Factory getFactory() {
        return FactoryHolder.factory;
    }

    /**
     * Creates a new game in the model
     * @param id of the new game
     * @param name of the new game
     * @param nbPlayedSessions of the new game
     * @param activated indicates if the new game is activated
     * @return the new Game
     */
    public Game createGame(Integer id, String name, Integer nbPlayedSessions, Boolean activated) {
        Game game = new Game(id, name, nbPlayedSessions, activated);
        return game;
    }

    /**
     * Creates a new player in the model
     * @param id of the new player
     * @param pseudo of the new player
     * @param mail of the new player
     * @return the new game
     */
    public Player createPlayer(Integer id, String pseudo, String mail){
        Player player = new Player(id, pseudo, mail);
        return player;
    }

    /**
     * Creates a new player
     * @param id of the new player
     * @param pseudo of the new player
     * @param mail of the new player
     * @param birthDate of the new player
     * @param preferedGames of the new player
     * @param nbPlayedSessions of the new player
     * @param registerDate of the new player
     * @param banned of the new player
     * @return the new player
     */
    public Player createPlayer(Integer id, String pseudo, String mail, String birthDate, String preferedGames, Integer nbPlayedSessions, Date registerDate, Boolean banned) {
        Player player = new Player(id, pseudo, mail, birthDate, preferedGames, nbPlayedSessions, registerDate, banned);
        return player;
    }

    /**
     * Creates a new game session
     * @param id of the new game session
     * @param duration of the new game session
     * @param game of the new game session
     * @param score of the new game session
     * @param player of the new game session
     * @param beginningDate of the new game session
     * @param endingDate of the new game session
     * @return the new game session
     */
    public GameSession createGameSession(Integer id, Integer duration, Game game, Integer score, Player player, Date beginningDate, Date endingDate) {
        GameSession gameSession = new GameSession(id, duration, game, score, player, beginningDate, endingDate);
        return gameSession;
    }
}
