package servlets;


import model.Player;
import objectManager.Factory;
import objectManager.Register;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class GamesList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Factory.getFactory().createGame(0,"BomberMan",0,true);
        Factory.getFactory().createGame(1,"Minecraft",0,true);
        Factory.getFactory().createGame(2,"WeebLand",0,true);
        System.out.println(Register.getGameMap());
        req.setAttribute("selectedGame", Register.getActivatedGamesList().get(0));
        req.setAttribute("gameList", Register.getActivatedGamesList());
        req.setAttribute("player", new Player(0, "xX_D4rk_S4suk3_Xx", "sasuke@gmail.com", "04/12/1969", "Minecraft", 69, new Date(), true));
        this.getServletContext().getRequestDispatcher("/WEB-INF/gamesList.jsp").forward(req, resp);
    }
}
