package servlets;


import model.Game;
import model.Player;
import objectManager.RequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static utilitaire.CookieFactory.*;

public class GamesList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String player = getCookieValue(req, COOKIE_PLAYER);
        req.setAttribute("gameList", RequestHandler.getRequestHandler().getEnabledGames());
        req.setAttribute("player", RequestHandler.getRequestHandler().getPlayerFromId(Integer.parseInt(player)));
        setCookie(resp, COOKIE_GAME, RequestHandler.getRequestHandler().getEnabledGames().get(0).getName(), COOKIE_MAX_AGE);

        this.getServletContext().getRequestDispatcher("/WEB-INF/gamesList.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        String idplayer = getCookieValue(req, COOKIE_PLAYER);

        ArrayList<model.Game> gameList = RequestHandler.getRequestHandler().getEnabledGames();
        int i = 0;
        for (model.Game game : gameList)
        {
            if (req.getParameter(game.getName()) != null)
            {
                req.setAttribute("selectedGame", RequestHandler.getRequestHandler().getEnabledGames().get(i));
                setCookie(resp, COOKIE_GAME, game.getName(), COOKIE_MAX_AGE);
            }
            i++;
        }



        req.setAttribute("gameList", RequestHandler.getRequestHandler().getEnabledGames());
        req.setAttribute("player", RequestHandler.getRequestHandler().getPlayerFromId(Integer.parseInt(idplayer)));
        this.getServletContext().getRequestDispatcher("/WEB-INF/gamesList.jsp").forward(req, resp);


    }
}
