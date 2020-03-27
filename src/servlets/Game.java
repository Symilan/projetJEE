package servlets;

import model.GameSession;
import objectManager.Factory;
import objectManager.RequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.PrinterGraphics;
import java.io.IOException;
import java.util.Date;

import static utilitaire.CookieFactory.*;

/**
 * This class represents the Game servlet, where the player is supposed to play
 */
public class Game extends HttpServlet {
    /**
     * GET Method
     * GET Method is called when the user enters the game.
     * It saves a new game session into the database.
     * @param req                   The HTTP request
     * @param resp                  The HTTP response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        It identifies the game and the player
         */
        String idplayer = getCookieValue(req, COOKIE_PLAYER);
        String gameName = getCookieValue(req, COOKIE_GAME);
        RequestHandler.getRequestHandler().saveGameSession(Factory.getFactory().createGameSession(
                0,
                0,
                RequestHandler.getRequestHandler().getGameFromName(gameName),
                1000,
                RequestHandler.getRequestHandler().getPlayerFromId(Integer.parseInt(idplayer)),
                new Date(),
                new Date()));


        req.setAttribute("player", RequestHandler.getRequestHandler().getPlayerFromId(Integer.parseInt(idplayer)).getPseudo());
        req.setAttribute("gameName", gameName);

        this.getServletContext().getRequestDispatcher("/WEB-INF/game.jsp").forward(req, resp);
    }
}
