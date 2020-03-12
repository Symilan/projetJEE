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

    public static HashMap<Integer, Player> g(){};
}
