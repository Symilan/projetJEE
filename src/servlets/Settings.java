package servlets;

import objectManager.RequestHandler;
import utilitaire.RegistrationForm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import model.*;

import static utilitaire.CookieFactory.*;
import static utilitaire.RegistrationForm.*;

/**
 * This class represent the Settings servlet
 */
public class Settings extends HttpServlet {
    /**
     * GET Method
     * We need to get the value of the different fields to complete them with user's personal information
     * @param req                   The HTTP request
     * @param resp                  The HTTP response
     * @throws ServletException
     * @throws IOException
     */
    @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            /*
            We pre-entered all the fields with player's information
             */
            Map<String, String> valeurs = new HashMap<String, String>();
            String idplayer = getCookieValue(req, COOKIE_PLAYER);
            Player player = RequestHandler.getRequestHandler().getPlayerFromId(Integer.parseInt(idplayer));
            valeurs.put(CHAMP_PSEUDO, player.getPseudo());
            valeurs.put(CHAMP_MAIL, player.getMail());
            valeurs.put(CHAMP_DATENAISSANCE_JOUR, player.getBirthDate().substring(0,2));
            valeurs.put(CHAMP_DATENAISSANCE_MOIS, player.getBirthDate().substring(3,5));
            valeurs.put(CHAMP_DATENAISSANCE_ANNEE, player.getBirthDate().substring(6,10));
            valeurs.put(CHAMP_PREFEREDGAMES, player.getPreferedGames());
            valeurs.put(CHAMP_NBSESSION, player.getNbPlayedSessions().toString());
            req.setAttribute("valeurs", valeurs);

            /*
            Then we display the web page
             */
            this.getServletContext().getRequestDispatcher("/WEB-INF/settings.jsp").forward(req, resp);
        }

    /**
     * POST Method
     * POST Method is called if the user press either "Modifier" or "Deconnexion", and does something according to the
     * pressed button.
     * If the user press "Modifier", then it will save the changes that he made.
     * If the user press "Deconnexion", then he will disconnect.
     * @param req                   HTTP request
     * @param resp                  HTTP response
     * @throws ServletException
     * @throws IOException
     */
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
        {
            /*
            If the user pressed "Deconnexion", he wants to disconnect, so we delete his cookie
             */
            if (req.getParameter("Deconnexion") != null)
            {
                setCookie(resp, COOKIE_PLAYER, "", 0);
                this.getServletContext().getRequestDispatcher("/WEB-INF/authentification.jsp").forward(req, resp);
            }
            /*
            Else, it means that he pressed "Modifier", he wants to modify his information
            We take every field and we check it, then we save the changes
             */
            else {
                String idplayer = getCookieValue(req, COOKIE_PLAYER);
                Player player = RequestHandler.getRequestHandler().getPlayerFromId(Integer.parseInt(idplayer));
                Map<String, String> erreurs = new HashMap<String, String>();
                Map<String, String> valeurs = new HashMap<String, String>();
                String pseudo = RegistrationForm.getValeurChamp(req, RegistrationForm.CHAMP_PSEUDO);
                String mail = RegistrationForm.getValeurChamp(req, RegistrationForm.CHAMP_MAIL);
                String oldPassword = getValeurChamp(req, CHAMP_ANCIEN_MOTDEPASSE);
                String password = RegistrationForm.getValeurChamp(req, RegistrationForm.CHAMP_MOTDEPASSE);
                String conf_password = RegistrationForm.getValeurChamp(req, CHAMP_CONF_MOTDEPASSE);
                String preferedGames = RegistrationForm.getValeurChamp(req, RegistrationForm.CHAMP_PREFEREDGAMES);



                try {
                    validationMail(mail);
                } catch (Exception e) {
                    erreurs.put(CHAMP_MAIL, e.getMessage());
                }
                valeurs.put(CHAMP_MAIL, mail);

                try {
                    validationPseudo(pseudo, Integer.parseInt(idplayer), false);
                } catch (Exception e) {
                    erreurs.put(CHAMP_PSEUDO, e.getMessage());
                }
                valeurs.put(CHAMP_PSEUDO, pseudo);


                if (oldPassword != null)
                {
                    try
                    {
                        RequestHandler.getRequestHandler().authenticate(RequestHandler.getRequestHandler().getPlayerFromId(Integer.parseInt(idplayer)).getPseudo(), oldPassword);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    try {
                        validationPassword_opt(password, conf_password);
                    } catch (Exception e) {
                        erreurs.put(CHAMP_MOTDEPASSE, e.getMessage());
                    }
                }
                else if (password != null)
                {
                    erreurs.put(CHAMP_MOTDEPASSE, "Vous ne pouvez pas changer de mot de passe sans rentrer l'ancien.");
                }


                valeurs.put(CHAMP_DATENAISSANCE_JOUR, player.getBirthDate().substring(0,2));
                valeurs.put(CHAMP_DATENAISSANCE_MOIS, player.getBirthDate().substring(3,5));
                valeurs.put(CHAMP_DATENAISSANCE_ANNEE, player.getBirthDate().substring(6,10));
                valeurs.put(CHAMP_PREFEREDGAMES, preferedGames);
                valeurs.put(CHAMP_NBSESSION, player.getNbPlayedSessions().toString());


                /*
                If there's no errors
                 */
                if (erreurs.isEmpty()) {
                    //User's information's modification
                    try {
                        RequestHandler.getRequestHandler().updatePlayer(Integer.parseInt(idplayer), pseudo, preferedGames, mail);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (password != null && oldPassword != null)
                    {
                        RequestHandler.getRequestHandler().updatePassword(Integer.parseInt(idplayer), password);
                    }
                    req.setAttribute("valeurs", valeurs);
                    this.getServletContext().getRequestDispatcher("/WEB-INF/settings.jsp").forward(req, resp);
                } else {
                    /*
                    We show where mistakes are.
                     */
                    req.setAttribute("erreurs", erreurs);
                    req.setAttribute("valeurs", valeurs);
                    this.getServletContext().getRequestDispatcher("/WEB-INF/settings.jsp").forward(req, resp);
                }
            }


        }
}
