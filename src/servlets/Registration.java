package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import objectManager.RequestHandler;

import static utilitaire.RegistrationForm.*;

/**
 * This class represent the Registration servlet
 */
public class Registration extends HttpServlet {

    /**
     * GET Method
     * GET Method is called when the user enter the page
     * @param req                   The HTTP request
     * @param resp                  The HTTP response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/registration.jsp").forward(req, resp);
    }

    /**
     * POST Method
     * POST Method is called when the user press the "Confirmation" button.
     * It reads all the field and then create a player in the database.
     * @param req                   The HTTP request
     * @param resp                  The HTTP response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        /*
        It reads every field
         */
        Map<String, String> erreurs = new HashMap<String, String>();
        Map<String, String> valeurs = new HashMap<String, String>();
        String pseudo = getValeurChamp(req, CHAMP_PSEUDO);
        String mail = getValeurChamp(req, CHAMP_MAIL);
        String password = getValeurChamp(req, CHAMP_MOTDEPASSE);
        String conf_password = getValeurChamp(req, CHAMP_CONF_MOTDEPASSE);
        String preferedGames = getValeurChamp(req, CHAMP_PREFEREDGAMES);
        String birthDate_day = getValeurChamp(req, CHAMP_DATENAISSANCE_JOUR);
        String birthDate_month = getValeurChamp(req, CHAMP_DATENAISSANCE_MOIS);
        String birthDate_year = getValeurChamp(req, CHAMP_DATENAISSANCE_ANNEE);
        String birthDate = birthDate_day + "/" + birthDate_month + "/" + birthDate_year;

        /*
        It tries if every field is well filled
         */
        try
        {
            validationMail(mail);
        } catch (Exception e) {
            erreurs.put(CHAMP_MAIL, e.getMessage());
        }
        valeurs.put(CHAMP_MAIL, mail);

        try
        {
            validationPseudo(pseudo, 0, true);
        } catch (Exception e)
        {
            erreurs.put(CHAMP_PSEUDO, e.getMessage());
        }
        valeurs.put(CHAMP_PSEUDO, pseudo);

        try
        {
            validationPassword(password, conf_password);
        } catch (Exception e)
        {
            erreurs.put(CHAMP_MOTDEPASSE, e.getMessage());
        }


        try
        {
            validationDate(birthDate_day, birthDate_month, birthDate_year);
        }
        catch (Exception e)
        {
            erreurs.put(CHAMP_DATENAISSANCE_ANNEE, e.getMessage());
        }

        valeurs.put(CHAMP_DATENAISSANCE_JOUR, birthDate_day);
        valeurs.put(CHAMP_DATENAISSANCE_MOIS, birthDate_month);
        valeurs.put(CHAMP_DATENAISSANCE_ANNEE, birthDate_year);

        valeurs.put(CHAMP_PREFEREDGAMES, preferedGames);

        /*
        If there is no error, it creates a player and add it to the database, then redirect the player towards the authentification page
         */
        if (erreurs.isEmpty())
        {
            RequestHandler.getRequestHandler().register(pseudo, mail, password, preferedGames, birthDate);
            req.setAttribute("pseudo", pseudo);
            this.getServletContext().getRequestDispatcher("/WEB-INF/authentification.jsp").forward(req, resp);

        } else
            /*
            Else, it reload the page with errors set and field already filled as the user filled them.
             */
        {
            req.setAttribute("erreurs", erreurs);
            req.setAttribute("valeurs", valeurs);
            this.getServletContext().getRequestDispatcher("/WEB-INF/registration.jsp").forward(req, resp);
        }
    }
}
