package servlets;



import objectManager.RequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import static utilitaire.CookieFactory.*;

/**
 * This class represents the GameList servlet, where the users will see the different games.
 */
public class GamesList extends HttpServlet {
    /**
     * GET Method
     * GET Method is called when a user enters the GamesList page.
     * It sets the first game by default as ready.
     * @param req                   The HTTP request
     * @param resp                  The HTTP response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String player = getCookieValue(req, COOKIE_PLAYER);
        req.setAttribute("gameList", RequestHandler.getRequestHandler().getEnabledGames());
        req.setAttribute("player", RequestHandler.getRequestHandler().getPlayerFromId(Integer.parseInt(player)));
        setCookie(resp, COOKIE_GAME, RequestHandler.getRequestHandler().getEnabledGames().get(0).getName(), COOKIE_MAX_AGE);

        this.getServletContext().getRequestDispatcher("/WEB-INF/gamesList.jsp").forward(req, resp);
    }

    /**
     * POST Method
     * POST Method is called when a user selects a game to play.
     * It sets the game selected as ready to play.
     * @param req                   The HTTP request
     * @param resp                  The HTTP response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        /*
        It identifies which player is connected
         */
        String idplayer = getCookieValue(req, COOKIE_PLAYER);
        /*
        It identifies which game the user selected.
         */
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


        /*
        The rest of the page remains the same.
         */
        req.setAttribute("gameList", RequestHandler.getRequestHandler().getEnabledGames());
        req.setAttribute("player", RequestHandler.getRequestHandler().getPlayerFromId(Integer.parseInt(idplayer)));
        this.getServletContext().getRequestDispatcher("/WEB-INF/gamesList.jsp").forward(req, resp);


    }
}
