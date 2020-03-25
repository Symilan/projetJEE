package servlets;


import objectManager.Factory;
import objectManager.Register;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GamesList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Factory.getFactory().createGame(0,"BomberMan",0,true);
        Factory.getFactory().createGame(1,"Minecraft",0,true);
        Factory.getFactory().createGame(2,"WeebLand",0,false);
        System.out.println(Register.getGameMap());
        req.setAttribute("gameList", Register.getActivatedGamesList());
        this.getServletContext().getRequestDispatcher("/WEB-INF/gamesList.jsp").forward(req, resp);
    }
}
