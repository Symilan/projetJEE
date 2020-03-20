package utilitaire;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationForm {
    private static final String CHAMP_PSEUDO = "tfa_6980290243481-L";
    private static final String CHAMP_MAIL = "tfa_6980290243482-L";

    private String              resultat;

    private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
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
