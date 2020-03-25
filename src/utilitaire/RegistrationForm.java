package utilitaire;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationForm {
    public static final String CHAMP_PSEUDO = "pseudo";
    public static final String CHAMP_MAIL = "mailAdress";
    public static final String CHAMP_MOTDEPASSE = "password";
    public static final String CHAMP_CONF_MOTDEPASSE = "passwordConfirmed";
    public static final String CHAMP_PREFERREDGAMES = "preferredGames";
    public static final String CHAMP_DATENAISSANCE_JOUR = "birthdate_day";
    public static final String CHAMP_DATENAISSANCE_MOIS = "birthdate_month";
    public static final String CHAMP_DATENAISSANCE_ANNEE = "birthdate_year";

    private String resultat;
    public static String getValeurChamp(HttpServletRequest request, String nomChamp) {
        String valeur = request.getParameter(nomChamp);
        if (valeur == null || valeur.trim().length() == 0)
        {
            return null;
        }
        else
        {
            return valeur;
        }
    }

}
