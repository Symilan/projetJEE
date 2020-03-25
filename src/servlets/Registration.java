package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

import model.*;
import utilitaire.*;


public class Registration extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/registration.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Player player = inscrirePlayer(req);


        req.setAttribute("Player", player);
        System.out.println(player.toString());

        this.getServletContext().getRequestDispatcher("/WEB-INF/registration.jsp").forward(req, resp);
    }



    public Player inscrirePlayer (HttpServletRequest request)
    {
        String pseudo = RegistrationForm.getValeurChamp(request, RegistrationForm.CHAMP_PSEUDO);
        String mail = RegistrationForm.getValeurChamp(request, RegistrationForm.CHAMP_MAIL);
        String password = RegistrationForm.getValeurChamp(request, RegistrationForm.CHAMP_MOTDEPASSE);
        String prefferedGames = RegistrationForm.getValeurChamp(request, RegistrationForm.CHAMP_PREFERREDGAMES);
        String birthDate = RegistrationForm.getValeurChamp(request, RegistrationForm.CHAMP_DATENAISSANCE_JOUR)+"/"+RegistrationForm.getValeurChamp(request, RegistrationForm.CHAMP_DATENAISSANCE_MOIS)+"/"+RegistrationForm.getValeurChamp(request, RegistrationForm.CHAMP_DATENAISSANCE_ANNEE);


        Player player = new Player();

        //try-catch
        player.setMail(mail);
        player.setPseudo(pseudo);
        player.setBirthDate(birthDate);
        player.setPreferedGames(prefferedGames);




        return player;
    }


}
