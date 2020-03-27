package servlets;

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

public class Game extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idplayer = getCookieValue(req, COOKIE_PLAYER);
        String gameName = getCookieValue(req, COOKIE_GAME);
        Factory.getFactory().createGameSession(
                0,
                0,
                RequestHandler.getRequestHandler().getGameFromName(gameName),
                1000,
                RequestHandler.getRequestHandler().getPlayerFromId(Integer.parseInt(idplayer)),
                new Date(),
                new Date());

        req.setAttribute("player", RequestHandler.getRequestHandler().getPlayerFromId(Integer.parseInt(idplayer)).getPseudo());
        req.setAttribute("gameName", gameName);

        this.getServletContext().getRequestDispatcher("/WEB-INF/game.jsp").forward(req, resp);
    }
}
