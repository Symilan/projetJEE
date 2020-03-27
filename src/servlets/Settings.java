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

public class Settings extends HttpServlet {
    @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            Map<String, String> valeurs = new HashMap<String, String>();
            String idplayer = getCookieValue(req, COOKIE_PLAYER);

            Player player = RequestHandler.getRequestHandler().getPlayerFromId(Integer.parseInt(idplayer));
            System.out.println(player.getPreferedGames());

            valeurs.put(CHAMP_PSEUDO, player.getPseudo());
            valeurs.put(CHAMP_MAIL, player.getMail());
            valeurs.put(CHAMP_DATENAISSANCE_JOUR, player.getBirthDate().substring(0,1));
            valeurs.put(CHAMP_DATENAISSANCE_MOIS, player.getBirthDate().substring(3,4));
            valeurs.put(CHAMP_DATENAISSANCE_ANNEE, player.getBirthDate().substring(6,9));
            valeurs.put(CHAMP_PREFEREDGAMES, player.getPreferedGames());
            req.setAttribute("valeurs", valeurs);
            setCookie(resp, COOKIE_PLAYER, player.getId().toString(), COOKIE_MAX_AGE);

            this.getServletContext().getRequestDispatcher("/WEB-INF/settings.jsp").forward(req, resp);
        }

        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
        {
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

            try
            {
                validationMail(mail);
            } catch (Exception e) {
                erreurs.put(CHAMP_MAIL, e.getMessage());
            }
            valeurs.put(CHAMP_MAIL, mail);

            try
            {
                validationPseudo(pseudo);
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


            valeurs.put(CHAMP_PREFEREDGAMES, preferedGames);

            if (erreurs.isEmpty())
            {
                //Modification enregistrées
            }
            else
            {
                req.setAttribute("erreurs", erreurs);
                req.setAttribute("valeurs", valeurs);
                this.getServletContext().getRequestDispatcher("/WEB-INF/settings.jsp").forward(req, resp);
            }

            setCookie(resp, COOKIE_PLAYER, player.getId().toString(), COOKIE_MAX_AGE);

        }
}
