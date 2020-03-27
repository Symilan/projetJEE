package objectManager;



import model.Game;
import model.GameSession;
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
            statement = connexion.prepareStatement("SELECT id FROM user WHERE pseudo=? AND password=MD5(?);");
            statement.setString(1,username);
            statement.setString(2,password);
            /* Exécution d'une requête de lecture */
            resultat = statement.executeQuery();


            /* Récupération des données du résultat de la requête de lecture */
            while ( resultat.next() ) {
                int id = resultat.getInt( "id" );
                player = getPlayerFromId(id);
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
            statement = connexion.prepareStatement("INSERT INTO user(id,pseudo,prefered_games,mail,password,birth_date,register_date) " +
                    "VALUES (?,?,?,?,MD5(?),?,?);");
            statement.setInt(1, id);
            statement.setString(2,pseudo);
            statement.setString(3,pref_games);
            statement.setString(4,mail);
            statement.setString(5,password);
            statement.setString(6,birth);
            statement.setDate(7,new Date(System.currentTimeMillis()));
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
                statement = connexion.prepareStatement("SELECT id FROM user,game_session,game WHERE user.id=? OR game_session.id=? OR game.id=?;");
                statement.setInt(1,id);
                statement.setInt(2,id);
                statement.setInt(3,id);
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
                Boolean banned = result.getString("banned")=="false" ;
                player = Factory.getFactory().createPlayer(id,pseudo,mail,birthDate,preferedGames,nbPlayedSessions,registerDate,banned) ;
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

    public Boolean saveGameSession(GameSession gameSession){
        PreparedStatement statement = null;
        PreparedStatement playerStatement ;
        PreparedStatement gameStatement = null;
        int id ;
        try {
            this.connect();
            id = new RequestHandler().getAvailableId();
            /* Création de l'objet gérant les requêtes */
            statement = connexion.prepareStatement("INSERT INTO game_session(id,id_game,id_player,duration,beginning_date,ending_date,score) " +
                    "VALUES (?,?,?,?,?,?,?);");
            playerStatement = connexion.prepareStatement("UPDATE user SET nb_game_sessions = ? WHERE id=?");
            gameStatement =  connexion.prepareStatement("UPDATE game SET nb_played_sessions = ? WHERE id=?");
            statement.setInt(1, id);
            statement.setInt(2,gameSession.getGame().getId());
            statement.setInt(3,gameSession.getPlayer().getId());
            statement.setTime(4,new Time(gameSession.getDuration()));
            statement.setDate(5, (Date) gameSession.getBeginningDate());
            statement.setDate(6, (Date) gameSession.getEndingDate());
            statement.setInt(7,gameSession.getScore());
            gameSession.getPlayer().setNbPlayedSessions(gameSession.getPlayer().getNbPlayedSessions()+1);
            playerStatement.setInt(1,gameSession.getPlayer().getNbPlayedSessions());
            playerStatement.setInt(2,gameSession.getPlayer().getId());
            gameSession.getGame().setNbPlayedSessions(gameSession.getGame().getNbPlayedSessions()+1);
            gameStatement.setInt(1,gameSession.getGame().getNbPlayedSessions());
            gameStatement.setInt(2,gameSession.getGame().getId());
            /* Exécution d'une requête de lecture */
            statement.execute();
            playerStatement.executeUpdate();
            gameStatement.executeUpdate();
            connexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true ;
    }

    public void updatePlayer(Integer id, String pseudo, String preferedGames, String mail){
        PreparedStatement statement = null;
        this.connect();
        try {
        statement = connexion.prepareStatement("UPDATE user SET pseudo=?, prefered_games=?, mail=? WHERE id=?;");
        statement.setString(1, pseudo);
        statement.setString(2, preferedGames);
        statement.setString(3, mail);
        statement.setInt(4, id);
        statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void updatePassword(Integer id, String password) {
        PreparedStatement statement = null;
        try {
            this.connect();
            statement = connexion.prepareStatement("UPDATE user SET password=MD5(?) WHERE id=?;");
            statement.setString(1, password);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Player getPlayerFromPseudo(String pseudo)
    {
        PreparedStatement statement = null;
        ResultSet result=null;
        Player player=null;
        try{
            this.connect();
            statement=connexion.prepareStatement("SELECT * FROM user WHERE pseudo=?;");
            statement.setString(1,pseudo);
            result=statement.executeQuery();
            while (result.next()){
                Integer id = result.getInt("id");
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

    public static void main(String[] args) {
        Player noob ;
        RequestHandler req = new RequestHandler();
        req.register("Thelegend27","dankmemssat@enssat.fr","azerty","Minecraft, ECTS HUnter","04/12/2012");
        noob = req.authenticate("Thelegend27","azerty");
        System.out.println(noob);
    }
}
