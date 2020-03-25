package objectManager;

import java.sql.Connection;

public class RequestHandler {
    /* Connexion à la base de données */
    String url = "jdbc:mysql://vps.tonychouteau.fr:3306/JEEux_fr";
    String utilisateur = "enssatJEEux";
    String motDePasse = "vamt_JEEux_fr";
    Connection connexion = null;

    public RequestHandler(){
        /* Chargement du driver JDBC pour MySQL */
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch ( ClassNotFoundException e ) {
            /* Gérer les éventuelles erreurs ici. */
        }
    }
}
