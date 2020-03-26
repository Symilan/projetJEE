package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import model.*;
import objectManager.Factory;
import objectManager.Register;
import utilitaire.*;

import static utilitaire.RegistrationForm.*;


public class Registration extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/registration.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String resultat;
        Map<String, String> erreurs = new HashMap<String, String>();
        Map<String, String> valeurs = new HashMap<String, String>();
        String pseudo = RegistrationForm.getValeurChamp(req, RegistrationForm.CHAMP_PSEUDO);
        String mail = RegistrationForm.getValeurChamp(req, RegistrationForm.CHAMP_MAIL);
        String password = RegistrationForm.getValeurChamp(req, RegistrationForm.CHAMP_MOTDEPASSE);
        String conf_password = RegistrationForm.getValeurChamp(req, CHAMP_CONF_MOTDEPASSE);
        String preferedGames = RegistrationForm.getValeurChamp(req, RegistrationForm.CHAMP_PREFEREDGAMES);
        String birthDate_day = RegistrationForm.getValeurChamp(req, RegistrationForm.CHAMP_DATENAISSANCE_JOUR);
        String birthDate_month = RegistrationForm.getValeurChamp(req, RegistrationForm.CHAMP_DATENAISSANCE_MOIS);
        String birthDate_year = RegistrationForm.getValeurChamp(req, RegistrationForm.CHAMP_DATENAISSANCE_ANNEE);
        String birthDate = birthDate_day + "/" + birthDate_month + "/" + birthDate_year;

        Player player = null;

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
            resultat = "Inscription réussie";
            //DAO créer le joueur
            player = new Player(pseudo, mail, birthDate, preferedGames);
            req.setAttribute("pseudo", pseudo);
            this.getServletContext().getRequestDispatcher("/WEB-INF/authentification.jsp").forward(req, resp);

        } else
        {
            resultat = "Inscription échouée";
            req.setAttribute("erreurs", erreurs);
            req.setAttribute("valeurs", valeurs);
            this.getServletContext().getRequestDispatcher("/WEB-INF/registration.jsp").forward(req, resp);
        }
    }






}
