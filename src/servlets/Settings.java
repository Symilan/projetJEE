package servlets;

import utilitaire.RegistrationForm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static utilitaire.CookieFactory.COOKIE_PLAYER;
import static utilitaire.CookieFactory.getCookieValue;
import static utilitaire.RegistrationForm.*;

public class Settings extends HttpServlet {
    @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            String idplayer = getCookieValue(req, COOKIE_PLAYER);
            this.getServletContext().getRequestDispatcher("/WEB-INF/settings.jsp").forward(req, resp);
        }

        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
        {
            Map<String, String> erreurs = new HashMap<String, String>();
            Map<String, String> valeurs = new HashMap<String, String>();
            String pseudo = RegistrationForm.getValeurChamp(req, RegistrationForm.CHAMP_PSEUDO);
            String mail = RegistrationForm.getValeurChamp(req, RegistrationForm.CHAMP_MAIL);
            String oldPassword = getValeurChamp(req, CHAMP_ANCIEN_MOTDEPASSE);
            String password = RegistrationForm.getValeurChamp(req, RegistrationForm.CHAMP_MOTDEPASSE);
            String conf_password = RegistrationForm.getValeurChamp(req, CHAMP_CONF_MOTDEPASSE);
            String preferedGames = RegistrationForm.getValeurChamp(req, RegistrationForm.CHAMP_PREFEREDGAMES);
            String birthDate_day = RegistrationForm.getValeurChamp(req, RegistrationForm.CHAMP_DATENAISSANCE_JOUR);
            String birthDate_month = RegistrationForm.getValeurChamp(req, RegistrationForm.CHAMP_DATENAISSANCE_MOIS);
            String birthDate_year = RegistrationForm.getValeurChamp(req, RegistrationForm.CHAMP_DATENAISSANCE_ANNEE);
            String birthDate = birthDate_day + "/" + birthDate_month + "/" + birthDate_year;

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


        }
}
