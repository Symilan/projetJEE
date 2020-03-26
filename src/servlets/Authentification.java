package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import model.*;
import objectManager.Factory;
import objectManager.Register;
import objectManager.SessionHandler;

import static utilitaire.CookieFactory.*;

public class Authentification extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/authentification.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Player player = SessionHandler.authFromPseudo("noobmaster","AZERTY");
        if (player!=null) {
            Factory.getFactory().createGame(0,"BomberMan",0,true);
            Factory.getFactory().createGame(1,"Minecraft",0,true);
            Factory.getFactory().createGame(2,"WeebLand",0,true);
            req.setAttribute("gameList", Register.getActivatedGamesList());
            setCookie(resp, COOKIE_PLAYER, player.getId().toString(), COOKIE_MAX_AGE);
            req.setAttribute("player",player);
            this.getServletContext().getRequestDispatcher("/WEB-INF/gamesList.jsp").forward(req, resp);
        }
        else
        {
            req.setAttribute("error","Impossible de t'identifier, vérifie ton pseudo et ton mot de passe.");
            req.setAttribute("pseudo","pseudo qu'il avait tapé");
            this.getServletContext().getRequestDispatcher("/WEB-INF/authentification.jsp").forward(req,resp);
        }
    }
}
