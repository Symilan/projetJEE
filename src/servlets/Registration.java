package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import model.*;
import utilitaire.*;


public class Registration extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/registration.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws /*ServletException*/ IOException
    {
        Player player = inscrirePlayer(req);


        req.setAttribute("Player", player);
        PrintWriter writer = resp.getWriter();
        String htmlRespone = "<html>";
        htmlRespone += "<h2>You is: " + player + "</h2>";
        htmlRespone += "</html>";
        writer.println(htmlRespone);

        //this.getServletContext().getRequestDispatcher("/WEB-INF/registration.jsp").forward(req, resp);
    }



    public Player inscrirePlayer (HttpServletRequest request)
    {
        String pseudo = "test"; //RegistrationForm.getValeurChamp(request, RegistrationForm.CHAMP_PSEUDO);
        String mail = RegistrationForm.getValeurChamp(request, RegistrationForm.CHAMP_MAIL);

        Player player = new Player();

        //try-catch
        player.setMail(mail);
        player.setPseudo(pseudo);




        return player;
    }


}
