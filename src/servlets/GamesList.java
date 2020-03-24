package servlets;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class GamesList extends HttpServlet {
    private ArrayList<String> getArrayList()
    {
        ArrayList<String> test = new ArrayList<>();
        test.add("test1");
        test.add("test2");
        return test;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("monArrayList", getArrayList());
        this.getServletContext().getRequestDispatcher("/WEB-INF/gamesList.jsp").forward(req, resp);
    }
}
