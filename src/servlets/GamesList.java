package servlets;


import model.Player;
import objectManager.RequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

import static utilitaire.CookieFactory.COOKIE_PLAYER;
import static utilitaire.CookieFactory.getCookieValue;

public class GamesList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String player = getCookieValue(req, COOKIE_PLAYER);
        req.setAttribute("selectedGame", RequestHandler.getRequestHandler().getEnabledGames().get(0));
        req.setAttribute("gameList", RequestHandler.getRequestHandler().getEnabledGames());
        req.setAttribute("player", new Player(0, "xX_D4rk_S4suk3_Xx", "sasuke@gmail.com", "04/12/1969", "Minecraft", 69, new Date(), true));
        this.getServletContext().getRequestDispatcher("/WEB-INF/gamesList.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        System.out.println(req.getParameter("Minecraft"));
        this.getServletContext().getRequestDispatcher("/WEB-INF/gamesList.jsp").forward(req, resp);

    }
}
