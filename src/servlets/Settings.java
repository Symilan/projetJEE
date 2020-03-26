package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static utilitaire.CookieFactory.COOKIE_PLAYER;
import static utilitaire.CookieFactory.getCookieValue;

public class Settings extends HttpServlet {
    @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            String idplayer = getCookieValue(req, COOKIE_PLAYER);
            this.getServletContext().getRequestDispatcher("/WEB-INF/settings.jsp").forward(req, resp);
        }
}
