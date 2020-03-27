package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import model.*;
import objectManager.Factory;
import objectManager.RequestHandler;

import static utilitaire.CookieFactory.*;

/**
 * This class represents the Authentification servlet, where the user will try to connect
 */
public class Authentification extends HttpServlet {
    /**
     * GET Method
     * GET Method is called when the user will try to authenticate
     * @param req                   The HTTP request
     * @param resp                  The HTTP response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/authentification.jsp").forward(req, resp);
    }

    /**
     * POST Method
     * POST Method is called when the player press the "Confirmation" button.
     * It will show a error if the player didn't achieve to authenticate
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        /*
        It tries to authenticate the user
         */
        Player player=null;
        String pseudo = req.getParameter("pseudo");
        String password = req.getParameter("password");
        if(pseudo!=null && password!=null) {
            player = RequestHandler.getRequestHandler().authenticate(pseudo, password);
        }
        /*
        If he is authenticated, we create a cookie to follow his connexion
         */
        if (player!=null) {
            req.setAttribute("gameList", RequestHandler.getRequestHandler().getEnabledGames());
            setCookie(resp, COOKIE_PLAYER, player.getId().toString(), COOKIE_MAX_AGE);
            req.setAttribute("player",player);
            this.getServletContext().getRequestDispatcher("/WEB-INF/gamesList.jsp").forward(req, resp);
        }
        /*
        Else
         */
        else
        {
            req.setAttribute("error","Impossible de t'identifier, vérifie ton pseudo et ton mot de passe.");
            if (pseudo!=null) {
                req.setAttribute("pseudo", pseudo);
            }
            this.getServletContext().getRequestDispatcher("/WEB-INF/authentification.jsp").forward(req,resp);
        }
    }
}
