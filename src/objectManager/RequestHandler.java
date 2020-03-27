package objectManager;

import model.Game;
import model.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Manage the DataBase connexion and requests
 */
public class RequestHandler {
    /* Connexion à la base de données */
    private String url = "jdbc:mysql://vps.tonychouteau.fr:3306/JEEux_fr";
    private String utilisateur = "enssatJEEux";
    private String motDePasse = "vamt_JEEux_fr";
    protected Connection connexion = null;

    private RequestHandler(){
        /* Chargement du driver JDBC pour MySQL */
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch ( ClassNotFoundException e ) {
            /* Gérer les éventuelles erreurs ici. */
        }
    }

    private static class RequestHandlerHolder {
        private static final RequestHandler MAIN_REQUEST_HANDLER_FACADE=new RequestHandler();
    }

    public static RequestHandler getRequestHandler()
    {
        return RequestHandlerHolder.MAIN_REQUEST_HANDLER_FACADE;
    }

    /**
     * initialize connexion to grant access to the online DataBase
     */
    protected void connect(){
        try {
            connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Try to authentificate a player from a pseudo and a password
     * @param username the pseudo entered in the TextField
     * @param password the password entered in the TextField
     * @return the player matching, or null if no player was found
     */
    public Player authenticate(String username,String password){
        PreparedStatement statement = null;
        ResultSet resultat = null;
        Player player = null;
        try{
            this.connect();
            /* Création de l'objet gérant les requêtes */
            statement = connexion.prepareStatement("SELECT id,pseudo,mail FROM user WHERE pseudo=? AND password=?;");
            statement.setString(1,username);
            statement.setString(2,password);
            /* Exécution d'une requête de lecture */
            resultat = statement.executeQuery();


            /* Récupération des données du résultat de la requête de lecture */
            while ( resultat.next() ) {
                int id = resultat.getInt( "id" );
                String mail = resultat.getString("mail");
                String pseudo = resultat.getString("pseudo");
                System.out.println(resultat.getInt( "id" ));
                player = Factory.getFactory().createPlayer(id,pseudo,mail);
            }
            connexion.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return player;
    }

    /**
     * Register a new player in the DataBase
     * @param pseudo pseudo entered in the TextField
     * @param mail mail entered in the TextField
     * @param password password entered in the TextField
     * @param pref_games prefered games entered in the TextField
     * @param birth birthdate recomposed from the TextFields
     * @return a Boolean indicating if the operation was successfull
     */
    public Boolean register(String pseudo,String mail,String password,String pref_games,String birth){
        PreparedStatement statement = null;
        int id ;
        try {
            this.connect();
            id = new RequestHandler().getAvailableId();
            /* Création de l'objet gérant les requêtes */
            statement = connexion.prepareStatement("INSERT INTO user(id,pseudo,prefered_games,mail,password,birth_date) " +
                    "VALUES (?,?,?,?,?,?);");
            statement.setInt(1, id);
            statement.setString(2,pseudo);
            statement.setString(3,pref_games);
            statement.setString(4,mail);
            statement.setString(5,password);
            statement.setString(6,birth);
            /* Exécution d'une requête de lecture */
            statement.execute();
            connexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }

    /**
     * Create a non existing new id randomly
     * @return the new id
     */
    private Integer getAvailableId() {
        PreparedStatement statement = null;
        ResultSet resultat = null;
        Integer id = 0;
        Boolean found = false ;
        Random random = new Random();
        try{
            this.connect();
            do {
                id = random.nextInt(1000000)+ 1;
                /* Création de l'objet gérant les requêtes */
                statement = connexion.prepareStatement("SELECT id FROM user WHERE id=?;");
                statement.setInt(1,id);
                /* Exécution d'une requête de lecture */
                resultat = statement.executeQuery();
                /* Récupération des données du résultat de la requête de lecture */
                if(!resultat.next()) {
                   found = true ;
                }
            }while(!found);
            connexion.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return id ;
    }

    public Player getPlayerFromId(Integer id)
    {
        PreparedStatement statement = null;
        ResultSet result=null;
        Player player=null;
        try{
            this.connect();
            statement=connexion.prepareStatement("SELECT pseudo,mail,birth_date,prefered_games,nb_game_sessions,register_date,banned FROM user WHERE id=?;");
            statement.setInt(1,id);
            result=statement.executeQuery();
            while (result.next()){
                String pseudo = result.getString("pseudo");
                String mail = result.getString("mail");
                String birthDate = result.getString("birth_date");
                String preferedGames = result.getString("prefered_games");
                Integer nbPlayedSessions = result.getInt("nb_game_sessions");
                Date registerDate = result.getDate("register_date");
                Boolean banned = (result.getString("banned")=="inactive");
                player = Factory.getFactory().createPlayer(id,pseudo,mail,birthDate,preferedGames,nbPlayedSessions,registerDate,banned);
            }
            connexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return player;
    }

    public ArrayList<Game> getEnabledGames()
    {
        PreparedStatement statement = null;
        ResultSet result=null;
        ArrayList<Game> gameList = new ArrayList<>();
        try {
            this.connect();
            statement=connexion.prepareStatement("SELECT * FROM game WHERE activated=1;");
            result=statement.executeQuery();
            while (result.next())
            {
                Integer id= result.getInt("id");
                String name= result.getString("name");
                Integer nbPlayedSessions=result.getInt("nb_played_sessions");
                Boolean activated=(result.getInt("activated")==1);
                gameList.add(Factory.getFactory().createGame(id,name,nbPlayedSessions,activated));
            }
            connexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gameList;
    }

    public static void main(String[] args) {
        System.out.println(RequestHandler.getRequestHandler().getEnabledGames());
    }
}
