package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import model.*;
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
        Map<String, String> erreurs = new HashMap<String, String>() ;
        String pseudo = RegistrationForm.getValeurChamp(req, RegistrationForm.CHAMP_PSEUDO);
        String mail = RegistrationForm.getValeurChamp(req, RegistrationForm.CHAMP_MAIL);
        String password = RegistrationForm.getValeurChamp(req, RegistrationForm.CHAMP_MOTDEPASSE);
        String conf_password = RegistrationForm.getValeurChamp(req, CHAMP_CONF_MOTDEPASSE);
        String preferedGames = RegistrationForm.getValeurChamp(req, RegistrationForm.CHAMP_PREFEREDGAMES);
        String birthDate = RegistrationForm.getValeurChamp(req, RegistrationForm.CHAMP_DATENAISSANCE_JOUR)+"/"+RegistrationForm.getValeurChamp(req, RegistrationForm.CHAMP_DATENAISSANCE_MOIS)+"/"+RegistrationForm.getValeurChamp(req, RegistrationForm.CHAMP_DATENAISSANCE_ANNEE);

        Player player = null;

        try
        {
            validationMail(mail);
        } catch (Exception e) {
            erreurs.put(CHAMP_MAIL, e.getMessage());
        }

        try
        {
            validationPseudo(pseudo);
        } catch (Exception e)
        {
            erreurs.put(CHAMP_PSEUDO, e.getMessage());
        }

        try
        {
            validationPassword(password, conf_password);
        } catch (Exception e)
        {
            erreurs.put(CHAMP_MOTDEPASSE, e.getMessage());
        }

        if (erreurs.isEmpty())
        {
            resultat = "Inscription réussie";
            player = new Player(pseudo, mail, birthDate, preferedGames);
        } else
        {
            resultat = "Incription échouée";
        }

        req.setAttribute("erreurs", erreurs);
        req.setAttribute("resultat", resultat);
        System.out.println(player.toString());

        this.getServletContext().getRequestDispatcher("/WEB-INF/registration.jsp").forward(req, resp);
    }






}
