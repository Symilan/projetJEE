package objectManager;


//import com.mysql.cj.xdevapi.Statement;
import model.Player;


import java.sql.*;

import static objectManager.Factory.getFactory;

public class RequestHandler {
    /* Connexion à la base de données */
    private String url = "jdbc:mysql://vps.tonychouteau.fr:3306/JEEux_fr";
    private String utilisateur = "enssatJEEux";
    private String motDePasse = "vamt_JEEux_fr";
    protected Connection connexion = null;

    public RequestHandler(){
        /* Chargement du driver JDBC pour MySQL */
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch ( ClassNotFoundException e ) {
            /* Gérer les éventuelles erreurs ici. */
        }
    }

    protected void connect(){
        try {
            connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

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

    public static void main(String[] args) {
        Player noob ;
        RequestHandler req = new RequestHandler();
        req.connect();
        noob = req.authenticate("noobmaster","AZERTY");
        System.out.println(noob);
    }
}
